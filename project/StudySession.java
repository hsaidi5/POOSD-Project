package com.mytime;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Locale;

public class StudySession extends AppCompatActivity
{
    private Button back;
    private Button start;
    private Button pause;
    private Button stop;

    private Button advMins;
    private Button advSecs;

    private Spinner courseSpinner;

    private int seconds = 0;
    private int minutes = 0;
    private int secs = 0;

    private String currentClass = "";

    private boolean running;
    private boolean onBreak = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_session);

        ArrayList<Course> enrolledCourses = SharedData.getCurrentCourses(this);

        setupDropdownList(enrolledCourses);
        configureBackButton();
        configureStartButton();
        configurePauseButton();
        configureStopButton(enrolledCourses);

        configureAdvMinutesButton();
        configureAdvSecondsButton();

        runTimer();
    }

    // Dropdown list that displays the list of courses.
    private void setupDropdownList(ArrayList<Course> enrolledCourses)
    {
        courseSpinner = (Spinner) findViewById(R.id.selectCourse);
        ArrayList<String> classNames = new ArrayList<String>();

        for (int i = 0; i < enrolledCourses.size(); i++)
        {
            if (i == 0)
                classNames.add("Select Course");

            classNames.add(new String(enrolledCourses.get(i).get_name()));
        }

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(StudySession.this, android.R.layout.simple_list_item_1,
                classNames);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseSpinner.setAdapter(myAdapter);

        // Button to start timer is disabled if the user doesn't have a course selected.
        courseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (position == 0)
                {
                    start.setEnabled(false);
                }
                else
                {
                    start.setEnabled(true);
                    currentClass = classNames.get(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }

        });
    }

    // Button for testing purposes. Advances stopwatch 14 minutes.
    private void configureAdvMinutesButton()
    {
        advMins = findViewById(R.id.advMinutes);

        advMins.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                seconds += 840;
            }
        });
    }

    // Button for testing purposes. Advances stopwatch 50 seconds.
    private void configureAdvSecondsButton()
    {
        advSecs = findViewById(R.id.advSeconds);

        advSecs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                seconds += 50;
            }
        });
    }

    // Sends the user back to the starting screen.
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

    // Begins the stopwatch.
    private void configureStartButton()
    {
        start = findViewById(R.id.startTimer);

        start.setEnabled(false);

        start.setOnClickListener(new View.OnClickListener()
        {
            // Disable start button and take it from view, then display the Pause and Stop buttons.
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

                courseSpinner.setEnabled(false);
            }
        });
    }

    // Pauses or continues the stopwatch.
    private void configurePauseButton()
    {
        pause = findViewById(R.id.pause);

        pause.setOnClickListener(new View.OnClickListener()
        {
            // Switch text on button depending on whether the user wants to pause or resume.
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

    // Stops the stopwatch and resets the display.
    private void configureStopButton(ArrayList<Course> enrolledCourses)
    {
        stop = findViewById(R.id.stop);

        stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                running = false;

                update_hours_remaining(enrolledCourses);
                stop.setVisibility(View.GONE);
                pause.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);

                stop.setEnabled(false);
                pause.setEnabled(false);
                start.setEnabled(true);

                courseSpinner.setEnabled(true);

                seconds = 0;
            }
        });
    }

    // Manages the formatting for the stopwatch display, if it's currently running.
    private void runTimer()
    {
        final EditText timeText = findViewById(R.id.editTextTime);
        final Handler handler = new Handler();

        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                minutes = seconds / 60;
                secs = seconds % 60;

                String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs);

                timeText.setText(time);

                // Tell the user to take a study break every 15 minutes.
                if (minutes != 0 && minutes % 15 == 0 && onBreak == false)
                {
                    onBreak = true;
                    startBreak();
                }
                else if (minutes % 15 != 0 && onBreak == true)
                    onBreak = false;

                if (running)
                    seconds++;

                // Update the stopwatch every second while running.
                handler.postDelayed(this, 1000);
            }
        });
    }

    // Programmed break, set to go off every 15 minutes.
    private void startBreak()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(StudySession.this);

        // Pause the stopwatch and display a dialog box.
        pause.performClick();
        builder.setTitle("It's time for a break!");
        builder.setCancelable(false);
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog breakDialog = builder.create();
        breakDialog.show();
    }

    // Code to deduct the amount of time spent studying from the amount of time remaining.
    private void update_hours_remaining(ArrayList<Course> enrolledCourses)
    {
        double timeSpent = (seconds / 60.0) + (seconds / 3600.0);
        timeSpent = Math.floor(timeSpent * 100) / 100;

        for (int i = 0; i < enrolledCourses.size(); i++)
        {
            if (enrolledCourses.get(i).get_name().equals(currentClass))
            {
                double starting = enrolledCourses.get(i).get_time_available();
                enrolledCourses.get(i).set_time_available(starting - timeSpent);

                if (enrolledCourses.get(i).get_time_available() < 0)
                {
                    enrolledCourses.get(i).set_time_available(0);
                }
            }
        }
    }
}