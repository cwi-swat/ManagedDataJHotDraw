package ccconcerns.managed_data.data_managers.subject_observer;

public interface SubjectRole {
    void add(Object listener, SubjectPredicate predicate, Action action);
    void remove(Object listener);
}
