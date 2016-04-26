package ccconcerns.managed_data.schema_factories;

import ccconcerns.managed_data.schemas.framework.MDNullDrawingView;
import ccconcerns.managed_data.schemas.framework.MDStandardDrawingView;

public interface DrawingViewSchemaFactory {
    MDStandardDrawingView DrawingView();
    MDNullDrawingView NullDrawingView();
}
