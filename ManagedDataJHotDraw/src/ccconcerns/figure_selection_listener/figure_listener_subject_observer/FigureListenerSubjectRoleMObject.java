package ccconcerns.figure_selection_listener.figure_listener_subject_observer;

import CH.ifa.draw.framework.Figure;
import ccconcerns.managed_data.MDDrawingView;
import ccconcerns.managed_data.schemas.framework.MDStandardDrawingView;
import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class FigureListenerSubjectRoleMObject extends MObject implements FigureSelectionPointcut, SubjectRole {

    private Map<Object, Action> listeners;

    public FigureListenerSubjectRoleMObject(Klass schemaKlass, Object... initializers) {
        super(schemaKlass, initializers);
        listeners = new HashMap<>();
    }

    private void executeListenerActions() {
        System.out.println(" > Execute Actions");
        listeners.values().forEach(Action::execute);
    }

    @Override
    public void addToSelection(Figure figure) {
        System.out.println("addToSelection");
        executeListenerActions();
    }

    @Override
    public void removeFromSelection(Figure figure) {
        System.out.println("removeFromSelection");
        executeListenerActions();
    }

    @Override
    public void toggleSelection(Figure figure) {
        System.out.println("toggleSelection");
        executeListenerActions();
    }

    @Override
    public void clearSelection() {
        if (((MDStandardDrawingView) this.getProxy()).selectionCount() > 0) {
            System.out.println("clearSelection");
            executeListenerActions();
        }
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