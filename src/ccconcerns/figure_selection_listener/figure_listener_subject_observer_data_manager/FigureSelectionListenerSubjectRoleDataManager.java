package ccconcerns.figure_selection_listener.figure_listener_subject_observer_data_manager;

import ccconcerns.managed_data.data_managers.SubjectRole.SubjectRoleDataManager;
import nl.cwi.managed_data_4j.language.managed_object.MObject;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

public class FigureSelectionListenerSubjectRoleDataManager extends SubjectRoleDataManager {

    @Override
    protected MObject createManagedObject(Klass klass, Object... _inits) {
        return new FigureSelectionListenerSubjectRoleMObject(klass, _inits);
    }
}