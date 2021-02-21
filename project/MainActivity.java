package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private Button startSession;
    private Button viewCourses;
    private Button getHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureStudySession();
        configureHistory();
        configureViewCourse();

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
}