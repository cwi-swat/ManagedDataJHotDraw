package ccconcerns.managed_data.schemas.framework.tools;

import ccconcerns.managed_data.schemas.framework.MDDrawingEditor;
import nl.cwi.managed_data_4j.language.schema.models.definition.M;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface MDTool extends M {
    Boolean active(Boolean... active);
    Boolean enabled(Boolean... enabled);
    MDDrawingEditor editor(MDDrawingEditor... editor);

    default void mouseDown(MouseEvent e, int x, int y) {}
    default void mouseDrag(MouseEvent e, int x, int y) {}
    default void mouseUp(MouseEvent e, int x, int y) {}
    default void mouseMove(MouseEvent evt, int x, int y) {}
    default void keyDown(KeyEvent evt, int key) {}
}
