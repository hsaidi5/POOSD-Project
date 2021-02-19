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