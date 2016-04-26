/*
 * @(#)DesktopEventService.java
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
import CH.ifa.draw.util.CollectionsFactory;

import javax.swing.event.EventListenerList;
import java.util.List;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerListener;
import java.awt.event.ContainerEvent;
import java.awt.*;

/**
 * @author  Wolfram Kaiser <mrfloppy@users.sourceforge.net>
 * @version <$CURRENT_VERSION$>
 */
public class DesktopEventService {

	private final EventListenerList listenerList = new EventListenerList();
	private MDDrawingView mySelectedView;
	private Container myContainer;
	private Desktop myDesktop;

	public DesktopEventService(Desktop newDesktop, Container newContainer) {
		setDesktop(newDesktop);
		setContainer(newContainer);
		getContainer().addContainerListener(createComponentListener());
	}

	private void setDesktop(Desktop newDesktop) {
		myDesktop = newDesktop;
	}

	protected Desktop getDesktop() {
		return myDesktop;
	}

	private void setContainer(Container newContainer) {
		myContainer = newContainer;
	}

	protected Container getContainer() {
		return myContainer;
	}

	public void addComponent(Component newComponent) {
		getContainer().add(newComponent);
	}

	public void removeComponent(MDDrawingView dv) {
		Component[] comps = getContainer().getComponents();
		for (int x=0; x < comps.length; x++) {
			if (dv == Helper.getDrawingView(comps[x])) {
				getContainer().remove(comps[x]);
			    break;
			}
		}
	}

	public void removeAllComponents() {
		getContainer().removeAll();
	}

	public void addDesktopListener(DesktopListener dpl) {
		listenerList.add(DesktopListener.class, dpl);
	}

	public void removeDesktopListener(DesktopListener dpl) {
	    listenerList.remove(DesktopListener.class, dpl);
	}

	protected void fireDrawingViewAddedEvent(final MDDrawingView dv) {
		final Object[] listeners = listenerList.getListenerList();
		DesktopListener dpl;
		DesktopEvent dpe = createDesktopEvent(getActiveDrawingView(), dv);
		for (int i = listeners.length-2; i>=0 ; i-=2)	{
			if (listeners[i] == DesktopListener.class) {
				dpl = (DesktopListener)listeners[i+1];
				dpl.drawingViewAdded(dpe);
			}
		}
	}

	protected void fireDrawingViewRemovedEvent(final MDDrawingView dv) {
		final Object[] listeners = listenerList.getListenerList();
		DesktopListener dpl;
		DesktopEvent dpe = createDesktopEvent(getActiveDrawingView(), dv);
		for (int i = listeners.length-2; i>=0 ; i-=2)	{
			if (listeners[i] == DesktopListener.class) {
				dpl = (DesktopListener)listeners[i+1];
				dpl.drawingViewRemoved(dpe);
			}
		}
	}

	/**
	 * This method is only called if the selected drawingView has actually changed
	 */
	protected void fireDrawingViewSelectedEvent(final MDDrawingView oldView, final MDDrawingView newView) {
		final Object[] listeners = listenerList.getListenerList();
		DesktopListener dpl;
		DesktopEvent dpe = createDesktopEvent(oldView, newView);
		for (int i = listeners.length-2; i>=0 ; i-=2)	{
			if (listeners[i] == DesktopListener.class) {
				dpl = (DesktopListener)listeners[i+1];
				dpl.drawingViewSelected(dpe);
			}
		}
	}

	/**
	 * @param oldView previous active drawing view (may be null because not all events require this information)
	 */
	protected DesktopEvent createDesktopEvent(MDDrawingView oldView, MDDrawingView newView) {
		return new DesktopEvent(getDesktop(), newView, oldView);
	}

	public MDDrawingView[] getDrawingViews(Component[] comps) {
		List al = CollectionsFactory.current().createList();
		for (int x = 0; x < comps.length; x++) {
			MDDrawingView dv = Helper.getDrawingView(comps[x]);
			if (dv != null) {
				al.add(dv);
			}
		}
		MDDrawingView[] dvs = new MDDrawingView[al.size()];
		al.toArray(dvs);
		return dvs;
	}

	public MDDrawingView getActiveDrawingView() {
		return mySelectedView;
	}

	protected void setActiveDrawingView(MDDrawingView newActiveDrawingView) {
		mySelectedView = newActiveDrawingView;
	}
	
	protected ContainerListener createComponentListener() {
		return new ContainerAdapter() {
			/**
			 * If the dv is null assert
			 * @todo does adding a component always make it the selected view?
			 *
			 */
            public void componentAdded(ContainerEvent e) {
				MDDrawingView dv = Helper.getDrawingView((java.awt.Container)e.getChild());
				MDDrawingView oldView = getActiveDrawingView();
				if (dv != null) {
					fireDrawingViewAddedEvent(dv);
					setActiveDrawingView(dv);
					fireDrawingViewSelectedEvent(oldView, getActiveDrawingView());
				}
            }

		    /**
			 * If dv is null assert
			 * if dv is not != getActiveDrawingView() assert
             * @todo  why should we assert? dont see a problem with removing a view thats not a selected view
             * This definitely needs fixing!!! dnoyeb 1/1/2003
			 */
            public void componentRemoved(ContainerEvent e) {
				MDDrawingView dv = Helper.getDrawingView((java.awt.Container)e.getChild());
				if (dv != null) {
					MDDrawingView oldView = getActiveDrawingView();
//					setActiveDrawingView(NullDrawingView.getManagedDrawingView(oldView.getEditor()));
					fireDrawingViewSelectedEvent(oldView, getActiveDrawingView());
					fireDrawingViewRemovedEvent(dv);
				}
            }
        };
	}
}
