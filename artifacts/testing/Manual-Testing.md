# Manual Testing

## GUI

Step 1: Launch application on mobile device/emulator.

Step 2: Click on the "Study Session" button. (This should take you to a new activity/screen)

Step 3: Click on the "Start Timer" button to begin the timer. (The clock should begin counting)

Step 4: Click on the "Back" button in the bottom left corner of the screen. (The home page/main activity should be reloaded)

Step 5: Click on the "View Course" button. (This should load a new activity on the screen which has an "Update Courses" button and a "Back" button)

Step 6: Click on the "Update Courses" button. (A new activity should be loaded onto the screen which has 2 input text lines which say "Course Name" and "Course Number")

Step 7: Click on the "Course Name" EditText object and enter the name of the course.

Step 8: Click on the "Course Number" EditText object and enter the credit hours for the course being entered.

Step 9: Click on the "Add" button to add the course to the list of courses being taken. (This should add the course to the array list of courses and output that the addition was successful

Step 10: Click on the "Course Name" EditText object and enter the name of the course that was just added.

Step 11: Click on the "Remove" button to remove the course from the list of courses being taken. (This should remove the course from the array list of courses)

Step 12: Click on the "Back" button in the bottom left corner. (This should return to the "View Courses" activity)

Step 13: Click on the "Back" button in the bottom left corner. (This should return to the home page/main activity)

Step 14: Click on the "History" button. (This should load a new activity on the screen which has a view of the average time spent per week and a log in a scroll pane containing the history of the past study sessions)

Step 15: Click on the "Back" button in the bottom left corner. (This should return the home page/main activity)

## Add/Remove Buttons

Step 1: Launch application on mobile device/emulator.

Step 2: Click on the view courses button.

Step 3: Click on the update courses button.

Step 4: Check functionality of error checking.

Step 5: Do not change input textboxes and see if error checking is working correctly.

Step 6: Check if code checks for both course hours no input and course name no input by clicking ADD.

Step 7: Leave textboxes empty and click ADD to see if program outputs errors for nothing being inputted.

Step 8: Then for credit hours input 0 and click ADD. The code shouldn't allow for this.

Step 9: Then input any string which isn't empty or "Course Name" and input an integer greater than zero and click ADD. This should output a success message.

Step 10: For the remove button only the name of the course must be entered. To test the error checking enter a course which hasn't been entered before and click Remove. It should output a message saying that the course doesn't exist.

Step 11: For testing purposes the remove button is also meant to output the contents og Arraylist holding the courses. Print before removing a course and after to observe that the function is working as described.

