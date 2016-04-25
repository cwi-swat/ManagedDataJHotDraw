package ccconcerns.managed_data.factories;

import ccconcerns.managed_data.schema_factories.GeometrySchemaFactory;
import ccconcerns.managed_data.schemas.geometry.MDDimension;
import ccconcerns.managed_data.schemas.geometry.MDPoint;
import ccconcerns.managed_data.schemas.geometry.MDRectangle;
import nl.cwi.managed_data_4j.framework.SchemaFactoryProvider;
import nl.cwi.managed_data_4j.language.data_manager.BasicDataManager;
import nl.cwi.managed_data_4j.language.schema.boot.SchemaFactory;
import nl.cwi.managed_data_4j.language.schema.load.SchemaLoader;
import nl.cwi.managed_data_4j.language.schema.models.definition.Schema;

public class MDGeometryFactory {

    private static final Schema schemaSchema = SchemaFactoryProvider.getSchemaSchema();
    private static final SchemaFactory schemaFactory = SchemaFactoryProvider.getSchemaFactory();

    private final static Schema geometrySchema = SchemaLoader.load(
            schemaFactory, schemaSchema,
            MDPoint.class, MDRectangle.class, MDDimension.class);
    private final static BasicDataManager basicFactoryForGeometry = new BasicDataManager(GeometrySchemaFactory.class, geometrySchema);
    private final static GeometrySchemaFactory geometrySchemaFactory = basicFactoryForGeometry.make();

    public static MDRectangle newRectangle(int x, int y, int width, int height) {
        MDRectangle mdRectangle = geometrySchemaFactory.Rectangle();
        mdRectangle.x(x);
        mdRectangle.y(y);
        mdRectangle.width(width);
        mdRectangle.height(height);

        return mdRectangle;
    }

    public static MDDimension newDimension(int width, int height) {
        MDDimension mdDimension = geometrySchemaFactory.Dimension();
        mdDimension.height(height);
        mdDimension.width(width);

        return mdDimension;
    }

    public static MDPoint newPoint(int x, int y) {
        MDPoint mdPoint = geometrySchemaFactory.Point();
        mdPoint.x(x);
        mdPoint.y(y);

        return mdPoint;
    }
}
