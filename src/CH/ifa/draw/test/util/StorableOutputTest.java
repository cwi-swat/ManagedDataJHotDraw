package CH.ifa.draw.test.util;

import junit.framework.TestCase;
// JUnitDoclet begin import
import CH.ifa.draw.util.StorableOutput;
import CH.ifa.draw.util.StorageFormat;
import CH.ifa.draw.util.StandardStorageFormat;

import java.io.FileOutputStream;
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
* TestCase StorableOutputTest is generated by
* JUnitDoclet to hold the tests for StorableOutput.
* @see CH.ifa.draw.util.StorableOutput
*/
// JUnitDoclet end javadoc_class
public class StorableOutputTest
// JUnitDoclet begin extends_implements
extends TestCase
// JUnitDoclet end extends_implements
{
  // JUnitDoclet begin class
  // instance variables, helper methods, ... put them in this marker
  CH.ifa.draw.util.StorableOutput storableoutput = null;
  // JUnitDoclet end class
  
  /**
  * Constructor StorableOutputTest is
  * basically calling the inherited constructor to
  * initiate the TestCase for use by the Framework.
  */
  public StorableOutputTest(String name) {
    // JUnitDoclet begin method StorableOutputTest
    super(name);
    // JUnitDoclet end method StorableOutputTest
  }
  
  /**
  * Factory method for instances of the class to be tested.
  */
  public CH.ifa.draw.util.StorableOutput createInstance() throws Exception {
    // JUnitDoclet begin method testcase.createInstance
	// todo
	String fileName = "";
	FileOutputStream stream = new FileOutputStream(fileName);
    return new CH.ifa.draw.util.StorableOutput(stream);
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
    storableoutput = createInstance();
    // JUnitDoclet end method testcase.setUp
  }
  
  /**
  * Method tearDown is overwriting the framework method to
  * clean up after each single test of this TestCase.
  * It's called from the JUnit framework only.
  */
  protected void tearDown() throws Exception {
    // JUnitDoclet begin method testcase.tearDown
    storableoutput = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
  }
  
  // JUnitDoclet begin javadoc_method writeStorable()
  /**
  * Method testWriteStorable is testing writeStorable
  * @see CH.ifa.draw.util.StorableOutput#writeStorable(CH.ifa.draw.util.Storable)
  */
  // JUnitDoclet end javadoc_method writeStorable()
  public void testWriteStorable() throws Exception {
    // JUnitDoclet begin method writeStorable
    // JUnitDoclet end method writeStorable
  }
  
  // JUnitDoclet begin javadoc_method writeInt()
  /**
  * Method testWriteInt is testing writeInt
  * @see CH.ifa.draw.util.StorableOutput#writeInt(int)
  */
  // JUnitDoclet end javadoc_method writeInt()
  public void testWriteInt() throws Exception {
    // JUnitDoclet begin method writeInt
    // JUnitDoclet end method writeInt
  }
  
  // JUnitDoclet begin javadoc_method writeLong()
  /**
  * Method testWriteLong is testing writeLong
  * @see CH.ifa.draw.util.StorableOutput#writeLong(long)
  */
  // JUnitDoclet end javadoc_method writeLong()
  public void testWriteLong() throws Exception {
    // JUnitDoclet begin method writeLong
    // JUnitDoclet end method writeLong
  }
  
  // JUnitDoclet begin javadoc_method writeColor()
  /**
  * Method testWriteColor is testing writeColor
  * @see CH.ifa.draw.util.StorableOutput#writeColor(java.awt.Color)
  */
  // JUnitDoclet end javadoc_method writeColor()
  public void testWriteColor() throws Exception {
    // JUnitDoclet begin method writeColor
    // JUnitDoclet end method writeColor
  }
  
  // JUnitDoclet begin javadoc_method writeDouble()
  /**
  * Method testWriteDouble is testing writeDouble
  * @see CH.ifa.draw.util.StorableOutput#writeDouble(double)
  */
  // JUnitDoclet end javadoc_method writeDouble()
  public void testWriteDouble() throws Exception {
    // JUnitDoclet begin method writeDouble
    // JUnitDoclet end method writeDouble
  }
  
  // JUnitDoclet begin javadoc_method writeBoolean()
  /**
  * Method testWriteBoolean is testing writeBoolean
  * @see CH.ifa.draw.util.StorableOutput#writeBoolean(boolean)
  */
  // JUnitDoclet end javadoc_method writeBoolean()
  public void testWriteBoolean() throws Exception {
    // JUnitDoclet begin method writeBoolean
    // JUnitDoclet end method writeBoolean
  }
  
  // JUnitDoclet begin javadoc_method writeString()
  /**
  * Method testWriteString is testing writeString
  * @see CH.ifa.draw.util.StorableOutput#writeString(java.lang.String)
  */
  // JUnitDoclet end javadoc_method writeString()
  public void testWriteString() throws Exception {
    // JUnitDoclet begin method writeString
    // JUnitDoclet end method writeString
  }
  
  // JUnitDoclet begin javadoc_method close()
  /**
  * Method testClose is testing close
  * @see CH.ifa.draw.util.StorableOutput#close()
  */
  // JUnitDoclet end javadoc_method close()
  public void testClose() throws Exception {
    // JUnitDoclet begin method close
    // JUnitDoclet end method close
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
    junit.textui.TestRunner.run(StorableOutputTest.class);
    // JUnitDoclet end method testcase.main
  }
}
