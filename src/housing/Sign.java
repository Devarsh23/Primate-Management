package housing;

/**
 * This class is used to display the monkey attributes in a structured format.
 */
public class Sign {
  private String name;
  private Sex monkeySex;
  private Food favouriteFood;

  /**
   * Constructs a Sign which includes name, Sex and favourite food of monkey.
   *
   * @param name          the name of the monkey.
   * @param monkeySex     the sex of the monkey.
   * @param favouriteFood the favourite food of monkey.
   */
  public Sign(String name, Sex monkeySex, Food favouriteFood) {
    this.name = name;
    this.monkeySex = monkeySex;
    this.favouriteFood = favouriteFood;
  }

  /**
   * Method to return name of monkey.
   */
  public String getNameofSign() {
    return this.name;
  }

  /**
   * Method to return sex of monkey.
   */
  public Sex getSexofSign() {
    return this.monkeySex;
  }

  /**
   * Method to return favourite food of monkey.
   */
  public Food getFavoriteFoodOfSign() {
    return this.favouriteFood;
  }

}
