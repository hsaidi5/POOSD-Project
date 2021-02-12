Populate each section with information as it applies to your project. If a section does not apply, explain why. Include diagrams (or links to diagrams) in each section, as appropriate.  For example, sketches of the user interfaces along with an explanation of how the interface components will work; ERD diagrams of the database; rough class diagrams; context diagrams showing the system boundary; etc. Do _not_ link to your diagrams, embed them directly in this document by uploading the images to your GitHub and linking to them. Do _not_ leave any section blank.

# Program Organization

You should have your context, container, and component (c4model.com) diagrams in this section, along with a description and explanation of each diagram and a table that relates each block to one or more user stories. 

See Code Complete, Chapter 3 and https://c4model.com/

# Code Design

You should have your UML Class diagram and any other useful UML diagrams in this section. Each diagram should be accompanied by a brief description explaining what the elements are and why they are in the diagram. For your class diagram, you must also include a table that relates each class to one or more user stories. 

See Code Complete, Chapter 3 and https://c4model.com/

# Data Design

This aspect of the design document does not apply to our product as we are not going to be using a database. Instead, we will be using files to save any information the user needs to save. This is due to the fact that each instance of the product will run independently of one another and does not need to know what other users are doing.

# Business Rules

The only business rule that our product applies to is the fact that we will calculate the number of hours of study for each course every week will be based off of 3 hours per credit hour. This was found to be the general rule across most universities/colleges.

# User Interface Design

You should have one or more user interface screens in this section. Each screen should be accompanied by an explaination of the screens purpose and how the user will interact with it. You should relate each screen to one another as the user transitions through the states of your application. You should also have a table that relates each window or component to the support using stories. 

See Code Complete, Chapter 3

# Resource Management

See Code Complete, Chapter 3

# Security

All of the data being inputted by the user will first be checked to make sure it is the correct information. If the input is in the correct format, it will be saved. In order to protect that information, the variables that are being used will all be set to private. To access the variables we will use getter and setter methods, in order to prevent the corruption of that data.

# Performance

See Code Complete, Chapter 3

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

See Code Complete, Chapter 3

# Build-vs-Buy Decisions

The architecture of our program will no be using any off-the-shelf software components. This is because we will be designing the GUI and any other components from scratch. This will allow us to develop the application to the needs of the user. By creating our own components, we can reduce the risk of error by not having to risk combining incompatible components.

# Reuse

We will not be reusing preexisting software, test cases, or any other materials. This is because we want to design and build everything from scratch in order to provide an efficient and useful solution to the product.

# Change Strategy

Each button on the mobile application will lead to its own activity. This means that every interactive aspect of the mobile program will have its own screen. Hence, this allows the product to have future changes made to it. It will allow for new buttons to be created which do things such as show a calendar containing the courses of the user. Therefore, allowing there to be future upgradability in a way which will not corrupt the essence of the project as the new and old components will be able to merge effortlessly.

In addition, we will be using git to version control the product. This will allow us to look back at previous versions of the product and make the changes necessary to change or add different components to the product.
