package ccconcerns.undo;

import CH.ifa.draw.util.Undoable;
import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

import java.lang.reflect.Method;

public abstract class UndoableMObject extends MObject implements UndoableRole {

    private Undoable myUndoableActivity;

    public UndoableMObject(Klass schemaKlass, Object... initializers) {
        super(schemaKlass, UndoableRole.class);
    }

    @Override
    public Undoable getUndoActivity() {
        return myUndoableActivity;
    }

    @Override
    public void setUndoActivity(Undoable newUndoableActivity) {
        myUndoableActivity = newUndoableActivity;
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
