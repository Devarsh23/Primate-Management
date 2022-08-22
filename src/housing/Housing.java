package housing;

import java.util.ArrayList;

/**
 * This interface contains the information of the Housing in a particular sanctuary
 * and various method to implement the housing functionality accurately.
 */
public interface Housing {

  /**
   * This method add the primate object in to the housing of the sanctuary.
   */
  void addPrimate(Monkey obj);

  /**
   * This method removes the primate from the Housing when called.
   *
   * @throws IllegalStateException if called would cause the number of primate below zero.
   */
  void reducePrimate(Monkey obj) throws IllegalStateException;

  /**
   * This method shift the primate from one location to another.
   */
  void shiftPrimate(Monkey obj);

  /**
   * This method checks how much space is available.
   */
  int getRemainingSpace();

  /**
   * This method does the task of listing animal in housing.
   */
  ArrayList<Monkey> getAnimalList();

  /**
   * This method specifies the detail of the Housing.
   */
  String getHousingDetail();

  /**
   * This method presents the details of sign of the enclosure like name,sex and favourite
   * food of each monkey in housing.
   */
  ArrayList<Sign> getSign();

  /**
   * This method adds the cell in to isolation or enclosure depending from where it
   * is called in housing.
   */
  void addCell(Housing obj);
}

