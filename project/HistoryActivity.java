package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.*;

public class HistoryActivity extends AppCompatActivity
{

    private Button back;
    private Button clear;
    private Button sort;
    private Button unsort_butt;
    private ScrollView history_scroll;
    private TextView historyText;
    private ArrayList<Course> courses_data_struct = new ArrayList<Course>();

    // Rows
    private TableRow r1_avg;
    private TableRow r2_avg;
    private TableRow r3_avg;
    private TableRow r4_avg;
    private TableRow r5_avg;
    private TableRow r6_avg;

    // TextViews for course names.
    private TextView courseOne;
    private TextView courseTwo;
    private TextView courseThree;
    private TextView courseFour;
    private TextView courseFive;
    private TextView courseSix;

    // TextViews for average study times.
    private TextView avgOne;
    private TextView avgTwo;
    private TextView avgThree;
    private TextView avgFour;
    private TextView avgFive;
    private TextView avgSix;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        history_scroll = (ScrollView) findViewById(R.id.scrollView2);
        historyText = (TextView) findViewById(R.id.historyText);
        courses_data_struct = SharedData.getCurrentCourses(this);

        r1_avg = findViewById(R.id.r1_avg);
        r2_avg = findViewById(R.id.r2_avg);
        r3_avg = findViewById(R.id.r3_avg);
        r4_avg = findViewById(R.id.r4_avg);
        r5_avg = findViewById(R.id.r5_avg);
        r6_avg = findViewById(R.id.r6_avg);

        courseOne = findViewById(R.id.course_1);
        courseTwo = findViewById(R.id.course_2);
        courseThree = findViewById(R.id.course_3);
        courseFour = findViewById(R.id.course_4);
        courseFive = findViewById(R.id.course_5);
        courseSix = findViewById(R.id.course_6);

        avgOne = findViewById(R.id.avg_1);
        avgTwo = findViewById(R.id.avg_2);
        avgThree = findViewById(R.id.avg_3);
        avgFour = findViewById(R.id.avg_4);
        avgFive = findViewById(R.id.avg_5);
        avgSix = findViewById(R.id.avg_6);

        populateHistoryList();
        configureCourses();
        configureBackButton();
        sort_HistoryList();
        clearStudyHistory();
        unsort();
    }

    private void populateHistoryList()
    {
        String str = new String();
        double sum = 0.0;

        for(int i = 0; i < courses_data_struct.size(); i++)
        {
            for(int j = 0; j < courses_data_struct.get(i).get_hours_spent().size(); j++)
            {
                sum += courses_data_struct.get(i).get_hours_spent().get(j);
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

    private void clearStudyHistory()
    {
        clear = findViewById(R.id.clearHistory);

        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                historyText.setText("");
                for(int i = 0; i < courses_data_struct.size(); i++)
                {
                    courses_data_struct.get(i).get_hours_spent().clear();
                }
                SharedData.clearCourses(getApplicationContext());
                SharedData.saveCourses(getApplicationContext(), courses_data_struct);
            }
        });
    }

    // Implemented by Christopher Delarosa
    // Retrieves and sets information for average study times per course.
    private void configureCourses()
    {
        int array_list_size = 0;
        TableRow[] rows = {r1_avg, r2_avg, r3_avg, r4_avg, r5_avg, r6_avg};
        TextView[] courses = {courseOne, courseTwo, courseThree, courseFour, courseFive, courseSix};
        TextView[] averages = {avgOne, avgTwo, avgThree, avgFour, avgFive, avgSix};

        if (courses_data_struct != null)
            array_list_size = courses_data_struct.size();

        setInvisible(rows);
        makevisible(array_list_size, rows);

        for (int i = 0; i < array_list_size; i++)
        {
            String avgStr = String.format(Locale.getDefault(), "%02.02f", courses_data_struct.get(i).get_avg_study_time());
            courses[i].setText(courses_data_struct.get(i).get_name());
            averages[i].setText(avgStr);
        }
    }

    // This function, along with setInvisible() have been recycled from ViewCourses.
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
