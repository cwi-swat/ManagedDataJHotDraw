package CH.ifa.draw.test.standard;

import CH.ifa.draw.standard.GridConstrainer;
import CH.ifa.draw.standard.SimpleUpdateStrategy;
import CH.ifa.draw.standard.StandardDrawingView;
import CH.ifa.draw.test.JHDTestCase;

// JUnitDoclet begin import
// JUnitDoclet end import

/*
* Generated by JUnitDoclet, a tool provided by
* ObjectFab GmbH under LGPL.
* Please see www.junitdoclet.org, www.gnu.org
* and www.objectfab.de for informations about
* the tool, the licence and the authors.
*/


// JUnitDoclet begin javadoc_class
/**
* TestCase StandardDrawingViewTest is generated by
* JUnitDoclet to hold the tests for StandardDrawingView.
* @see CH.ifa.draw.standard.StandardDrawingView
*/
// JUnitDoclet end javadoc_class
public class StandardDrawingViewTest
// JUnitDoclet begin extends_implements
extends JHDTestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  // instance variables, helper methods, ... put them in this marker
  CH.ifa.draw.standard.StandardDrawingView standarddrawingview = null;
  // JUnitDoclet end class
  
  /**
  * Constructor StandardDrawingViewTest is
  * basically calling the inherited constructor to
  * initiate the TestCase for use by the Framework.
  */
  public StandardDrawingViewTest(String name) {
    // JUnitDoclet begin method StandardDrawingViewTest
    super(name);
    // JUnitDoclet end method StandardDrawingViewTest
  }
  
  /**
  * Factory method for instances of the class to be tested.
  */
  public CH.ifa.draw.standard.StandardDrawingView createInstance() throws Exception {
    // JUnitDoclet begin method testcase.createInstance
    return (StandardDrawingView)getDrawingEditor().view();
    // JUnitDoclet end method testcase.createInstance
  }
  
  /**
  * Method setUp is overwriting the framework method to
  * prepare an instance of this TestCase for a single test.
  * It's called from the JUnit framework only.
  */
  protected void setUp() throws Exception {
    // JUnitDoclet begin method testcase.setUp
    super.setUp();
    standarddrawingview = createInstance();
    // JUnitDoclet end method testcase.setUp
  }
  
  /**
  * Method tearDown is overwriting the framework method to
  * clean up after each single test of this TestCase.
  * It's called from the JUnit framework only.
  */
  protected void tearDown() throws Exception {
    // JUnitDoclet begin method testcase.tearDown
    standarddrawingview = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  // JUnitDoclet begin javadoc_method setEditor()
  /**
  * Method testSetEditor is testing setEditor
  * @see CH.ifa.draw.standard.StandardDrawingView#setEditor(CH.ifa.draw.framework.DrawingEditor)
  */
  // JUnitDoclet end javadoc_method setEditor()
  public void testSetEditor() throws Exception {
    // JUnitDoclet begin method setEditor
    // JUnitDoclet end method setEditor
  }
  
  // JUnitDoclet begin javadoc_method tool()
  /**
  * Method testTool is testing tool
  * @see CH.ifa.draw.standard.StandardDrawingView#tool()
  */
  // JUnitDoclet end javadoc_method tool()
  public void testTool() throws Exception {
    // JUnitDoclet begin method tool
    // JUnitDoclet end method tool
  }
  
  // JUnitDoclet begin javadoc_method drawing()
  /**
  * Method testDrawing is testing drawing
  * @see CH.ifa.draw.standard.StandardDrawingView#drawing()
  */
  // JUnitDoclet end javadoc_method drawing()
  public void testDrawing() throws Exception {
    // JUnitDoclet begin method drawing
    // JUnitDoclet end method drawing
  }
  
  // JUnitDoclet begin javadoc_method setDrawing()
  /**
  * Method testSetDrawing is testing setDrawing
  * @see CH.ifa.draw.standard.StandardDrawingView#setDrawing(CH.ifa.draw.framework.Drawing)
  */
  // JUnitDoclet end javadoc_method setDrawing()
  public void testSetDrawing() throws Exception {
    // JUnitDoclet begin method setDrawing
    // JUnitDoclet end method setDrawing
  }
  
  // JUnitDoclet begin javadoc_method editor()
  /**
  * Method testEditor is testing editor
  * @see CH.ifa.draw.standard.StandardDrawingView#editor()
  */
  // JUnitDoclet end javadoc_method editor()
  public void testEditor() throws Exception {
    // JUnitDoclet begin method editor
    // JUnitDoclet end method editor
  }
  
  // JUnitDoclet begin javadoc_method add()
  /**
  * Method testAdd is testing add
  * @see CH.ifa.draw.standard.StandardDrawingView#add(CH.ifa.draw.framework.Figure)
  */
  // JUnitDoclet end javadoc_method add()
  public void testAdd() throws Exception {
    // JUnitDoclet begin method add
    // JUnitDoclet end method add
  }
  
  // JUnitDoclet begin javadoc_method remove()
  /**
  * Method testRemove is testing remove
  * @see CH.ifa.draw.standard.StandardDrawingView#remove(CH.ifa.draw.framework.Figure)
  */
  // JUnitDoclet end javadoc_method remove()
  public void testRemove() throws Exception {
    // JUnitDoclet begin method remove
    // JUnitDoclet end method remove
  }
  
  // JUnitDoclet begin javadoc_method addAll()
  /**
  * Method testAddAll is testing addAll
  * @see CH.ifa.draw.standard.StandardDrawingView#addAll(java.util.Collection)
  */
  // JUnitDoclet end javadoc_method addAll()
  public void testAddAll() throws Exception {
    // JUnitDoclet begin method addAll
    // JUnitDoclet end method addAll
  }
  
  // JUnitDoclet begin javadoc_method figureExists()
  /**
  * Method testFigureExists is testing figureExists
  * @see CH.ifa.draw.standard.StandardDrawingView#figureExists(CH.ifa.draw.framework.Figure, CH.ifa.draw.framework.FigureEnumeration)
  */
  // JUnitDoclet end javadoc_method figureExists()
  public void testFigureExists() throws Exception {
    // JUnitDoclet begin method figureExists
    // JUnitDoclet end method figureExists
  }
  
  // JUnitDoclet begin javadoc_method insertFigures()
  /**
  * Method testInsertFigures is testing insertFigures
  * @see CH.ifa.draw.standard.StandardDrawingView#insertFigures(CH.ifa.draw.framework.FigureEnumeration, int, int, boolean)
  */
  // JUnitDoclet end javadoc_method insertFigures()
  public void testInsertFigures() throws Exception {
    // JUnitDoclet begin method insertFigures
    // JUnitDoclet end method insertFigures
  }
  
  // JUnitDoclet begin javadoc_method getConnectionFigures()
  /**
  * Method testGetConnectionFigures is testing getConnectionFigures
  * @see CH.ifa.draw.standard.StandardDrawingView#getConnectionFigures(CH.ifa.draw.framework.Figure)
  */
  // JUnitDoclet end javadoc_method getConnectionFigures()
  public void testGetConnectionFigures() throws Exception {
    // JUnitDoclet begin method getConnectionFigures
    // JUnitDoclet end method getConnectionFigures
  }
  
  // JUnitDoclet begin javadoc_method getMinimumSize()
  /**
  * Method testGetMinimumSize is testing getMinimumSize
  * @see CH.ifa.draw.standard.StandardDrawingView#getMinimumSize()
  */
  // JUnitDoclet end javadoc_method getMinimumSize()
  public void testGetMinimumSize() throws Exception {
    // JUnitDoclet begin method getMinimumSize
    // JUnitDoclet end method getMinimumSize
  }
  
  // JUnitDoclet begin javadoc_method getPreferredSize()
  /**
  * Method testGetPreferredSize is testing getPreferredSize
  * @see CH.ifa.draw.standard.StandardDrawingView#getPreferredSize()
  */
  // JUnitDoclet end javadoc_method getPreferredSize()
  public void testGetPreferredSize() throws Exception {
    // JUnitDoclet begin method getPreferredSize
    // JUnitDoclet end method getPreferredSize
  }
  
  // JUnitDoclet begin javadoc_method setDisplayUpdate()
  /**
  * Method testSetGetDisplayUpdate is testing setDisplayUpdate
  * and getDisplayUpdate together by setting some value
  * and verifying it by reading.
  * @see CH.ifa.draw.standard.StandardDrawingView#setDisplayUpdate(CH.ifa.draw.framework.Painter)
  * @see CH.ifa.draw.standard.StandardDrawingView#getDisplayUpdate()
  */
  // JUnitDoclet end javadoc_method setDisplayUpdate()
  public void testSetGetDisplayUpdate() throws Exception {
    // JUnitDoclet begin method setDisplayUpdate getDisplayUpdate
    CH.ifa.draw.framework.Painter[] tests = {new SimpleUpdateStrategy(), null};
    
    for (int i = 0; i < tests.length; i++) {
      standarddrawingview.setDisplayUpdate(tests[i]);
      assertEquals(tests[i], standarddrawingview.getDisplayUpdate());
    }
    // JUnitDoclet end method setDisplayUpdate getDisplayUpdate
  }
  
  // JUnitDoclet begin javadoc_method selection()
  /**
  * Method testSelection is testing selection
  * @see CH.ifa.draw.standard.StandardDrawingView#selection()
  */
  // JUnitDoclet end javadoc_method selection()
  public void testSelection() throws Exception {
    // JUnitDoclet begin method selection
    // JUnitDoclet end method selection
  }
  
  // JUnitDoclet begin javadoc_method selectionZOrdered()
  /**
  * Method testSelectionZOrdered is testing selectionZOrdered
  * @see CH.ifa.draw.standard.StandardDrawingView#selectionZOrdered()
  */
  // JUnitDoclet end javadoc_method selectionZOrdered()
  public void testSelectionZOrdered() throws Exception {
    // JUnitDoclet begin method selectionZOrdered
    // JUnitDoclet end method selectionZOrdered
  }
  
  // JUnitDoclet begin javadoc_method selectionCount()
  /**
  * Method testSelectionCount is testing selectionCount
  * @see CH.ifa.draw.standard.StandardDrawingView#selectionCount()
  */
  // JUnitDoclet end javadoc_method selectionCount()
  public void testSelectionCount() throws Exception {
    // JUnitDoclet begin method selectionCount
    // JUnitDoclet end method selectionCount
  }
  
  // JUnitDoclet begin javadoc_method isFigureSelected()
  /**
  * Method testIsFigureSelected is testing isFigureSelected
  * @see CH.ifa.draw.standard.StandardDrawingView#isFigureSelected(CH.ifa.draw.framework.Figure)
  */
  // JUnitDoclet end javadoc_method isFigureSelected()
  public void testIsFigureSelected() throws Exception {
    // JUnitDoclet begin method isFigureSelected
    // JUnitDoclet end method isFigureSelected
  }
  
  // JUnitDoclet begin javadoc_method addToSelection()
  /**
  * Method testAddToSelection is testing addToSelection
  * @see CH.ifa.draw.standard.StandardDrawingView#addToSelection(CH.ifa.draw.framework.Figure)
  */
  // JUnitDoclet end javadoc_method addToSelection()
  public void testAddToSelection() throws Exception {
    // JUnitDoclet begin method addToSelection
    // JUnitDoclet end method addToSelection
  }
  
  // JUnitDoclet begin javadoc_method addToSelectionAll()
  /**
  * Method testAddToSelectionAll is testing addToSelectionAll
  * @see CH.ifa.draw.standard.StandardDrawingView#addToSelectionAll(java.util.Collection)
  */
  // JUnitDoclet end javadoc_method addToSelectionAll()
  public void testAddToSelectionAll() throws Exception {
    // JUnitDoclet begin method addToSelectionAll
    // JUnitDoclet end method addToSelectionAll
  }
  
  // JUnitDoclet begin javadoc_method removeFromSelection()
  /**
  * Method testRemoveFromSelection is testing removeFromSelection
  * @see CH.ifa.draw.standard.StandardDrawingView#removeFromSelection(CH.ifa.draw.framework.Figure)
  */
  // JUnitDoclet end javadoc_method removeFromSelection()
  public void testRemoveFromSelection() throws Exception {
    // JUnitDoclet begin method removeFromSelection
    // JUnitDoclet end method removeFromSelection
  }
  
  // JUnitDoclet begin javadoc_method toggleSelection()
  /**
  * Method testToggleSelection is testing toggleSelection
  * @see CH.ifa.draw.standard.StandardDrawingView#toggleSelection(CH.ifa.draw.framework.Figure)
  */
  // JUnitDoclet end javadoc_method toggleSelection()
  public void testToggleSelection() throws Exception {
    // JUnitDoclet begin method toggleSelection
    // JUnitDoclet end method toggleSelection
  }
  
  // JUnitDoclet begin javadoc_method clearSelection()
  /**
  * Method testClearSelection is testing clearSelection
  * @see CH.ifa.draw.standard.StandardDrawingView#clearSelection()
  */
  // JUnitDoclet end javadoc_method clearSelection()
  public void testClearSelection() throws Exception {
    // JUnitDoclet begin method clearSelection
    // JUnitDoclet end method clearSelection
  }
  
  // JUnitDoclet begin javadoc_method getFigureSelection()
  /**
  * Method testGetFigureSelection is testing getFigureSelection
  * @see CH.ifa.draw.standard.StandardDrawingView#getFigureSelection()
  */
  // JUnitDoclet end javadoc_method getFigureSelection()
  public void testGetFigureSelection() throws Exception {
    // JUnitDoclet begin method getFigureSelection
    // JUnitDoclet end method getFigureSelection
  }
  
  // JUnitDoclet begin javadoc_method findHandle()
  /**
  * Method testFindHandle is testing findHandle
  * @see CH.ifa.draw.standard.StandardDrawingView#findHandle(int, int)
  */
  // JUnitDoclet end javadoc_method findHandle()
  public void testFindHandle() throws Exception {
    // JUnitDoclet begin method findHandle
    // JUnitDoclet end method findHandle
  }
  
  // JUnitDoclet begin javadoc_method lastClick()
  /**
  * Method testLastClick is testing lastClick
  * @see CH.ifa.draw.standard.StandardDrawingView#lastClick()
  */
  // JUnitDoclet end javadoc_method lastClick()
  public void testLastClick() throws Exception {
    // JUnitDoclet begin method lastClick
    // JUnitDoclet end method lastClick
  }
  
  // JUnitDoclet begin javadoc_method setConstrainer()
  /**
  * Method testSetGetConstrainer is testing setConstrainer
  * and getConstrainer together by setting some value
  * and verifying it by reading.
  * @see CH.ifa.draw.standard.StandardDrawingView#setConstrainer(CH.ifa.draw.framework.PointConstrainer)
  * @see CH.ifa.draw.standard.StandardDrawingView#getConstrainer()
  */
  // JUnitDoclet end javadoc_method setConstrainer()
  public void testSetGetConstrainer() throws Exception {
    // JUnitDoclet begin method setConstrainer getConstrainer
    CH.ifa.draw.framework.PointConstrainer[] tests = {new GridConstrainer(5, 5), null};
    
    for (int i = 0; i < tests.length; i++) {
      standarddrawingview.setConstrainer(tests[i]);
      assertEquals(tests[i], standarddrawingview.getConstrainer());
    }
    // JUnitDoclet end method setConstrainer getConstrainer
  }
  
  // JUnitDoclet begin javadoc_method checkDamage()
  /**
  * Method testCheckDamage is testing checkDamage
  * @see CH.ifa.draw.standard.StandardDrawingView#checkDamage()
  */
  // JUnitDoclet end javadoc_method checkDamage()
  public void testCheckDamage() throws Exception {
    // JUnitDoclet begin method checkDamage
    // JUnitDoclet end method checkDamage
  }
  
  // JUnitDoclet begin javadoc_method repairDamage()
  /**
  * Method testRepairDamage is testing repairDamage
  * @see CH.ifa.draw.standard.StandardDrawingView#repairDamage()
  */
  // JUnitDoclet end javadoc_method repairDamage()
  public void testRepairDamage() throws Exception {
    // JUnitDoclet begin method repairDamage
    // JUnitDoclet end method repairDamage
  }
  
  // JUnitDoclet begin javadoc_method drawingInvalidated()
  /**
  * Method testDrawingInvalidated is testing drawingInvalidated
  * @see CH.ifa.draw.standard.StandardDrawingView#drawingInvalidated(CH.ifa.draw.framework.DrawingChangeEvent)
  */
  // JUnitDoclet end javadoc_method drawingInvalidated()
  public void testDrawingInvalidated() throws Exception {
    // JUnitDoclet begin method drawingInvalidated
    // JUnitDoclet end method drawingInvalidated
  }
  
  // JUnitDoclet begin javadoc_method drawingRequestUpdate()
  /**
  * Method testDrawingRequestUpdate is testing drawingRequestUpdate
  * @see CH.ifa.draw.standard.StandardDrawingView#drawingRequestUpdate(CH.ifa.draw.framework.DrawingChangeEvent)
  */
  // JUnitDoclet end javadoc_method drawingRequestUpdate()
  public void testDrawingRequestUpdate() throws Exception {
    // JUnitDoclet begin method drawingRequestUpdate
    // JUnitDoclet end method drawingRequestUpdate
  }
  
  // JUnitDoclet begin javadoc_method drawingTitleChanged()
  /**
  * Method testDrawingTitleChanged is testing drawingTitleChanged
  * @see CH.ifa.draw.standard.StandardDrawingView#drawingTitleChanged(CH.ifa.draw.framework.DrawingChangeEvent)
  */
  // JUnitDoclet end javadoc_method drawingTitleChanged()
  public void testDrawingTitleChanged() throws Exception {
    // JUnitDoclet begin method drawingTitleChanged
    // JUnitDoclet end method drawingTitleChanged
  }
  
  // JUnitDoclet begin javadoc_method drawAll()
  /**
  * Method testDrawAll is testing drawAll
  * @see CH.ifa.draw.standard.StandardDrawingView#drawAll(java.awt.Graphics)
  */
  // JUnitDoclet end javadoc_method drawAll()
  public void testDrawAll() throws Exception {
    // JUnitDoclet begin method drawAll
    // JUnitDoclet end method drawAll
  }
  
  // JUnitDoclet begin javadoc_method draw()
  /**
  * Method testDraw is testing draw
  * @see CH.ifa.draw.standard.StandardDrawingView#draw(java.awt.Graphics, CH.ifa.draw.framework.FigureEnumeration)
  */
  // JUnitDoclet end javadoc_method draw()
  public void testDraw() throws Exception {
    // JUnitDoclet begin method draw
    // JUnitDoclet end method draw
  }
  
  // JUnitDoclet begin javadoc_method drawHandles()
  /**
  * Method testDrawHandles is testing drawHandles
  * @see CH.ifa.draw.standard.StandardDrawingView#drawHandles(java.awt.Graphics)
  */
  // JUnitDoclet end javadoc_method drawHandles()
  public void testDrawHandles() throws Exception {
    // JUnitDoclet begin method drawHandles
    // JUnitDoclet end method drawHandles
  }
  
  // JUnitDoclet begin javadoc_method drawDrawing()
  /**
  * Method testDrawDrawing is testing drawDrawing
  * @see CH.ifa.draw.standard.StandardDrawingView#drawDrawing(java.awt.Graphics)
  */
  // JUnitDoclet end javadoc_method drawDrawing()
  public void testDrawDrawing() throws Exception {
    // JUnitDoclet begin method drawDrawing
    // JUnitDoclet end method drawDrawing
  }
  
  // JUnitDoclet begin javadoc_method drawBackground()
  /**
  * Method testDrawBackground is testing drawBackground
  * @see CH.ifa.draw.standard.StandardDrawingView#drawBackground(java.awt.Graphics)
  */
  // JUnitDoclet end javadoc_method drawBackground()
  public void testDrawBackground() throws Exception {
    // JUnitDoclet begin method drawBackground
    // JUnitDoclet end method drawBackground
  }
  
  // JUnitDoclet begin javadoc_method addBackground()
  /**
  * Method testAddBackground is testing addBackground
  * @see CH.ifa.draw.standard.StandardDrawingView#addBackground(CH.ifa.draw.framework.Painter)
  */
  // JUnitDoclet end javadoc_method addBackground()
  public void testAddBackground() throws Exception {
    // JUnitDoclet begin method addBackground
    // JUnitDoclet end method addBackground
  }
  
  // JUnitDoclet begin javadoc_method removeBackground()
  /**
  * Method testRemoveBackground is testing removeBackground
  * @see CH.ifa.draw.standard.StandardDrawingView#removeBackground(CH.ifa.draw.framework.Painter)
  */
  // JUnitDoclet end javadoc_method removeBackground()
  public void testRemoveBackground() throws Exception {
    // JUnitDoclet begin method removeBackground
    // JUnitDoclet end method removeBackground
  }
  
  // JUnitDoclet begin javadoc_method removeForeground()
  /**
  * Method testRemoveForeground is testing removeForeground
  * @see CH.ifa.draw.standard.StandardDrawingView#removeForeground(CH.ifa.draw.framework.Painter)
  */
  // JUnitDoclet end javadoc_method removeForeground()
  public void testRemoveForeground() throws Exception {
    // JUnitDoclet begin method removeForeground
    // JUnitDoclet end method removeForeground
  }
  
  // JUnitDoclet begin javadoc_method addForeground()
  /**
  * Method testAddForeground is testing addForeground
  * @see CH.ifa.draw.standard.StandardDrawingView#addForeground(CH.ifa.draw.framework.Painter)
  */
  // JUnitDoclet end javadoc_method addForeground()
  public void testAddForeground() throws Exception {
    // JUnitDoclet begin method addForeground
    // JUnitDoclet end method addForeground
  }
  
  // JUnitDoclet begin javadoc_method freezeView()
  /**
  * Method testFreezeView is testing freezeView
  * @see CH.ifa.draw.standard.StandardDrawingView#freezeView()
  */
  // JUnitDoclet end javadoc_method freezeView()
  public void testFreezeView() throws Exception {
    // JUnitDoclet begin method freezeView
    // JUnitDoclet end method freezeView
  }
  
  // JUnitDoclet begin javadoc_method unfreezeView()
  /**
  * Method testUnfreezeView is testing unfreezeView
  * @see CH.ifa.draw.standard.StandardDrawingView#unfreezeView()
  */
  // JUnitDoclet end javadoc_method unfreezeView()
  public void testUnfreezeView() throws Exception {
    // JUnitDoclet begin method unfreezeView
    // JUnitDoclet end method unfreezeView
  }
  
  // JUnitDoclet begin javadoc_method isFocusTraversable()
  /**
  * Method testIsFocusTraversable is testing isFocusTraversable
  * @see CH.ifa.draw.standard.StandardDrawingView#isFocusTraversable()
  */
  // JUnitDoclet end javadoc_method isFocusTraversable()
  public void testIsFocusTraversable() throws Exception {
    // JUnitDoclet begin method isFocusTraversable
    // JUnitDoclet end method isFocusTraversable
  }
  
  // JUnitDoclet begin javadoc_method isInteractive()
  /**
  * Method testIsInteractive is testing isInteractive
  * @see CH.ifa.draw.standard.StandardDrawingView#isInteractive()
  */
  // JUnitDoclet end javadoc_method isInteractive()
  public void testIsInteractive() throws Exception {
    // JUnitDoclet begin method isInteractive
    // JUnitDoclet end method isInteractive
  }
  
  // JUnitDoclet begin javadoc_method keyTyped()
  /**
  * Method testKeyTyped is testing keyTyped
  * @see CH.ifa.draw.standard.StandardDrawingView#keyTyped(java.awt.event.KeyEvent)
  */
  // JUnitDoclet end javadoc_method keyTyped()
  public void testKeyTyped() throws Exception {
    // JUnitDoclet begin method keyTyped
    // JUnitDoclet end method keyTyped
  }
  
  // JUnitDoclet begin javadoc_method keyReleased()
  /**
  * Method testKeyReleased is testing keyReleased
  * @see CH.ifa.draw.standard.StandardDrawingView#keyReleased(java.awt.event.KeyEvent)
  */
  // JUnitDoclet end javadoc_method keyReleased()
  public void testKeyReleased() throws Exception {
    // JUnitDoclet begin method keyReleased
    // JUnitDoclet end method keyReleased
  }
  
  // JUnitDoclet begin javadoc_method addFigureSelectionListener()
  /**
  * Method testAddFigureSelectionListener is testing addFigureSelectionListener
  * @see CH.ifa.draw.standard.StandardDrawingView#addFigureSelectionListener(CH.ifa.draw.framework.FigureSelectionListener)
  */
  // JUnitDoclet end javadoc_method addFigureSelectionListener()
  public void testAddFigureSelectionListener() throws Exception {
    // JUnitDoclet begin method addFigureSelectionListener
    // JUnitDoclet end method addFigureSelectionListener
  }
  
  // JUnitDoclet begin javadoc_method removeFigureSelectionListener()
  /**
  * Method testRemoveFigureSelectionListener is testing removeFigureSelectionListener
  * @see CH.ifa.draw.standard.StandardDrawingView#removeFigureSelectionListener(CH.ifa.draw.framework.FigureSelectionListener)
  */
  // JUnitDoclet end javadoc_method removeFigureSelectionListener()
  public void testRemoveFigureSelectionListener() throws Exception {
    // JUnitDoclet begin method removeFigureSelectionListener
    // JUnitDoclet end method removeFigureSelectionListener
  }
  
  // JUnitDoclet begin javadoc_method getDefaultDNDActions()
  /**
  * Method testGetDefaultDNDActions is testing getDefaultDNDActions
  * @see CH.ifa.draw.standard.StandardDrawingView#getDefaultDNDActions()
  */
  // JUnitDoclet end javadoc_method getDefaultDNDActions()
  public void testGetDefaultDNDActions() throws Exception {
    // JUnitDoclet begin method getDefaultDNDActions
    // JUnitDoclet end method getDefaultDNDActions
  }
  
  // JUnitDoclet begin javadoc_method autoscroll()
  /**
  * Method testAutoscroll is testing autoscroll
  * @see CH.ifa.draw.standard.StandardDrawingView#autoscroll(java.awt.Point)
  */
  // JUnitDoclet end javadoc_method autoscroll()
  public void testAutoscroll() throws Exception {
    // JUnitDoclet begin method autoscroll
    // JUnitDoclet end method autoscroll
  }
  
  // JUnitDoclet begin javadoc_method getAutoscrollInsets()
  /**
  * Method testGetAutoscrollInsets is testing getAutoscrollInsets
  * @see CH.ifa.draw.standard.StandardDrawingView#getAutoscrollInsets()
  */
  // JUnitDoclet end javadoc_method getAutoscrollInsets()
  public void testGetAutoscrollInsets() throws Exception {
    // JUnitDoclet begin method getAutoscrollInsets
    // JUnitDoclet end method getAutoscrollInsets
  }
  
  // JUnitDoclet begin javadoc_method toString()
  /**
  * Method testToString is testing toString
  * @see CH.ifa.draw.standard.StandardDrawingView#toString()
  */
  // JUnitDoclet end javadoc_method toString()
  public void testToString() throws Exception {
    // JUnitDoclet begin method toString
    // JUnitDoclet end method toString
  }
  
  // JUnitDoclet begin javadoc_method setDragSourceActive()
  /**
  * Method testSetDragSourceActive is testing setDragSourceActive
  * @see CH.ifa.draw.standard.StandardDrawingView#setDragSourceActive(boolean)
  */
  // JUnitDoclet end javadoc_method setDragSourceActive()
  public void testSetDragSourceActive() throws Exception {
    // JUnitDoclet begin method setDragSourceActive
    // JUnitDoclet end method setDragSourceActive
  }
  
  // JUnitDoclet begin javadoc_method setDropTargetActive()
  /**
  * Method testSetDropTargetActive is testing setDropTargetActive
  * @see CH.ifa.draw.standard.StandardDrawingView#setDropTargetActive(boolean)
  */
  // JUnitDoclet end javadoc_method setDropTargetActive()
  public void testSetDropTargetActive() throws Exception {
    // JUnitDoclet begin method setDropTargetActive
    // JUnitDoclet end method setDropTargetActive
  }
  
  
  
  // JUnitDoclet begin javadoc_method testVault
  /**
  * JUnitDoclet moves marker to this method, if there is not match
  * for them in the regenerated code and if the marker is not empty.
  * This way, no test gets lost when regenerating after renaming.
  * <b>Method testVault is supposed to be empty.</b>
  */
  // JUnitDoclet end javadoc_method testVault
  public void testVault() throws Exception {
    // JUnitDoclet begin method testcase.testVault
    // JUnitDoclet end method testcase.testVault
  }
  
  /**
  * Method to execute the TestCase from command line
  * using JUnit's textui.TestRunner .
  */
  public static void main(String[] args) {
    // JUnitDoclet begin method testcase.main
    junit.textui.TestRunner.run(StandardDrawingViewTest.class);
    // JUnitDoclet end method testcase.main
  }
}
