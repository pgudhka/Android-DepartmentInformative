package com.example.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Facultyinfo extends AppCompatActivity {

    private ViewPager viewPager;
    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultyinfo);

        viewPager = findViewById(R.id.pager);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

    }
}
