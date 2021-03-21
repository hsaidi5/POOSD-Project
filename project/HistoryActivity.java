package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class HistoryActivity extends AppCompatActivity
{

    private Button back;
    private Button HistoryCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ArrayList<Course> enrolledCourses = SharedData.getCurrentCourses(this);
        
        // configureHistoryCourses();
        configureCourses(enrolledCourses);
        configureBackButton();
    }

    // TEMPORARY FUNCTION
    private void configureCourses(ArrayList<Course> enrolledCourses) {
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

    /*
    //Function to view the History of the Courses
    private void configureHistoryCourses(){
         HistoryCourses = findViewByID(R.id.HistoryCourses);
         HistoryCourses.setOnClickListener(new View.OnClickListener(){
         
             @Override
             public void OnClick(View v){
                 Intent intent = new Intent(ViewCourses.this.HistoryCourses.class);
                 startActivity(intent);
             }
         });
    }
     */

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
