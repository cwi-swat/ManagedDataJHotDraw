package ccconcerns.undo;

import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureAttributeConstant;
import CH.ifa.draw.framework.FigureEnumeration;
import CH.ifa.draw.util.Undoable;
import CH.ifa.draw.util.UndoableAdapter;
import ccconcerns.managed_data.MDChangeAttrCmd;
import ccconcerns.managed_data.MDDrawingView;
import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

import java.util.Hashtable;

public class UndoableChangeAttrCmdMObject extends UndoableMObject implements Executable {

    public UndoableChangeAttrCmdMObject(Klass schemaKlass, Object... initializers) {
        super(schemaKlass, initializers);
    }

    @Override
    public Undoable createUndoActivity() {
        final MDChangeAttrCmd thisObj = ((MDChangeAttrCmd) thisObject);
        return new UndoActivity(thisObj.view(), thisObj.attribute(), thisObj.value());
    }

    @Override
    public void execute() {
        final MDChangeAttrCmd thisObj = ((MDChangeAttrCmd) thisObject);
        setUndoActivity(createUndoActivity());
        getUndoActivity().setAffectedFigures(thisObj.view().selection());
        System.out.println(" !!! execute: Undoable Change Attribute Command Data Manager !!!");
    }

    public static class UndoActivity extends UndoableAdapter {
        private FigureAttributeConstant myUndoAttribute;
        private Hashtable myOriginalValues;
        private Object myUndoValue;

        public UndoActivity(MDDrawingView newDrawingView, FigureAttributeConstant newUndoAttribute, Object newUndoValue) {
            super(newDrawingView);
            myOriginalValues = new Hashtable();
            setAttribute(newUndoAttribute);
            setBackupValue(newUndoValue);
            setUndoable(true);
            setRedoable(true);
        }

        public boolean undo() {
            if (!super.undo()) {
                return false;
            }

            FigureEnumeration fe = getAffectedFigures();
            while (fe.hasNextFigure()) {
                Figure f = fe.nextFigure();
                if (getOriginalValue(f) != null) {
                    f.setAttribute(getAttribute(), getOriginalValue(f));
                }
            }

            return true;
        }

        public boolean redo() {
            if (!isRedoable()) {
                return false;
            }

            FigureEnumeration fe = getAffectedFigures();
            while (fe.hasNextFigure()) {
                Figure f = fe.nextFigure();
                if (getBackupValue() != null) {
                    f.setAttribute(getAttribute(), getBackupValue());
                }
            }

            return true;
        }

        protected void addOriginalValue(Figure affectedFigure, Object newOriginalValue) {
            myOriginalValues.put(affectedFigure, newOriginalValue);
        }

        protected Object getOriginalValue(Figure lookupAffectedFigure) {
            return myOriginalValues.get(lookupAffectedFigure);
        }

        protected void setAttribute(FigureAttributeConstant newUndoAttribute) {
            myUndoAttribute = newUndoAttribute;
        }

        public FigureAttributeConstant getAttribute() {
            return myUndoAttribute;
        }

        protected void setBackupValue(Object newUndoValue) {
            myUndoValue = newUndoValue;
        }

        public Object getBackupValue() {
            return myUndoValue;
        }

        public void release() {
            super.release();
            myOriginalValues = null;
        }

        public void setAffectedFigures(FigureEnumeration fe) {
            // first make copy of FigureEnumeration in superclass
            super.setAffectedFigures(fe);
            // then get new FigureEnumeration of copy to save attributes
            FigureEnumeration copyFe = getAffectedFigures();
            while (copyFe.hasNextFigure()) {
                Figure f = copyFe.nextFigure();
                Object attributeValue = f.getAttribute(getAttribute());
                if (attributeValue != null) {
                    addOriginalValue(f, attributeValue);
                }
            }
        }
    }
}
