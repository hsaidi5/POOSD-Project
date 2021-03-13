package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity
{
    private Button updateCourses;
    private Button back;

    // Rows
    private TableRow r1;
    private TableRow r2;
    private TableRow r3;
    private TableRow r4;
    private TableRow r5;
    private TableRow r6;


    // Course name textviews
    private TextView r1_course_text;
    private TextView r2_course_text;
    private TextView r3_course_text;
    private TextView r4_course_text;
    private TextView r5_course_text;
    private TextView r6_course_text;

    // Credit hours textviews
    private TextView r1_cred_text;
    private TextView r2_cred_text;
    private TextView r3_cred_text;
    private TextView r4_cred_text;
    private TextView r5_cred_text;
    private TextView r6_cred_text;

    // Time remaining textviews
    private TextView r1_time_text;
    private TextView r2_time_text;
    private TextView r3_time_text;
    private TextView r4_time_text;
    private TextView r5_time_text;
    private TextView r6_time_text;

    //Completion status cells
    private TextView r1_comp_text;
    private TextView r2_comp_text;
    private TextView r3_comp_text;
    private TextView r4_comp_text;
    private TextView r5_comp_text;
    private TextView r6_comp_text;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);


        ArrayList<Course> courses_data_struct = SharedData.getCurrentCourses(this);

        configureUpdateCourses();
        configureBackButton();

        r1 = (TableRow) findViewById(R.id.r1);
        r2 = (TableRow) findViewById(R.id.r2);
        r3 = (TableRow) findViewById(R.id.r3);
        r4 = (TableRow) findViewById(R.id.r4);
        r5 = (TableRow) findViewById(R.id.r5);
        r6 = (TableRow) findViewById(R.id.r6);

        r1_course_text = (TextView) findViewById(R.id.r1_course);
        r2_course_text = (TextView) findViewById(R.id.r2_course);
        r3_course_text = (TextView) findViewById(R.id.r3_course);
        r4_course_text = (TextView) findViewById(R.id.r4_course);
        r5_course_text = (TextView) findViewById(R.id.r5_course);
        r6_course_text = (TextView) findViewById(R.id.r6_course);

        r1_cred_text = (TextView) findViewById(R.id.r1_cred);
        r2_cred_text = (TextView) findViewById(R.id.r2_cred);
        r3_cred_text = (TextView) findViewById(R.id.r3_cred);
        r4_cred_text = (TextView) findViewById(R.id.r4_cred);
        r5_cred_text = (TextView) findViewById(R.id.r5_cred);
        r6_cred_text = (TextView) findViewById(R.id.r6_cred);

        r1_time_text = (TextView) findViewById(R.id.r1_time);
        r2_time_text = (TextView) findViewById(R.id.r2_time);
        r3_time_text = (TextView) findViewById(R.id.r3_time);
        r4_time_text = (TextView) findViewById(R.id.r4_time);
        r5_time_text = (TextView) findViewById(R.id.r5_time);
        r6_time_text = (TextView) findViewById(R.id.r6_time);

        r1_comp_text = (TextView) findViewById(R.id.r1_comp);
        r2_comp_text = (TextView) findViewById(R.id.r2_comp);
        r3_comp_text = (TextView) findViewById(R.id.r3_comp);
        r4_comp_text = (TextView) findViewById(R.id.r4_comp);
        r5_comp_text = (TextView) findViewById(R.id.r5_comp);
        r6_comp_text = (TextView) findViewById(R.id.r6_comp);




        int array_list_size = courses_data_struct.size();

        TableRow[] row_arr = {r1, r2, r3, r4, r5, r6};
        TextView[] course_arr = {r1_course_text, r2_course_text, r3_course_text, r4_course_text, r5_course_text, r6_course_text};
        TextView[] cred_arr = {r1_cred_text, r2_cred_text, r3_cred_text, r4_cred_text, r5_cred_text, r6_cred_text};
        TextView[] time_arr = {r1_time_text, r2_time_text, r3_time_text, r4_time_text, r5_time_text, r6_time_text};
        TextView[] comp_arr = {r1_comp_text, r2_comp_text, r3_comp_text, r4_comp_text, r5_comp_text, r6_comp_text};


        makevisible(array_list_size, row_arr);

        for(int i = 0; i < array_list_size; i++)
        {
            course_arr[i].setText(courses_data_struct.get(i).get_name());
            String credits = Integer.toString(courses_data_struct.get(i).get_cred_hours());
            cred_arr[i].setText(credits);
            Double time_aval = courses_data_struct.get(i).get_time_available();
            String time = Double.toString(time_aval);
            time_arr[i].setText(time);

            if(time_aval <= 0)
            {
                comp_arr[i].setBackgroundColor(Color.parseColor("#00FF00"));
                comp_arr[i].setText("Complete");
                comp_arr[i].setTextColor(Color.parseColor("#000000"));
                courses_data_struct.get(i).set_comp_stat(true);
            }

            else
            {
                comp_arr[i].setBackgroundColor(Color.parseColor("#FF0000"));
                comp_arr[i].setText("Incomplete");
                comp_arr[i].setTextColor(Color.parseColor("#FFFFFF"));
            }
        }
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

    // Function to map button press to continue to the Update Courses activity
    private void configureUpdateCourses()
    {
        updateCourses = findViewById(R.id.updateCourses);

        updateCourses.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ViewCourses.this, UpdateCourses.class);
                startActivity(intent);
            }
        });
    }

    // Function to return from the View Courses activity back to the home page
    private void configureBackButton()
    {
        back = findViewById(R.id.backFromView);

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