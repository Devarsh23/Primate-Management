import housing.Enclosure;
import housing.Food;
import housing.Isolation;
import housing.Monkey;
import housing.Sex;
import housing.Size;
import housing.Species;
import housing.Utility;


class Driver {
  public static void main(String[] args) {
    Isolation isoDemo1 = new Isolation(1, "isolation 1", 20);
    final Enclosure encDemoObj1 = new Enclosure("Enclosure 1", 1, 20,
            10, Species.DRILL);
    final Enclosure encDemoObj2 = new Enclosure("Enclosure 1", 1, 20,
            10, Species.HOWLER);
    final Monkey monkey = new Monkey("Monkey1", 1, 5, 3, Sex.FEMALE,
            Size.MEDIUM, Food.Insects, Species.SAKI);
    final Monkey monkey1 = new Monkey("Primate1", 2, 3, 1, Sex.MALE,
            Size.SMALL, Food.TreeSap, Species.HOWLER);
    final Utility utilityDemo = new Utility();

    System.out.println("You have arrived at the Jungle Friends Primate Sanctuary!");
    System.out.println("\nIn our sanctuary, you'll find " + isoDemo1.getRemainingSpace()
            + " isolations and" + " 10 enclosures");

    System.out.println("\nNow, we'll see all the features of this Sanctuary like:");
    System.out.println("\nAdding a new Primate to the isolation");
    isoDemo1.addPrimate(monkey);
    System.out.println("A primate having details like:"
            + "\n" + "Monkey Name: " + monkey.getName() + "\nMonkey ID: "
            + monkey.getId() + "\nMonkey Age: " + monkey.getAge() + "\nMonkey Size: "
            + monkey.getSize() + "\nMonkey Species: " + monkey.getSpecies() + "\nSex: "
            + monkey.getSex() + "\nFavourite Food: " + monkey.getFavouriteFood()
            + "\nhas been added to an isolation");

    System.out.println("\n\n Now, let's remove the same monkey from the isolation.");
    isoDemo1.reducePrimate(monkey);
    System.out.println("A primate having details like:"
            + "\n" + "Monkey Name: " + monkey.getName() + "\nMonkey ID: "
            + monkey.getId() + "\nMonkey Age: " + monkey.getAge() + "\nMonkey Size: "
            + monkey.getSize() + "\nMonkey Species: " + monkey.getSpecies() + "\nSex: "
            + monkey.getSex() + "\nFavourite Food: " + monkey.getFavouriteFood()
            + "\nhas been removed from the isolation");

    System.out.println("\n Now, we'll see the shifting of a monkey from Isolation to Enclosure");
    isoDemo1.addPrimate(monkey);
    isoDemo1.shiftPrimate(monkey);
    System.out.println("A primate having details like:"
            + "\n" + "Monkey Name: " + monkey.getName() + "\nMonkey ID: "
            + monkey.getId() + "\nMonkey Age: " + monkey.getAge() + "\nMonkey Size: "
            + monkey.getSize() + "\nMonkey Species: " + monkey.getSpecies() + "\nSex: "
            + monkey.getSex() + "\nFavourite Food: " + monkey.getFavouriteFood()
            + "\nhas been shifted from the isolation to enclosure");

    System.out.println("\nLet's add a monkey to the enclosure");
    encDemoObj2.addPrimate(monkey1);
    System.out.println("A monkey having details like: "
            + "\nMonkey Name: " + monkey1.getName() + "\nMonkey ID: "
            + monkey1.getId() + "\nMonkey Age: " + monkey1.getAge() + "\nMonkey Size: "
            + monkey1.getSize() + "\nMonkey Species: " + monkey1.getSpecies()
            + "\nSex: " + monkey1.getSex() + "\nFavourite Food: " + monkey1.getFavouriteFood()
            + "\nhas been added to an enclosure");

    System.out.println("\nLet's shift the monkey from enclosure to isolation");
    encDemoObj2.shiftPrimate(monkey1);
    System.out.println("A monkey having details like: "
            + "\nMonkey Name: " + monkey1.getName() + "\nMonkey ID: "
            + monkey1.getId() + "\nMonkey Age: " + monkey1.getAge() + "\nMonkey Size: "
            + monkey1.getSize() + "\nMonkey Species: " + monkey1.getSpecies()
            + "\nSex: " + monkey1.getSex() + "\nFavourite Food: " + monkey1.getFavouriteFood()
            + "\nhas been shifted to an isolation");

    System.out.println("\nNow, we'll remove a monkey from the enclosure.");

    encDemoObj2.addPrimate(monkey1);
    encDemoObj2.reducePrimate(monkey1);
    System.out.println("A monkey having details like: "
            + "\nMonkey Name: " + monkey1.getName() + "\nMonkey ID: "
            + monkey1.getId() + "\nMonkey Age: " + monkey1.getAge() + "\nMonkey Size: "
            + monkey1.getSize() + "\nMonkey Species: " + monkey1.getSpecies()
            + "\nSex: " + monkey1.getSex() + "\nFavourite Food: " + monkey1.getFavouriteFood()
            + "\nhas been removed from an enclosure");


    encDemoObj2.addPrimate(monkey1);
    System.out.println("\nNow, we'll see the total Species housed in the Sanctuary in an "
            + "alphabetically sorted order:\n" + utilityDemo.housedSpecies());

    System.out.println("\nLet's lookup where we can find the MANGABEY species.");
    System.out.println(Species.HOWLER.toString() + " can be found at "
            + utilityDemo.lookUp(Species.HOWLER));

    System.out.println("\nLet's get the list of monkey names sorted " + "alphabetically"
            + " along with their housing");

    System.out.println("\nAll housed monkeys in alphabetical order with their housing: \n"
            + utilityDemo.alphabeticalMonkeyList());
    encDemoObj1.addPrimate(new Monkey("Monkey1", 1, 5, 3, Sex.FEMALE,
            Size.MEDIUM, Food.Insects, Species.DRILL));
    System.out.println("\n\nLet's get the signs of every monkey present");
    System.out.println("\nSign: \n" + encDemoObj1.getSign().get(0).getNameofSign()
            + ", " + encDemoObj1.getSign().get(0).getSexofSign()
            + ", " + encDemoObj1.getSign().get(0).getFavoriteFoodOfSign());

    System.out.println("Finally, let's see the shopping list for all the primates in the "
            + "sanctuary: \n" + utilityDemo.shoppingInfo());
  }
}
