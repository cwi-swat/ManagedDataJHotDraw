package ccconcerns.managed_data.factories;

import CH.ifa.draw.framework.DrawingEditor;
import CH.ifa.draw.standard.DeleteCommand;
import CH.ifa.draw.standard.SimpleUpdateStrategy;
import CH.ifa.draw.standard.StandardDrawing;
import CH.ifa.draw.util.Command;
import CH.ifa.draw.util.UndoableCommand;
import ccconcerns.MyJPanel;
import ccconcerns.figure_selection_listener.figure_listener_subject_observer_data_manager.FigureSelectionListenerSubjectRoleDataManager;
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
import java.awt.event.*;

public class MDDrawingViewFactory {

    private static final SchemaFactory schemaFactory = SchemaFactoryProvider.getSchemaFactory();

    public static MDDrawingView newSubjectRoleDrawingView(DrawingEditor editor) {
        return newSubjectRoleDrawingView(editor, MDStandardDrawingView.MINIMUM_WIDTH, MDStandardDrawingView.MINIMUM_HEIGHT);
    }

    public static MDDrawingView newSubjectRoleDrawingView(DrawingEditor editor, int width, int height) {

        // ================================================
        final Schema drawingViewSchema = SchemaLoader.load(schemaFactory, JHotDrawPrimitives.class, MDStandardDrawingView.class);

        final FigureSelectionListenerSubjectRoleDataManager subjectRoleFactory =
                new FigureSelectionListenerSubjectRoleDataManager();

        final DrawingViewSchemaFactory drawingViewSchemaFactory = subjectRoleFactory.factory(DrawingViewSchemaFactory.class, drawingViewSchema);
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

        jPanel.addKeyListener(new DrawingViewKeyListener(drawingView));

        return drawingView;
    }

    public static MDDrawingView newNullDrawingView(DrawingEditor editor) {

        // ================================================
        final Schema drawingViewSchema = SchemaLoader.load(
                schemaFactory,
                JHotDrawPrimitives.class, MDNullDrawingView.class);

        final BasicDataManager subjectRoleFactory = new BasicDataManager();
        final DrawingViewSchemaFactory drawingViewSchemaFactory = subjectRoleFactory.factory(DrawingViewSchemaFactory.class, drawingViewSchema);
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

    public static class DrawingViewKeyListener implements KeyListener {
        private Command deleteCmd;
        private MDDrawingView drawingView;

        public DrawingViewKeyListener(MDDrawingView drawingView) {
            this.drawingView = drawingView;
            deleteCmd = createDeleteCommand();
        }

        /**
         * Handles key down events. Cursor keys are handled
         * by the view the other key events are delegated to the
         * currently active tool.
         */
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            if ((code == KeyEvent.VK_BACK_SPACE) || (code == KeyEvent.VK_DELETE)) {
                if (deleteCmd.isExecutable()) {
                    deleteCmd.execute();
//					deleteCmd.viewSelectionChanged(this);
                }
            } else if ((code == KeyEvent.VK_DOWN) || (code == KeyEvent.VK_UP)
                    || (code == KeyEvent.VK_RIGHT) || (code == KeyEvent.VK_LEFT)) {
                handleCursorKey(code);
            } else {
                drawingView.tool().keyDown(e, code);
            }
            drawingView.checkDamage();
        }

        /**
         * Handles cursor keys by moving all the selected figures
         * one grid point in the cursor direction.
         */
        protected void handleCursorKey(int key) {
            int dx = 0, dy = 0;
            int stepX = 1, stepY = 1;
            // should consider Null Object.
            if (drawingView.getConstrainer() != null) {
                stepX = drawingView.getConstrainer().getStepX();
                stepY = drawingView.getConstrainer().getStepY();
            }

            switch (key) {
                case KeyEvent.VK_DOWN:
                    dy = stepY;
                    break;
                case KeyEvent.VK_UP:
                    dy = -stepY;
                    break;
                case KeyEvent.VK_RIGHT:
                    dx = stepX;
                    break;
                case KeyEvent.VK_LEFT:
                    dx = -stepX;
                    break;
            }
            drawingView.moveSelection(dx, dy);
        }

        public void keyTyped(KeyEvent event) {
            // do nothing
        }

        public void keyReleased(KeyEvent event) {
            // do nothing
        }

        protected Command createDeleteCommand() {
            return new UndoableCommand(new DeleteCommand("Delete", drawingView.getEditor()));
        }
    }
}
