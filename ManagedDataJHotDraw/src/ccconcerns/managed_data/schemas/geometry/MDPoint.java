package ccconcerns.managed_data.schemas.geometry;

import nl.cwi.managed_data_4j.M;

public interface MDPoint extends M {
    Integer x(Integer... x);
    Integer y(Integer... y);

    default void translate(int dx, int dy) {
        Integer currentX = x();
        Integer currentY = y();

        x(currentX + dx);
        y(currentY + dy);
    }
}
