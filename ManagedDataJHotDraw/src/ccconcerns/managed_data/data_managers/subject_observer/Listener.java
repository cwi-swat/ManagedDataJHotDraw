package ccconcerns.managed_data.data_managers.subject_observer;

@FunctionalInterface
public interface Listener {
    void observe(Object obj, String field, Object value);
}
