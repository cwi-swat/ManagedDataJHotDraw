package ccconcerns.managed_data.data_managers.SubjectRole;

import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SubjectRoleMObject extends MObject implements SubjectRole {

    protected Map<Object, Action> listeners;

    public SubjectRoleMObject(Klass schemaKlass, Object... initializers) {
        super(schemaKlass, initializers);
        listeners = new HashMap<>();
    }

    protected void executeListenerActions() {
        listeners.values().forEach(Action::execute);
    }

    @Override
    public void addListener(Object listener, Action action) {
        listeners.put(listener, action);
    }

    @Override
    public void removeListener(Object listener) {
        listeners.remove(listener);
    }

    @Override
    protected Object _invokeDefaultMethod(Object proxy, Method method, Object[] args) throws Throwable {
        for (Method objMethod : this.getClass().getMethods()) {
            if (method.getName().equals(objMethod.getName()) &&
                method.getReturnType().equals(objMethod.getReturnType()))
            {
                System.out.println("Going to call: " + method.getName());
                objMethod.invoke(this, args);
            }
        }
        return super._invokeDefaultMethod(proxy, method, args);
    }
}