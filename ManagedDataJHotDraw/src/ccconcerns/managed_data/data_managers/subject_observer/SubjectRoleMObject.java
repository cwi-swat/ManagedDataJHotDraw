package ccconcerns.managed_data.data_managers.subject_observer;

import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

import java.util.HashMap;
import java.util.Map;

public class SubjectRoleMObject extends MObject implements SubjectRole {

    private Map<SubjectPredicate, Action> listeners;

    public SubjectRoleMObject(Klass schemaKlass, Object... initializers) {
        super(schemaKlass, initializers);
        listeners = new HashMap<>();
    }

    @Override
    public void add(SubjectPredicate predicate, Action action) {
        listeners.put(predicate, action);
    }

    @Override
    protected void defaultMethodInvocation(String methodName, Object[] args) {

        // check if the predicate of the action holds for the specific method,
        // in case it holds execute the action.
        listeners.keySet().forEach(subjectPredicate -> {
            if (subjectPredicate.test(this.getProxy(), methodName, args)) {

                System.out.println(" ** @MDHD ** " + methodName + " called, execute action!");

                final Action action = listeners.get(subjectPredicate);
                action.execute();
            }
        });
    }
}