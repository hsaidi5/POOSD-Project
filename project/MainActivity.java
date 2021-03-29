package com.mytime;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{

    private Button startSession;
    private Button viewCourses;
    private Button getHistory;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureStudySession();
        configureHistory();
        configureViewCourse();

        //checkDayOfWeek();
    }

    // Function to move from home page to the Study Session activity
    public void configureStudySession()
    {
        startSession = findViewById(R.id.studySession);

        startSession.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, StudySession.class);
                startActivity(intent);
            }
        });
    }

    // Function to move from home page to the View Courses activity
    public void configureViewCourse()
    {
        viewCourses = findViewById(R.id.viewCourses);

        viewCourses.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(MainActivity.this, ViewCourses.class);
                startActivity(intent2);
            }
        });
    }

    // Function to move from home page to the History activity
    public void configureHistory()
    {
        getHistory = findViewById(R.id.history);

        getHistory.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent3 = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent3);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void checkDayOfWeek()
    {
        LocalDate currentDate = LocalDate.now();
        Calendar calendar = Calendar.getInstance();
        int currentDay = currentDate.getDayOfYear();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        ArrayList<Course> currentCourses = SharedData.getCurrentCourses(this);

        if(currentCourses != null)
        {
            int day = currentCourses.get(0).getStartOfWeek();
            System.out.println("\n\nThe day is " + day + "\n\n");
            if(currentCourses.get(0).getLastChecked() != currentDay)
            {
                if((day == 0) && (dayOfWeek == 1))
                {
                    currentCourses.get(0).setStartOfWeek(currentDay);
                }
                else if(currentDay - day >= 7)
                {
                    for(int i = 0; i < currentCourses.size(); i++)
                    {
                        currentCourses.get(i).resetTimeAvailable();
                    }
                    int newDay = currentDate.minusDays(dayOfWeek-1).getDayOfYear();
                    currentCourses.get(0).setStartOfWeek(newDay);
                }
                currentCourses.get(0).setLastChecked(currentDay);
                SharedData.clearCourses(getApplicationContext());
                SharedData.saveCourses(getApplicationContext(), currentCourses);
                System.out.println("\n\nNew day is " + currentCourses.get(0).getStartOfWeek() + "\n\n");
                System.out.println("\n\nNew day is " + currentCourses.get(1).getStartOfWeek() + "\n\n");
            }
            else
            {
                System.out.println("\n\nThe day is " + currentCourses.get(0).getStartOfWeek() + "\n\n");
                System.out.println("\n\nThe day is " + currentCourses.get(1).getStartOfWeek() + "\n\n");
            }
        }
    }
}