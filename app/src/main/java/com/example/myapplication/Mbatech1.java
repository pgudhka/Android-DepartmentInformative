package com.example.myapplication;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Mbatech1 extends AppCompatActivity {

    CardView academicCalender;
    CardView timeTable;
    CardView syllabus;
    CardView questionPapers;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    String syllaFile;

    int sem_select;
    final CharSequence[] sem = {"Sem 1","Sem 2","Sem 3","Sem 4","Sem 5","Sem 6","Sem 7","Sem 8","Sem 9","Sem 10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbatech1);

        academicCalender = (CardView) findViewById(R.id.mbacademicCalender);
        timeTable = (CardView) findViewById(R.id.mbtimeTable);
        syllabus = (CardView) findViewById(R.id.mbsyllabus);
        questionPapers = (CardView) findViewById(R.id.mbquestionPapers);
        final Bundle bundle2 = new Bundle();

        storageReference = firebaseStorage.getInstance().getReference();

        final AlertDialog.Builder mbttbuilder = new AlertDialog.Builder(this);
        mbttbuilder.setTitle("Select Semester");
        mbttbuilder.setItems(sem, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                sem_select = item+1;
                bundle2.putInt("sem",sem_select);
                Intent intent2 = new Intent(Mbatech1.this,MBSelectTT.class);
                intent2.putExtras(bundle2);
                startActivity(intent2);
            }
        });

        timeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alert2 = mbttbuilder.create();
                alert2.show();
            }
        });

        final AlertDialog.Builder mbsylabusbuilder = new AlertDialog.Builder(this);
        mbsylabusbuilder.setTitle("Select Semester");
        mbsylabusbuilder.setItems(sem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sem_select = which + 1;
                mbsyllabusviewer(sem_select);
            }
        });

        academicCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Mbatech1.this,PDFWebView.class);
                Bundle bundle = new Bundle();
                String pdf = "https://firebasestorage.googleapis.com/v0/b/departmentinformative.appspot.com/o/Btech%2FAcademic%20Calendar%2Facademiccalendar.pdf?alt=media&token=30806bf0-e493-4d61-8187-354c7df2fa33";
                bundle.putString("pdf",pdf);
                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });

        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alert3 = mbsylabusbuilder.create();
                alert3.show();

            }
        });

        final AlertDialog.Builder mbpapersbuilder = new AlertDialog.Builder(this);
        mbpapersbuilder.setTitle("Select Semester");
        mbpapersbuilder.setItems(sem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item1) {
                sem_select = item1 + 1;
                forwardactivity(sem_select);
            }
        });

        questionPapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert4 = mbpapersbuilder.create();
                alert4.show();
            }
        });

    }

    public void mbsyllabusviewer(int a) {

        switch (a) {
            case 1:
                ref = storageReference.child("/Btech/Syllabus/sem1.pdf");
                syllaFile = "sem1";
                break;

            case 2:
                ref = storageReference.child("");
                syllaFile = "sem2";
                break;

            case 3:
                ref = storageReference.child("");
                syllaFile = "sem3";
                break;

            case 4:
                ref = storageReference.child("");
                syllaFile = "sem4";
                break;

            case 5:
                ref = storageReference.child("");
                syllaFile = "sem5";
                break;

            case 6:
                ref = storageReference.child("");
                syllaFile = "sem6";
                break;

            case 7:
                ref = storageReference.child("");
                syllaFile = "sem7";
                break;

            case 8:
                ref = storageReference.child("");
                syllaFile = "sem8";
                break;
            case 9:
                ref = storageReference.child("");
                syllaFile = "sem8";
                break;
            case 10:
                ref = storageReference.child("");
                syllaFile = "sem8";
                break;
        }

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFiles(Mbatech1.this,syllaFile,".pdf",DIRECTORY_DOWNLOADS,url);
                Toast.makeText(Mbatech1.this, "Your file is being Downloaded", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    public void downloadFiles(Context context, String fileName, String fileExtension, String destinationDirectory, String url)
    {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);

        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context,destinationDirectory,fileName+fileExtension);

        downloadManager.enqueue(request);
    }

    public void forwardactivity(int sem_select)
    {
        switch (sem_select)
        {
            case 1:
                Intent intent1 = new Intent(Mbatech1.this,MBASem1sub.class);
                startActivity(intent1);
                break;

            case 2:
                Intent intent2 = new Intent(Mbatech1.this,MBASem2sub.class);
                startActivity(intent2);
                break;

            case 3:
                Intent intent3 = new Intent(Mbatech1.this,MBASem3sub.class);
                startActivity(intent3);
                break;

            case 4:
                Intent intent4 = new Intent(Mbatech1.this,MBASem4sub.class);
                startActivity(intent4);
                break;

            case 5:
                Intent intent5 = new Intent(Mbatech1.this,MBASem5sub.class);
                startActivity(intent5);
                break;

            case 6:
                Intent intent6 = new Intent(Mbatech1.this,MBASem6sub.class);
                startActivity(intent6);
                break;

            case 7:
                Intent intent7 = new Intent(Mbatech1.this,MBASem7sub.class);
                startActivity(intent7);
                break;

            case 8:
                Intent intent8 = new Intent(Mbatech1.this,MBASem8sub.class);
                startActivity(intent8);
                break;

            case 9:
                Intent intent9 = new Intent(Mbatech1.this,MBASem9sub.class);
                startActivity(intent9);
                break;

            case 10:
                Intent intent10 = new Intent(Mbatech1.this,MBASem10sub.class);
                startActivity(intent10);
                break;
        }
    }
}
