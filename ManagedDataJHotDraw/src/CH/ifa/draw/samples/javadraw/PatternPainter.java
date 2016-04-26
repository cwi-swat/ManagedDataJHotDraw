/*
 * @(#)PatternPainter.java
 *
 * Project:		JHotdraw - a GUI framework for technical drawings
 *				http://www.jhotdraw.org
 *				http://jhotdraw.sourceforge.net
 * Copyright:	� by the original author(s) and all contributors
 * License:		Lesser GNU Public License (LGPL)
 *				http://www.opensource.org/licenses/lgpl-license.html
 */

package CH.ifa.draw.samples.javadraw;

import CH.ifa.draw.framework.DrawingView;
import CH.ifa.draw.framework.Painter;
 import ccconcerns.managed_data.MDDrawingView;
import ccconcerns.managed_data.schemas.geometry.MDDimension;

import java.awt.*;

/**
 * PatternDrawer a background that can be added to a drawing.
 *
 * @see DrawingView
 * @see Painter
 *
 * @version <$CURRENT_VERSION$>
 */
public  class PatternPainter
		implements Painter {

	private Image   fImage;

	public PatternPainter(Image image) {
		fImage = image;
	}

	public void draw(Graphics g, MDDrawingView view) {
		drawPattern(g, fImage, view);
	}

	/**
	 * Draws a pattern background pattern by replicating an image.
	 */
	private void drawPattern(Graphics g, Image image, MDDrawingView view) {
		int iwidth = image.getWidth(view);
		int iheight = image.getHeight(view);
		MDDimension d = view.getSize();
		int x = 0;
		int y = 0;

		while (y < d.height()) {
			while (x < d.width()) {
				g.drawImage(image, x, y, view);
				x += iwidth;
			}
			y += iheight;
			x = 0;
		}
	}
}
