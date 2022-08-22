package housing;

/**
 * This class contains the information of a particular Monkey
 * it indicates the fields like name, id, weight, age, sex, size, favourite food,and
 * species of monkey.
 */
public class Monkey {

  private String name;
  private int id;
  private int weight;
  private int age;
  private Sex monkeySex;
  private Size monkeySize;
  private Food monkeyFood;
  private Species monkeySpecies;

  /**
   * Constructs a monkey which includes name, id, weight, age, sex, size, favourite food,and
   * species of monkey.
   *
   * @param name          the name of the monkey.
   * @param id            the id of the monkey.
   * @param weight        the weight of monkey.
   * @param age           the age of monkey.
   * @param monkeySex     the sex of monkey.
   * @param monkeySize    the size of monkey.
   * @param monkeyFood    the favourite food of monkey.
   * @param monkeySpecies the species of monkey.
   * @throws IllegalArgumentException if weight of monkey is negative.
   * @throws IllegalArgumentException if age of monkey is negative.
   */
  public Monkey(String name, int id, int weight, int age, Sex monkeySex, Size monkeySize,
                Food monkeyFood, Species monkeySpecies) throws IllegalArgumentException {
    if (weight < 0) {
      throw new IllegalArgumentException("The weight of the monkey can not be negative");
    }
    if (age < 0) {
      throw new IllegalArgumentException("The age of the monkey can not be negative");
    }
    if (id < 0) {
      throw new IllegalArgumentException("Attempted to add Invalid monkey is not supported");
    }
    if (monkeyFood == null) {
      throw new IllegalArgumentException("Illegal Species not supported");
    }
    this.name = name;
    this.id = id;
    this.weight = weight;
    this.age = age;
    this.monkeySex = monkeySex;
    this.monkeySize = monkeySize;
    this.monkeyFood = monkeyFood;
    this.monkeySpecies = monkeySpecies;
  }

  /**
   * Method to return name of monkey.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Method to return size of monkey.
   */
  public int getSize() {
    if (monkeySize == Size.SMALL) {
      return 1;
    } else if (monkeySize == Size.MEDIUM) {
      return 5;
    } else {
      return 10;
    }
  }

  /**
   * Method to return Species of monkey.
   */
  public Species getSpecies() {
    return monkeySpecies;
  }

  /**
   * Method to return favourite food of monkey.
   */
  public Food getFavouriteFood() {
    return monkeyFood;
  }

  /**
   * Method to return sex of monkey.
   */
  public Sex getSex() {
    return monkeySex;
  }

  /**
   * Method to return quantity of food required by monkey.
   */
  public int getFoodQuantity() {
    if (monkeySize == Size.SMALL) {
      return 100;
    } else if (monkeySize == Size.MEDIUM) {
      return 250;
    } else {
      return 500;
    }
  }

  /**
   * Method to return the age of monkey.
   */
  public int getAge() {
    return this.age;
  }

  /**
   * Method to return id of the monkey.
   */
  public int getWeight() {
    return this.weight;
  }

  /**
   * Method to return id of the monkey.
   */
  public int getId() {
    return this.id;
  }


}
