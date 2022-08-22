package housing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the Sign class.
 */
public class SignTest {
  private Sign testDemo;

  @Before
  public void setUp() throws Exception {
    testDemo = signTest("Devarsh", Sex.MALE, Food.Egg);
  }

  /**
   * This method is easy and short way of creating instances of a new
   * sign object.
   *
   * @param name          the name of monkey.
   * @param monkeySex     the sex of the monkey.
   * @param monkeyFavFood the favourite food of the monkey.
   * @return a new instance of a Isolation object
   */
  protected Sign signTest(String name, Sex monkeySex, Food monkeyFavFood) {
    return new Sign(name, monkeySex, monkeyFavFood);
  }

  @Test
  public void getNameofSign() {
    assertEquals(testDemo.getNameofSign(), "Devarsh");
  }

  @Test
  public void getSexofSign() {
    assertEquals(testDemo.getSexofSign(), Sex.MALE);
  }

  @Test
  public void getFavoriteFoodOfSign() {
    assertEquals(testDemo.getFavoriteFoodOfSign(), Food.Egg);
  }
}