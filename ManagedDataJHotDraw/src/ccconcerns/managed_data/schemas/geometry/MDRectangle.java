package ccconcerns.managed_data.schemas.geometry;

import nl.cwi.managed_data_4j.language.schema.models.definition.M;

public interface MDRectangle extends M {
    Integer x(Integer... x);
    Integer y(Integer... y);
    Integer width(Integer... width);
    Integer height(Integer... height);

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
        int x = this.x();
        int y = this.y();
        if (X < x || Y < y) {
            return false;
        }
        w += x;
        h += y;
        return ((w < x || w > X) &&
                (h < y || h > Y));
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
}
