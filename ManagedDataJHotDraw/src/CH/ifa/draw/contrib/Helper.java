/*
 * @(#)Helper.java
 *
 * Project:		JHotdraw - a GUI framework for technical drawings
 *				http://www.jhotdraw.org
 *				http://jhotdraw.sourceforge.net
 * Copyright:	� by the original author(s) and all contributors
 * License:		Lesser GNU Public License (LGPL)
 *				http://www.opensource.org/licenses/lgpl-license.html
 */

package CH.ifa.draw.contrib;

import ccconcerns.MyJPanel;
import ccconcerns.managed_data.schemas.MDStandardDrawingView;

import java.awt.*;

/**
 * @author  C.L.Gilbert <dnoyeb@sourceforge.net>
 * @version <$CURRENT_VERSION$>
 */
public class Helper {

//	static public DrawingView getDrawingView(Container container) {
//		DrawingView oldDrawingView = null;
//		Component[] components = container.getComponents();
//		for (int i = 0; i < components.length; i++) {
//			if (components[i] instanceof DrawingView) {
//				return (DrawingView)components[i];
//			}
//			else if (components[i] instanceof Container) {
//				oldDrawingView = getDrawingView((Container)components[i]);
//				if (oldDrawingView != null) {
//					return oldDrawingView;
//				}
//			}
//		}
//		return null;
//	}

	static public MDStandardDrawingView getDrawingView(Container container) {
		MDStandardDrawingView oldDrawingView = null;
		Component[] components = container.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof MyJPanel) {
				return (MDStandardDrawingView)((MyJPanel) components[i]).getDrawingView();
			}
			else if (components[i] instanceof Container) {
				oldDrawingView = getDrawingView((Container)components[i]);
				if (oldDrawingView != null) {
					return oldDrawingView;
				}
			}
		}
		return null;
	}

//	static public DrawingView getDrawingView(Component component) {
//		if (Container.class.isInstance(component)) {
//			return getDrawingView((Container)component);
//		}
//		else if (DrawingView.class.isInstance(component)) {
//			return (DrawingView)component;
//		}
//		else {
//			return null;
//		}
//	}

	static public MDStandardDrawingView getDrawingView(Component component) {
		if (Container.class.isInstance(component)) {
			return getDrawingView((Container)component);
		}
		else if (MyJPanel.class.isInstance(component)) {
			return (MDStandardDrawingView)((MyJPanel) component).getDrawingView();
		}
		else {
			return null;
		}
	}
}