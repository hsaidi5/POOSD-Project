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
    private Button sort;
    private Button unsort_butt;
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
        sort_HistoryList();
        unsort();
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

        }
        historyText.setText(str);
    }

    private void unsort()
    {
        unsort_butt = findViewById(R.id.unsort_butt);
        unsort_butt.setOnClickListener(new View.OnClickListener()
                                       {
            @Override
            public void onClick(View v)
            {
                String str = new String();

                for(int i = 0; i < courses_data_struct.size(); i++)
                {
                    for(int j = 0; j < courses_data_struct.get(i).get_hours_spent().size(); j++)
                    {
                        str += "Course: " + courses_data_struct.get(i).get_name() + ", Time Spent: " + courses_data_struct.get(i).get_hours_spent().get(j) + "\n";
                    }
                }
                historyText.setText(str);

            }
        }
        );
    }

    private void sort_HistoryList()
    {

        sort = findViewById(R.id.sort_butt);

        sort.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ArrayList<Course> sorted_data_struct = new ArrayList<Course>();
                for(int i = 0; i < courses_data_struct.size(); i++)
                {
                    for(int j = 0; j < courses_data_struct.get(i).get_hours_spent().size(); j++)
                    {
                        Course c = new Course();
                        c.set_name(courses_data_struct.get(i).get_name());
                        c.set_hours_for_sort(courses_data_struct.get(i).get_hours_spent().get(j));
                        sorted_data_struct.add(c);
                    }
                }

                // Perform Sort
                for(int i = 0; i < sorted_data_struct.size() - 1; i++)
                {
                    for(int j = 0; j < sorted_data_struct.size() - 1; j++)
                    {
                        if(sorted_data_struct.get(j).get_hours_for_sort() > sorted_data_struct.get(j + 1).get_hours_for_sort())
                        {
                            Course temp = sorted_data_struct.get(j);
                            sorted_data_struct.set(j, sorted_data_struct.get(j+1));// traditional
                            sorted_data_struct.set(j+1, temp); // traditional
                        }
                    }
                }
                String str = new String();

                for(int i = 0; i < sorted_data_struct.size(); i++)
                {
                    str += "Course: " + sorted_data_struct.get(i).get_name() + ", Time Spent: " + sorted_data_struct.get(i).get_hours_for_sort() + "\n";
                }
                historyText.setText("");
                historyText.setText(str);
            }
        });
    }

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
