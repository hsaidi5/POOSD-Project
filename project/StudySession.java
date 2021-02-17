package com.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class StudySession extends AppCompatActivity {
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_session);

        back = findViewById(R.id.backFromStudy);

        Spinner enrolledClasses = (Spinner) findViewById(R.id.selectCourse);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(StudySession.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.courses));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enrolledClasses.setAdapter(myAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudySession.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}