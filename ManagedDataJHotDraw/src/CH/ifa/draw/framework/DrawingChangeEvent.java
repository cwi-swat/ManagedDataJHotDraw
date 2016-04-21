/*
 * @(#)DrawingChangeEvent.java
 *
 * Project:		JHotdraw - a GUI framework for technical drawings
 *				http://www.jhotdraw.org
 *				http://jhotdraw.sourceforge.net
 * Copyright:	� by the original author(s) and all contributors
 * License:		Lesser GNU Public License (LGPL)
 *				http://www.opensource.org/licenses/lgpl-license.html
 */

package CH.ifa.draw.framework;

import ccconcerns.managed_data.schemas.geometry.MDRectangle;
import java.util.EventObject;

/**
 * The event passed to DrawingChangeListeners.
 *
 * @version <$CURRENT_VERSION$>
 */
public class DrawingChangeEvent extends EventObject {

//	private Rectangle fRectangle;
	private MDRectangle fMDRectangle;

//	/**
//	 *  Constructs a drawing change event.
//	 */
//	public DrawingChangeEvent(Drawing source, Rectangle r) {
//		super(source);
//		fRectangle = r;
//	}

	public DrawingChangeEvent(Drawing source, MDRectangle mdR) {
		super(source);
		fMDRectangle = mdR;
	}

	/**
	 *  Gets the changed drawing
	 */
	public Drawing getDrawing() {
		return (Drawing)getSource();
	}

//	/**
//	 *  Gets the changed rectangle
//	 */
//	public Rectangle getInvalidatedRectangle() {
//		return fRectangle;
//	}

	public MDRectangle getInvalidatedMDRectangle() {
		return fMDRectangle;
	}
}
