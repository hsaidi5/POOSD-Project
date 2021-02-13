Populate each section with information as it applies to your project. If a section does not apply, explain why. Include diagrams (or links to diagrams) in each section, as appropriate.  For example, sketches of the user interfaces along with an explanation of how the interface components will work; ERD diagrams of the database; rough class diagrams; context diagrams showing the system boundary; etc. Do _not_ link to your diagrams, embed them directly in this document by uploading the images to your GitHub and linking to them. Do _not_ leave any section blank.

# Program Organization

[Context Diagram](https://github.com/hsaidi5/POOSD-Project/blob/master/artifacts/Context%20Diagram.png)

| Block | User Story IDs |
|-------|----------------|
| Mobile Scheduling System | U000 - U010 |

The context system is a simple interaction between the user and the mobile scheduling app. With college students being the target audience for this project, the context diagram provides a general view of how they would go about using the scheduling software.

[Container Diagram](https://github.com/hsaidi5/POOSD-Project/blob/master/artifacts/Container%20Diagram.png)

| Block | User Story IDs |
|-------|----------------|
| Mobile App | U000 - U010 |

Through a mobile app on their Android device, the users will then be able to officially upload relevant data. The application will then keep and store this information, then creating a proper work schedule based off what's been given. Because we will not be using a database for this project, information will be stored locally within the mobile app's files.

[Component Diagram](https://github.com/hsaidi5/POOSD-Project/blob/master/artifacts/Component%20Diagram.png)

| Block | User Story IDs |
|-------|----------------|
| Course Controller | 	U001, U005, U009 |
| History Controller | 	U006, U010 |
| Record Component | 	U006, U007, U010 |
| Security Component |	 U001, U004, U005 |
| Study Session Controller | 	U002, U003, U004, U008 |

Breaking the mobile app down further is the key components and controllers that allow the program to function in accordance with what the user wants.
- The Course Controller is what allows the user to enter information regarding the classes they're currently taking. It will naturally allow for the user to register a new class, or remove one from the registry if they're no longer taking the corresponding course.
- The History Controller takes the information stored in the Record Component and displays the information within to the user. Specifically, the Controller would show statistics on how long they've spent doing work for a certain class, and the average amount of time they've spent working throughout the week.
- The Record Component is what stores statistical information mentioned above. This information is usually taken from the Study Session Controller when the user commits to a study session.
- The Study Session Controller lets the customer dictate when they are beginning a work session for one of the classes they're registered for, how long they plan on studying, and when they plan on ending. There should be another timer within that will notify the user to take a small break and stretch their legs.

# Code Design

click this link bellow to view the class diagram 
https://github.com/hsaidi5/POOSD-Project/blob/master/Class_Diagram.jpg

# Data Design

Our product will not be using a database to store information. Instead, we will be using local files to save any information the user needs to save. This is due to the fact that each instance of the product will run independently of one another and does not need to know what other users are doing. In addition to this, this will allow our application to be run by the user without the need of an internet connection to communicate with a database.

# Business Rules

The only business rule that our product applies to is the fact that we will calculate the number of hours of study for each course every week will be based off of 3 hours per credit hour. This was found to be the general rule across most universities/colleges.

# User Interface Design

Due to our product being a mobile application, the user interface is an essential aspect of the product. The first screen (home screen) will contain 3 main buttons that the user can choose from. There is a "Start Studying" button, an "Update Courses" button, and a "History" button. When the "Start Studying" button is pressed, the user is brought to a new screen where they can set and start the timer for their study session. They will also have a dropdown menu to select the courses that they have saved in order to put that time studying towards the desired course. When the timer starts, a couple of aspects of the screen will change so that there will be a pause timer button and an end timer button. The pause button is for the benefit of the user incase something interrupts them while studying. The end timer button is for the user in the event they finish studying/working early. There is also a back button to return to the home screen.

When the "Update Courses" button is pressed, the new screen contains 2 text entry boxes. Those boxes will take in the course name and credit hours for the course. This will allow the user to enter the desired name for the course and the amount of credit hours for the course. There will be 2 buttons below the text entry boxes. One will be "Add Course" which adds the course that the user has entered in the text box. The other button will be "Remove Course" which will remove the respective course entered by the user. Again, there will be a back button on the bottom left corner of the screen to return to the home screen.

Once the "History" button is pressed, the user is taken to a screen which shows them a couple pieces of useful information. The top half of the screen will be dedicated to display the average time spent per subject/course. This will allow the user to see their weekly progress and the distribution of their time to their respective courses. On the bottom half of the screen, there will be a scroll pane which will show the previous study sessions. It will provide the name of the course they worked on and the amount of time they spent on it. Once again, this will show the user their progression for studying that week. There will also be a back button in order for the user to return to the home screen.

## User Story Relations to UI

| Screen/Section of UI  | User Story IDs | 
|-----------------------|----------------|
| Home Screen           |           000  |
| Start Studying Screen |           002, 004, 007  |
| Start Timer Screen    |           008  |
| Update Courses Screen |           001, 005, 009  |
| History Screen        |           006, 010  |

To view graphical/sketch representation of the user interface click [here](https://github.com/hsaidi5/POOSD-Project/blob/master/artifacts/User%20Interface%20Design.jpg).


# Resource Management

See Code Complete, Chapter 3

# Security

All of the data being inputted by the user will first be checked to make sure it is the correct information. If the input is in the correct format, it will be saved. In order to protect that information, the variables that are being used will all be set to private. To access the variables we will use getter and setter methods, in order to prevent the corruption of that data.

# Performance

  As for performance, this system must have a drop down menu for the user to choose the course he/she wants to work on. After the user set the time, when the user press start the timer must start count down toward zero. The user should have username and a passwork to log in, and because this system is based on time management, each request must not take more than 15 seconds. Also, the system should remind the user to get up and move around every 30 minutes of working. Nevertheless the time the user spends on working should save in the course history for the selected course.

# Scalability

Although new features will be able to be added to the application based on the user (such as a calendar that shows their classes), scalability is not an issue for our product. This is because our product is a mobile application which solely relies on the users needs and does not require different instances of the application to communicate with one another. Hence, the number of people which own the app does not require there to be changes to the product.

# Interoperability

This section of the design document does not apply to our product, as the program has no real need to share data or resources with other software or hardware. All operations should be conducted with the project team's own code and user input.

# Internationalization/Localization

See Code Complete, Chapter 3

# Input/Output

The architecture of our product will be using a just-in-time reading scheme when reading files. This is because the files will be used to save and retrieve information about the user's courses and their respective credit hours. 

# Error Processing

- Error processing will generally be detective, and the program should continue processing as though nothing had happened. Though it should certainly notify the user that an error has been detected, as most errors that accompany the project will likely be caused by the user.
- Error detection will be active as the program should constantly be checking user input for validity. For example, if the user forgets to enter the number of credit hours for a certain class, the program should notify them that the corresponding text box should be filled in.
- Once an error has been detected, the program should wait until all other associated processes are completed before notifying the user that errors have been detected. If possible, the program should notify the user where the error has occurred.
- When handling an error message, the program should ideally throw out an exception to help handle the situation. This way, the application should be able to recover and continue. In the event that the program is unable to handle the error on its own, it should be logged.
- How exceptions will be handled should vary depending on what type of exception has been thrown out. If at all possible, the application should be able to recover by itself. In the event that the program cannot recover, the associated exception should be logged.
- Errors should happen at the point of detection, and be passed off to an error-handling class if possible.
- Each class should be responsible for validating its own input data, and may have a flag indicating whether or not their input is clean. Classes on any level shouldn't assume the receiving data is clean unless told otherwise.
- The environment's built-in exception-handling mechanism will be used as a default, unless the time comes where we will need to build our own.

# Fault Tolerance

There's a handful of approaches when it comes to fault-tolerance, generally revolving around the system's current state at the time. Depending on the severity of the error at hand, the system could change to a state of partial operation or back itself up to a state where it is still fully functional.

# Architectural Feasibility

See Code Complete, Chapter 3

# Overengineering

This system will not operate as robustness, because the system will not be error free. the user will have to enter his/her username and password correctly another to log in through the system. However, it won't be case sensitive another to give the user easy access to the system.

# Build-vs-Buy Decisions

The architecture of our program will no be using any off-the-shelf software components. This is because we will be designing the GUI and any other components from scratch. This will allow us to develop the application to the needs of the user. By creating our own components, we can reduce the risk of error by not having to risk combining incompatible components.

# Reuse

We will not be reusing preexisting software, test cases, or any other materials. This is because we want to design and build everything from scratch in order to provide an efficient and useful solution to the product.

# Change Strategy

Each button on the mobile application will lead to its own activity. This means that every interactive aspect of the mobile program will have its own screen. Hence, this allows the product to have future changes made to it. It will allow for new buttons to be created which do things such as show a calendar containing the courses of the user. Therefore, allowing there to be future upgradability in a way which will not corrupt the essence of the project as the new and old components will be able to merge effortlessly.

In addition, we will be using git to version control the product. This will allow us to look back at previous versions of the product and make the changes necessary to change or add different components to the product.
