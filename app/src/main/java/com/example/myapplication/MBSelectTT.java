package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MBSelectTT extends AppCompatActivity {

    CardView mbacademicTT;
    CardView mbexamTT;
    CardView mbfacultyTT;
    String finaltturl;
    String pdf;

    int sem_select;
    String examTtType;
    final CharSequence[] examtt = {"Mid-Term Test (MTT)","Final Exam"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbselect_tt);

        mbacademicTT = findViewById(R.id.mbacademicTT);
        mbexamTT = findViewById(R.id.mbexamTT);
        mbfacultyTT = findViewById(R.id.mbfacultyTT);

        Intent intent = getIntent();
        Bundle bundle1 = intent.getExtras();
        sem_select = bundle1.getInt("sem");
        final Bundle b2 = new Bundle();
        final Bundle b3 = new Bundle();

        mbacademicTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String acadtturl = mbacadtturl(sem_select);
                b2.putString("pdf",acadtturl);
                Intent acadtt =  new Intent(MBSelectTT.this,PDFWebView.class);
                acadtt.putExtras(b2);
                startActivity(acadtt);
            }
        });

        final AlertDialog.Builder mbexambuilder = new AlertDialog.Builder(this);
        mbexambuilder.setTitle("-- Select --");
        mbexambuilder.setItems(examtt, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                examTtType = (String) examtt[item];
                if(item == 0)
                {
                    b3.putInt("sem",sem_select);
                    Intent intent1 = new Intent(MBSelectTT.this,MBMttTt.class);
                    intent1.putExtras(b3);
                    startActivity(intent1);
                }
                if(item == 1)
                {
                    finaltturl = examtturl(sem_select);
                    b3.putString("pdf",finaltturl);
                    Intent intent2 = new Intent(MBSelectTT.this,PDFWebView.class);
                    intent2.putExtras(b3);
                    startActivity(intent2);
                }
            }
        });

        mbexamTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert1 = mbexambuilder.create();
                alert1.show();

            }
        });

        String[] names =
                {
                        "Dr. Priyesh Kanungo",
                        "Mr. Prashant P. Udawant",
                        "Sonia V. Relan",
                        "Ritesh Dhanare",
                        "Ms. Pratiksha L. Meshram",
                        "Mr. Piyush Kumar Soni",
                        "Mr. Pravinkummar B. Landge",
                        "Mr. Dhiraj V. Bhise"
                };

        final AlertDialog.Builder facultybuilder = new AlertDialog.Builder(this);
        facultybuilder.setTitle("Select Faculty name:");
        facultybuilder.setItems(names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {



                switch(which+1)
                {
                    case 1:
                        pdf="https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%201.pdf?alt=media&token=f2c9d4c2-76ff-470b-afed-37bc93d8eaad";
                        break;

                    case 2:
                        pdf="https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%202.pdf?alt=media&token=1713bfe6-a3c3-4149-b944-8c4463480922";
                        break;

                    case 3:
                        pdf="";
                        break;

                    case 4:
                        pdf="";
                        break;

                    case 5:
                        pdf="";
                        break;

                    case 6:
                        pdf="";
                        break;

                    case 7:
                        pdf="";
                        break;

                    case 8:
                        pdf="";
                        break;
                }
                Intent intent1 = new Intent(MBSelectTT.this,PDFWebView.class);
                Bundle bundle = new Bundle();
                bundle.putString("pdf",pdf);
                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });

        mbfacultyTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = facultybuilder.create();
                alertDialog.show();
            }
        });

    }

    public String mbacadtturl(int a)
    {
        String url = "";
        switch(a)
        {
            case 1: url = "https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%202.pdf?alt=media&token=1713bfe6-a3c3-4149-b944-8c4463480922";
                break;

            case 2: url = "";
                break;

            case 3: url = "";
                break;

            case 4: url = "";
                break;

            case 5: url = "";
                break;

            case 6: url = "";
                break;

            case 7: url = "";
                break;

            case 8: url = "";
                break;
            case 9: url = "";
                break;
            case 10: url = "";
                break;
        }

        return url;
    }

    public String examtturl(int a)
    {
        String pdf = "";

        switch(a)
        {
            case 1: pdf = "https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%202.pdf?alt=media&token=1713bfe6-a3c3-4149-b944-8c4463480922";
                break;

            case 2: pdf = "";
                break;

            case 3: pdf = "";
                break;

            case 4: pdf = "";
                break;

            case 5: pdf = "";
                break;

            case 6: pdf = "";
                break;

            case 7: pdf = "";
                break;

            case 8: pdf = "";
                break;
            case 9: pdf = "";
                break;

            case 10: pdf = "";
                break;


        }

        return pdf;
    }
}
