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

See Code Complete, Chapter 3

# Internationalization/Localization

See Code Complete, Chapter 3

# Input/Output

The architecture of our product will be using a just-in-time reading scheme when reading files. This is because the files will be used to save and retrieve information about the user's courses and their respective credit hours. 

# Error Processing

See Code Complete, Chapter 3

# Fault Tolerance

See Code Complete, Chapter 3

# Architectural Feasibility

See Code Complete, Chapter 3

# Overengineering

See Code Complete, Chapter 3

# Build-vs-Buy Decisions

The architecture of our program will no be using any off-the-shelf software components. This is because we will be designing the GUI and any other components from scratch. This will allow us to develop the application to the needs of the user. By creating our own components, we can reduce the risk of error by not having to risk combining incompatible components.

# Reuse

We will not be reusing preexisting software, test cases, or any other materials. This is because we want to design and build everything from scratch in order to provide an efficient and useful solution to the product.

# Change Strategy

Each button on the mobile application will lead to its own activiyt. This means that every interactive aspect of the mobile program will have its own screen. Hence, this allows the product to have future changes made to it. It will allow for new buttons to be created which do things such as show a calendar containing the courses of the user. Therefore, allowing there to be future upgradability in a way which will not corrupt the essence of the project as the new and old components will be able to merge effortlessly.
