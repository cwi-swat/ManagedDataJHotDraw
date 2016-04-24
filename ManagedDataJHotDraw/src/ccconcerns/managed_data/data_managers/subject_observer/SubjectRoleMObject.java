package ccconcerns.managed_data.data_managers.subject_observer;

import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

import java.util.ArrayList;
import java.util.List;

public class SubjectRoleMObject extends MObject implements SubjectRole {

    private List<Listener> listeners;

    public SubjectRoleMObject(Klass schemaKlass, Object... initializers) {
        super(schemaKlass, initializers);
        listeners = new ArrayList<>();
    }

    @Override
    public void addListener(Listener _listener) {
        listeners.add(_listener);
    }
    @Override
    protected void defaultMethodInvocation(String methodName, Object[] args) {
        listeners.forEach(listener -> listener.observeInvocation(this.getProxy(), methodName, args));
    }
}