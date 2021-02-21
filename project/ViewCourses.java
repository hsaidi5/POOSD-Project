package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewCourses extends AppCompatActivity
{
    private Button updateCourses;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);

        configureUpdateCourses();
        configureBackButton();
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