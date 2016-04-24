package ccconcerns.figure_selection_listener;

import ccconcerns.managed_data.schemas.MDStandardDrawingView;

public class ConsistentBehavior {

    public static void figureSelectionConsistentBehavior(Object subjectObject, String methodName, Object[] args) {
        if (methodName.equals("addToSelection") ||
            methodName.equals("removeFromSelection") ||
            methodName.equals("toggleSelection") ||
            (methodName.equals("clearSelection") && ((MDStandardDrawingView) subjectObject).selectionCount() > 0))
        {
            System.out.println(" **** ConsistentBehavior FOUND **** " + methodName);
        }
    }
}
