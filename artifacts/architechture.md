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

See Code Complete, Chapter 3

# Performance

See Code Complete, Chapter 3

# Scalability

See Code Complete, Chapter 3

# Interoperability

See Code Complete, Chapter 3

# Internationalization/Localization

See Code Complete, Chapter 3

# Input/Output

The architecture of our product will be using a jsut-in-time reading scheme when reading files. This is because the files will be used to save and retrieve information about the user's courses and their respective credit hours. 

# Error Processing

See Code Complete, Chapter 3

# Fault Tolerance

See Code Complete, Chapter 3

# Architectural Feasibility

See Code Complete, Chapter 3

# Overengineering

See Code Complete, Chapter 3

# Build-vs-Buy Decisions

This section should list the third party libraries your system is using and describe what those libraries are being used for.

See Code Complete, Chapter 3

# Reuse

See Code Complete, Chapter 3

# Change Strategy

See Code Complete, Chapter 3
