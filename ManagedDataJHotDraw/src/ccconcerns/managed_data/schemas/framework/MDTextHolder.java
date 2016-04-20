package ccconcerns.managed_data.schemas.framework;

import ccconcerns.managed_data.schemas.framework.figures.MDFigure;
import nl.cwi.managed_data_4j.language.schema.models.definition.M;

public interface MDTextHolder extends M {
    String text(String... text);
    Boolean acceptsTyping(Boolean... acceptsTyping);
    MDFigure representingFigure(MDFigure... representingFigure);
}
