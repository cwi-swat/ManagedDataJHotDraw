package ccconcerns.managed_data.schemas.framework.figures;

import ccconcerns.managed_data.schemas.framework.MDHandle;
import ccconcerns.managed_data.schemas.framework.MDTextHolder;
import ccconcerns.managed_data.schemas.geometry.MDDimension;
import ccconcerns.managed_data.schemas.geometry.MDPoint;
import ccconcerns.managed_data.schemas.geometry.MDRectangle;
import nl.cwi.managed_data_4j.language.schema.models.definition.M;

import java.util.List;

/**
 * Refactored Figure interface to Managed data
 * It implements the Abstract Figure as well
 */
public interface MDFigure extends M {
    List<MDHandle> handles(MDHandle... handles);

    MDRectangle displayBox(MDRectangle... displayBox);
    MDDimension size(MDDimension... size);
    MDPoint center(MDPoint... center);

    List<MDFigure> dependendFigures(MDFigure... figures);

    default void addDependendFigure(MDFigure newDependendFigure) {
    }

    default void removeDependendFigure(MDFigure newDependendFigure) {
    }

    Integer z(Integer... z);

    MDTextHolder textHolder(MDTextHolder... textHolder);
    MDFigure decorateFigure(MDFigure... figure);

    // ===============
    // AbstractFigure
    default boolean isEmpty() {
        return (size().width() < 3) || (size().height() < 3);
    }

    default boolean containsPoint(int x, int y) {
        return displayBox().contains(x, y);
    }

    default boolean includes(MDFigure figure) {
        return figure == this;
    }
}
