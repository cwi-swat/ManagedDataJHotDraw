package ccconcerns.figure_selection_listener.figure_listener_subject_observer_data_manager;

import CH.ifa.draw.framework.Figure;
import ccconcerns.managed_data.data_managers.SubjectRole.SubjectRoleMObject;
import ccconcerns.managed_data.schemas.framework.MDStandardDrawingView;
import nl.cwi.managed_data_4j.language.schema.models.definition.Klass;

public class FigureSelectionListenerSubjectRoleMObject extends SubjectRoleMObject implements FigureSelectionPointcut {

    public FigureSelectionListenerSubjectRoleMObject(Klass schemaKlass, Object... initializers) {
        super(schemaKlass, initializers);
    }

    @Override
    public void addToSelection(Figure figure) {
        executeListenerActions();
    }

    @Override
    public void removeFromSelection(Figure figure) {
        executeListenerActions();
    }

    @Override
    public void toggleSelection(Figure figure) {
        executeListenerActions();
    }

    @Override
    public void clearSelection() {
        if (((MDStandardDrawingView) thisObject).selectionCount() > 0) {
            executeListenerActions();
        }
    }
}