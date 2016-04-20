package ccconcerns.managed_data;

import ccconcerns.managed_data.schemas.framework.MDDrawing;
import ccconcerns.managed_data.schemas.framework.figures.MDFigure;
import ccconcerns.managed_data.schemas.framework.MDTextHolder;
import ccconcerns.managed_data.schemas.geometry.MDDimension;
import ccconcerns.managed_data.schemas.geometry.MDPoint;
import ccconcerns.managed_data.schemas.geometry.MDRectangle;
import nl.cwi.managed_data_4j.framework.SchemaFactoryProvider;
import nl.cwi.managed_data_4j.language.data_manager.BasicDataManager;
import nl.cwi.managed_data_4j.language.schema.boot.SchemaFactory;
import nl.cwi.managed_data_4j.language.schema.load.SchemaLoader;
import nl.cwi.managed_data_4j.language.schema.models.definition.Schema;

import ccconcerns.managed_data.schema_factories.*;

public class ExampleUsesDrawings {
    public static void main(String[] args) {
        final Schema schemaSchema = SchemaFactoryProvider.getSchemaSchema();
        final SchemaFactory schemaFactory = SchemaFactoryProvider.getSchemaFactory();

        final Schema drawingSchema = SchemaLoader.load(
                schemaFactory, schemaSchema,
                MDDrawing.class, MDFigure.class, MDTextHolder.class,
                MDPoint.class, MDRectangle.class, MDDimension.class);

        final BasicDataManager basicFactoryForFigures = new BasicDataManager(FrameworkSchemaFactory.class, drawingSchema);
        final FrameworkSchemaFactory frameworkSchemaFactory = basicFactoryForFigures.make();

        final BasicDataManager basicFactoryForGeometry = new BasicDataManager(GeometrySchemaFactory.class, drawingSchema);
        final GeometrySchemaFactory geometrySchemaFactory = basicFactoryForGeometry.make();

        final MDRectangle rect = geometrySchemaFactory.Rectangle();

        final MDFigure figure = frameworkSchemaFactory.Figure();
        figure.displayBox(rect);
    }
}
