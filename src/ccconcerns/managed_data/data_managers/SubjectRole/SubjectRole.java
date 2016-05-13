package ccconcerns.managed_data.data_managers.SubjectRole;

public interface SubjectRole {
    void addListener(Object listener, Action action);
    void removeListener(Object listener);
    void executeListenerActions();
}
