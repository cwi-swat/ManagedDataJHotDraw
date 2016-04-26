/*
 * @(#)DesktopEvent.java
 *
 * Project:		JHotdraw - a GUI framework for technical drawings
 *				http://www.jhotdraw.org
 *				http://jhotdraw.sourceforge.net
 * Copyright:	� by the original author(s) and all contributors
 * License:		Lesser GNU Public License (LGPL)
 *				http://www.opensource.org/licenses/lgpl-license.html
 */

package CH.ifa.draw.contrib;

import ccconcerns.managed_data.MDDrawingView;

import java.util.EventObject;

/**
 * @author  C.L.Gilbert <dnoyeb@users.sourceforge.net>
 * @version <$CURRENT_VERSION$>
 */
public class DesktopEvent extends EventObject {
	private MDDrawingView myDrawingView;

	/**
	 * Some events require the previous DrawingView (e.g. when a new DrawingView
	 * is selected).
	 */	
	private MDDrawingView myPreviousDrawingView;

	public DesktopEvent(Desktop source, MDDrawingView newDrawingView) {
		this(source, newDrawingView, null);
	}

	public DesktopEvent(Desktop source, MDDrawingView newDrawingView, MDDrawingView newPreviousDV) {
		super(source);
		setDrawingView(newDrawingView);
		setPreviousDrawingView(newPreviousDV);
	}

	private void setDrawingView(MDDrawingView newDrawingView) {
		myDrawingView = newDrawingView;
	}
	
	public MDDrawingView getDrawingView() {
	    return myDrawingView;
	}

	private void setPreviousDrawingView(MDDrawingView newPreviousDrawingView) {
		myPreviousDrawingView = newPreviousDrawingView;
	}
	
	public MDDrawingView getPreviousDrawingView() {
		return myPreviousDrawingView;
	}
}