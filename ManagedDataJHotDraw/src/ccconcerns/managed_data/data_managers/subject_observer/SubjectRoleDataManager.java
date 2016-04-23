package ccconcerns.managed_data.data_managers.subject_observer;

import nl.cwi.managed_data_4j.language.data_manager.BasicDataManager;
import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;
import nl.cwi.managed_data_4j.language.schema.models.definition.Schema;

public class SubjectRoleDataManager extends BasicDataManager {

    public SubjectRoleDataManager(Class<?> moSchemaFactoryClass, Schema schema) {

        // Add the observable class in order to use it in the managed object.
        super(moSchemaFactoryClass, schema, SubjectRole.class);
    }

    @Override
    protected MObject createManagedObject(Klass klass, Object... _inits) {
        return new SubjectRoleMObject(klass, _inits);
    }
}