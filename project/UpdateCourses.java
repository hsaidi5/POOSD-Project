package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Spinner;

import java.util.ArrayList;

public class UpdateCourses extends AppCompatActivity
{
    private boolean exists;
    private Button back;
    private Button add;
    private Button remove;
    private Spinner importanceSpinner;
    private EditText course_name_textbox;
    private EditText cred_hours_textbox;
    private TextView confirm_textview;
    private ArrayList<Course> courses_data_struct;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_courses);

        // Gets the list of all courses currently enrolled in.
        courses_data_struct = SharedData.getCurrentCourses(this);
        if(courses_data_struct == null)
        {
            // Creates a new list if there is no current list of courses.
            courses_data_struct = new ArrayList<Course>();
        }

        course_name_textbox = (EditText) findViewById(R.id.courseName);
        cred_hours_textbox = (EditText) findViewById(R.id.courseNumber);
        confirm_textview = (TextView) findViewById((R.id.confirmation));

        configureAddButton();
        configureRemoveButton();
        configureBackButton();

        //Function call implemented by Pedro Nemalceff
        setupDropdownList();
    }

    // Function to add course inputted by user
    private void configureAddButton()
    {
        add = findViewById(R.id.addCourse);

        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Course c = new Course();
                String courseName = course_name_textbox.getText().toString();
                String credits = cred_hours_textbox.getText().toString();

                //Added by Pedro Nemalceff
                String importanceLevel = importanceSpinner.getSelectedItem().toString();

                // If the info they enter isn't correct or non existent
                if( courseName.equals("") || courseName.equals("Course Name") )
                {
                    confirm_textview.setText("You didn't type anything for Course Name!");

                }

                else
                {
                    // Following code to prevent user from adding the same course twice.
                    exists = false;
                    for(int i = 0; i < courses_data_struct.size(); i++)
                    {
                        if(courses_data_struct.get(i).get_name().equals(courseName))
                        {
                            exists = true;
                        }
                    }

                    if(exists == true)
                    {
                        confirm_textview.setText("You are already enrolled in this course!");
                    } else
                    {
                        c.set_name(courseName);
                    }
                }

                // If the info they enter isn't correct or non existent
                //Added by Pedro Nemalceff
                if(importanceLevel.equals("Select Importance Level") )
                {
                    confirm_textview.setText("Please Select an Importance Level!");
                }
                else
                {
                    c.set_importance_level(importanceLevel);
                }

                //Check if a valid integer was entered

                if(credits.equals("") || credits.equals("Credit Hours") || credits.equals("0"))
                {
                    confirm_textview.setText("You didn't type anything for Credit Hours!");
                }

                else
                {
                    try
                    {
                        int num = Integer.parseInt(credits);
                        c.set_cred_hours(num);
                    }

                    catch(NumberFormatException e)
                    {
                        confirm_textview.setText("You didn't type a valid integer.");
                    }
                }

                if(c.get_cred_hours() != 0 && !(c.get_name().equals("")) && (exists == false) && (!importanceLevel.equals("Select Importance Level")) && (courses_data_struct.size() < 6))
                {
                    confirm_textview.setText("Successfully added: " + c.get_name() + " with credit hours: " + c.get_cred_hours() + " with time available: "+ c.get_time_available() + " minutes with importance level: " + c.get_level_of_importance());
                    courses_data_struct.add(c);
                    SharedData.saveCourses(getApplicationContext(), courses_data_struct);
                }
                else if(courses_data_struct.size() == 6)
                {
                    confirm_textview.setText("No more courses can be added! Maximum of 6 courses have been added! Please delete a course to add different course");
                }
            }
        });
    }

    // Function to remove course inputted by user
    public void configureRemoveButton()
    {
        remove = findViewById(R.id.removeCourse);

        remove.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name_tbox = course_name_textbox.getText().toString();

                if(courses_data_struct.size() < 1)
                {
                    confirm_textview.setText("No courses have been added");
                }

                else
                {
                    for(int i = 0; i < courses_data_struct.size(); i++)
                    {
                        if(courses_data_struct.get(i).get_name().equals(name_tbox))
                        {
                            courses_data_struct.remove(i);
                            SharedData.clearCourses(getApplicationContext());
                            SharedData.saveCourses(getApplicationContext(), courses_data_struct);

                            confirm_textview.setText("Course: " + name_tbox + " has been successfully removed.");
                        }

                        else
                        {
                            confirm_textview.setText("Course: " + name_tbox + " doesn't exist.");
                        }

                    }

                }
            }
        });
    }

    //Implemented by Pedro Nemalceff
    // Dropdown list that displays the levels of importance of each course.
    private void setupDropdownList()
    {
        importanceSpinner = (Spinner) findViewById(R.id.selectLevelOfImportance);
        ArrayList<String> importanceLevels = new ArrayList<String>();

        importanceLevels.add("Select Importance Level");
        importanceLevels.add("Not Important");
        importanceLevels.add("Somewhat Important");
        importanceLevels.add("Important");
        importanceLevels.add("Very Important");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(UpdateCourses.this, android.R.layout.simple_list_item_1,
                importanceLevels);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        importanceSpinner.setAdapter(myAdapter);

    }


    // Function to return to the View Courses activity from the Update Courses activity
    private void configureBackButton()
    {
        back = findViewById(R.id.backFromUpdate);

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Following code returns most up-to-date list of course info back to the view courses screen.
                ArrayList<Course> result = courses_data_struct;
                Intent resultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("refresh", courses_data_struct);
                resultIntent.putExtras(bundle);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}