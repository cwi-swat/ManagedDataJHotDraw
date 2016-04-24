package ccconcerns.managed_data.data_managers.subject_observer;

@FunctionalInterface
public interface SubjectPredicate {
    boolean test(Object subjectObject, String methodName, Object[] args);
}
