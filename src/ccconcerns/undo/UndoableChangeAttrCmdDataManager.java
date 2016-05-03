package ccconcerns.undo;

import nl.cwi.managed_data_4j.language.data_manager.BasicDataManager;
import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;
import nl.cwi.managed_data_4j.language.schema.models.definition.Schema;

public class UndoableChangeAttrCmdDataManager extends BasicDataManager {

    public UndoableChangeAttrCmdDataManager(Class<?> moSchemaFactoryClass, Schema schema) {
        super(moSchemaFactoryClass, schema, UndoableRole.class);
    }

    @Override
    protected MObject createManagedObject(Klass klass, Object... _inits) {
        return new UndoableChangeAttrCmdMObject(klass, _inits);
    }
}
