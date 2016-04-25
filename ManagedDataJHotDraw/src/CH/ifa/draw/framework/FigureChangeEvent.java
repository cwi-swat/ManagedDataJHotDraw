/*
 * @(#)FigureChangeEvent.java
 *
 * Project:		JHotdraw - a GUI framework for technical drawings
 *				http://www.jhotdraw.org
 *				http://jhotdraw.sourceforge.net
 * Copyright:	� by the original author(s) and all contributors
 * License:		Lesser GNU Public License (LGPL)
 *				http://www.opensource.org/licenses/lgpl-license.html
 */

package CH.ifa.draw.framework;

import ccconcerns.managed_data.factories.MDGeometryFactory;
import ccconcerns.managed_data.schemas.geometry.MDRectangle;

import java.awt.Rectangle;
import java.util.EventObject;

/**
 * FigureChange event passed to FigureChangeListeners.
 *
 * @version <$CURRENT_VERSION$>
 */
public class FigureChangeEvent extends EventObject {

	private MDRectangle fRectangle;
	private FigureChangeEvent myNestedEvent;

	private static final MDRectangle  fgEmptyRectangle = MDGeometryFactory.newRectangle(0, 0, 0, 0);

   /**
	* Constructs an event for the given source Figure. The rectangle is the
	* area to be invalvidated.
	*/
	public FigureChangeEvent(Figure source, MDRectangle r) {
		super(source);
		fRectangle = r;
	}

	public FigureChangeEvent(Figure source) {
		super(source);
		fRectangle = fgEmptyRectangle;
	}

	public FigureChangeEvent(Figure source, MDRectangle r, FigureChangeEvent nestedEvent) {
		this(source, r);
		myNestedEvent = nestedEvent;
	}

	/**
	 *  Gets the changed figure
	 */
	public Figure getFigure() {
		return (Figure)getSource();
	}

	/**
	 *  Gets the changed rectangle
	 */
	public MDRectangle getInvalidatedRectangle() {
		return fRectangle;
	}

	public FigureChangeEvent getNestedEvent() {
		return myNestedEvent;
	}
}
