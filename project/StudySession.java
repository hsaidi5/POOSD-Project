package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
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
    private Button pause;
    private Button stop;

    private Spinner enrolledClasses;

    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_session);

        setupDropdownList();
        configureBackButton();
        configureStartButton();
        configurePauseButton();
        configureStopButton();

        runTimer();
    }

    private void setupDropdownList()
    {
        enrolledClasses = (Spinner) findViewById(R.id.selectCourse);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(StudySession.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.courses));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enrolledClasses.setAdapter(myAdapter);

        enrolledClasses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                    start.setEnabled(false);
                else
                    start.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
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

    // Implemented by Christopher Delarosa
    private void configureStartButton()
    {
        start = findViewById(R.id.button);

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                running = true;
                start.setEnabled(false);
                start.setVisibility(View.GONE);
                pause.setEnabled(true);
                pause.setVisibility(View.VISIBLE);
                stop.setEnabled(true);
                stop.setVisibility(View.VISIBLE);

                enrolledClasses.setEnabled(false);
            }
        });
    }

    private void configurePauseButton()
    {
        pause = findViewById(R.id.pause);

        pause.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (running)
                {
                    running = false;
                    pause.setText("Resume");
                }
                else
                {
                    running = true;
                    pause.setText("Pause");
                }
            }
        });
    }

    private void configureStopButton()
    {
        stop = findViewById(R.id.stop);

        stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                running = false;
                // Code to upload time spent studying to HistoryActivity should be placed here

                stop.setVisibility(View.GONE);
                pause.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);

                stop.setEnabled(false);
                pause.setEnabled(false);
                start.setEnabled(true);

                enrolledClasses.setEnabled(true);

                seconds = 0;
            }
        });
    }

    // Implemented by Christopher Delarosa
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
                int secs = seconds % 60;

                String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs);

                timeText.setText(time);

                if (running)
                    seconds++;

                handler.postDelayed(this, 1000);
            }
        });
    }
}
