package housing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the monkey class.
 */
public class MonkeyTest {
  private Monkey testDemo;

  @Before
  public void setUp() throws Exception {
    testDemo = testMonkey("Monkey1", 1, 25, 5, Sex.MALE, Size.SMALL,
            Food.Egg, Species.SAKI);
  }

  /**
   * This method is easy and short way of creating instances of a new
   * Monkey object.
   *
   * @param name          the name monkey
   * @param id            the id monkey
   * @param weight        the weight of the monkey
   * @param age           the age monkey
   * @param monkeySex     sex of the monkey
   * @param monkeySpecies Species of the monkey
   * @return a new instance of a Isolation object
   */
  protected Monkey testMonkey(String name, int id, int weight, int age, Sex monkeySex,
                              Size monkeySize, Food monkeyFood, Species monkeySpecies) {
    return new Monkey(name, id, weight, age, monkeySex, monkeySize, monkeyFood, monkeySpecies);
  }

  @Test
  public void getName() {
    assertEquals(testDemo.getName(), "Monkey1");
  }

  @Test
  public void getSize() {
    assertEquals(testDemo.getSize(), 1);
  }

  @Test
  public void getId() {
    assertEquals(testDemo.getId(), 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidWeight() {
    testMonkey("monkey2", 2, -30, 40, Sex.MALE, Size.SMALL, Food.Egg,
            Species.DRILL);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidAge() {
    testMonkey("monkey2", 2, 40, -40, Sex.MALE, Size.SMALL, Food.Egg,
            Species.DRILL);
  }

  @Test
  public void getSpecies() {
    assertEquals(testDemo.getSpecies(), Species.SAKI);
  }

  @Test
  public void getFavouriteFood() {
    assertEquals(testDemo.getFavouriteFood(), Food.Egg);
  }

  @Test
  public void getSex() {
    assertEquals(testDemo.getSex(), Sex.MALE);
  }

  @Test
  public void getFoodQuantity() {
    assertEquals(testDemo.getFoodQuantity(), 100);
  }

  @Test
  public void getAge() {
    assertEquals(testDemo.getAge(), 5);
  }

  @Test
  public void getWeight() {
    assertEquals(testDemo.getWeight(), 25);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidMonkey() {
    testMonkey("Monkey1", -1, 25, 5, Sex.MALE, Size.SMALL,
            Food.Egg, Species.SAKI);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidFavFood() {
    testMonkey("Monkey1", 1, 25, 5, Sex.MALE, Size.SMALL,
            null, Species.SAKI);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfValidSpecies() {
    testMonkey("Monkey1", 1, 25, 5, Sex.MALE, Size.SMALL,
            null, Species.SAKI);
  }
}