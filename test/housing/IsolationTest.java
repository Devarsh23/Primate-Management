package housing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the Isolation class.
 */
public class IsolationTest {
  private Housing testDemo;

  @Before
  public void setUp() throws Exception {
    testDemo = isolationTest(3, "Isolation1", 1);
  }

  Monkey monkeyTest = new Monkey("Monkey1", 1, 20, 3, Sex.MALE,
          Size.SMALL, Food.Fruits, Species.SAKI);

  /**
   * This method is easy and short way of creating instances of a new
   * Isolation object.
   *
   * @param noOfUnits   the number of units in the isolation
   * @param name        the name the isolation
   * @param isolationId the id isolation
   * @return a new instance of a Isolation object
   */
  protected Housing isolationTest(int noOfUnits, String name, int isolationId) {
    return new Isolation(noOfUnits, name, isolationId);
  }

  @Test
  public void addPrimate() {
    testDemo.addPrimate(monkeyTest);
    assertEquals(testDemo.getAnimalList().get(testDemo.getAnimalList().size() - 1).getName(),
            monkeyTest.getName());
    assertEquals(testDemo.getAnimalList().get(testDemo.getAnimalList().size() - 1).getSize(),
            monkeyTest.getSize());
    assertEquals(testDemo.getAnimalList().get(testDemo.getAnimalList().size() - 1).getSpecies(),
            monkeyTest.getSpecies());
    assertEquals(testDemo.getAnimalList().get(testDemo.getAnimalList().size() - 1).getSex(),
            monkeyTest.getSex());

  }

  @Test
  public void reducePrimate() {
    testDemo.addPrimate(monkeyTest);
    testDemo.reducePrimate(monkeyTest);
    assertEquals(testDemo.getAnimalList().isEmpty(), true);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidMonkeyReduce() {
    Monkey monkeyTestObj = new Monkey("Monkey3", 3, 50, 7, Sex.FEMALE,
            Size.LARGE, Food.Fruits, Species.DRILL);
    testDemo.reducePrimate(monkeyTestObj);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfReducePrimateFromEmptyIsolation() {
    testDemo.reducePrimate(monkeyTest);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidNoOfUnits() {
    isolationTest(-2, "Isolation2", 2);
  }

  @Test
  public void shiftPrimate() {
    testDemo.addPrimate(monkeyTest);
    testDemo.shiftPrimate(monkeyTest);
    assertEquals(testDemo.getAnimalList().isEmpty(), true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidShiftMonkey() {
    Monkey monkeyTestObj = new Monkey("Monkey3", 3, 50, 7, Sex.FEMALE,
            Size.LARGE, Food.Fruits, Species.DRILL);
    testDemo.shiftPrimate(monkeyTestObj);
  }

  @Test
  public void getRemainingSpace() {
    testDemo.addPrimate(monkeyTest);
    assertEquals(testDemo.getRemainingSpace(), 2);
  }

  @Test
  public void getAnimalList() {
    ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    monkeyList.add(monkeyTest);
    testDemo.addPrimate(monkeyTest);
    assertEquals(testDemo.getAnimalList(), monkeyList);
  }

  @Test
  public void testGetHousingDeteils() {
    testDemo.addPrimate(monkeyTest);
    assertEquals(testDemo.getHousingDetail(), "Isolation Name Isolation1 Isolation ID1");
  }

}