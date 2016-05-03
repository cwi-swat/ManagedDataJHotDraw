package ccconcerns.undo;

import CH.ifa.draw.util.Undoable;

public interface UndoableRole {
    public Undoable getUndoActivity();
    public void setUndoActivity(Undoable newUndoableActivity);
}
