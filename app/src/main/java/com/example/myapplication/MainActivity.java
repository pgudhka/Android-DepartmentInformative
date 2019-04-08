package com.example.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    Button stu;
    Button fac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stu = findViewById(R.id.stu);
        fac = findViewById(R.id.fac);

        stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent course_select = new Intent(MainActivity.this,Course_select.class);
                startActivity(course_select);
                finish();

            }
        });

    }
}
