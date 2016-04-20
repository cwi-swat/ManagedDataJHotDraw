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
