package CH.ifa.draw.test.contrib;

import CH.ifa.draw.standard.DeleteCommand;
import CH.ifa.draw.test.JHDTestCase;
import CH.ifa.draw.util.Command;

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
* TestCase CommandCheckBoxMenuItemTest is generated by
* JUnitDoclet to hold the tests for CommandCheckBoxMenuItem.
* @see CH.ifa.draw.contrib.CommandCheckBoxMenuItem
*/
// JUnitDoclet end javadoc_class
public class CommandCheckBoxMenuItemTest
// JUnitDoclet begin extends_implements
extends JHDTestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  // instance variables, helper methods, ... put them in this marker
  CH.ifa.draw.contrib.CommandCheckBoxMenuItem commandcheckboxmenuitem = null;
  // JUnitDoclet end class
  
  /**
  * Constructor CommandCheckBoxMenuItemTest is
  * basically calling the inherited constructor to
  * initiate the TestCase for use by the Framework.
  */
  public CommandCheckBoxMenuItemTest(String name) {
    // JUnitDoclet begin method CommandCheckBoxMenuItemTest
    super(name);
    // JUnitDoclet end method CommandCheckBoxMenuItemTest
  }
  
  /**
  * Factory method for instances of the class to be tested.
  */
  public CH.ifa.draw.contrib.CommandCheckBoxMenuItem createInstance() throws Exception {
    // JUnitDoclet begin method testcase.createInstance
	Command cmd = new DeleteCommand("TestDelete", getDrawingEditor());
    return new CH.ifa.draw.contrib.CommandCheckBoxMenuItem(cmd);
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
    commandcheckboxmenuitem = createInstance();
    // JUnitDoclet end method testcase.setUp
  }
  
  /**
  * Method tearDown is overwriting the framework method to
  * clean up after each single test of this TestCase.
  * It's called from the JUnit framework only.
  */
  protected void tearDown() throws Exception {
    // JUnitDoclet begin method testcase.tearDown
    commandcheckboxmenuitem = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  // JUnitDoclet begin javadoc_method setCommand()
  /**
  * Method testSetGetCommand is testing setCommand
  * and getCommand together by setting some value
  * and verifying it by reading.
  * @see CH.ifa.draw.contrib.CommandCheckBoxMenuItem#setCommand(CH.ifa.draw.util.Command)
  * @see CH.ifa.draw.contrib.CommandCheckBoxMenuItem#getCommand()
  */
  // JUnitDoclet end javadoc_method setCommand()
  public void testSetGetCommand() throws Exception {
    // JUnitDoclet begin method setCommand getCommand
    CH.ifa.draw.util.Command[] tests = {new DeleteCommand("TestDelete", getDrawingEditor()), null};
    
    for (int i = 0; i < tests.length; i++) {
      commandcheckboxmenuitem.setCommand(tests[i]);
      assertEquals(tests[i], commandcheckboxmenuitem.getCommand());
    }
    // JUnitDoclet end method setCommand getCommand
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
    junit.textui.TestRunner.run(CommandCheckBoxMenuItemTest.class);
    // JUnitDoclet end method testcase.main
  }
}
