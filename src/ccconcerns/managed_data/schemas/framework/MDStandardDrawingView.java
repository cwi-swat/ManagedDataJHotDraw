package ccconcerns.managed_data.schemas.framework;

import CH.ifa.draw.framework.*;
import CH.ifa.draw.framework.Painter;
import CH.ifa.draw.standard.*;
import CH.ifa.draw.util.CollectionsFactory;
import CH.ifa.draw.util.Geom;
import ccconcerns.managed_data.MDDrawingView;
import nl.cwi.managed_data_4j.M;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public interface MDStandardDrawingView extends M, MDDrawingView {

    public static final int MINIMUM_WIDTH = 400;
    public static final int MINIMUM_HEIGHT = 300;
    public static final int SCROLL_OFFSET = 10;

    Rectangle damage(Rectangle... damage);

    Dimension size(Dimension... size);

    default Dimension getSize() {
        return size();
    }

    default void setSize(Dimension _s) {
        size(_s);
    }

    default Rectangle getDamage() {
        return damage();
    }

    default void setDamage(Rectangle r) {
        damage(r);
    }

    // Composition over inheritance,
    // the original inherits the JPanel
    JPanel panel(JPanel... panel);

    default JPanel getPanel() {
        return panel();
    }

    default void setPanel(JPanel _panel) {
        panel(_panel);
    }

    DrawingEditor editor(DrawingEditor... editor);

    default DrawingEditor getEditor() {
        return editor();
    }

    default void setEditor(DrawingEditor editor) {
        editor(editor);
    }

    Drawing drawing(Drawing... drawing);

    default Drawing getDrawing() {
        return drawing();
    }

    Painter displayUpdate(Painter... displayUpdate);

    default void setDisplayUpdate(Painter _displayUpdate) {
        displayUpdate(_displayUpdate);
    }

    default Painter getDisplayUpdate() {
        return displayUpdate();
    }

    PointConstrainer constrainer(PointConstrainer... constrainer);

    default PointConstrainer getConstrainer() {
        return constrainer();
    }

    default void setConstrainer(PointConstrainer _constrainer) {
        constrainer(_constrainer);
    }

    Color background(Color... background);

    default Color getBackground() {
        return panel().getBackground();
    }

    default void setBackground(Color bg) {
        panel().setBackground(bg);
    }

    Cursor cursor(Cursor... cursor);

    default Cursor getCursor() {
        return cursor();
    }

    default void setCursor(Cursor cur) {
        cursor(cur);
    }

    Point lastClick(Point... lastClick);

    default Point getLastClick() {
        return lastClick();
    }

    default void setLastClick(Point lc) {
        lastClick(lc);
    }

    // @MDHD: FigureSelectionListener (FSL) Refactoring
//    List<FigureSelectionListener> fSelectionListeners(FigureSelectionListener... listeners);

    List<Handle> fSelectionHandles(Handle... selectionHandles);
    List<Figure> fSelection(Figure... selection);
    List<Handle> fBackgrounds(Painter... backgrounds);
    List<Painter> fForegrounds(Painter... foregrounds);
    List<Figure> fFigures(Figure... figures);

    default void addFigure(Figure figure) {
        List<Figure> prev = fFigures();
        prev.add(figure);

        Figure[] newfsl =  prev.toArray(new Figure[prev.size()]);
        fFigures(newfsl);
    }

    default void removeFigure(Figure figure) {
        List<Figure> prev = fFigures();
        prev.remove(figure);

        Figure[] newfsl = prev.toArray(new Figure[prev.size()]);
        fFigures(newfsl);
    }

    default void addSelection(Figure figure) {
        List<Figure> prev = fSelection();
        prev.add(figure);

        Figure[] newfsl =  prev.toArray(new Figure[prev.size()]);
        fSelection(newfsl);
    }

    default void removeSelection(Figure figure) {
        List<Figure> prev = fSelection();
        prev.remove(figure);

        Figure[] newfsl =  prev.toArray(new Figure[prev.size()]);
        fSelection(newfsl);
    }

    default void addSelectionHandle(Handle handle) {
        List<Handle> prev = fSelectionHandles();
        prev.add(handle);

        Handle[] newfsl =  prev.toArray(new Handle[prev.size()]);
        fSelectionHandles(newfsl);
    }

    default void removeSelectionHandle(Handle handle) {
        List<Handle> prev = fSelectionHandles();
        prev.remove(handle);

        Handle[] newfsl =  prev.toArray(new Handle[prev.size()]);
        fSelectionHandles(newfsl);
    }

    default Tool tool() {
        return editor().tool();
    }

    default void setDrawing(Drawing d) {
        Drawing drawing = drawing();
        if (drawing() != null) {
            clearSelection();

            drawing.removeDrawingChangeListener(this);
            drawing(drawing);
        }

        drawing(d);

         if (drawing() != null) {
             Drawing drawing2 = drawing();
             drawing2.addDrawingChangeListener(this);
             drawing(drawing2);
         }

        checkMinimumSize();

        // @MDHD: it is a member now not parent class
        // repaint();
        panel().repaint();
    }

    default Figure add(Figure figure) {
        Drawing drawing = drawing();
        drawing.add(figure);
        drawing(drawing);
        return figure;
    }

    default Figure remove(Figure figure) {
        Drawing drawing = drawing();
        drawing.remove(figure);
        drawing(drawing);
        return figure;
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

        List vCF = CollectionsFactory.current().createList(10);
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
        return fSelection().size();
    }

    default boolean isFigureSelected(Figure checkFigure) {
        List<Figure> sel = fSelection();

        for (Figure figure : sel) {
            if (figure.equals(checkFigure))
                return true;
        }

        return false;
    }

    default void addToSelectionAll(Collection figures) {
        addToSelectionAll(new FigureEnumerator(figures));
    }

    default void addToSelectionAll(FigureEnumeration fe) {
        while (fe.hasNextFigure()) {
            addToSelection(fe.nextFigure());
        }
    }

    default HandleEnumeration selectionHandles() {
        if (fSelectionHandles().size() == 0) {
            fSelectionHandles(null);

            FigureEnumeration fe = selection();
            List<Handle> handles = new LinkedList<>();
            while (fe.hasNextFigure()) {
                Figure figure = fe.nextFigure();
                HandleEnumeration kk = figure.handles();
                while (kk.hasNextHandle()) {
                    handles.add(kk.nextHandle());
                }
            }
            fSelectionHandles(handles.toArray(new Handle[handles.size()]));
        }
        return new HandleEnumerator(fSelectionHandles());
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

    default void checkDamage() {
        Iterator each = drawing().drawingChangeListeners();
        while (each.hasNext()) {
            Object l = each.next();
            if (l instanceof MDDrawingView) {
                ((MDDrawingView)l).repairDamage();
            }
        }
    }

    default void repairDamage() {
        if (getDamage() != null) {
            panel().repaint(damage().x, damage().y, damage().width, damage().height);
            setDamage(null);
		}
    }

    default void drawingInvalidated(DrawingChangeEvent e) {

        Rectangle r = e.getInvalidatedRectangle();
		if (getDamage() == null) {
            setDamage(r);
		}
		else {
			// don't manipulate rectangle returned by getDamage() directly
			// because it could be a cloned rectangle.
            Rectangle damagedR = getDamage();
			damagedR.add(r);
            setDamage(damagedR);
		}

        // TODO: not sure
        repairDamage();
    }

    default void drawingRequestUpdate(DrawingChangeEvent e) {
        repairDamage();
    }

    default void drawingTitleChanged(DrawingChangeEvent e) {
    }

    default void paintComponent(Graphics g) {
        Painter displayStrategy = getDisplayUpdate();
        displayStrategy.draw(g, this);
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
        if ((fBackgrounds() != null) && !isPrinting) {
            drawPainters(g, fBackgrounds());
        }
        drawDrawing(g);
        if ((fForegrounds() != null) && !isPrinting) {
            drawPainters(g, fForegrounds());
        }
        if (!isPrinting) {
            drawHandles(g);
        }
    }

    default void drawPainters(Graphics g, List v) {
        for (int i = 0; i < v.size(); i++) {
            ((Painter)v.get(i)).draw(g, this);
        }
    }

    default void draw(Graphics g, FigureEnumeration fe) {
        Boolean isPrinting = g instanceof PrintGraphics;
        if ((fBackgrounds() != null) && !isPrinting) {
            drawPainters(g, fBackgrounds());
        }
        drawing().draw(g, fe);
        if ((fForegrounds() != null) && !isPrinting) {
            drawPainters(g, fForegrounds());
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
        g.setColor(panel().getBackground());
        g.fillRect(0, 0, panel().getBounds().width, panel().getBounds().height);
    }

    default void freezeView() {
        drawing().lock();
    }

    default void unfreezeView() {
        drawing().unlock();
    }

    default FigureEnumeration getConnectionFigures(Figure inFigure) {
        // If no figure or figure is non connectable, just return null
        if (inFigure == null || !inFigure.canConnect()) {
            return null;
        }

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
            Dimension newSize = new Dimension(0, 0);
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
            d.width = Math.max(d.width, r.x + r.width);
            d.height = Math.max(d.height, r.y + r.height);
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

    // @MDHD: FigureSelectionListener (FSL) Refactoring
    // ===========================================================================================
    // ===========================================================================================
    // ===========================================================================================
    default void addToSelection(Figure figure) {
        if (!isFigureSelected(figure) && drawing().includes(figure)) {
            addSelection(figure);
            fSelectionHandles(null);
            figure.invalidate();

            // @MDHD: FigureSelectionListener (FSL) Refactoring
            //  fireSelectionChanged();
        }
    }

    default void removeFromSelection(Figure figure) {
        if (isFigureSelected(figure)) {
            removeSelection(figure);
            fSelectionHandles(null);

            figure.invalidate();

            // @MDHD: FigureSelectionListener (FSL) Refactoring
            //  fireSelectionChanged();
        }
    }

    default void toggleSelection(Figure figure) {
        if (isFigureSelected(figure)) {
            removeFromSelection(figure);
        }
        else {
            addToSelection(figure);
        }

        // @MDHD: FigureSelectionListener (FSL) Refactoring
        //  fireSelectionChanged();
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

        fSelection(null);
        fSelectionHandles(null);

        // @MDHD: FigureSelectionListener (FSL) Refactoring
        //  fireSelectionChanged();
    }

    // @MDHD: FigureSelectionListener (FSL) Refactoring
//    default void fireSelectionChanged() {
//        if (fSelectionListeners() != null) {
//            for (int i = 0; i < fSelectionListeners().size(); i++) {
//                List<FigureSelectionListener> listeners = fSelectionListeners();
//                FigureSelectionListener l = listeners.get(i);
//				l.figureSelectionChanged(this);
//            }
//        }
//    }

    // @MDHD: FigureSelectionListener (FSL) Refactoring
//    default void addFigureSelectionListener(FigureSelectionListener fsl) {
//        List<FigureSelectionListener> prev = fSelectionListeners();
//        prev.add(fsl);
//        FigureSelectionListener[] newfsl =  prev.toArray(new FigureSelectionListener[prev.size()]);
//        fSelectionListeners(newfsl);
//    }
//

    // @MDHD: FigureSelectionListener (FSL) Refactoring
//    default void removeFigureSelectionListener(FigureSelectionListener fsl) {
//        List<FigureSelectionListener> prev = fSelectionListeners();
//        prev.remove(fsl);
//        FigureSelectionListener[] newfsl =  prev.toArray(new FigureSelectionListener[prev.size()]);
//        fSelectionListeners(newfsl);
//    }
}
