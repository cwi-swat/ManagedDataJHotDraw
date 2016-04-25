package CH.ifa.draw.framework;
import ccconcerns.managed_data.schemas.framework.MDStandardDrawingView;

import java.util.EventListener;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author      SourceForge(dnoyeb) aka C.L.Gilbert
 * @version     1.0
 * @since       10/14/01
 */

 /**
  *
  * @see javax.swing.event.EventListenerList
  */
public interface ViewChangeListener extends EventListener {

	/**
	 * Sent when the active view has changed.
	 * @param newView view
	 */
//	public void viewSelectionChanged(DrawingView oldView, DrawingView newView);
	public void viewSelectionChanged(MDStandardDrawingView oldView, MDStandardDrawingView newView);

	/**
	 * Sent when a new view is created.  This should only be fired after the view
	 * has a peer.  I believe that means the view has a component chain all the way
	 * to a heavyweight container.
	 * @param view view
	 */
//	public void viewCreated(DrawingView view);
	public void viewCreated(MDStandardDrawingView view);

	/**
	 * Send when an existing view is about to be destroyed.  After processing this
	 * event, the view is not guaranteed to contain any appropriate data.  You
	 * must not use it.
	 */
//	public void viewDestroying(DrawingView view);
	public void viewDestroying(MDStandardDrawingView view);
}
