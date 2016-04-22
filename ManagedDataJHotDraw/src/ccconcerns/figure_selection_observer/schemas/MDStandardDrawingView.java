package ccconcerns.figure_selection_observer.schemas;

import CH.ifa.draw.framework.*;
import CH.ifa.draw.framework.Painter;
import CH.ifa.draw.standard.*;
import CH.ifa.draw.util.CollectionsFactory;
import CH.ifa.draw.util.Geom;
import nl.cwi.managed_data_4j.language.schema.models.definition.M;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.*;
import java.util.List;

public interface MDStandardDrawingView extends M, ImageObserver, DrawingChangeListener {

    public static final int MINIMUM_WIDTH = 400;
    public static final int MINIMUM_HEIGHT = 300;
    public static final int SCROLL_OFFSET = 10;

    // Composition over inheritance,
    // the original inherits the JPanel
    JPanel panel(JPanel... panel);

    DrawingEditor editor(DrawingEditor... editor);

    default DrawingEditor getEditor() {
        return editor();
    }

    default void setEditor(DrawingEditor editor) {
        editor(editor);
    }

    Drawing drawing(Drawing... drawing);

    Dimension size(Dimension... size);

    Painter displayUpdate(Painter... displayUpdate);

    PointConstrainer constrainer(PointConstrainer... constrainer);

    Color background(Color... background);

    Cursor cursor(Cursor... cursor);

    Rectangle damage(Rectangle... damage);

    Point lastClick(Point... lastClick);

    List fSelection = null;
    List fSelectionHandles = null;
    List fBackgrounds = null;
    List fForegrounds = null;

//    List<Handle> selectionHandles(Handle... selectionHandles);
//    List<Figure> selection(Figure... selection);
//    List<Handle> backgrounds(Painter... backgrounds);
//    List<Painter> foregrounds(Painter... foregrounds);

    default Tool tool() {
        return editor().tool();
    }

    default void setDrawing(Drawing d) {
        if (drawing() != null) {
            clearSelection();

            // @MDHD: it is at the data managed
            // drawing().removeDrawingChangeListener(this);
        }

        drawing(d);
        // @MDHD: it is at the data managed
        // if (drawing() != null) {
        //     drawing().addDrawingChangeListener(this);
        // }

        checkMinimumSize();

        // @MDHD: it is a member now not parent class
        // repaint();
        panel().repaint();
    }

    default Figure add(Figure figure) {
        return drawing().add(figure);
    }

    default Figure remove(Figure figure) {
        return drawing().remove(figure);
    }

    default void addAll(Collection figures) {
        FigureEnumeration fe = new FigureEnumerator(figures);
        while (fe.hasNextFigure()) {
            add(fe.nextFigure());
        }
    }

    default Boolean figureExists(Figure inf, FigureEnumeration fe) {
        while (fe.hasNextFigure()) {
            Figure figure = fe.nextFigure();

            if (figure.includes(inf)) {
                return true;
            }
        }
        return false;
    }

    default FigureEnumeration insertFigures(FigureEnumeration fe, int dx, int dy, Boolean bCheck) {
        if (fe == null) {
            return FigureEnumerator.getEmptyEnumeration();
        }

        java.util.List vCF = CollectionsFactory.current().createList(10);
        InsertIntoDrawingVisitor visitor = new InsertIntoDrawingVisitor(drawing());

        while (fe.hasNextFigure()) {
            Figure figure = fe.nextFigure();
            if (figure instanceof ConnectionFigure) {
                vCF.add(figure);
            }
            else if (figure != null) {
                figure.moveBy(dx, dy);
                figure.visit(visitor);
            }
        }

        FigureEnumeration ecf = new FigureEnumerator(vCF);

        while (ecf.hasNextFigure()) {
            ConnectionFigure cf = (ConnectionFigure) ecf.nextFigure();
            Figure sf = cf.startFigure();
            Figure ef = cf.endFigure();

            if (figureExists(sf, drawing().figures()) &&
                    figureExists(ef, drawing().figures()) &&
                    (!bCheck || cf.canConnect(sf, ef))) {

                if (bCheck) {
                    Point sp = sf.center();
                    Point ep = ef.center();
                    Connector fStartConnector = cf.startFigure().connectorAt(ep.x, ep.y);
                    Connector fEndConnector = cf.endFigure().connectorAt(sp.x, sp.y);

                    if (fEndConnector != null && fStartConnector != null) {
                        cf.connectStart(fStartConnector);
                        cf.connectEnd(fEndConnector);
                        cf.updateConnection();
                    }
                }

                cf.visit(visitor);
            }
        }

        addToSelectionAll(visitor.getInsertedFigures());
        return visitor.getInsertedFigures();
    }

    default Dimension getMinimumSize() {
        return size();
    }

    default Dimension getPreferredSize() {
        return getMinimumSize();
    }

    default FigureEnumeration selection() {
        return selectionZOrdered();
    }

