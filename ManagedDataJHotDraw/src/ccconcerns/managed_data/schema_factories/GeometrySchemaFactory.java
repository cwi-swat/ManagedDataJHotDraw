package ccconcerns.managed_data.schema_factories;

import ccconcerns.managed_data.schemas.geometry.MDDimension;
import ccconcerns.managed_data.schemas.geometry.MDPoint;
import ccconcerns.managed_data.schemas.geometry.MDRectangle;

public interface GeometrySchemaFactory {
    MDPoint Point();
    MDPoint Point(Integer x, Integer y);

    MDRectangle Rectangle();
    MDRectangle Rectangle(Integer height, Integer width, Integer x, Integer y);

    MDDimension Dimension();
    MDDimension Dimension(Integer height, Integer width);
}
