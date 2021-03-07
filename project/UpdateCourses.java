package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class UpdateCourses extends AppCompatActivity
{

    private Button back;
    private Button add;
    private Button remove;
    private EditText course_name_textbox;
    private EditText cred_hours_textbox;
    private TextView confirm_textview;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_courses);

        // Gets the list of all courses currently enrolled in.
        ArrayList<Course> courses_data_struct = SharedData.getCurrentCourses(this);
        if(courses_data_struct == null)
        {
            // Creates a new list if there is no current list of courses.
            courses_data_struct = new ArrayList<Course>();
        }

        course_name_textbox = (EditText) findViewById(R.id.courseName);
        cred_hours_textbox = (EditText) findViewById(R.id.courseNumber);
        confirm_textview = (TextView) findViewById((R.id.confirmation));

        configureAddButton(courses_data_struct);
        configureRemoveButton(courses_data_struct);
        configureBackButton(courses_data_struct);
    }

    // Function to add course inputted by user
    private void configureAddButton(ArrayList<Course> courses_data_struct)
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
                // If the info they enter isn't correct or non existent
                if( courseName.equals("") || courseName.equals("Course Name") )
                {
                    confirm_textview.setText("You didn't type anything for Course Name!");

                }

                else
                {
                    c.set_name(courseName);
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

                if(c.get_cred_hours() != 0 && !(c.get_name().equals("")))
                {
                    confirm_textview.setText("Successfully added: " + c.get_name() + " with credit hours: " + c.get_cred_hours() + "with time available: "+ c.get_time_available() + " minutes");
                    courses_data_struct.add(c);
                    SharedData.saveCourses(getApplicationContext(), courses_data_struct);
                }
            }
        });
    }

    // Function to remove course inputted by user
    public void configureRemoveButton(ArrayList<Course> courses_data_struct)
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

    // Function to return to the View Courses activity from the Update Courses activity
    private void configureBackButton(ArrayList<Course> courses_data_struct)
    {
        back = findViewById(R.id.backFromUpdate);

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}