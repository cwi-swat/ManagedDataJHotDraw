package ccconcerns.figure_selection_listener.figure_listener_subject_observer;

public interface SubjectRole {
    void addListener(Object listener, Action action);
    void removeListener(Object listener);
}
