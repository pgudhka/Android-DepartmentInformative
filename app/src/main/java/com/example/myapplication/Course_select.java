package com.example.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class Course_select extends AppCompatActivity {

    Button b_tech;
    Button mba_tech;
    Button faculty_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_select);

        b_tech = findViewById(R.id.b_tech);
        mba_tech = findViewById(R.id.mba_tech);
        faculty_info = findViewById(R.id.faculty_info);

        faculty_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fac_info = new Intent(Course_select.this,Facultyinfo.class);
                startActivity(fac_info);

            }
        });

        b_tech.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                Intent b_tech1 = new Intent(Course_select.this,Btech1.class);
                startActivity(b_tech1);
            }
        });

        mba_tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mba_tech1 = new Intent(Course_select.this,Mbatech1.class);
                startActivity(mba_tech1);
            }
        });
    }
}
