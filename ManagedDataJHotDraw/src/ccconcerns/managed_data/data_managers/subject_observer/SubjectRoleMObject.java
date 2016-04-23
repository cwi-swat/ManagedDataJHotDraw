package ccconcerns.managed_data.data_managers.subject_observer;

import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.managed_object.managed_object_field.errors.InvalidFieldValueException;
import nl.cwi.managed_data_4j.language.managed_object.managed_object_field.errors.NoKeyFieldException;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

import java.util.ArrayList;
import java.util.List;

public class SubjectRoleMObject extends MObject implements SubjectRole {

    private List<Listener> listeners;

    public SubjectRoleMObject(Klass schemaKlass, Object... initializers) {
        super(schemaKlass, initializers);
        listeners = new ArrayList<Listener>();
    }

    @Override
    public void addListener(Listener _listener) {
        listeners.add(_listener);
    }

    @Override
    public void _set(String _name, Object _value) throws NoSuchFieldError, InvalidFieldValueException, NoKeyFieldException {
        super._set(_name, _value);

        listeners.forEach(listener -> listener.observe(this, _name, _value));
    }
}