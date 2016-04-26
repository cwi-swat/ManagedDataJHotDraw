package ccconcerns.figure_selection_listener.figure_listener_subject_observer_data_manager;

public interface SubjectRole {
    void addListener(Object listener, Action action);
    void removeListener(Object listener);
}
