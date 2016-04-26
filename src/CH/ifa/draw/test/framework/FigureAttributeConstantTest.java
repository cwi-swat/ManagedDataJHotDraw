package CH.ifa.draw.test.framework;

import junit.framework.TestCase;
// JUnitDoclet begin import
import CH.ifa.draw.framework.FigureAttributeConstant;
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
* TestCase FigureAttributeConstantTest is generated by
* JUnitDoclet to hold the tests for FigureAttributeConstant.
* @see CH.ifa.draw.framework.FigureAttributeConstant
*/
// JUnitDoclet end javadoc_class
public class FigureAttributeConstantTest
// JUnitDoclet begin extends_implements
extends TestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  // instance variables, helper methods, ... put them in this marker
  CH.ifa.draw.framework.FigureAttributeConstant figureattributeconstant = null;
  // JUnitDoclet end class
  
  /**
  * Constructor FigureAttributeConstantTest is
  * basically calling the inherited constructor to
  * initiate the TestCase for use by the Framework.
  */
  public FigureAttributeConstantTest(String name) {
    // JUnitDoclet begin method FigureAttributeConstantTest
    super(name);
    // JUnitDoclet end method FigureAttributeConstantTest
  }
  
  /**
  * Factory method for instances of the class to be tested.
  */
  public CH.ifa.draw.framework.FigureAttributeConstant createInstance() throws Exception {
    // JUnitDoclet begin method testcase.createInstance
    return new CH.ifa.draw.framework.FigureAttributeConstant("test_property");
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
    figureattributeconstant = createInstance();
    // JUnitDoclet end method testcase.setUp
  }
  
  /**
  * Method tearDown is overwriting the framework method to
  * clean up after each single test of this TestCase.
  * It's called from the JUnit framework only.
  */
  protected void tearDown() throws Exception {
    // JUnitDoclet begin method testcase.tearDown
    figureattributeconstant = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  // JUnitDoclet begin javadoc_method getName()
  /**
  * Method testGetName is testing getName
  * @see CH.ifa.draw.framework.FigureAttributeConstant#getName()
  */
  // JUnitDoclet end javadoc_method getName()
  public void testGetName() throws Exception {
    // JUnitDoclet begin method getName
    // JUnitDoclet end method getName
  }
  
  // JUnitDoclet begin javadoc_method getID()
  /**
  * Method testGetID is testing getID
  * @see CH.ifa.draw.framework.FigureAttributeConstant#getID()
  */
  // JUnitDoclet end javadoc_method getID()
  public void testGetID() throws Exception {
    // JUnitDoclet begin method getID
    // JUnitDoclet end method getID
  }
  
  // JUnitDoclet begin javadoc_method equals()
  /**
  * Method testEquals is testing equals
  * @see CH.ifa.draw.framework.FigureAttributeConstant#equals(java.lang.Object)
  */
  // JUnitDoclet end javadoc_method equals()
  public void testEquals() throws Exception {
    // JUnitDoclet begin method equals
    // JUnitDoclet end method equals
  }
  
  // JUnitDoclet begin javadoc_method hashCode()
  /**
  * Method testHashCode is testing hashCode
  * @see CH.ifa.draw.framework.FigureAttributeConstant#hashCode()
  */
  // JUnitDoclet end javadoc_method hashCode()
  public void testHashCode() throws Exception {
    // JUnitDoclet begin method hashCode
    // JUnitDoclet end method hashCode
  }
  
  // JUnitDoclet begin javadoc_method getConstant()
  /**
  * Method testGetConstant is testing getConstant
  * @see CH.ifa.draw.framework.FigureAttributeConstant#getConstant(java.lang.String)
  */
  // JUnitDoclet end javadoc_method getConstant()
  public void testGetConstant() throws Exception {
    // JUnitDoclet begin method getConstant
    // JUnitDoclet end method getConstant
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
    junit.textui.TestRunner.run(FigureAttributeConstantTest.class);
    // JUnitDoclet end method testcase.main
  }
}
