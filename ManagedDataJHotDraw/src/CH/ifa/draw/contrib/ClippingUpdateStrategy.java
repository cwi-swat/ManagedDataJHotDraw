package CH.ifa.draw.contrib;

import java.awt.Graphics;
import java.util.Vector;

import CH.ifa.draw.framework.*;
import CH.ifa.draw.standard.FigureEnumerator;
import ccconcerns.managed_data.factories.MDGeometryFactory;
import ccconcerns.managed_data.schemas.framework.MDStandardDrawingView;
import ccconcerns.managed_data.schemas.geometry.MDRectangle;

/**
 * The ClippingUpdateStrategy will only draw those Figures in the DrawingView
 * which intersect the Graphic's clipping rectangle. 
 * 
 * @author Aviv Hurvitz
 */
public class ClippingUpdateStrategy implements Painter {

	public ClippingUpdateStrategy() {
		super();
	}

	public void draw(Graphics g, MDStandardDrawingView view) {
		MDRectangle viewClipRectangle = MDGeometryFactory.newRectangle(g.getClipBounds().x, g.getClipBounds().y, g.getClipBounds().width, g.getClipBounds().height);

		if (viewClipRectangle == null) {
			// it seems clip is always set, but nevertheless handle it
			view.drawAll(g);
			return;
		}

		FigureEnumeration fe = view.drawing().figures();

		// it's better to start big than to do Log(nFigures) reallocations
		Vector v = new Vector(1000);

		// create a List of the figures within the clip rectangle
		while (fe.hasNextFigure()) {
			Figure fig = fe.nextFigure();
			MDRectangle r = fig.displayBox();

			// grow Rectangles that have 0 width or height, since
			// Rectangle.intersects() returns false on them.
			// These Rectangles are common, as they are the typical bounding
			// boxes of horizontal and vertical lines.
			// see my (regression) bug report on Sun's site:
			//   http://developer.java.sun.com/developer/bugParade/bugs/4643428.html
			if (r.width() <= 0) {
				r.width(1);
			}
			if (r.height() <= 0) {
				r.height(1);
			}

			if (r.intersects(viewClipRectangle)) {
				v.add(fig);
			}
		}

		// draw the figures in the clip rectangle
		FigureEnumeration clippedFE = new FigureEnumerator(v);
		view.draw(g, clippedFE);
	}
}
