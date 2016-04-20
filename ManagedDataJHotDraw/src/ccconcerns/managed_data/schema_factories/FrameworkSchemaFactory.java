package ccconcerns.managed_data.schema_factories;

import ccconcerns.managed_data.schemas.framework.MDDrawing;
import ccconcerns.managed_data.schemas.framework.figures.MDFigure;
import ccconcerns.managed_data.schemas.framework.MDTextHolder;

public interface FrameworkSchemaFactory {
    MDDrawing Drawing();
    MDFigure Figure();
    MDTextHolder TextHolder();
}
