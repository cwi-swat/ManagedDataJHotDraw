package ccconcerns.managed_data.data_managers.subject_observer;

import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

import java.util.HashMap;
import java.util.Map;

public class SubjectRoleMObject extends MObject implements SubjectRole {

    private class Tuple<X, Y> {
        public final X fst;
        public final Y snd;
        public Tuple(X fst, Y snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }

    private Map<Object, Tuple<SubjectPredicate, Action>> listeners;

    public SubjectRoleMObject(Klass schemaKlass, Object... initializers) {
        super(schemaKlass, initializers);
        listeners = new HashMap<>();
    }

    @Override
    public void add(Object listener, SubjectPredicate predicate, Action action) {
        listeners.put(listener, new Tuple<>(predicate, action));
    }

    @Override
    public void remove(Object listener) {
        listeners.remove(listener);
    }

    @Override
    protected void defaultMethodInvocation(String methodName, Object[] args) {

        // check if the predicate of the action holds for the specific method,
        // in case it holds execute the action.
        listeners.keySet().forEach(listener -> {
            final SubjectPredicate predicate = listeners.get(listener).fst;
            final Action action = listeners.get(listener).snd;

            if (predicate.test(this.getProxy(), methodName, args)) {

                System.out.println(" ** @MDHD ** " + methodName + " called, execute action!");

                action.execute();
            }
        });
    }
}