package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.*;

public class HistoryActivity extends AppCompatActivity
{

    private Button back;
    private ScrollView history_scroll;
    private TextView historyText;
    private ArrayList<Course> courses_data_struct = new ArrayList<Course>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        history_scroll = (ScrollView) findViewById(R.id.scrollView2);
        historyText = (TextView) findViewById(R.id.historyText);
        courses_data_struct = SharedData.getCurrentCourses(this);

        populateHistoryList();
        configureCourses(courses_data_struct);
        configureBackButton();
    }

    private void populateHistoryList()
    {
        String str = new String();

        for(int i = 0; i < courses_data_struct.size(); i++)
        {
            for(int j = 0; j < courses_data_struct.get(i).get_hours_spent().size(); j++)
            {
                str += "Course: " + courses_data_struct.get(i).get_name() + ", Time Spent: " + courses_data_struct.get(i).get_hours_spent().get(j) + "\n";
            }
            historyText.setText(str);
        }
    }

    // TEMPORARY FUNCTION
    private void configureCourses(ArrayList<Course> enrolledCourses)
    {
        TextView courseOne = findViewById(R.id.textView5);
        TextView courseTwo = findViewById(R.id.textView4);

        TextView avgOne = findViewById(R.id.textView3);
        TextView avgTwo = findViewById(R.id.textView6);

        courseOne.setText(enrolledCourses.get(0).get_name());
        courseTwo.setText(enrolledCourses.get(1).get_name());

        String timeOne = String.format(Locale.getDefault(), "%02.02f", enrolledCourses.get(0).get_avg_study_time());
        String timeTwo = String.format(Locale.getDefault(), "%02.02f", enrolledCourses.get(1).get_avg_study_time());
        avgOne.setText(timeOne);
        avgTwo.setText(timeTwo);
    }

    // Function to return to the home page from the History activity
    private void configureBackButton()
    {
        back = findViewById(R.id.backFromHistory);

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
