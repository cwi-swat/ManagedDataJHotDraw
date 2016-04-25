package ccconcerns.managed_data.schemas.framework;

import CH.ifa.draw.framework.DrawingChangeListener;
import nl.cwi.managed_data_4j.language.schema.models.definition.M;
import nl.cwi.managed_data_4j.language.schema.models.definition.annotations.Key;

import java.util.Iterator;
import java.util.List;

// TODO
public interface MDStandardDrawing extends M {

    @Key
    String title(String... title);

    // =======================================================
    // ===== Listeners Stuff
    List<DrawingChangeListener> fListeners(DrawingChangeListener... listeners);

    default void addListener(DrawingChangeListener listener) {
        List<DrawingChangeListener> prev = fListeners();
        prev.add(listener);

        DrawingChangeListener[] newfsl =  prev.toArray(new DrawingChangeListener[prev.size()]);
        fListeners(newfsl);
    }

    default void removeListener(DrawingChangeListener listener) {
        List<DrawingChangeListener> prev = fListeners();
        prev.remove(listener);

        DrawingChangeListener[] newfsl =  prev.toArray(new DrawingChangeListener[prev.size()]);
        fListeners(newfsl);
    }

    default void addDrawingChangeListener(DrawingChangeListener listener) {
        addListener(listener);
    }

    default void removeDrawingChangeListener(DrawingChangeListener listener) {
        removeListener(listener);
    }

    default Iterator drawingChangeListeners() {
        return fListeners().iterator();
    }
    // =======================================================
}
