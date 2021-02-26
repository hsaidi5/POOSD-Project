# Manual Testing

## GUI (U000)

| Step | Steps to Reproduce | Expected Behaviour | 
|------|--------------------|--------------------|
| 1    | Launch application on mobile device/emulator. | Home page/main activity is showing on device. |
| 2    | Click on the "Study Session" button. | This should take you to a new activity/screen which has a stopwatch set at 00:00, a start timer button, a dropdown menu, and a back button. |
| 3    | Click on the "Start Timer" button to begin the timer. |  The clock should begin counting.  |
| 4    | Click on the "Back" button in the bottom left corner of the screen. | The home page/main activity should be reloaded. |
| 5    | Click on the "View Course" button. | This should load a new activity on the screen which has an "Update Courses" button and a "Back" button. |
| 6    | Click on the "Update Courses" button. | A new activity should be loaded onto the screen which has 2 input text lines which say "Course Name" and "Credit Hours". |
| 7    | Click on the "Course Name" EditText object and enter the name of the course.| The user should be able to input the course name. |
| 8    | Click on the "Credit Hours" EditText object and enter the credit hours for the course being entered. | The user should be able to input the credit hours. |
| 9    | Click on the "Add" button to add the course to the list of courses being taken. | This should add the course to the array list of courses and output that the addition was successful. |
| 10   | Click on the "Course Name" EditText object and enter the name of the course that was just added. | The user should be able to input the course name. |
| 11   | Click on the "Remove" button to remove the course from the list of courses being taken. | This should remove the course from the array list of courses. |
| 12   | Click on the "Back" button in the bottom left corner. | This should return to the "View Courses" activity. |
| 13   | Click on the "Back" button in the bottom left corner. | This should return to the home page/main activity. |
| 14   | Click on the "History" button. | This should load a new activity on the screen which has a view of the average time spent per week and a log in a scroll pane containing the history of the past study sessions. |
| 15   | Click on the "Back" button in the bottom left corner. | This should return the home page/main activity. |


## Add button (U001)

| Step | Steps to Reproduce | Expected Behaviour | 
|------|--------------------|--------------------|
| 1    | Launch application on mobile device/emulator. | Home page/main activity is showing on device. |
| 2    | Click on the view courses button. | View courses page. |
| 3    | Click on the update courses button. | Update courses page. |
| 4    | Check functionality of error checking. Do not change input textboxes. | Default update courses page. |
| 5    | Check if code checks for both course hours no input and course name no input by clicking ADD. | Error should display to the screen indicating a lack of input.|
| 6    | Check functionality of error checking. No input test with blank input fields. | Default update courses page with blank input boxes. |
| 7    | Erase the text inside of the course name textbox. Then click ADD to test the error checking of the program. | Error should display to the screen indicating a lack of input for specifically the course name input field.|
| 8    | Erase the text inside of the credit hours textbox. Then click ADD to test the error checking of the program. | Error should display to the screen indicating a lack of input for specifically the credit hours input field. |
| 9    | Erase text inside of the credit horus textbox. Then enter a 0 for the amount of credit hours. | Error should display to the screen indicating that you cannot have a zero credit hour class. |
| 10    | Reset from the beginning with default settings by restarting the application. This erases any locally stored data. Then enter a non null string and an integer greater than 0 for credit hours. Then click the ADD button.| Success message indicating data was saved into corresponding data structure. |


## Start stopwatch (U008)

| Step | Steps to Reproduce | Expected Behaviour | 
|------|--------------------|--------------------|
| 1    | Launch application on mobile device/emulator. | Home page/main activity is showing on device. |
| 2    | Click on the "Study Session" button. | This should take you to a new activity/screen which has a stopwatch set at 00:00, a start timer button, a dropdown menu, and a back button. The start timer button should be disabled on arrival. |
| 3    | Select one of the existing/sample courses from the dropdown menu. | This should enable the button to start the timer. |
| 4    | Click on the "Start Timer" button. | The clock should begin counting. The start button should also disappear from view, and be replaced with the pause and stop buttons. The dropdown menu where the courses have been selected from should also be disabled. |
| 5    | Click on the "Pause" button. | The clock should come to a stop. The text on the button should be replaced with "Resume". |
| 6    | Click on the "Resume" button. | The clock should continue counting from where it had left off. The text on the button should now change back to "Pause". |
| 7    | Check the clock for proper formatting. | Wait for a minute to pass, ensuring that the seconds reset back to zero, and that the minutes also count up. |
| 8    | Click on the "Stop" button. | The clock should come to a stop, and soon be reset. The pause and stop buttons will disappear from view, and be replaced with the start button. The dropdown menu should also be re-enabled. |


## Remove Button (Still working on functionality) (U009)
(Disregard below)

Step 10: For the remove button only the name of the course must be entered. To test the error checking enter a course which hasn't been entered before and click Remove. It should output a message saying that the course doesn't exist.

Step 11: For testing purposes the remove button is also meant to output the contents og Arraylist holding the courses. Print before removing a course and after to observe that the function is working as described.

