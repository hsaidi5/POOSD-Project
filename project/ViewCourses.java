package com.mytime;

import androidx.annotation.Nullable;
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
    private static final int REFRESH_KEY = 1;

    private Button updateCourses;
    private Button back;
    private ArrayList<Course> courses_data_struct = new ArrayList<Course>();

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


        this.courses_data_struct = SharedData.getCurrentCourses(this);

        configureUpdateCourses();
        configureBackButton();

        this.r1 = (TableRow) findViewById(R.id.r1);
        this.r2 = (TableRow) findViewById(R.id.r2);
        this.r3 = (TableRow) findViewById(R.id.r3);
        this.r4 = (TableRow) findViewById(R.id.r4);
        this.r5 = (TableRow) findViewById(R.id.r5);
        this.r6 = (TableRow) findViewById(R.id.r6);

        this.r1_course_text = (TextView) findViewById(R.id.r1_course);
        this.r2_course_text = (TextView) findViewById(R.id.r2_course);
        this.r3_course_text = (TextView) findViewById(R.id.r3_course);
        this.r4_course_text = (TextView) findViewById(R.id.r4_course);
        this.r5_course_text = (TextView) findViewById(R.id.r5_course);
        this.r6_course_text = (TextView) findViewById(R.id.r6_course);

        this.r1_cred_text = (TextView) findViewById(R.id.r1_cred);
        this.r2_cred_text = (TextView) findViewById(R.id.r2_cred);
        this.r3_cred_text = (TextView) findViewById(R.id.r3_cred);
        this.r4_cred_text = (TextView) findViewById(R.id.r4_cred);
        this.r5_cred_text = (TextView) findViewById(R.id.r5_cred);
        this.r6_cred_text = (TextView) findViewById(R.id.r6_cred);

        this.r1_time_text = (TextView) findViewById(R.id.r1_time);
        this.r2_time_text = (TextView) findViewById(R.id.r2_time);
        this.r3_time_text = (TextView) findViewById(R.id.r3_time);
        this.r4_time_text = (TextView) findViewById(R.id.r4_time);
        this.r5_time_text = (TextView) findViewById(R.id.r5_time);
        this.r6_time_text = (TextView) findViewById(R.id.r6_time);

        this.r1_comp_text = (TextView) findViewById(R.id.r1_comp);
        this.r2_comp_text = (TextView) findViewById(R.id.r2_comp);
        this.r3_comp_text = (TextView) findViewById(R.id.r3_comp);
        this.r4_comp_text = (TextView) findViewById(R.id.r4_comp);
        this.r5_comp_text = (TextView) findViewById(R.id.r5_comp);
        this.r6_comp_text = (TextView) findViewById(R.id.r6_comp);

        setCourseList();
    }

    private void setCourseList()
    {
        int array_list_size = courses_data_struct.size();

        TableRow[] row_arr = {r1, r2, r3, r4, r5, r6};
        TextView[] course_arr = {r1_course_text, r2_course_text, r3_course_text, r4_course_text, r5_course_text, r6_course_text};
        TextView[] cred_arr = {r1_cred_text, r2_cred_text, r3_cred_text, r4_cred_text, r5_cred_text, r6_cred_text};
        TextView[] time_arr = {r1_time_text, r2_time_text, r3_time_text, r4_time_text, r5_time_text, r6_time_text};
        TextView[] comp_arr = {r1_comp_text, r2_comp_text, r3_comp_text, r4_comp_text, r5_comp_text, r6_comp_text};

        setInvisible(row_arr);
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
                courses_data_struct.get(i).set_comp_stat(false);
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

    private void setInvisible(TableRow[] row_arr)
    {
        for(int i = 0; i < row_arr.length; i++)
        {
            row_arr[i].setVisibility(View.INVISIBLE);
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
                startActivityForResult(intent, REFRESH_KEY);
            }
        });
    }

    // Function to retrieve the up-to-date course info from the update courses screen.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REFRESH_KEY)
        {
            if(resultCode == RESULT_OK)
            {
                Bundle bundleObject = data.getExtras();
                this.courses_data_struct = (ArrayList<Course>) bundleObject.getSerializable("refresh");
                setCourseList();
            }
        }
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