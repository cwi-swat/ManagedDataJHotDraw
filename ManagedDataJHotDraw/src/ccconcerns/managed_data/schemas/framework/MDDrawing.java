package ccconcerns.managed_data.schemas.framework;

import ccconcerns.managed_data.schemas.framework.figures.MDFigure;
import nl.cwi.managed_data_4j.language.schema.models.definition.M;

import java.util.List;

public interface MDDrawing extends M {
    String title(String... title);
    List<MDFigure> figures(MDFigure... figures);

    default void add(MDFigure figure) {

    }

    default void remove(MDFigure figure) {

    }
}
