/*
 * @(#)JavaDrawViewer.java
 *
 * Project:		JHotdraw - a GUI framework for technical drawings
 *				http://www.jhotdraw.org
 *				http://jhotdraw.sourceforge.net
 * Copyright:	� by the original author(s) and all contributors
 * License:		Lesser GNU Public License (LGPL)
 *				http://www.opensource.org/licenses/lgpl-license.html
 */

package CH.ifa.draw.samples.javadraw;

import CH.ifa.draw.framework.*;
import CH.ifa.draw.standard.*;
import CH.ifa.draw.util.*;
import ccconcerns.managed_data.MDDrawingView;
import ccconcerns.managed_data.factories.MDDrawingViewFactory;
import ccconcerns.managed_data.schemas.framework.MDStandardDrawingView;

import javax.swing.JApplet;
import java.awt.*;
import java.io.*;
import java.net.*;

/**
 * @version <$CURRENT_VERSION$>
 */
public  class JavaDrawViewer extends JApplet implements DrawingEditor {

	private Drawing         fDrawing;
	private Tool            fTool;
	private MDDrawingView fView;
	private transient 		UndoManager myUndoManager;

	public void init() {
		setUndoManager(new UndoManager());
		getContentPane().setLayout(new BorderLayout());
		fView = MDDrawingViewFactory.newDrawingView(this, 400, 370);

		getContentPane().add("Center", fView.getPanel());
		setTool(new FollowURLTool(this, this));

		String filename = getParameter("Drawing");
		if (filename != null) {
			loadDrawing(filename);
			fView.setDrawing(fDrawing);
		}
		else {
			showStatus("Unable to load drawing");
		}
	}

	public void addViewChangeListener(ViewChangeListener vsl)  {
	}

	public void removeViewChangeListener(ViewChangeListener vsl) {
	}

	private void loadDrawing(String filename) {
		try {
			URL url = new URL(getCodeBase(), filename);
			InputStream stream = url.openStream();
			StorableInput reader = new StorableInput(stream);
			fDrawing = (Drawing)reader.readStorable();
		}
		catch (IOException e) {
			fDrawing = createDrawing();
			System.err.println("Error when Loading: " + e);
			showStatus("Error when Loading: " + e);
		}
	}

	protected Drawing createDrawing() {
		return new StandardDrawing();
	}

	/**
	 * Gets the editor's drawing view.
	 */
	public MDDrawingView view() {
		return fView;
	}

	public MDDrawingView[] views() {
		return new MDDrawingView[] { view() };
	}

	/**
	 * Gets the editor's drawing.
	 */
	public Drawing drawing() {
		return fDrawing;
	}

	/**
	 * Gets the current the tool (there is only one):
	 */
	public Tool tool() {
		return fTool;
	}

	/**
     * Sets the current the tool
     */
	public void setTool(Tool newTool) {
		fTool = newTool;
	}

    /**
	 * Sets the editor's default tool. Do nothing since we only have one tool.
	 */
	public void toolDone() {}

	// @MDHD: FigureSelectionListener (FSL) Refactoring
//	public void figureSelectionChanged(MDStandardDrawingView view) {}
	public void figureSelectionChanged() {}

	protected void setUndoManager(UndoManager newUndoManager) {
		myUndoManager = newUndoManager;
	}

	public UndoManager getUndoManager() {
		return myUndoManager;
	}
}
