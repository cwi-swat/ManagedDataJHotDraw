package ccconcerns.managed_data;

import CH.ifa.draw.framework.*;
import CH.ifa.draw.framework.Painter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Collection;

public interface MDDrawingView extends ImageObserver, DrawingChangeListener {

    default JPanel getPanel() {
        return null;
    }

    default void setPanel(JPanel panel) {}

    default void setEditor(DrawingEditor editor) {}

    default Tool tool() {
        return null;
    }

    default Drawing getDrawing() {
        return null;
    }

    default void setDrawing(Drawing d) {}

    default void setEditor() {

    }

    default DrawingEditor getEditor() {
        return null;
    }

    default Figure add(Figure figure) {
        return null;
    }

    default Figure remove(Figure figure) {
        return null;
    }

    default void addAll(Collection figures) {}

    default Dimension getSize() {
        return null;
    }

    default Dimension getMinimumSize() {
        return null;
    }

    default Dimension getPreferredSize() {
        return null;
    }

    default void setDisplayUpdate(Painter updateStrategy) {}

    default Painter getDisplayUpdate() {
        return null;
    }

    default FigureEnumeration selection() {
        return null;
    }

    default FigureEnumeration selectionZOrdered() {
        return null;
    }

    default int selectionCount() {
        return 0;
    }

    default boolean isFigureSelected(Figure checkFigure) {
        return false;
    }

    default void addToSelection(Figure figure) {}

    default void addToSelectionAll(Collection figures) {}

    default void addToSelectionAll(FigureEnumeration fe) {}

    default void removeFromSelection(Figure figure) {}

    default void toggleSelection(Figure figure) {}

    default void clearSelection() {}

    default FigureSelection getFigureSelection() {
        return null;
    }

    default Handle findHandle(int x, int y) {
        return null;
    }

    default Point lastClick() {
        return null;
    }

    default void setConstrainer(PointConstrainer p) {}

    default PointConstrainer getConstrainer() {
        return null;
    }

    default void checkDamage() {}

    default void repairDamage() {}

    default void paint(Graphics g) {}

    default Image createImage(int width, int height) {
        return null;
    }

    default Graphics getGraphics() {
        return null;
    }

    default Color getBackground() {
        return null;
    }

    default void setBackground(Color c) {}

    default void drawAll(Graphics g) {}

    default void draw(Graphics g, FigureEnumeration fe) {}

    default void drawHandles(Graphics g) {}

    default void drawDrawing(Graphics g) {}

    default void drawBackground(Graphics g) {}

    default void setCursor(Cursor c) {}

    default void freezeView() {}

    default void unfreezeView() {}

    default FigureEnumeration getConnectionFigures(Figure inFigure) {
        return null;
    }

    default FigureEnumeration insertFigures(FigureEnumeration inFigures, int dx, int dy, boolean bCheck) {
        return null;
    }

    default boolean isInteractive() {
        return false;
    }

    default void moveSelection(int dx, int dy) {

    }
}
