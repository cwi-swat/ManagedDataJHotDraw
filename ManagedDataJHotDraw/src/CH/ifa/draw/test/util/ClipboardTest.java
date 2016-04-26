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
* TestCase ClipboardTest is generated by
* JUnitDoclet to hold the tests for Clipboard.
* @see CH.ifa.draw.util.Clipboard
*/
// JUnitDoclet end javadoc_class
public class ClipboardTest
// JUnitDoclet begin extends_implements
extends TestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  // instance variables, helper methods, ... put them in this marker
  CH.ifa.draw.util.Clipboard clipboard = null;
  // JUnitDoclet end class
  
  /**
  * Constructor ClipboardTest is
  * basically calling the inherited constructor to
  * initiate the TestCase for use by the Framework.
  */
  public ClipboardTest(String name) {
    // JUnitDoclet begin method ClipboardTest
    super(name);
    // JUnitDoclet end method ClipboardTest
  }
  
  /**
  * Factory method for instances of the class to be tested.
  */
  public CH.ifa.draw.util.Clipboard createInstance() throws Exception {
    // JUnitDoclet begin method testcase.createInstance
    return CH.ifa.draw.util.Clipboard.getClipboard();
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
    clipboard = createInstance();
    // JUnitDoclet end method testcase.setUp
  }
  
  /**
  * Method tearDown is overwriting the framework method to
  * clean up after each single test of this TestCase.
  * It's called from the JUnit framework only.
  */
  protected void tearDown() throws Exception {
    // JUnitDoclet begin method testcase.tearDown
    clipboard = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  // JUnitDoclet begin javadoc_method getClipboard()
  /**
  * Method testGetClipboard is testing getClipboard
  * @see CH.ifa.draw.util.Clipboard#getClipboard()
  */
  // JUnitDoclet end javadoc_method getClipboard()
  public void testGetClipboard() throws Exception {
    // JUnitDoclet begin method getClipboard
    // JUnitDoclet end method getClipboard
  }
  
  // JUnitDoclet begin javadoc_method setContents()
  /**
  * Method testSetGetContents is testing setContents
  * and getContents together by setting some value
  * and verifying it by reading.
  * @see CH.ifa.draw.util.Clipboard#setContents(java.lang.Object)
  * @see CH.ifa.draw.util.Clipboard#getContents()
  */
  // JUnitDoclet end javadoc_method setContents()
  public void testSetGetContents() throws Exception {
    // JUnitDoclet begin method setContents getContents
    java.lang.Object[] tests = {new java.lang.Object(), null};
    
    for (int i = 0; i < tests.length; i++) {
      clipboard.setContents(tests[i]);
      assertEquals(tests[i], clipboard.getContents());
    }
    // JUnitDoclet end method setContents getContents
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
    junit.textui.TestRunner.run(ClipboardTest.class);
    // JUnitDoclet end method testcase.main
  }
}
