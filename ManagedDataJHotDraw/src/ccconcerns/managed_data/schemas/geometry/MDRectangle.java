package ccconcerns.managed_data.schemas.geometry;

import nl.cwi.managed_data_4j.language.schema.models.definition.M;

public interface MDRectangle extends M {
    Integer x(Integer... x);
    Integer y(Integer... y);
    Integer width(Integer... width);
    Integer height(Integer... height);


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
