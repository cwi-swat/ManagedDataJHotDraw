package CH.ifa.draw.test.samples.javadraw;

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
* TestCase URLToolTest is generated by
* JUnitDoclet to hold the tests for URLTool.
* @see CH.ifa.draw.samples.javadraw.URLTool
*/
// JUnitDoclet end javadoc_class
public class URLToolTest
// JUnitDoclet begin extends_implements
extends JHDTestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  // instance variables, helper methods, ... put them in this marker
  CH.ifa.draw.samples.javadraw.URLTool urltool = null;
  // JUnitDoclet end class
  
  /**
  * Constructor URLToolTest is
  * basically calling the inherited constructor to
  * initiate the TestCase for use by the Framework.
  */
  public URLToolTest(String name) {
    // JUnitDoclet begin method URLToolTest
    super(name);
    // JUnitDoclet end method URLToolTest
  }
  
  /**
  * Factory method for instances of the class to be tested.
  */
  public CH.ifa.draw.samples.javadraw.URLTool createInstance() throws Exception {
    // JUnitDoclet begin method testcase.createInstance
    return new CH.ifa.draw.samples.javadraw.URLTool(getDrawingEditor());
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
    urltool = createInstance();
    // JUnitDoclet end method testcase.setUp
  }
  
  /**
  * Method tearDown is overwriting the framework method to
  * clean up after each single test of this TestCase.
  * It's called from the JUnit framework only.
  */
  protected void tearDown() throws Exception {
    // JUnitDoclet begin method testcase.tearDown
    urltool = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  // JUnitDoclet begin javadoc_method mouseDown()
  /**
  * Method testMouseDown is testing mouseDown
  * @see CH.ifa.draw.samples.javadraw.URLTool#mouseDown(java.awt.event.MouseEvent, int, int)
  */
  // JUnitDoclet end javadoc_method mouseDown()
  public void testMouseDown() throws Exception {
    // JUnitDoclet begin method mouseDown
    // JUnitDoclet end method mouseDown
  }
  
  // JUnitDoclet begin javadoc_method mouseUp()
  /**
  * Method testMouseUp is testing mouseUp
  * @see CH.ifa.draw.samples.javadraw.URLTool#mouseUp(java.awt.event.MouseEvent, int, int)
  */
  // JUnitDoclet end javadoc_method mouseUp()
  public void testMouseUp() throws Exception {
    // JUnitDoclet begin method mouseUp
    // JUnitDoclet end method mouseUp
  }
  
  // JUnitDoclet begin javadoc_method deactivate()
  /**
  * Method testDeactivate is testing deactivate
  * @see CH.ifa.draw.samples.javadraw.URLTool#deactivate(CH.ifa.draw.framework.DrawingView)
  */
  // JUnitDoclet end javadoc_method deactivate()
  public void testDeactivate() throws Exception {
    // JUnitDoclet begin method deactivate
    // JUnitDoclet end method deactivate
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
    junit.textui.TestRunner.run(URLToolTest.class);
    // JUnitDoclet end method testcase.main
  }
}
