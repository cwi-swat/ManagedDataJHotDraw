package ccconcerns.managed_data.factories;

import ccconcerns.managed_data.schema_factories.GeometrySchemaFactory;
import ccconcerns.managed_data.schemas.geometry.MDDimension;
import ccconcerns.managed_data.schemas.geometry.MDPoint;
import ccconcerns.managed_data.schemas.geometry.MDRectangle;
import nl.cwi.managed_data_4j.ccconcerns.patterns.observer.ObservableDataManager;
import nl.cwi.managed_data_4j.framework.SchemaFactoryProvider;
import nl.cwi.managed_data_4j.language.data_manager.BasicDataManager;
import nl.cwi.managed_data_4j.language.schema.boot.SchemaFactory;
import nl.cwi.managed_data_4j.language.schema.load.SchemaLoader;
import nl.cwi.managed_data_4j.language.schema.models.definition.Schema;

public class MDRectangleFactory {

    private static final Schema schemaSchema = SchemaFactoryProvider.getSchemaSchema();
    private static final SchemaFactory schemaFactory = SchemaFactoryProvider.getSchemaFactory();

    public static MDRectangle newRectangle(int x, int y, int width, int height) {

        // ======
        final Schema geometrySchema = SchemaLoader.load(
                schemaFactory, schemaSchema,
                MDPoint.class, MDRectangle.class, MDDimension.class);

        final BasicDataManager basicFactoryForGeometry =
                new BasicDataManager(GeometrySchemaFactory.class, geometrySchema);
        final GeometrySchemaFactory geometrySchemaFactory = basicFactoryForGeometry.make();
        // ======

        // observable rectangle
        MDRectangle mdRectangle = geometrySchemaFactory.Rectangle();
        mdRectangle.x(x);
        mdRectangle.y(y);
        mdRectangle.width(width);
        mdRectangle.height(height);

        return mdRectangle;
    }

    public static MDRectangle newObservableRectangle(int x, int y, int width, int height) {

        final Schema geometrySchema = SchemaLoader.load(
                schemaFactory, schemaSchema,
                MDPoint.class, MDRectangle.class, MDDimension.class);

        final ObservableDataManager observableFactory =
                new ObservableDataManager(GeometrySchemaFactory.class, geometrySchema);
        final GeometrySchemaFactory observableForGeometry = observableFactory.make();
        // ======

        // observable rectangle
        MDRectangle mdRectangle = observableForGeometry.Rectangle();

        mdRectangle.x(x);
        mdRectangle.y(y);
        mdRectangle.width(width);
        mdRectangle.height(height);

        return mdRectangle;
    }
}
