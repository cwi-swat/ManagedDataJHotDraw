/*
 *  @(#)TextAreaFigure.java
 *
 *  Project:		JHotdraw - a GUI framework for technical drawings
 *  http://www.jhotdraw.org
 *  http://jhotdraw.sourceforge.net
 *  Copyright:	� by the original author(s) and all contributors
 *  License:		Lesser GNU Public License (LGPL)
 *  http://www.opensource.org/licenses/lgpl-license.html
 */
package CH.ifa.draw.contrib.html;

import ccconcerns.managed_data.schemas.geometry.MDRectangle;

import java.awt.*;

/**
 * FigureContentProducerContext defines the interface required of clients
 * requesting contents for Figure oriented ContentProducers.<br>
 *
 *
 * @author    Eduardo Francos - InContext
 * @created   7 mai 2002
 * @version   1.0
 */

public interface FigureContentProducerContext extends ContentProducerContext {
	/**
	 * Returns the display box of the figure
	 *
	 * @return   the display box
	 */
	public MDRectangle displayBox();


	/**
	 * Gets the font of the figure
	 *
	 * @return   The font
	 */
	public Font getFont();
}
