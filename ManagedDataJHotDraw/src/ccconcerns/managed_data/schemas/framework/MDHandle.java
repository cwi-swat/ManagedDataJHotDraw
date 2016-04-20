package ccconcerns.managed_data.schemas.framework;

import ccconcerns.managed_data.schemas.framework.figures.MDFigure;
import ccconcerns.managed_data.schemas.geometry.MDPoint;
import ccconcerns.managed_data.schemas.geometry.MDRectangle;
import nl.cwi.managed_data_4j.language.schema.models.definition.M;
import nl.cwi.managed_data_4j.language.schema.models.definition.annotations.Inverse;

public interface MDHandle extends M {

    MDPoint locate(MDPoint... point);

    @Inverse(other = MDFigure.class, field = "handles")
    MDFigure owner(MDFigure... figure);

    MDRectangle displayBox(MDRectangle... displayBox);
}
