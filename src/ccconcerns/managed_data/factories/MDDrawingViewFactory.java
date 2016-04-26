package ccconcerns.managed_data.factories;

import CH.ifa.draw.framework.DrawingEditor;
import CH.ifa.draw.standard.SimpleUpdateStrategy;
import CH.ifa.draw.standard.StandardDrawing;
import ccconcerns.MyJPanel;
import ccconcerns.figure_selection_listener.figure_listener_subject_observer_data_manager.FigureListenerSubjectRoleDataManager;
import ccconcerns.managed_data.MDDrawingView;
import ccconcerns.managed_data.schema_factories.DrawingViewSchemaFactory;
import ccconcerns.managed_data.schemas.JHotDrawPrimitives;
import ccconcerns.managed_data.schemas.framework.MDNullDrawingView;
import ccconcerns.managed_data.schemas.framework.MDStandardDrawingView;
import nl.cwi.managed_data_4j.framework.SchemaFactoryProvider;
import nl.cwi.managed_data_4j.language.data_manager.BasicDataManager;
import nl.cwi.managed_data_4j.language.schema.boot.SchemaFactory;
import nl.cwi.managed_data_4j.language.schema.load.SchemaLoader;
import nl.cwi.managed_data_4j.language.schema.models.definition.Schema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MDDrawingViewFactory {

    private static final Schema schemaSchema = SchemaFactoryProvider.getSchemaSchema();
    private static final SchemaFactory schemaFactory = SchemaFactoryProvider.getSchemaFactory();

    public static MDDrawingView newSubjectRoleDrawingView(DrawingEditor editor) {
        return newSubjectRoleDrawingView(editor, MDStandardDrawingView.MINIMUM_WIDTH, MDStandardDrawingView.MINIMUM_HEIGHT);
    }

    public static MDDrawingView newSubjectRoleDrawingView(DrawingEditor editor, int width, int height) {

        // ================================================
        final Schema drawingViewSchema = SchemaLoader.load(
                schemaFactory, schemaSchema,
                JHotDrawPrimitives.class, MDStandardDrawingView.class);

        final FigureListenerSubjectRoleDataManager subjectRoleFactory =
                new FigureListenerSubjectRoleDataManager(DrawingViewSchemaFactory.class, drawingViewSchema);

        final DrawingViewSchemaFactory drawingViewSchemaFactory = subjectRoleFactory.make();
        // ================================================

        final MDStandardDrawingView drawingView = drawingViewSchemaFactory.DrawingView();

        // JPanel setup
        MyJPanel jPanel = new MyJPanel();
        jPanel.setAutoscrolls(true);
        jPanel.setSize(width, height);
        jPanel.setBackground(Color.lightGray);
        drawingView.panel(jPanel);
        jPanel.setDrawingView(drawingView);

        // editor
        drawingView.editor(editor);

        // Size
        drawingView.size(new Dimension(width, height));
        jPanel.setSize(width, height);

        // Last click
        drawingView.lastClick(new Point(0, 0));

        // Constrainer
        drawingView.constrainer(null);

        // Display update
        drawingView.setDisplayUpdate(new SimpleUpdateStrategy());

        // Background
        drawingView.setBackground(Color.lightGray);

        // Drawing
        drawingView.drawing(new StandardDrawing());

        // Panel events
        jPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    jPanel.requestFocus(); // JDK1.1
                    Point p = drawingView.constrainPoint(new Point(e.getX(), e.getY()));
                    drawingView.setLastClick(new Point(e.getX(), e.getY()));

                    e.setSource(drawingView);
                    drawingView.tool().mouseDown(e, p.x, p.y);
                    drawingView.checkDamage();
                }
                catch (Throwable t) {
                    handleMouseEventException(jPanel, t);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    Point p = drawingView.constrainPoint(new Point(e.getX(), e.getY()));

                    e.setSource(drawingView);
                    drawingView.tool().mouseUp(e, p.x, p.y);
                    drawingView.checkDamage();
                }
                catch (Throwable t) {
                    handleMouseEventException(jPanel, t);
                }
            }
        });

        jPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                try {
                    Point p = drawingView.constrainPoint(new Point(e.getX(), e.getY()));

                    e.setSource(drawingView);
                    drawingView.tool().mouseDrag(e, p.x, p.y);
                    drawingView.checkDamage();
                }
                catch (Throwable t) {
                    handleMouseEventException(jPanel, t);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                try {
                    drawingView.tool().mouseMove(e, e.getX(), e.getY());
                }
                catch (Throwable t) {
                    handleMouseEventException(jPanel, t);
                }
            }
        });
        return drawingView;
    }

    public static MDDrawingView newDrawingView(DrawingEditor editor) {
        return newDrawingView(editor, MDStandardDrawingView.MINIMUM_WIDTH, MDStandardDrawingView.MINIMUM_HEIGHT);
    }

    public static MDDrawingView newDrawingView(DrawingEditor editor, int width, int height) {

        // ================================================
        final Schema drawingViewSchema = SchemaLoader.load(
                schemaFactory, schemaSchema,
                MDStandardDrawingView.class, JHotDrawPrimitives.class);

        final BasicDataManager basicFactory =
                new BasicDataManager(DrawingViewSchemaFactory.class, drawingViewSchema);
        final DrawingViewSchemaFactory drawingViewSchemaFactory = basicFactory.make();
        // ================================================

        final MDStandardDrawingView drawingView = drawingViewSchemaFactory.DrawingView();

        // JPanel setup
        MyJPanel jPanel = new MyJPanel();
        jPanel.setAutoscrolls(true);
        jPanel.setSize(width, height);
        jPanel.setBackground(Color.lightGray);
        drawingView.panel(jPanel);
        jPanel.setDrawingView(drawingView);

        // editor
        drawingView.editor(editor);

        // Size
        drawingView.size(new Dimension(width, height));
        jPanel.setSize(width, height);

        // Last click
        drawingView.lastClick(new Point(0, 0));

        // Constrainer
        drawingView.constrainer(null);

        // Selection listeners
        // @MDHD: FigureSelectionListener (FSL) Refactoring
        //  drawingView.addFigureSelectionListener(editor);

        // Display update
        drawingView.setDisplayUpdate(new SimpleUpdateStrategy());

        // Background
        drawingView.setBackground(Color.lightGray);

        // Drawing
        drawingView.drawing(new StandardDrawing());

        // Panel events
        jPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    jPanel.requestFocus(); // JDK1.1
                    Point p = drawingView.constrainPoint(new Point(e.getX(), e.getY()));
                    drawingView.setLastClick(new Point(e.getX(), e.getY()));

                    e.setSource(drawingView);
                    drawingView.tool().mouseDown(e, p.x, p.y);
                    drawingView.checkDamage();
                }
                catch (Throwable t) {
                    handleMouseEventException(jPanel, t);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    Point p = drawingView.constrainPoint(new Point(e.getX(), e.getY()));

                    e.setSource(drawingView);
                    drawingView.tool().mouseUp(e, p.x, p.y);
                    drawingView.checkDamage();
                }
                catch (Throwable t) {
                    handleMouseEventException(jPanel, t);
                }
            }
        });

        jPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                try {
                    Point p = drawingView.constrainPoint(new Point(e.getX(), e.getY()));

                    e.setSource(drawingView);
                    drawingView.tool().mouseDrag(e, p.x, p.y);
                    drawingView.checkDamage();
                }
                catch (Throwable t) {
                    handleMouseEventException(jPanel, t);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                try {
                    drawingView.tool().mouseMove(e, e.getX(), e.getY());
                }
                catch (Throwable t) {
                    handleMouseEventException(jPanel, t);
                }
            }
        });

//        jPanel.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        });
        return drawingView;
    }

    public static MDDrawingView newNullDrawingView(DrawingEditor editor) {

        // ================================================
        final Schema drawingViewSchema = SchemaLoader.load(
                schemaFactory, schemaSchema,
                JHotDrawPrimitives.class, MDNullDrawingView.class);

        final BasicDataManager subjectRoleFactory =
                new BasicDataManager(DrawingViewSchemaFactory.class, drawingViewSchema);

        final DrawingViewSchemaFactory drawingViewSchemaFactory = subjectRoleFactory.make();
        // ================================================

        final MDNullDrawingView drawingView = drawingViewSchemaFactory.NullDrawingView();

        // JPanel setup
        MyJPanel jPanel = new MyJPanel();
        jPanel.setAutoscrolls(true);
        drawingView.panel(jPanel);

        // editor
        drawingView.editor(editor);

        return drawingView;
    }

    private static void handleMouseEventException(Component c, Throwable t) {
        JOptionPane.showMessageDialog(c,
                t.getClass().getName() + " - " + t.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        t.printStackTrace();
    }
}
