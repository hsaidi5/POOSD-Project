package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class UpdateCourses extends AppCompatActivity
{
    private boolean exists;
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
        configureBackButton();
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

                if(c.get_cred_hours() != 0 && !(c.get_name().equals("")) && (exists == false))
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

    private void makevisible(int size, TableRow[] row_arr)
    {
        for(int i = 0; i < size; i++)
        {
            if(size >= i + 1)
            {
                row_arr[i].setVisibility(View.VISIBLE);
            }
        }
    }

    /* CODE FOR REFRESH OF VIEW COURSES SCREEN (HASAN ASSAIDI)
    private void refreshViewCourseScreen(ArrayList<Course> courses_data_struct)
    {
        // Initializing view courses variables for screen refresh
        TextView r1_course_text = (TextView) findViewById(R.id.r1_course);
        TextView r2_course_text = (TextView) findViewById(R.id.r2_course);
        TextView r3_course_text = (TextView) findViewById(R.id.r3_course);
        TextView r4_course_text = (TextView) findViewById(R.id.r4_course);
        TextView r5_course_text = (TextView) findViewById(R.id.r5_course);
        TextView r6_course_text = (TextView) findViewById(R.id.r6_course);

        TextView r1_cred_text = (TextView) findViewById(R.id.r1_cred);
        TextView r2_cred_text = (TextView) findViewById(R.id.r2_cred);
        TextView r3_cred_text = (TextView) findViewById(R.id.r3_cred);
        TextView r4_cred_text = (TextView) findViewById(R.id.r4_cred);
        TextView r5_cred_text = (TextView) findViewById(R.id.r5_cred);
        TextView r6_cred_text = (TextView) findViewById(R.id.r6_cred);

        TextView r1_time_text = (TextView) findViewById(R.id.r1_time);
        TextView r2_time_text = (TextView) findViewById(R.id.r2_time);
        TextView r3_time_text = (TextView) findViewById(R.id.r3_time);
        TextView r4_time_text = (TextView) findViewById(R.id.r4_time);
        TextView r5_time_text = (TextView) findViewById(R.id.r5_time);
        TextView r6_time_text = (TextView) findViewById(R.id.r6_time);

        TableRow r1 = (TableRow) findViewById(R.id.r1);
        TableRow r2 = (TableRow) findViewById(R.id.r2);
        TableRow r3 = (TableRow) findViewById(R.id.r3);
        TableRow r4 = (TableRow) findViewById(R.id.r4);
        TableRow r5 = (TableRow) findViewById(R.id.r5);
        TableRow r6 = (TableRow) findViewById(R.id.r6);

        TableRow[] row_arr = {r1, r2, r3, r4, r5, r6};
        TextView[] course_arr = {r1_course_text, r2_course_text, r3_course_text, r4_course_text, r5_course_text, r6_course_text};
        TextView[] cred_arr = {r1_cred_text, r2_cred_text, r3_cred_text, r4_cred_text, r5_cred_text, r6_cred_text};
        TextView[] time_arr = {r1_time_text, r2_time_text, r3_time_text, r4_time_text, r5_time_text, r6_time_text};

        int array_list_size = courses_data_struct.size();

        makevisible(array_list_size, row_arr);

        for(int i = 0; i < array_list_size; i++)
        {
            course_arr[i].setText(courses_data_struct.get(i).get_name());
            String credits = Integer.toString(courses_data_struct.get(i).get_cred_hours());
            cred_arr[i].setText(credits);
            String time = Double.toString(courses_data_struct.get(i).get_time_available());
            time_arr[i].setText(time);
        }
    }*/

    // Function to return to the View Courses activity from the Update Courses activity
    private void configureBackButton()
    {
        ArrayList<Course> courses_data_struct = SharedData.getCurrentCourses(this);
        back = findViewById(R.id.backFromUpdate);

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //refreshViewCourseScreen(courses_data_struct);
                finish();
            }
        });
    }
}