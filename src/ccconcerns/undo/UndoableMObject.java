package ccconcerns.undo;

import CH.ifa.draw.util.Undoable;
import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

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
}
