package ccconcerns.figure_selection_listener.figure_listener_subject_observer_data_manager;

import CH.ifa.draw.framework.Figure;

public interface FigureSelectionPointcut {
    void addToSelection(Figure figure);
    void removeFromSelection(Figure figure);
    void toggleSelection(Figure figure);
    void clearSelection();
}
