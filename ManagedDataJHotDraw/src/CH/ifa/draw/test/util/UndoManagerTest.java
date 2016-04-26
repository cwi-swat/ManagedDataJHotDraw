package CH.ifa.draw.test.util;

import junit.framework.TestCase;

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
* TestCase UndoManagerTest is generated by
* JUnitDoclet to hold the tests for UndoManager.
* @see CH.ifa.draw.util.UndoManager
*/
// JUnitDoclet end javadoc_class
public class UndoManagerTest
// JUnitDoclet begin extends_implements
extends TestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  // instance variables, helper methods, ... put them in this marker
  CH.ifa.draw.util.UndoManager undomanager = null;
  // JUnitDoclet end class
  
  /**
  * Constructor UndoManagerTest is
  * basically calling the inherited constructor to
  * initiate the TestCase for use by the Framework.
  */
  public UndoManagerTest(String name) {
    // JUnitDoclet begin method UndoManagerTest
    super(name);
    // JUnitDoclet end method UndoManagerTest
  }
  
  /**
  * Factory method for instances of the class to be tested.
  */
  public CH.ifa.draw.util.UndoManager createInstance() throws Exception {
    // JUnitDoclet begin method testcase.createInstance
    return new CH.ifa.draw.util.UndoManager();
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
    undomanager = createInstance();
    // JUnitDoclet end method testcase.setUp
  }
  
  /**
  * Method tearDown is overwriting the framework method to
  * clean up after each single test of this TestCase.
  * It's called from the JUnit framework only.
  */
  protected void tearDown() throws Exception {
    // JUnitDoclet begin method testcase.tearDown
    undomanager = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  // JUnitDoclet begin javadoc_method pushUndo()
  /**
  * Method testPushUndo is testing pushUndo
  * @see CH.ifa.draw.util.UndoManager#pushUndo(CH.ifa.draw.util.Undoable)
  */
  // JUnitDoclet end javadoc_method pushUndo()
  public void testPushUndo() throws Exception {
    // JUnitDoclet begin method pushUndo
    // JUnitDoclet end method pushUndo
  }
  
  // JUnitDoclet begin javadoc_method pushRedo()
  /**
  * Method testPushRedo is testing pushRedo
  * @see CH.ifa.draw.util.UndoManager#pushRedo(CH.ifa.draw.util.Undoable)
  */
  // JUnitDoclet end javadoc_method pushRedo()
  public void testPushRedo() throws Exception {
    // JUnitDoclet begin method pushRedo
    // JUnitDoclet end method pushRedo
  }
  
  // JUnitDoclet begin javadoc_method isUndoable()
  /**
  * Method testIsUndoable is testing isUndoable
  * @see CH.ifa.draw.util.UndoManager#isUndoable()
  */
  // JUnitDoclet end javadoc_method isUndoable()
  public void testIsUndoable() throws Exception {
    // JUnitDoclet begin method isUndoable
    // JUnitDoclet end method isUndoable
  }
  
  // JUnitDoclet begin javadoc_method isRedoable()
  /**
  * Method testIsRedoable is testing isRedoable
  * @see CH.ifa.draw.util.UndoManager#isRedoable()
  */
  // JUnitDoclet end javadoc_method isRedoable()
  public void testIsRedoable() throws Exception {
    // JUnitDoclet begin method isRedoable
    // JUnitDoclet end method isRedoable
  }
  
  // JUnitDoclet begin javadoc_method getUndoSize()
  /**
  * Method testGetUndoSize is testing getUndoSize
  * @see CH.ifa.draw.util.UndoManager#getUndoSize()
  */
  // JUnitDoclet end javadoc_method getUndoSize()
  public void testGetUndoSize() throws Exception {
    // JUnitDoclet begin method getUndoSize
    // JUnitDoclet end method getUndoSize
  }
  
  // JUnitDoclet begin javadoc_method getRedoSize()
  /**
  * Method testGetRedoSize is testing getRedoSize
  * @see CH.ifa.draw.util.UndoManager#getRedoSize()
  */
  // JUnitDoclet end javadoc_method getRedoSize()
  public void testGetRedoSize() throws Exception {
    // JUnitDoclet begin method getRedoSize
    // JUnitDoclet end method getRedoSize
  }
  
  // JUnitDoclet begin javadoc_method popUndo()
  /**
  * Method testPopUndo is testing popUndo
  * @see CH.ifa.draw.util.UndoManager#popUndo()
  */
  // JUnitDoclet end javadoc_method popUndo()
  public void testPopUndo() throws Exception {
    // JUnitDoclet begin method popUndo
    // JUnitDoclet end method popUndo
  }
  
  // JUnitDoclet begin javadoc_method popRedo()
  /**
  * Method testPopRedo is testing popRedo
  * @see CH.ifa.draw.util.UndoManager#popRedo()
  */
  // JUnitDoclet end javadoc_method popRedo()
  public void testPopRedo() throws Exception {
    // JUnitDoclet begin method popRedo
    // JUnitDoclet end method popRedo
  }
  
  // JUnitDoclet begin javadoc_method clearUndos()
  /**
  * Method testClearUndos is testing clearUndos
  * @see CH.ifa.draw.util.UndoManager#clearUndos()
  */
  // JUnitDoclet end javadoc_method clearUndos()
  public void testClearUndos() throws Exception {
    // JUnitDoclet begin method clearUndos
    // JUnitDoclet end method clearUndos
  }
  
  // JUnitDoclet begin javadoc_method clearRedos()
  /**
  * Method testClearRedos is testing clearRedos
  * @see CH.ifa.draw.util.UndoManager#clearRedos()
  */
  // JUnitDoclet end javadoc_method clearRedos()
  public void testClearRedos() throws Exception {
    // JUnitDoclet begin method clearRedos
    // JUnitDoclet end method clearRedos
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
    junit.textui.TestRunner.run(UndoManagerTest.class);
    // JUnitDoclet end method testcase.main
  }
}
