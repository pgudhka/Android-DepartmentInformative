package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MBMttTt extends AppCompatActivity {

    int sem_select;
    Spinner mttselect;
    WebView mttview;


    String pdf="";
    String url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbmtt_tt);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        sem_select = bundle.getInt("sem");

        mttselect = findViewById(R.id.mbmttselect);
        mttview = findViewById(R.id.mbmttview);
        mttview.setVisibility(View.INVISIBLE);

        ArrayList<String> mttlist = new ArrayList<>();

        mttlist.add("-- Select --");
        mttlist.add("MTT - 1");
        mttlist.add("MTT - 2");
        mttlist.add("MTT - 3");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mttlist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mttselect.setAdapter(arrayAdapter);

        mttselect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int position1 = position + 1;

                switch(position1)
                {
                    case 1: mttview.setVisibility(View.INVISIBLE);
                        pdf="";
                        break;

                    case 2: mttview.setVisibility(View.VISIBLE);
                        pdf = mtt1url(sem_select);
                        break;

                    case 3: mttview.setVisibility(View.VISIBLE);
                        pdf = mtt2url(sem_select);
                        break;

                    case 4: mttview.setVisibility(View.VISIBLE);
                        pdf = mtt3url(sem_select);
                        break;
                }


                mttview.setBackgroundColor(Color.TRANSPARENT);
                mttview.getSettings().setJavaScriptEnabled(true);

                try {
                    url = URLEncoder.encode(pdf,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                mttview.loadUrl("https://docs.google.com/viewerng/viewer?url="+url);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mttview.setVisibility(View.INVISIBLE);
            }
        });

    }

    public String mtt1url(int a)
    {
        String urla = "";

        switch(a)
        {
            case 1: urla = "https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%201.pdf?alt=media&token=f2c9d4c2-76ff-470b-afed-37bc93d8eaad";
                break;

            case 2: urla = "";
                break;

            case 3: urla = "";
                break;

            case 4: urla = "";
                break;

            case 5: urla = "";
                break;

            case 6: urla = "";
                break;

            case 7: urla = "";
                break;

            case 8: urla = "";
                break;
            case 9: urla = "";
                break;
            case 10: urla = "";
                break;
        }

        return urla;
    }

    public String mtt2url(int b)
    {
        String urlb = "";

        switch(b)
        {
            case 1: urlb = "https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%202.pdf?alt=media&token=1713bfe6-a3c3-4149-b944-8c4463480922";
                break;

            case 2: urlb = "";
                break;

            case 3: urlb = "";
                break;

            case 4: urlb = "";
                break;

            case 5: urlb = "";
                break;

            case 6: urlb = "";
                break;

            case 7: urlb = "";
                break;

            case 8: urlb = "";
                break;
            case 9: urlb = "";
                break;
            case 10: urlb = "";
                break;
        }

        return urlb;
    }

    public String mtt3url(int c)
    {
        String urlc = "";

        switch(c)
        {
            case 1: urlc = "https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%203.pdf?alt=media&token=0778aa48-ede6-46c8-9a62-e4411dd2fecd";
                break;

            case 2: urlc = "";
                break;

            case 3: urlc = "";
                break;

            case 4: urlc = "";
                break;

            case 5: urlc = "";
                break;

            case 6: urlc = "";
                break;

            case 7: urlc = "";
                break;

            case 8: urlc = "";
                break;
            case 9: urlc = "";
                break;
            case 10: urlc = "";
                break;
        }

        return urlc;
    }
}
