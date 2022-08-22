package housing;

import java.util.ArrayList;

/**
 * This class contains the information of a particular isolation
 * it indicates the fields like no of units, name, and ID of Isolation.
 */
public class Isolation implements Housing {
  private int noOfUnits;
  private String name;
  private int isolationId;
  protected static ArrayList<Monkey> isolationUnits = new ArrayList<Monkey>();
  private int counter = 0;

  /**
   * Constructs an Isolation which includes no of units, name, and ID.
   *
   * @param noOfUnits   the number of units in Isolation.
   * @param name        the name of the Isolation.
   * @param isolationId the ID of the Isolation.
   * @throws IllegalArgumentException if no of units is negative.
   * @throws IllegalArgumentException if no of units is greater than MAX int value.
   */
  public Isolation(int noOfUnits, String name, int isolationId) throws IllegalArgumentException {
    if (noOfUnits < 0) {
      throw new IllegalArgumentException(
              "The isolation size can not be less than zero"
      );
    }
    if (noOfUnits > Integer.MAX_VALUE) {
      throw new IllegalArgumentException(
              "The value is greater than max integer size"
      );
    }
    this.noOfUnits = noOfUnits;
    this.name = name;
    this.isolationId = isolationId;
  }

  @Override
  public void addPrimate(Monkey obj) {
    if (getRemainingSpace() >= 1) {
      isolationUnits.add(obj);
      counter++;
    }
  }

  @Override
  public void reducePrimate(Monkey obj) throws IllegalArgumentException {
    if (this.counter <= 0) {
      throw new IllegalArgumentException("Can not remove animal from empty isolation");
    }
    for (int i = 0; i < isolationUnits.size(); i++) {
      if (isolationUnits.get(i) == obj) {
        isolationUnits.remove(obj);
        counter--;
      } else {
        throw new IllegalArgumentException("Can not reduce monkey which is not in enclosure");
      }
    }
  }

  @Override
  public void shiftPrimate(Monkey obj) {
    Enclosure enclosureObj = new Enclosure("enclosure1", 1, 50,
            10, Species.SAKI);
    enclosureObj.addPrimate(obj);
    this.reducePrimate(obj);
  }

  @Override
  public int getRemainingSpace() {
    return noOfUnits - counter;
  }

  @Override
  public ArrayList<Monkey> getAnimalList() {
    return isolationUnits;
  }

  @Override
  public String getHousingDetail() {
    return String.format("Isolation Name " + this.name + " Isolation ID" + this.isolationId);
  }

  @Override
  public void addCell(Housing obj) {
    /* The below line adds the null object to isolation but we can also add the Isolation cage */
    isolationUnits.add(null);
    counter++;
  }

  /**
   * This method is not supported in the isolation class.
   */
  @Override
  public ArrayList<Sign> getSign() {
    throw new UnsupportedOperationException();
  }

  /**
   * This method presents the list of animal living in isolation.
   */
  protected ArrayList<Monkey> getIsolationUnits() {
    return isolationUnits;
  }
}
