package ccconcerns.managed_data.data_managers.subject_observer;

@FunctionalInterface
public interface Listener {
    void observeInvocation(Object subjectObject, String methodName, Object[] args);
}
