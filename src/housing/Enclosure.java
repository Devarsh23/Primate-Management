package housing;

import java.util.ArrayList;

/**
 * This class contains the information of a particular enclosure
 * it indicates the fields like name, ID, size, no of animal, and species.
 */
public class Enclosure implements Housing {

  private String name;
  private int enclosureId;
  private int enclosureSize;
  private int noOfAnimal;
  private Species monkeySpecies;
  protected static ArrayList<Enclosure> enclosureUnits = new ArrayList<Enclosure>();


  private ArrayList<Monkey> enclosureAnimals = new ArrayList<Monkey>();

  /**
   * Constructs an Enclosure which includes name, ID, size, no of animal, and species.
   *
   * @param name          the name of the enclosure.
   * @param enclosureId   the id of the enclosure.
   * @param enclosureSize the size of enclosure.
   * @param noOfAnimal    the no of animal in enclosure.
   * @param monkeySpecies the species of monkey in enclosure.
   * @throws IllegalArgumentException if no of animal is negative.
   * @throws IllegalArgumentException if the size of enclosure is negative.
   */
  public Enclosure(String name, int enclosureId, int enclosureSize, int noOfAnimal,
                   Species monkeySpecies)
          throws IllegalArgumentException {
    if (noOfAnimal < 0) {
      throw new IllegalArgumentException("The no of animal can not be less than zero");
    }
    if (enclosureSize < 0) {
      throw new IllegalArgumentException("The size of the enclosure can not be less than zero");
    }
    this.name = name;
    this.enclosureId = enclosureId;
    this.enclosureSize = enclosureSize;
    this.noOfAnimal = noOfAnimal;
    this.monkeySpecies = monkeySpecies;
    enclosureUnits.add(this);
  }

  @Override
  public void addPrimate(Monkey obj) throws IllegalArgumentException {
    if (obj.getSpecies() != monkeySpecies) {
      throw new IllegalArgumentException(
              "The species in enclosure is not the species requested to add"
      );
    }
    int size = obj.getSize();
    double availableSpace = getRemainingSpace();
    if (availableSpace >= size) {
      if (enclosureAnimals.contains(obj)) {
        throw new IllegalArgumentException("Can not add the monkey alredy present");
      }
      enclosureAnimals.add(obj);
      enclosureSize -= size;
      monkeySpecies = obj.getSpecies();
    } else {
      throw new IllegalArgumentException("The size of the enclosure is full");
    }
  }

  @Override
  public void reducePrimate(Monkey obj) throws IllegalArgumentException {
    if (getRemainingSpace() == enclosureSize) {
      throw new IllegalArgumentException("Can not remove Primate from empty enclosure");
    }
    for (int i = 0; i < enclosureAnimals.size(); i++) {
      if (enclosureAnimals.get(i) == obj) {
        enclosureAnimals.remove(obj);
      } else {
        throw new IllegalArgumentException("Can not reduce monkey which is not in enclosure");
      }
    }
  }

  @Override
  public void shiftPrimate(Monkey obj) throws IllegalArgumentException {
    if (getRemainingSpace() == enclosureSize) {
      throw new IllegalArgumentException("Can not shift Primate from empty enclosure");
    }

    Isolation isolationObj = new Isolation(3, "Isolation1", 1);
    isolationObj.addPrimate(obj);
    this.reducePrimate(obj);
  }

  @Override
  public int getRemainingSpace() {
    int totalSqMeter = 0;
    if (!enclosureAnimals.isEmpty()) {
      int sizeOfMonkey;
      for (int i = 0; i < enclosureAnimals.size(); i++) {
        sizeOfMonkey = enclosureAnimals.get(i).getSize();
        if (sizeOfMonkey == 1) {
          totalSqMeter = totalSqMeter + 1;
        } else if (sizeOfMonkey == 5) {
          totalSqMeter = totalSqMeter + 5;
        } else {
          totalSqMeter = totalSqMeter + 10;
        }
      }
      return enclosureSize - totalSqMeter;
    }
    return enclosureSize;
  }

  /**
   * This method presents the list of animal residing in a particular enclosure.
   */
  protected ArrayList<Monkey> getenclosureAnimals() {
    return enclosureAnimals;
  }

  @Override
  public ArrayList<Sign> getSign() {
    ArrayList<Sign> signList = new ArrayList<Sign>();
    if (!enclosureAnimals.isEmpty()) {
      for (int i = 0; i < enclosureAnimals.size(); i++) {
        String name = enclosureAnimals.get(i).getName();
        Sex sex = enclosureAnimals.get(i).getSex();
        Food favouriteFood = enclosureAnimals.get(i).getFavouriteFood();
        Sign signObject = new Sign(name, sex, favouriteFood);
        signList.add(signObject);
      }
      return signList;
    }
    return new ArrayList<Sign>();
  }

  @Override
  public void addCell(Housing obj) {
    /* The below line adds the null object to isolation but we can also add the enclosure */
    enclosureUnits.add(null);
  }

  /**
   * This method presents the species of the monkey residing in a particular enclosure.
   */
  protected Species getSpecies() {
    return monkeySpecies;
  }

  @Override
  public ArrayList<Monkey> getAnimalList() {
    return enclosureAnimals;
  }

  @Override
  public String getHousingDetail() {
    return String.format("Enclosure name " + this.name + " Enclosure id " + this.enclosureId
            + " Enclosure Size " + this.enclosureSize + " no of animal in Enclosure "
            + this.noOfAnimal);
  }
}
