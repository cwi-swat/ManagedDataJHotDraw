package ccconcerns.figure_selection_listener.figure_listener_subject_observer_data_manager;

import nl.cwi.managed_data_4j.language.data_manager.BasicDataManager;
import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;
import nl.cwi.managed_data_4j.language.schema.models.definition.Schema;

public class FigureListenerSubjectRoleDataManager extends BasicDataManager {

    public FigureListenerSubjectRoleDataManager(Class<?> moSchemaFactoryClass, Schema schema) {

        // Add the observable class in order to use it in the managed object.
        super(moSchemaFactoryClass, schema, SubjectRole.class);
    }

    @Override
    protected MObject createManagedObject(Klass klass, Object... _inits) {
        return new FigureListenerSubjectRoleMObject(klass, _inits);
    }
}