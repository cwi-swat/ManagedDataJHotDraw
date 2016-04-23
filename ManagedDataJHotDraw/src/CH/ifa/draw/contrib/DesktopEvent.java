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

import CH.ifa.draw.framework.DrawingView;
import ccconcerns.figure_selection_observer.schemas.MDStandardDrawingView;

import java.util.EventObject;

/**
 * @author  C.L.Gilbert <dnoyeb@users.sourceforge.net>
 * @version <$CURRENT_VERSION$>
 */
public class DesktopEvent extends EventObject {

	// MDHD
//	private DrawingView myDrawingView;

	private MDStandardDrawingView myDrawingView;

	/**
	 * Some events require the previous DrawingView (e.g. when a new DrawingView
	 * is selected).
	 */	
//	private DrawingView myPreviousDrawingView;
	private MDStandardDrawingView myPreviousDrawingView;

//	public DesktopEvent(Desktop source, DrawingView newDrawingView) {
//		this(source, newDrawingView, null);
//	}

	public DesktopEvent(Desktop source, MDStandardDrawingView newDrawingView) {
		this(source, newDrawingView, null);
	}

//	public DesktopEvent(Desktop source, DrawingView newDrawingView, DrawingView newPreviousDV) {
//		super(source);
//		setDrawingView(newDrawingView);
//		setPreviousDrawingView(newPreviousDV);
//	}

	public DesktopEvent(Desktop source, MDStandardDrawingView newDrawingView, MDStandardDrawingView newPreviousDV) {
		super(source);
		setDrawingView(newDrawingView);
		setPreviousDrawingView(newPreviousDV);
	}

//	private void setDrawingView(DrawingView newDrawingView) {
//		myDrawingView = newDrawingView;
//	}

	private void setDrawingView(MDStandardDrawingView newDrawingView) {
		myDrawingView = newDrawingView;
	}

//	public DrawingView getDrawingView() {
//	    return myDrawingView;
//	}

	public MDStandardDrawingView getDrawingView() {
		return myDrawingView;
	}

//	private void setPreviousDrawingView(DrawingView newPreviousDrawingView) {
//		myPreviousDrawingView = newPreviousDrawingView;
//	}

	private void setPreviousDrawingView(MDStandardDrawingView newPreviousDrawingView) {
		myPreviousDrawingView = newPreviousDrawingView;
	}
	
//	public DrawingView getPreviousDrawingView() {
//		return myPreviousDrawingView;
//	}

	public MDStandardDrawingView getPreviousDrawingView() {
		return myPreviousDrawingView;
	}
}