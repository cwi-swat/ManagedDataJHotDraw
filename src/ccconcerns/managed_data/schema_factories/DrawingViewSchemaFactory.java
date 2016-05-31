package ccconcerns.managed_data.schema_factories;

import ccconcerns.managed_data.schemas.framework.MDNullDrawingView;
import ccconcerns.managed_data.schemas.framework.MDStandardDrawingView;
import nl.cwi.managed_data_4j.IFactory;

public interface DrawingViewSchemaFactory extends IFactory {
    MDStandardDrawingView DrawingView();
    MDNullDrawingView NullDrawingView();
}
