/*
 * @(#)UndoableCommand.java
 *
 * Project:		JHotdraw - a GUI framework for technical drawings
 *				http://www.jhotdraw.org
 *				http://jhotdraw.sourceforge.net
 * Copyright:	� by the original author(s) and all contributors
 * License:		Lesser GNU Public License (LGPL)
 *				http://www.opensource.org/licenses/lgpl-license.html
 */

package CH.ifa.draw.util;

import CH.ifa.draw.framework.*;
import CH.ifa.draw.standard.AbstractCommand;
import ccconcerns.figure_selection_listener.FigureSelectionConcerns;
import ccconcerns.managed_data.data_managers.subject_observer.SubjectRole;
import ccconcerns.managed_data.schemas.framework.MDStandardDrawingView;

import java.util.EventObject;

/**
 * @author  Wolfram Kaiser <mrfloppy@sourceforge.net>
 * @version <$CURRENT_VERSION$>
 */
// @MDHD: FigureSelectionListener (FSL) Refactoring
public class UndoableCommand implements Command, /* @MDHD FigureSelectionListener,*/ CommandListener {

	private Command myWrappedCommand;
	private boolean hasSelectionChanged;
	private AbstractCommand.EventDispatcher myEventDispatcher;
	public UndoableCommand(Command newWrappedCommand) {
		setWrappedCommand(newWrappedCommand);
		getWrappedCommand().addCommandListener(this);
		setEventDispatcher(createEventDispatcher());
	}

	/**
	 * Tests if the command can be executed.
	 */
	public boolean isExecutable() {
		return getWrappedCommand().isExecutable();
	}

	protected void setWrappedCommand(Command newWrappedCommand) {
		myWrappedCommand = newWrappedCommand;
	}

	protected Command getWrappedCommand() {
		return myWrappedCommand;
	}

	/**
	 * Gets the command name.
	 */
	public String name() {
		return getWrappedCommand().name();
	}

	public DrawingEditor getDrawingEditor() {
		return getWrappedCommand().getDrawingEditor();
	}

	public MDStandardDrawingView view() {
		return getDrawingEditor().view();
	}

	public Undoable getUndoActivity() {
		return new UndoableAdapter(view());
	}

	public void setUndoActivity(Undoable newUndoableActivity) {
		// do nothing: always return default UndoableAdapter
	}

	public void addCommandListener(CommandListener newCommandListener) {
		getEventDispatcher().addCommandListener(newCommandListener);
	}

	public void removeCommandListener(CommandListener oldCommandListener) {
		getEventDispatcher().removeCommandListener(oldCommandListener);
	}

	private void setEventDispatcher(AbstractCommand.EventDispatcher newEventDispatcher) {
		myEventDispatcher = newEventDispatcher;
	}

	protected AbstractCommand.EventDispatcher getEventDispatcher() {
		return myEventDispatcher;
	}

	public AbstractCommand.EventDispatcher createEventDispatcher() {
		return new AbstractCommand.EventDispatcher(this);
	}

	public void commandExecuted(EventObject commandEvent) {
		getEventDispatcher().fireCommandExecutedEvent();
	}

	public void commandExecutable(EventObject commandEvent) {
		getEventDispatcher().fireCommandExecutableEvent();
	}

	public void commandNotExecutable(EventObject commandEvent) {
		getEventDispatcher().fireCommandNotExecutableEvent();
	}

	// @MDHD: FigureSelectionListener (FSL) Refactoring
	// ===========================================================================================
	// ===========================================================================================
	// ===========================================================================================
	/**
	 * Executes the command.
	 */
	public void execute() {
		hasSelectionChanged = false;
		// listen for selection change events during executing the wrapped command

		// @MDHD: FigureSelectionListener (FSL) Refactoring
//		view().addFigureSelectionListener(this);

		// @MDHD: FigureSelectionListener (FSL) Refactoring
		((SubjectRole) view()).add(this, FigureSelectionConcerns::consistentBehaviorPredicate, this::figureSelectionChanged);

		getWrappedCommand().execute();

		Undoable undoableCommand = getWrappedCommand().getUndoActivity();
		if ((undoableCommand != null) && (undoableCommand.isUndoable())) {
			getDrawingEditor().getUndoManager().pushUndo(undoableCommand);
			getDrawingEditor().getUndoManager().clearRedos();
		}

		// initiate manual update of undo/redo menu states if it has not
		// been done automatically during executing the wrapped command
		if (!hasSelectionChanged || (getDrawingEditor().getUndoManager().getUndoSize() == 1)) {

			// @MDHD: FigureSelectionListener (FSL) Refactoring
//			getDrawingEditor().figureSelectionChanged(view());
			getDrawingEditor().figureSelectionChanged();
		}

		// @MDHD: FigureSelectionListener (FSL) Refactoring
//		view().removeFigureSelectionListener(this);

		// @MDHD: FigureSelectionListener (FSL) Refactoring
		((SubjectRole) view()).remove(this);
	}

	// @MDHD: FigureSelectionListener (FSL) Refactoring
//	public void figureSelectionChanged(MDStandardDrawingView view) {
//		hasSelectionChanged = true;
//	}

	public void figureSelectionChanged() {
		hasSelectionChanged = true;
	}
}