    default FigureEnumeration selectionZOrdered() {
        List result = CollectionsFactory.current().createList(selectionCount());
        FigureEnumeration figures = drawing().figures();

        while (figures.hasNextFigure()) {
            Figure f= figures.nextFigure();
            if (isFigureSelected(f)) {
                result.add(f);
            }
        }
        return new ReverseFigureEnumerator(result);
    }

    default int selectionCount() {
        return fSelection.size();
    }

    default boolean isFigureSelected(Figure checkFigure) {
        return fSelection.contains(checkFigure);
    }

    default void addToSelection(Figure figure) {
        if (!isFigureSelected(figure) && drawing().includes(figure)) {
            fSelection.add(figure);
//            fSelectionHandles = null; TODO
            figure.invalidate();
//            fireSelectionChanged(); TODO
        }
    }

    default void addToSelectionAll(Collection figures) {
        addToSelectionAll(new FigureEnumerator(figures));
    }

    default void addToSelectionAll(FigureEnumeration fe) {
        while (fe.hasNextFigure()) {
            addToSelection(fe.nextFigure());
        }
    }

    default void removeFromSelection(Figure figure) {
        if (isFigureSelected(figure)) {
            fSelection.remove(figure);
//            fSelectionHandles = null; TODO
            figure.invalidate();
//            fireSelectionChanged(); TODO
        }
    }

    default void toggleSelection(Figure figure) {
        if (isFigureSelected(figure)) {
            removeFromSelection(figure);
        }
        else {
            addToSelection(figure);
        }
        // fireSelectionChanged(); TODO
    }

    default void clearSelection() {
        // there is nothing selected - bug fix ID 628818
        if (selectionCount() == 0) {
            // avoid unnecessary selection changed event when nothing has to be cleared
            return;
        }

        FigureEnumeration fe = selection();
        while (fe.hasNextFigure()) {
            fe.nextFigure().invalidate();
        }
        // fSelection = CollectionsFactory.current().createList(); TODO
        //fSelectionHandles = null; TODO
        //fireSelectionChanged(); TODO
    }

    default HandleEnumeration selectionHandles() {
        if (fSelectionHandles == null) {
//            fSelectionHandles = CollectionsFactory.current().createList(); // todo
            FigureEnumeration fe = selection();
            while (fe.hasNextFigure()) {
                Figure figure = fe.nextFigure();
                HandleEnumeration kk = figure.handles();
                while (kk.hasNextHandle()) {
                    fSelectionHandles.add(kk.nextHandle());
                }
            }
        }
        return new HandleEnumerator(fSelectionHandles);
    }

    default FigureSelection getFigureSelection() {
        return new StandardFigureSelection(selectionZOrdered(), selectionCount());
    }

    default Handle findHandle(int x, int y) {
        Handle handle;

        HandleEnumeration he = selectionHandles();
        while (he.hasNextHandle()) {
            handle = he.nextHandle();
            if (handle.containsPoint(x, y)) {
                return handle;
            }
        }
        return null;
    }

    default Point lastClick() {
        return null;
    }

    default void checkDamage() {
        Iterator each = drawing().drawingChangeListeners();
        while (each.hasNext()) {
            Object l = each.next();
            if (l instanceof DrawingView) {
                ((DrawingView)l).repairDamage();
            }
        }
    }

    default void repairDamage() {
        if (damage() != null) {
            // MDHD
			// repaint(damage().x, damage().y, damage().width, damage().height);
            panel().repaint(damage().x, damage().y, damage().width, damage().height);
            damage(null);
		}
    }


    default void drawingInvalidated(DrawingChangeEvent e) {

		Rectangle r = e.getInvalidatedRectangle();
		if (damage() == null) {
            damage(r);
		}
		else {
			// don't manipulate rectangle returned by getDamage() directly
			// because it could be a cloned rectangle.
			Rectangle damagedR = damage();
			damagedR.add(r);
            damage(damagedR);
		}
    }

    default void drawingRequestUpdate(DrawingChangeEvent e) {
        repairDamage();
    }

    default void drawingTitleChanged(DrawingChangeEvent e) {
    }

    default void paintComponent(Graphics g) {
        // displayUpdate().draw(g, this); TODO
         displayUpdate().draw(g, (DrawingView)this);
    }


    default void paint(Graphics g) {

    }

    default Image createImage(int width, int height) {
        return null;
    }

    default Graphics getGraphics() {
        return null;
    }

    default void drawAll(Graphics g) {
        Boolean isPrinting = g instanceof PrintGraphics;
        drawBackground(g);
        if ((fBackgrounds != null) && !isPrinting) {
            drawPainters(g, fBackgrounds);
        }
        drawDrawing(g);
        if ((fForegrounds != null) && !isPrinting) {
            drawPainters(g, fForegrounds);
        }
        if (!isPrinting) {
            drawHandles(g);
        }
    }

