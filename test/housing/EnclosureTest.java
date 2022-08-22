package housing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing the Enclosure class.
 */
public class EnclosureTest {
  private Housing testDemo;

  @Before
  public void setUp() throws Exception {
    testDemo = enclosureTest("Enclosure1", 1, 20, 4,
            Species.DRILL);
  }

  Monkey monkeyTest = new Monkey("Monkey1", 1, 20, 3, Sex.MALE,
          Size.SMALL, Food.Fruits, Species.DRILL);

  /**
   * This method is easy and short way of creating instances of a new
   * Enclosure object.
   *
   * @param name          the name of the enclosure
   * @param enclosureId   the id of the enclosure
   * @param enclosureSize the size of the enclosure
   * @param noOfAnimal    the number of animal in enclosure
   * @return a new instance of a Enclosure object
   */
  protected Housing enclosureTest(String name, int enclosureId,
                                  int enclosureSize, int noOfAnimal, Species monkeySpecies) {
    return new Enclosure(name, enclosureId, enclosureSize, noOfAnimal, monkeySpecies);
  }

  @Test
  public void addPrimate() {
    testDemo.addPrimate(monkeyTest);
    assertEquals(testDemo.getAnimalList().get(testDemo.getAnimalList().size() - 1), monkeyTest);
  }

  @Test
  public void reducePrimate() {
    testDemo.addPrimate(monkeyTest);
    testDemo.reducePrimate(monkeyTest);
    assertEquals(testDemo.getAnimalList().isEmpty(), true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfReduceFromEmptyEnclosure() {
    testDemo.reducePrimate(monkeyTest);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidReduce() {
    testDemo.addPrimate(monkeyTest);
    Monkey monkeyTestObj = new Monkey("Monkey3", 3, 50, 7, Sex.FEMALE,
            Size.LARGE, Food.Fruits, Species.DRILL);
    testDemo.reducePrimate(monkeyTestObj);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidEnclosureSize() {
    enclosureTest("monkey2", 2, -30, 40, Species.DRILL);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfAddToFullEnclosure() {
    testDemo.addPrimate(monkeyTest);
    Monkey monkeyObj = new Monkey("Monkey2", 2, 40, 5, Sex.FEMALE,
            Size.LARGE, Food.Fruits, Species.DRILL);
    Monkey monkeyTestObj = new Monkey("Monkey3", 3, 50, 7, Sex.FEMALE,
            Size.LARGE, Food.Fruits, Species.DRILL);
    testDemo.addPrimate(monkeyObj);
    testDemo.addPrimate(monkeyTestObj);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfAddMonkeyPresent() {
    testDemo.addPrimate(monkeyTest);
    testDemo.addPrimate(monkeyTest);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidMonkeySpecies() {
    Monkey monkeyTest = new Monkey("Monkey1", 1, 20, 3, Sex.MALE,
            Size.SMALL, Food.Fruits, Species.SAKI);
    testDemo.addPrimate(monkeyTest);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidNoOfAnimal() {
    enclosureTest("monkey2", 2, 30, -40, Species.DRILL);
  }


  @Test
  public void shiftPrimate() {
    testDemo.addPrimate(monkeyTest);
    testDemo.shiftPrimate(monkeyTest);
    assertEquals(testDemo.getAnimalList().isEmpty(), true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidShift() {
    testDemo.addPrimate(monkeyTest);
    Monkey monkeyTestObj = new Monkey("Monkey3", 3, 50, 7, Sex.FEMALE,
            Size.LARGE, Food.Fruits, Species.DRILL);
    testDemo.shiftPrimate(monkeyTestObj);
  }

  @Test
  public void getRemainingSpace() {
    testDemo.addPrimate(monkeyTest);
    Monkey monkeyTest1 = new Monkey("Monkey2", 2, 25, 4, Sex.FEMALE,
            Size.MEDIUM, Food.Fruits, Species.DRILL);
    testDemo.addPrimate(monkeyTest1);
    assertEquals(testDemo.getRemainingSpace(), 8);
  }

  @Test
  public void getenclosureAnimals() {
    ArrayList<Monkey> testList = new ArrayList<Monkey>();
    testList.add(monkeyTest);
    testDemo.addPrimate(monkeyTest);
    assertEquals(testDemo.getAnimalList(), testList);
  }

  @Test
  public void getSign() {
    ArrayList<Sign> testSign = new ArrayList<Sign>();
    Sign obj = new Sign("Monkey1", Sex.MALE, Food.Fruits);
    testSign.add(obj);
    testDemo.addPrimate(monkeyTest);
    assertEquals(testDemo.getSign().get(0).getNameofSign(), "Monkey1");
    assertEquals(testDemo.getSign().get(0).getSexofSign(), Sex.MALE);
    assertEquals(testDemo.getSign().get(0).getFavoriteFoodOfSign(), Food.Fruits);
  }

  @Test
  public void testGetHousingDeteils() {
    testDemo.addPrimate(monkeyTest);
    assertEquals(testDemo.getHousingDetail(), "Enclosure name Enclosure1 Enclosure id "
            + "1 Enclosure Size 19 no of animal in Enclosure 4");
  }

  @Test
  public void getAnimalList() {
    ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    monkeyList.add(monkeyTest);
    testDemo.addPrimate(monkeyTest);
    assertEquals(testDemo.getAnimalList(), monkeyList);
  }
}