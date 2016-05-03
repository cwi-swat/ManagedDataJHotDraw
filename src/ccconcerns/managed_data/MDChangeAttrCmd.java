package ccconcerns.managed_data;

import CH.ifa.draw.framework.DrawingEditor;
import CH.ifa.draw.framework.FigureAttributeConstant;
import CH.ifa.draw.framework.FigureEnumeration;
import CH.ifa.draw.framework.ViewChangeListener;
import CH.ifa.draw.standard.AbstractCommand;
import CH.ifa.draw.standard.ChangeAttributeCommand;
import CH.ifa.draw.util.Command;
import CH.ifa.draw.util.CommandListener;
import CH.ifa.draw.util.Undoable;
import ccconcerns.figure_selection_listener.figure_listener_subject_observer_data_manager.SubjectRole;
import nl.cwi.managed_data_4j.M;
import nl.cwi.managed_data_4j.language.schema.models.definition.annotations.Key;

public interface MDChangeAttrCmd extends M, Command, ViewChangeListener {

    // @MDHD Undo Refactoring: should not be used
    Undoable undoableActivity(Undoable... undoable);

    // @MDHD Undo Refactoring: should not be used
    default Undoable getUndoActivity() {
        return undoableActivity();
    }

    // @MDHD Undo Refactoring: should not be used
    default void setUndoActivity(Undoable newUndoableActivity) {
        undoableActivity(newUndoableActivity);
    }

    FigureAttributeConstant attribute(FigureAttributeConstant... fAttribute);
    Object value(Object... value);

    AbstractCommand.EventDispatcher eventDispatcher(AbstractCommand.EventDispatcher... eventDispatcher);

    default AbstractCommand.EventDispatcher getEventDispatcher() {
        return eventDispatcher();
    }

    default void setEventDispatcher(AbstractCommand.EventDispatcher newEventDispatcher) {
        eventDispatcher(newEventDispatcher);
    }

    @Key
    String name(String... name);

    default String getName() {
        return name();
    }

    default void setName(String newName) {
        name(newName);
    }

    DrawingEditor drawingEditor(DrawingEditor... myDrawingEditor);

    default DrawingEditor getDrawingEditor() {
        return drawingEditor();
    }

    default void setDrawingEditor(DrawingEditor newDrawingEditor) {
        drawingEditor(newDrawingEditor);
    }

    default MDDrawingView view() {
        return getDrawingEditor().view();
    }

    default void execute() {
        // @MDHD Undo Refactoring TODO:
//		FigureEnumeration fe = view().selection();
//		while (fe.hasNextFigure()) {
//			fe.nextFigure().setAttribute(fAttribute, fValue);
//		}
//		view().checkDamage();

        setUndoActivity(createUndoActivity());
        getUndoActivity().setAffectedFigures(view().selection());
        FigureEnumeration fe = getUndoActivity().getAffectedFigures();
        while (fe.hasNextFigure()) {
            fe.nextFigure().setAttribute(attribute(), value());
        }
        view().checkDamage();
    }

    // TODO: Remove
    default Undoable createUndoActivity() {
        return new ChangeAttributeCommand.UndoActivity(view(), attribute(), value());
    }

    default boolean isViewRequired() {
        return true;
    }

    default boolean isExecutableWithView() {
        return true;
    }

    default boolean isExecutable() {
        if (isViewRequired()) {
            if ((view() == null) || !view().isInteractive()) {
                return false;
            }
        }
        return isExecutableWithView();
    }

    default void addCommandListener(CommandListener newCommandListener) {
        getEventDispatcher().addCommandListener(newCommandListener);
    }

    default void removeCommandListener(CommandListener oldCommandListener) {
        getEventDispatcher().removeCommandListener(oldCommandListener);
    }

    default public void dispose() {
        if (view() != null) {

            // @MDHD: FigureSelectionListener (FSL) Refactoring
            ((SubjectRole) view()).removeListener(this);

            // @MDHD: FigureSelectionListener (FSL) Refactoring
//			view().removeFigureSelectionListener(this);
        }
    }

    default void viewSelectionChanged(MDDrawingView oldView, MDDrawingView newView) {
        if (oldView != null) {

            // @MDHD: FigureSelectionListener (FSL) Refactoring
//			oldView.removeFigureSelectionListener(this);

            // @MDHD: FigureSelectionListener (FSL) Refactoring
            if (oldView instanceof SubjectRole)
                ((SubjectRole) oldView).removeListener(this);
        }
        if (newView != null) {

            // @MDHD: FigureSelectionListener (FSL) Refactoring
//			newView.addFigureSelectionListener(this);

            // @MDHD: FigureSelectionListener (FSL) Refactoring
            ((SubjectRole) newView).addListener(this, this::figureSelectionChanged);

        }
        if (isViewRequired()) {
            boolean isOldViewInteractive = (oldView != null) && oldView.isInteractive();
            boolean isNewViewInteractive = (newView != null) && newView.isInteractive();

            // old view was not interactive aware while new view is now interactive aware
            if (!isOldViewInteractive && isNewViewInteractive) {
                getEventDispatcher().fireCommandExecutableEvent();
            }
            // old view was interactive aware while new view is not
            else if (isOldViewInteractive && !isNewViewInteractive) {
                getEventDispatcher().fireCommandNotExecutableEvent();
            }
        }
    }

    default void figureSelectionChanged() {
    }

    default void viewCreated(MDDrawingView view) {}
    default void viewDestroying(MDDrawingView view) {}
    default void figureSelectionChanged(MDDrawingView view) {}
}
