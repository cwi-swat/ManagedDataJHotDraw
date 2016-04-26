package ccconcerns.managed_data.schemas.geometry;

import ccconcerns.managed_data.factories.MDGeometryFactory;
import nl.cwi.managed_data_4j.M;

import java.awt.*;

public interface MDRectangle extends M {
    Integer x(Integer... x);
    Integer y(Integer... y);
    Integer width(Integer... width);
    Integer height(Integer... height);

    default MDRectangle union(MDRectangle r) {
        long tx2 = this.width();
        long ty2 = this.height();
        if ((tx2 | ty2) < 0) {
            // This rectangle has negative dimensions...
            // If r has non-negative dimensions then it is the answer.
            // If r is non-existant (has a negative dimension), then both
            // are non-existant and we can return any non-existant rectangle
            // as an answer.  Thus, returning r meets that criterion.
            // Either way, r is our answer.
            return MDGeometryFactory.newRectangle(r.x(), r.y(), r.width(), r.height());
        }
        long rx2 = r.width();
        long ry2 = r.height();
        if ((rx2 | ry2) < 0) {
            return MDGeometryFactory.newRectangle(x(), y(), width(), height());
        }
        int tx1 = this.x();
        int ty1 = this.y();
        tx2 += tx1;
        ty2 += ty1;
        int rx1 = r.x();
        int ry1 = r.y();
        rx2 += rx1;
        ry2 += ry1;
        if (tx1 > rx1) tx1 = rx1;
        if (ty1 > ry1) ty1 = ry1;
        if (tx2 < rx2) tx2 = rx2;
        if (ty2 < ry2) ty2 = ry2;
        tx2 -= tx1;
        ty2 -= ty1;
        // tx2,ty2 will never underflow since both original rectangles
        // were already proven to be non-empty
        // they might overflow, though...
        if (tx2 > Integer.MAX_VALUE) tx2 = Integer.MAX_VALUE;
        if (ty2 > Integer.MAX_VALUE) ty2 = Integer.MAX_VALUE;
        return MDGeometryFactory.newRectangle(tx1, ty1, (int) tx2, (int) ty2);
    }

    default void add(int newx, int newy) {
        if ((width() | height()) < 0) {
            x(newx);
            y(newy);
            width(0);
            height(0);
            return;
        }
        int x1 = x();
        int y1 = y();
        long x2 = width();
        long y2 = height();
        x2 += x1;
        y2 += y1;
        if (x1 > newx) x1 = newx;
        if (y1 > newy) y1 = newy;
        if (x2 < newx) x2 = newx;
        if (y2 < newy) y2 = newy;
        x2 -= x1;
        y2 -= y1;
        if (x2 > Integer.MAX_VALUE) x2 = Integer.MAX_VALUE;
        if (y2 > Integer.MAX_VALUE) y2 = Integer.MAX_VALUE;
        reshape(x1, y1, (int) x2, (int) y2);
    }

    default void add(MDRectangle r) {
        long tx2 = width();
        long ty2 = height();
        if ((tx2 | ty2) < 0) {
            reshape(r.x(), r.y(), r.width(), r.height());
        }
        long rx2 = r.width();
        long ry2 = r.height();
        if ((rx2 | ry2) < 0) {
            return;
        }
        int tx1 = x();
        int ty1 = y();
        tx2 += tx1;
        ty2 += ty1;
        int rx1 = r.x();
        int ry1 = r.y();
        rx2 += rx1;
        ry2 += ry1;
        if (tx1 > rx1) tx1 = rx1;
        if (ty1 > ry1) ty1 = ry1;
        if (tx2 < rx2) tx2 = rx2;
        if (ty2 < ry2) ty2 = ry2;
        tx2 -= tx1;
        ty2 -= ty1;

        if (tx2 > Integer.MAX_VALUE) tx2 = Integer.MAX_VALUE;
        if (ty2 > Integer.MAX_VALUE) ty2 = Integer.MAX_VALUE;
        reshape(tx1, ty1, (int) tx2, (int) ty2);
    }

