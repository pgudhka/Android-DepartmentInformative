package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MBASem10sub extends AppCompatActivity {

    ListView listView;
    String url;
    String[] yearlist = {"2016-17","2017-18"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbasem10sub);

        listView = findViewById(R.id.msem10subList);

        ArrayList<String> sublist = new ArrayList<>();
        sublist.add("sub 1");
        sublist.add("sub 2");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,sublist);
        listView.setAdapter(arrayAdapter);


        final AlertDialog.Builder sub1yearlist = new AlertDialog.Builder(this);
        sub1yearlist.setTitle("Select Year");
        sub1yearlist.setItems(yearlist, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which+1)
                {
                    case 1:
                        url = "https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%201.pdf?alt=media&token=f2c9d4c2-76ff-470b-afed-37bc93d8eaad";
                        break;

                    case 2:
                        url = "https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%202.pdf?alt=media&token=1713bfe6-a3c3-4149-b944-8c4463480922";
                        break;
                }
                Intent intent = new Intent(MBASem10sub.this,PDFWebView.class);
                Bundle bundle = new Bundle();
                bundle.putString("pdf",url);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        final AlertDialog.Builder sub2yearlist = new AlertDialog.Builder(this);
        sub2yearlist.setTitle("Select Year");
        sub2yearlist.setItems(yearlist, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch(item+1)
                {
                    case 1:
                        url = "https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%203.pdf?alt=media&token=0778aa48-ede6-46c8-9a62-e4411dd2fecd";
                        break;

                    case 2:
                        url = "https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2Ftest%2FSample%20Document%201.pdf?alt=media&token=f2c9d4c2-76ff-470b-afed-37bc93d8eaad";
                        break;
                }
                Intent intent = new Intent(MBASem10sub.this,PDFWebView.class);
                Bundle bundle = new Bundle();
                bundle.putString("pdf",url);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        //registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    AlertDialog alertDialog1 = sub1yearlist.create();
                    alertDialog1.show();
                }
                else if(position == 1)
                {
                    AlertDialog alertDialog2 = sub2yearlist.create();
                    alertDialog2.show();
                }
            }
        });
    }
}
