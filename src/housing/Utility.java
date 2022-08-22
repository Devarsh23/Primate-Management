package housing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * This class contains the information about utilities provided by the sanctuary. We could run
 * the utilities with the help of the object of this class.
 */
public class Utility {
  /**
   * This method does the task to specifies the species along with where it is housed in the
   * sanctuary in alphabetical order.
   */
  public ArrayList<ArrayList<String>> housedSpecies() {
    ArrayList<ArrayList<String>> finalList = new ArrayList<ArrayList<String>>();
    for (int i = 0; i < Isolation.isolationUnits.size(); i++) {
      Species demo = Isolation.isolationUnits.get(i).getSpecies();
      finalList.add(new ArrayList<String>(Arrays.asList(demo.toString(), "Isolation")));
    }
    for (int i = 0; i < Enclosure.enclosureUnits.size(); i++) {
      Species demo1 = Enclosure.enclosureUnits.get(i).getSpecies();
      finalList.add(new ArrayList<String>(Arrays.asList(demo1.toString(), "Enclosure")));
    }
    Collections.sort(finalList, new Comparator<ArrayList<String>>() {
      @Override
      public int compare(ArrayList<String> o1, ArrayList<String> o2) {
        return o1.get(0).compareTo(o2.get(0));
      }
    });
    return finalList;
  }

  /**
   * This method look up where each species is housed and report if the species is not housed.
   */
  public String lookUp(Species species) {
    String s = "";
    for (int i = 0; i < Isolation.isolationUnits.size(); i++) {
      Species demo = Isolation.isolationUnits.get(i).getSpecies();
      if (demo == species) {
        s = "Isolation";
      }
    }
    for (int i = 0; i < Enclosure.enclosureUnits.size(); i++) {
      Species demo1 = Enclosure.enclosureUnits.get(i).getSpecies();
      if (demo1 == species) {
        s = s.concat(" & Enclosure");
      }
    }
    if (s.equals("")) {
      throw new IllegalStateException("The species is not present in Sanctuary");
    } else {
      return s;
    }
  }

  /**
   * This method return the information on each monkey in alphabetical order along with
   * where it is currently housed.
   */
  public ArrayList<ArrayList<String>> alphabeticalMonkeyList() {
    ArrayList<ArrayList<String>> alphabeticalList = new ArrayList<ArrayList<String>>();
    for (int i = 0; i < Isolation.isolationUnits.size(); i++) {
      String nameofMonkey = Isolation.isolationUnits.get(i).getName();
      alphabeticalList.add(new ArrayList<String>(Arrays.asList(nameofMonkey, "Isolation")));
    }
    for (int i = 0; i < Enclosure.enclosureUnits.size(); i++) {
      ArrayList<Monkey> monkeyList = Enclosure.enclosureUnits.get(i).getAnimalList();
      for (int j = 0; j < monkeyList.size(); j++) {
        String monkeyName = monkeyList.get(j).getName();
        alphabeticalList.add(new ArrayList<String>(Arrays.asList(monkeyName, "Enclosure")));
      }
    }
    Collections.sort(alphabeticalList, new Comparator<ArrayList<String>>() {
      @Override
      public int compare(ArrayList<String> o1, ArrayList<String> o2) {
        return o1.get(0).compareTo(o2.get(0));
      }
    });
    return alphabeticalList;
  }

  /**
   * This method specifies the hash map of each species along with the required quantity
   * to purchase for it.
   */
  public HashMap<String, Integer> shoppingInfo() {
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < Isolation.isolationUnits.size(); i++) {
      String favFood = Isolation.isolationUnits.get(i).getFavouriteFood().toString();
      int quantity = Isolation.isolationUnits.get(i).getFoodQuantity();
      if (!map.containsKey(favFood)) {
        map.put(favFood, quantity);
      } else {
        map.put(favFood, map.get(favFood) + quantity);
      }
    }
    for (int i = 0; i < Enclosure.enclosureUnits.size(); i++) {
      ArrayList<Monkey> monkeyList = Enclosure.enclosureUnits.get(i).getAnimalList();
      for (int j = 0; j < monkeyList.size(); j++) {
        String favFood = monkeyList.get(j).getFavouriteFood().toString();
        int quantity = monkeyList.get(j).getFoodQuantity();
        if (!map.containsKey(favFood)) {
          map.put(favFood, quantity);
        } else {
          map.put(favFood, map.get(favFood) + quantity);
        }
      }
    }
    return map;
  }

}
