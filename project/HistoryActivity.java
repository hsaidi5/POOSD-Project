package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HistoryActivity extends AppCompatActivity
{

    private Button back;
    //private Button HistoryCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        
        //configureHistoryCourses();
        configureBackButton();
    }
    
    /*//Function to view the History of the Courses
    private void configurationHistoryCourses(){
         HistoryCourses = findViewByID(R.id.HistoryCourses);
         HistoryCourses.setOnClickListener(new View.OnClickListener(){
         
             @Override
             public void OnClick(View v){
                 Intent intent = new Intent(ViewCourses.this.HistoryCourses.class);
                 startActivity(intent);
             }
         });
    }*/

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
