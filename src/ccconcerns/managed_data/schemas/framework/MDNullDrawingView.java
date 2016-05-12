package ccconcerns.managed_data.schemas.framework;

import CH.ifa.draw.framework.*;
import CH.ifa.draw.framework.Painter;
import CH.ifa.draw.standard.FigureEnumerator;
import CH.ifa.draw.standard.StandardFigureSelection;
import ccconcerns.managed_data.MDDrawingView;
import nl.cwi.managed_data_4j.M;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.List;

public interface MDNullDrawingView extends M, MDDrawingView {

    Dimension size(Dimension... size);

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

    Painter displayUpdate(Painter... displayUpdate);

    default void setDisplayUpdate(Painter _displayUpdate) {
        displayUpdate(_displayUpdate);
    }

    default Painter getDisplayUpdate() {
        return displayUpdate();
    }

    default PointConstrainer getConstrainer() {
        return null;
    }

    default void setConstrainer(PointConstrainer _constrainer) {
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

    List<Figure> fFigures(Figure... figures);

    default Tool tool() {
        return editor().tool();
    }

    default void setDrawing(Drawing d) {
        drawing(d);
    }

    default Figure add(Figure figure) {
        return figure;
    }

    default Figure remove(Figure figure) {
        return figure;
    }

    default FigureEnumeration insertFigures(FigureEnumeration fe, int dx, int dy, Boolean bCheck) {
        return FigureEnumerator.getEmptyEnumeration();
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
        return FigureEnumerator.getEmptyEnumeration();
    }

    default int selectionCount() {
        return 0;
    }

    default boolean isFigureSelected(Figure checkFigure) {
        return false;
    }

    default FigureSelection getFigureSelection() {
        return new StandardFigureSelection(selection(), 0);
    }

    default Handle findHandle(int x, int y) {
        return null;
    }

    default Point lastClick() {
        return new Point();
    }

    default void drawingInvalidated(DrawingChangeEvent e) {
        // ignore: do nothing
    }

    default void drawingRequestUpdate(DrawingChangeEvent e) {
        // ignore: do nothing
    }

    default void drawingTitleChanged(DrawingChangeEvent e) {
        // ignore: do nothing
    }

    default boolean isInteractive() {
        return false;
    }

    default Image createImage(int width, int height) {
        return null;
    }

    default Graphics getGraphics() {
        return null;
    }

    default FigureEnumeration getConnectionFigures(Figure inFigure) {
        return FigureEnumerator.getEmptyEnumeration();
    }

    default boolean isFocusTraversable() {
        return true;
    }
}
