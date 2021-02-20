package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class StudySession extends AppCompatActivity
{
    private Button back;
    private Button start;

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_session);

        setupDropdownList();
        configureBackButton();
        configureStartButton();

    }

    private void setupDropdownList()
    {
        Spinner enrolledClasses = (Spinner) findViewById(R.id.selectCourse);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(StudySession.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.courses));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enrolledClasses.setAdapter(myAdapter);
    }

    private void configureBackButton()
    {
        back = findViewById(R.id.backFromStudy);

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    private void configureStartButton()
    {
        start = findViewById(R.id.button);

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                running = true;
                runTimer();
            }
        });
    }

    private void runTimer()
    {
        final EditText timeText = findViewById(R.id.editTextTime);
        final Handler handler = new Handler();

        handler.post(new Runnable()
        {
            @Override

            public void run()
            {
                int minutes = (seconds % 3600) / 60;
                int secs = seconds;

                String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs);

                timeText.setText(time);

                if (running)
                {
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }
}
