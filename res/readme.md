# Project 1
## Jungle friends Primate Sanctuary

## 1.About/Overview
The given problem statement states that the Jungle Primate Sanctuary wants to digitalize their system and they want more feature added to their current system. They want to add the feature like add, remove, and shift animal to the isolation or enclosure. Also, they want the features like report the species living in a sanctuary with their name and their location in alphabetical order, look up for where a particular species is housed in sanctuary, get details on each monkey living in sanctuary in alphabetical order, and create a shoping list including the quantity of favourite food of monkey.

So, here I have tried to solve this problem by creating the set of required features (function) which would not ony help them to solve their problem to digitalize their system but would also provide them the added functionality. I have designed and implemented this functionality considering the *Object Oriented Design* as a design paradigm. 
## 2. List of features
- Add the Primate(Monkey) in to the Isolation. 
- Add the Primate(Monkey) in to the enclosure
- Reduce(remove) the Primate(Monkey) from the Isolation.
- Reduce(remove) the Primate(Monkey) from the Isolation.
- Shift the Primate(Monkey) from isolation to enclosure.
- Shift the Primate(Monkey) from enclosure to isolation. 
- Add new isolation
- Add new enclosure
- The project could get the alphbetical sorted list of the species living in a sanctuary along with the location on where they are housed.
- The project could look for a particular species on where it is housed. Also, if there is a case where the requested species is not housed than this incident is reported.
- The project could also mention the list of all the monkey present in a sanctuary in alphabeticl sorted oreder along with the detail on where they are housed.
- The project could also provide the shopping list of the favourite food of monkey. It also mention in which quantity each food is needed according to the number and size of the monkey.
- The project could also provide the sign of each monkey living in the sanctuary. This functionality return the list of sign in a structured way.
## 3. How to Run
- This project can be run by running the JAR file provided in the JAR folder.
## 4. How to use program
- addPrimate(Monkey obj) : This method add the primate in the Sanctuary. To run this functionality we need to call this method by the object of the enclosure or isolation. If we need to add primate in isolation then this is called by the object of isolation. Also, if we need to add primate in enclosure then this method is called by the object of enclosure. It takes the object of Monkey class as an argument.
- reducePrimate(Monkey obj) : This method removes the primate from the sanctuary. To run this functionality we need to call this method by the object of the enclosure or isolation. If we need to reduce primate in isolation then this is called by the object of isolation. Also, if we need to reduce primate in enclosure then this is called by the object of enclosure. It takes the object of Monkey class as an argument.
- shiftPrimate(Monkey obj) : This method shifts the primate in the Sanctuary.To run this functionality we need to call this method by the object of the enclosure or isolation. If we need to shift primate from isolation to enclosure then this is called by the object of isolation. Also, if we need to shift primate from enclosure to isolation  then this is called by the object of enclosure. It takes the object of Monkey class as an argument.
- housedSpecies() : This method returns the list of the species in an alphabetical order. Also it returns where each species is housed. to run this method it is called by the object of the Utlity class.
- lookUp(Species species) : This method finds where the particular species is residing. It take Species enum as an argument and search in the sanctuary where that particular species is housed. To run this method it needs to be called from the object of the Utility class.
- alphabeticalMonkeyList() : This method returns the information about where each monkey is housed in the sanctuary in alphabetical order. To run this method it is needed to be called by the object of the Utility class. 
- shoppingInfo() : This method returns the hash map containing the favourite food of the monkey and the quantity of food needed to be purchased. Here, the quantity of the food is determine by the size of monkey. To run this method it is needed to be called by the object of the Utility class. 
## 5. Description Of Example
- The description of the output is provided in the DriverOutput.txt files in the res folder.
- line 2. Welcome line which print welcome message
- line 4 This line shows that the sanctuary is initialized to 1(n) isolation and 10(m) no of troops in enclosures.
- line 8-17 This section adds the primate into the isolation and displays the attributes of the added primate.
- line 20-29  This section removes the monkey from the isolation and displays the details of the monkey which is remoced.
- line 31-40 This section shifts the monkey form Isolation to enclosure and displays the detail of that monkey.
- line 42-51 This section adds the monkey to the enclosure and displays the detail of the monkey added.
- line 53-62 This section shift the monkey from enclosure to isolation and displays the detail of the monkey shifted.
- line 64-73 This Section removes the monkey form the enclosure and diplays the detail of the removed monkey.
- line 75-76 This section shows the Species housed in sanctuary in alphabetical order
- line 78-79 This species lookup for a particular species an displays the detail.
- Line 81-84 This section displays all the monkey housed in the sanctuary in alphabetical order along with location.
- line 86-89 This section displays sign of the monkey in enclosure.
- line 90-91 This section displays the shoping list of the sanctuary
- Hence We have walkthrough the entire example and discuss each aspect of it.
## 6. Design/Model Changes
- Introduced the enum classes in the design as it provides the flexibililty to handle categorical data easily. The new design includes the enum like :- Food(Seeds, Fruits, Insects, Egg, Leaves, Nuts, TreeSap), sex(MALE, FEMALE), Species(DRILL, GUEREZA, HOWLER, MANGABEY, SAKI, SPIDER, SQUIRREL, TAMARIN), Size(SMALL, MEDIUM, LARGE). 
- Also, I have added the Isolation cretor and enclosure creator class. This will help me to add the functionality of creating isolation and enclosure.
- I have removed the Abstract housing class which implements the Housing interface. The main reason to create the abstract class is to ensure that the code is shared between the classes which extens that class. As this functionality was not properly provided in the previos design so it was not needed to implement this class.
- I have added the sign class which provides the strutured data for the getSign method which shows the details each monkey in the enclosure. 
## 7. Assumptions
- There are no specific assumption I have considered to create this project according to the description. 
## 8. Limitations
- There are no imitation in the project as it works according to the description given. The project completely runs and checks all the functionality which are mean to be provided in to the sanctuary. Also, the test case provided encourages that the code runs well under all circumstances.
## 9 Citations
- I have not used any major citation but I have seen some line of code on stack overflow. So the link for that code is : "https://stackoverflow.com/questions/20480723/how-to-sort-2d-arrayliststring-by-only-the-first-element"




.








