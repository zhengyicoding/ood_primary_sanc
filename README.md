Full-Stack Object-Oriented Primate Sanctuary Management Platform using Java and Java Swing

Author: Zhengyi Xu

Date: April 12 2024

General Problem Overview:

We need to create a full software solution for a primate sanctuary. 
The sanctuary operates in a way that 8 species' of monkeys (ususally rescued with different level of injury or illness) can be put into it. 
Firstly all monkeys need to go into isolation area which consists of 20 isolation cages, each can only take in 1 monkey. 
After providing medical care to the monkeys in isolation area, healthy monkeys can be put into enclosure area, which consists of 8 large places, each of which can take in 1 specific species of monkeys without limits on the number of monkeys.
Also, the program need to display a list of every enclosure with information of all monkeys including name, sex and favorite food in each enclosure. A full name list of all monkeys in the sanctuary by alphabetical order can also be displayed to the user.
To sum up, the sanctuary software needs to provide a basic management system for a primate sanctuary, allowing users to register new monkeys, manage monkeys in isolation and track enclosure information and all monkeys in the sanctuary.

Features:

- Registration: Register new monkeys with details such as name, species, sex, size, weight, age, and favorite food. If the isolation area is full, a fail-to-register warning message will show to notify the users. Successful registration message will also show up to the user.
- Isolation Management: View and manage monkeys in isolation, including providing medical care and moving them to enclosures. Failure to provide medical care or move to enclosure operations will incur notifying message to notify the user. Successful operations will also incur success message showing up to notify the user.
- Enclosure Tracking: Monitor monkeys currently residing in different enclosures, showing a list of all enclosures, including species of monkeys residing in, and each monkey's name, sex and favorite food information.
- Full Name List: View a complete list of all monkeys housing in the sanctuary by alphabetical order.

Instructions on Running the Program:

1. Using terminal command line: 

Step 1: Input path to the folder containing the JAR file:

$cd ~/Desktop/cs5004/projects/Project6/res

Step 2: Input command to run the JAR file:

$java -jar Project6.jar

The program should be successfully launched with a GUI (graphical user interface) for the user to interact with.

2. Not using terminal command line:

Step 1: navigate to the directory where the Project6 JAR file is located (should be in /res folder in the project6 folder).

Step 2: Double-click on the project6.jar file.

The primate sanctuary application should start running with a GUI (graphical user interface) of the application to interact with.

Instructions on Using the Application:

The application GUI(graphic user interface) has 4 tabbed panes in accordance with 4 core functions of the application for the user to operate:

- Registration: the user needs to input information of a new monkey to be registered and put into isolation area of the sanctuary: Name, Species (choose from a drop-down box), Sex (choose from a drop-down box), Size, Weight, Age and Favorite Food (choose from a drop-down box). 
After fulfilling all the information, the user can click the "Register New Monkey" button to add the new monkey into the sanctuary. If any missing or incorrect information, a warning message will show up in red. Also, if the isolation area is full, a warning message will show up notifying that no new monkey can be registered at the time. 
If the registration is successful, a success message will show up in blue. The user can also click "Clear Input" button to clear all input in the information filling area.

- Isolation: With new monkeys successfully registered, a list of monkeys in isolation will show up in the Isolation Panel. The user can select 1 monkey from the list, then click "Provide Medical Care" button to treat the selected monkey. Note that only Single Selection is allowed. After receiving medical care, a selected monkey can be moved to enclosure area by clicking "Move to Enclosure" button. Note that only monkeys who have received medical care and become healthy can be moved to enclosure. Otherwise a warning message will show up indicating the move to enclosure action if not successful. If a monkey is successfully moved to enclosure area, the "Monkeys in isolation" list will be updated by removing the monkey from the list.

- Enlosure: Once any monkey is sucessfully moved from isolation to enlosure, a list of all (non-empty) enclosures will show up in this panel. And the list is updated once any new monkey is successfully moved to enclosure. For each enclosure, species of monkeys living in the enclosure, and every monkey's name, sex and favoriate food information shows up. There is no operation required from the user for this panel and the list is only for display purpose.

- Full Name List: The last panel of the application is used to display a full name list of all monkeys housing in the sanctuary. The list is updated once a new monkey is registered into the sanctuary and the names are listed by alphabetical order.

The user can click on the "x" key on the upper left side of the application to quit the program.


Original Design And Changes:

There is only one major change from the original design: tabbed panes. Originally the application used only 1 big nested Panel for all the features. Yet such design make the user interface layout a bit messy and confusing. Also, with more data (number of monkeys) coming in, the display formatting becomes a mess. Also, from back end, a massive view class file containing everything make the code difficult to read or to locate any display area/buttons.
Therefore, tabbed pane is adopted with each pane having its own view class file, packed in the overview class file. With this change, the experience improves significantly for both user side and backend developer side with clear division of functions.

A List of Assumptions:

Each monkey has a unique name.

All monkeys go into the isolation area first (if it is not full).

There are only 8 species of monkeys, each specie enjoys 1 enclosure area.

As long as the user input monkey information with the right data type, the system will accept assuming that the information is correct.

Once any monkey receives medical care, it becomes healthy and can move to enclosure area.



Limitations And Area of Improvements:

There is no function for the user to select and see detailed information of each monkey.

There is no function to update basic information of any monkey (name, age, weight, size, favorite food) once successfully registered.

There is no function to move the monkey back to isolation area. if any monkey gets ill or gets hurt and needs to be isolated again, there is no place to log such information.

There is no function to log the information to remove the monkey from the sanctuary. 

There is no function to log the date and time records of each operation.

Citations:

Java Swing tutorial : https://docs.oracle.com/javase/tutorial/uiswing/
