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

import CH.ifa.draw.figures.RoundRectangleFigure;
import ccconcerns.managed_data.schemas.geometry.MDRectangle;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Geometric adapter for the RoundRectangleFigure
 *
 * @author    Eduardo Francos - InContext
 * @created   4 mai 2002
 * @version   1.0
 */

public class RoundRectangleGeometricAdapter extends RoundRectangleFigure
		 implements GeometricFigure {

	/**Constructor for the RoundRectangleGeometricAdapter object */
	public RoundRectangleGeometricAdapter() {
		super();
	}


	/**
	 *Constructor for the RoundRectangleGeometricAdapter object
	 *
	 * @param origin  Description of the Parameter
	 * @param corner  Description of the Parameter
	 */
	public RoundRectangleGeometricAdapter(Point origin, Point corner) {
		super(origin, corner);
	}


	/**
	 * Gets the shape attribute of the TriangleFigure object
	 *
	 * @return   The shape value
	 */
	public Shape getShape() {
		Point arc = getArc();
		MDRectangle dspBox = displayBox();
		RoundRectangle2D.Float roundRectangle = new RoundRectangle2D.Float(
				dspBox.x(), dspBox.y(), dspBox.width(), dspBox.height(),
				arc.x, arc.y);

		return roundRectangle;
	}
}