    default void grow(int h, int v) {
        long x0 = x();
        long y0 = y();
        long x1 = width();
        long y1 = height();
        x1 += x0;
        y1 += y0;

        x0 -= h;
        y0 -= v;
        x1 += h;
        y1 += v;

        if (x1 < x0) {
            // Non-existant in X direction
            // Final width must remain negative so subtract x0 before
            // it is clipped so that we avoid the risk that the clipping
            // of x0 will reverse the ordering of x0 and x1.
            x1 -= x0;
            if (x1 < Integer.MIN_VALUE) x1 = Integer.MIN_VALUE;
            if (x0 < Integer.MIN_VALUE) x0 = Integer.MIN_VALUE;
            else if (x0 > Integer.MAX_VALUE) x0 = Integer.MAX_VALUE;
        } else { // (x1 >= x0)
            // Clip x0 before we subtract it from x1 in case the clipping
            // affects the representable area of the rectangle.
            if (x0 < Integer.MIN_VALUE) x0 = Integer.MIN_VALUE;
            else if (x0 > Integer.MAX_VALUE) x0 = Integer.MAX_VALUE;
            x1 -= x0;
            // The only way x1 can be negative now is if we clipped
            // x0 against MIN and x1 is less than MIN - in which case
            // we want to leave the width negative since the result
            // did not intersect the representable area.
            if (x1 < Integer.MIN_VALUE) x1 = Integer.MIN_VALUE;
            else if (x1 > Integer.MAX_VALUE) x1 = Integer.MAX_VALUE;
        }

        if (y1 < y0) {
            // Non-existant in Y direction
            y1 -= y0;
            if (y1 < Integer.MIN_VALUE) y1 = Integer.MIN_VALUE;
            if (y0 < Integer.MIN_VALUE) y0 = Integer.MIN_VALUE;
            else if (y0 > Integer.MAX_VALUE) y0 = Integer.MAX_VALUE;
        } else { // (y1 >= y0)
            if (y0 < Integer.MIN_VALUE) y0 = Integer.MIN_VALUE;
            else if (y0 > Integer.MAX_VALUE) y0 = Integer.MAX_VALUE;
            y1 -= y0;
            if (y1 < Integer.MIN_VALUE) y1 = Integer.MIN_VALUE;
            else if (y1 > Integer.MAX_VALUE) y1 = Integer.MAX_VALUE;
        }

        reshape((int) x0, (int) y0, (int) x1, (int) y1);
    }

    default boolean contains(int x, int y) {
        return inside(x, y);
    }

    default boolean inside(int X, int Y) {
        int w = width();
        int h = height();
        if ((w | h) < 0) {
            return false;
        }
        int x = x();
        int y = y();
        if (X < x || Y < y) {
            return false;
        }
        w += x;
        h += y;
        return ((w < x || w > X) &&
                (h < y || h > Y));
    }

    default boolean intersects(MDRectangle r) {
        int tw = width();
        int th = height();
        int rw = r.width();
        int rh = r.height();
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = x();
        int ty = y();
        int rx = r.x();
        int ry = r.y();
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }

    default void reshape(int _x, int _y, int _width, int _height) {
        x(_x);
        y(_y);
        width(_width);
        height(_height);
    }

    default void resize(int _width, int _height) {
        width(_width);
        height(_height);
    }

    default boolean isEmpty() {
        return (width() <= 0) || (height() <= 0);
    }

    default Point getLocation() {
        return new Point(x(), y());
    }

    default double getMaxX() {
        return x() + width();
    }

    default double getMaxY() {
        return y() + height();
    }

    default double getMinX() {
        return x();
    }

    default double getMinY() {
        return y();
    }

    default void translate(int dx, int dy) {
        int oldv = x();
        int newv = oldv + dx;
        if (dx < 0) {
            // moving leftward
            if (newv > oldv) {
                // negative overflow
                // Only adjust width if it was valid (>= 0).
                if (width() >= 0) {
                    // The right edge is now conceptually at
                    // newv+width, but we may move newv to prevent
                    // overflow.  But we want the right edge to
                    // remain at its new location in spite of the
                    // clipping.  Think of the following adjustment
                    // conceptually the same as:
                    // width += newv; newv = MIN_VALUE; width -= newv;
                    Integer oldW = width();
                    oldW += newv - Integer.MIN_VALUE;
                    width(oldW);

                    // width may go negative if the right edge went past
                    // MIN_VALUE, but it cannot overflow since it cannot
                    // have moved more than MIN_VALUE and any non-negative
                    // number + MIN_VALUE does not overflow.
                }
                newv = Integer.MIN_VALUE;
            }
        } else {
            // moving rightward (or staying still)
            if (newv < oldv) {
                // positive overflow
                if (width() >= 0) {
                    // Conceptually the same as:
                    // width += newv; newv = MAX_VALUE; width -= newv;
                    Integer oldW = width();
                    oldW += newv - Integer.MAX_VALUE;
                    width(oldW);
                    // With large widths and large displacements
                    // we may overflow so we need to check it.
                    if (width() < 0) width(Integer.MAX_VALUE);
                }
                newv = Integer.MAX_VALUE;
            }
        }
        x(newv);

        oldv = y();
        newv = oldv + dy;
        if (dy < 0) {
            // moving upward
            if (newv > oldv) {
                // negative overflow
                if (height() >= 0) {

                    Integer oldH = height();
                    oldH += newv - Integer.MIN_VALUE;
                    height(oldH);
                    // See above comment about no overflow in this case
                }
                newv = Integer.MIN_VALUE;
            }
        } else {
            // moving downward (or staying still)
            if (newv < oldv) {
                // positive overflow
                if (height() >= 0) {
                    Integer oldH = height();
                    oldH += newv - Integer.MAX_VALUE;
                    height(oldH);

                    if (height() < 0) height(Integer.MAX_VALUE);
                }
                newv = Integer.MAX_VALUE;
            }
        }
        y(newv);
    }
}