    default void drawPainters(Graphics g, List v) {
        for (int i = 0; i < v.size(); i++) {
//            ((Painter)v.get(i)).draw(g, this); TODO
            ((Painter)v.get(i)).draw(g, (DrawingView)this);
        }
    }


    default void draw(Graphics g, FigureEnumeration fe) {
        Boolean isPrinting = g instanceof PrintGraphics;
        //drawBackground(g);
        if ((fBackgrounds != null) && !isPrinting) {
            drawPainters(g, fBackgrounds);
        }
        drawing().draw(g, fe);
        if ((fForegrounds != null) && !isPrinting) {
            drawPainters(g, fForegrounds);
        }
        if (!isPrinting) {
            drawHandles(g);
        }
    }

    default void drawHandles(Graphics g) {
        HandleEnumeration he = selectionHandles();
        while (he.hasNextHandle()) {
            (he.nextHandle()).draw(g);
        }
    }

    default void drawDrawing(Graphics g) {
        drawing().draw(g);
    }

    default void drawBackground(Graphics g) {
//        g.setColor(getBackground());
//        g.fillRect(0, 0, getBounds().width, getBounds().height);
        g.setColor(panel().getBackground());
        g.fillRect(0, 0, panel().getBounds().width, panel().getBounds().height);
    }

//    default void addBackground(Painter painter)  {
//        if (fBackgrounds == null) {
//            fBackgrounds = CollectionsFactory.current().createList(3);
//        }
//        fBackgrounds.add(painter);
////        repaint();
//        panel().repaint();
//    }
//
//    default void removeBackground(Painter painter)  {
//        if (fBackgrounds != null) {
//            fBackgrounds.remove(painter);
//        }
////        repaint();
//        panel().repaint();
//    }
//
//    default void removeForeground(Painter painter)  {
//        if (fForegrounds != null) {
//            fForegrounds.remove(painter);
//        }
////        repaint();
//        panel().repaint();
//    }
//
//    default void addForeground(Painter painter)  {
//        if (fForegrounds == null) {
//            fForegrounds = CollectionsFactory.current().createList(3);
//        }
//        fForegrounds.add(painter);
////        repaint();
//        panel().repaint();
//    }

    default void freezeView() {
        drawing().lock();
    }

    default void unfreezeView() {
        drawing().unlock();
    }

    // @MDHD refactored
    // public void addFigureSelectionListener(FigureSelectionListener fsl);

    // @MDHD refactored
    // public void removeFigureSelectionListener(FigureSelectionListener fsl);

    default FigureEnumeration getConnectionFigures(Figure inFigure) {
        // If no figure or figure is non connectable, just return null
        if (inFigure == null || !inFigure.canConnect()) {
            return null;
        }

        // if (inFigure instanceof ConnectionFigure)
        //  return null;

        List result = CollectionsFactory.current().createList(5);
        FigureEnumeration figures = drawing().figures();

        // Find all connection figures
        while (figures.hasNextFigure()) {
            Figure f= figures.nextFigure();

            if ((f instanceof ConnectionFigure) && !(isFigureSelected(f))) {
                ConnectionFigure cf = (ConnectionFigure) f;

                if (cf.startFigure().includes(inFigure) ||
                        cf.endFigure().includes(inFigure)) {
                    result.add(f);
                }
            }
        }

        return new FigureEnumerator(result);
    }

    default void checkMinimumSize() {
        Dimension d = getDrawingSize();

        if (size().height < d.height || size().width < d.width) {
            Dimension newSize = new Dimension();
            newSize.height = d.height + SCROLL_OFFSET;
            newSize.width = d.width + SCROLL_OFFSET;
            size(newSize);
        }
    }

    default Dimension getDrawingSize() {
        FigureEnumeration fe = drawing().figures();
        Dimension d = new Dimension(0, 0);
        while (fe.hasNextFigure()) {
            Rectangle r = fe.nextFigure().displayBox();
            d.width = Math.max(d.width, r.x+r.width);
            d.height = Math.max(d.height, r.y+r.height);
        }
        return d;
    }

    default boolean isFocusTraversable() {
        return true;
    }

    default boolean isInteractive() {
        return true;
    }

    default Point constrainPoint(Point p) {
        // constrain to view size
        Dimension size = size();
        //p.x = Math.min(size.width, Math.max(1, p.x));
        //p.y = Math.min(size.height, Math.max(1, p.y));
        p.x = Geom.range(1, size.width, p.x);
        p.y = Geom.range(1, size.height, p.y);

        if (constrainer() != null ) {
            return constrainer().constrainPoint(p);
        }
        return p;
    }

    default void moveSelection(int dx, int dy) {
        FigureEnumeration figures = selection();
        while (figures.hasNextFigure()) {
            figures.nextFigure().moveBy(dx, dy);
        }
        checkDamage();
    }

    default void keyTyped(KeyEvent e) {}
    default void keyReleased(KeyEvent e) {}
}
