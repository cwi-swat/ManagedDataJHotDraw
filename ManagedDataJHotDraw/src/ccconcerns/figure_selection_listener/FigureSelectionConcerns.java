package ccconcerns.figure_selection_listener;

import ccconcerns.managed_data.schemas.MDStandardDrawingView;

public class FigureSelectionConcerns {

    public static boolean consistentBehaviorPredicate(Object subjectObject, String methodName, Object[] args) {
        return
            methodName.equals("addToSelection")      ||
            methodName.equals("removeFromSelection") ||
            methodName.equals("toggleSelection")     ||
            (methodName.equals("clearSelection")     &&
                ((MDStandardDrawingView) subjectObject).selectionCount() > 0);
    }
}
