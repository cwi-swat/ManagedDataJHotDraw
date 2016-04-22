package ccconcerns.figure_selection_observer.helpers;

import ccconcerns.figure_selection_observer.factories.DrawingViewSchemaFactory;
import ccconcerns.figure_selection_observer.primitives.java_awt.*;
import ccconcerns.figure_selection_observer.primitives.java_swing.JPanelPrimitive;
import ccconcerns.figure_selection_observer.primitives.jhodraw.*;
import ccconcerns.figure_selection_observer.schemas.MDStandardDrawingView;
import nl.cwi.managed_data_4j.framework.SchemaFactoryProvider;
import nl.cwi.managed_data_4j.language.data_manager.BasicDataManager;
import nl.cwi.managed_data_4j.language.schema.boot.SchemaFactory;
import nl.cwi.managed_data_4j.language.schema.load.SchemaLoader;
import nl.cwi.managed_data_4j.language.schema.models.definition.Schema;

import javax.swing.*;
import java.awt.*;

public class MDDrawingViewFactory {

    private static final Schema schemaSchema = SchemaFactoryProvider.getSchemaSchema();
    private static final SchemaFactory schemaFactory = SchemaFactoryProvider.getSchemaFactory();

    public static MDStandardDrawingView newDrawingView() {

        SchemaLoader.addPrimitive(new DimensionPrimitive());
        SchemaLoader.addPrimitive(new RectanglePrimitive());
        SchemaLoader.addPrimitive(new PointPrimitive());
        SchemaLoader.addPrimitive(new ColorPrimitive());
        SchemaLoader.addPrimitive(new CursorPrimitive());

        SchemaLoader.addPrimitive(new JPanelPrimitive());

        SchemaLoader.addPrimitive(new DrawingEditorPrimitive());
        SchemaLoader.addPrimitive(new DrawingPrimitive());
        SchemaLoader.addPrimitive(new ToolPrimitive());
        SchemaLoader.addPrimitive(new FigurePrimitive());
        SchemaLoader.addPrimitive(new PointConstrainerPrimitive());
        SchemaLoader.addPrimitive(new PainterPrimitive());
        SchemaLoader.addPrimitive(new HandlePrimitive());

        // ======
        final Schema drawingViewSchema = SchemaLoader.load(
                schemaFactory, schemaSchema,
                MDStandardDrawingView.class);

        final BasicDataManager basicFactory =
                new BasicDataManager(DrawingViewSchemaFactory.class, drawingViewSchema);
        final DrawingViewSchemaFactory drawingViewSchemaFactory = basicFactory.make();
        // ======

        MDStandardDrawingView drawingView = drawingViewSchemaFactory.DrawingView();

        JPanel jPanel = new JPanel();
        jPanel.setAutoscrolls(true);
        jPanel.setSize(MDStandardDrawingView.MINIMUM_WIDTH, MDStandardDrawingView.MINIMUM_HEIGHT);
        jPanel.setBackground(Color.lightGray);
//        jPanel.addMouseListener(createMouseListener());
//        jPanel.addMouseMotionListener(createMouseMotionListener());
//        jPanel.addKeyListener(createKeyListener());
        drawingView.panel(jPanel);

        return drawingView;
    }
}
