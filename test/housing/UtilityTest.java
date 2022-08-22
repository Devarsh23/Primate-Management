package housing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the utility class.
 */
public class UtilityTest {
  private Utility testDemo;

  @Before
  public void setUp() throws Exception {
    testDemo = testUtility();
  }

  /**
   * This method is easy and short way of creating instances of a new
   * utility object.
   **/
  protected Utility testUtility() {
    return new Utility();
  }

  @Test
  public void housedSpecies() {
    Isolation isolationTestDemo = new Isolation(1, "Isolation", 1);
    Monkey monkeyTest = new Monkey("ami", 1, 20, 3, Sex.MALE,
            Size.SMALL, Food.Fruits, Species.DRILL);
    isolationTestDemo.addPrimate(monkeyTest);
    Enclosure enclosureTestDemo = new Enclosure("Enclosure1", 1, 20,
            4, Species.TAMARIN);
    Monkey monkeyTest1 = new Monkey("pop", 1, 20, 3, Sex.MALE,
            Size.SMALL, Food.Fruits, Species.TAMARIN);
    enclosureTestDemo.addPrimate(monkeyTest1);
    ArrayList<ArrayList<String>> testList = new ArrayList<ArrayList<String>>();
    testList.add(new ArrayList<String>(Arrays.asList("DRILL", "Isolation")));
    testList.add(new ArrayList<String>(Arrays.asList("DRILL", "Isolation")));
    testList.add(new ArrayList<String>(Arrays.asList("DRILL", "Isolation")));
    testList.add(new ArrayList<String>(Arrays.asList("TAMARIN", "Enclosure")));
    assertEquals(testDemo.housedSpecies(), testList);

  }

  @Test
  public void lookUp() {
    Isolation isolationTestDemo = new Isolation(1, "Isolation", 1);
    Monkey monkeyTest = new Monkey("tom", 1, 20, 3, Sex.MALE,
            Size.SMALL, Food.Fruits, Species.DRILL);
    isolationTestDemo.addPrimate(monkeyTest);
    assertEquals(testDemo.lookUp(Species.DRILL), "Isolation");
  }

  @Test(expected = IllegalStateException.class)
  public void testIfValidLookup() {
    testDemo.lookUp(Species.HOWLER);
  }

  @Test
  public void alphabeticalMonkeyList() {
    ArrayList<ArrayList<String>> testList1 = new ArrayList<ArrayList<String>>();
    testList1.add(new ArrayList<String>(Arrays.asList("ami", "Isolation")));
    testList1.add(new ArrayList<String>(Arrays.asList("pop", "Enclosure")));
    testList1.add(new ArrayList<String>(Arrays.asList("tom", "Isolation")));
    testList1.add(new ArrayList<String>(Arrays.asList("tom", "Isolation")));
    assertEquals(testDemo.alphabeticalMonkeyList(), testList1);
  }

  @Test
  public void shoppingInfo() {
    HashMap<String, Integer> map = new HashMap<>();
    Isolation isolationTestDemo = new Isolation(1, "Isolation", 1);
    Monkey monkeyTest = new Monkey("tom", 1, 20, 3, Sex.MALE,
            Size.SMALL, Food.Fruits, Species.DRILL);
    isolationTestDemo.addPrimate(monkeyTest);
    map.put("Fruits", 100);
    assertEquals(testDemo.shoppingInfo(), map);
  }
}