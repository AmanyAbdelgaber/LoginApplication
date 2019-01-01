package com.example.org.loginapplication;

import android.content.DialogInterface;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static android.os.Looper.prepare;

public class RecordActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton addRecordFab;
    private AlertDialog.Builder addRecordDialog;
    private Button recordBtn, stopRecordBtn, addRecordBtn;
    private EditText noteEditTxt;
    private MediaRecorder mediaRecorder;
    private String mediaFileName = null;
    private static  final String LOG_TAG = "Record_log";
    private TextView usernameTxt;
    private ArrayList<User> userArrayList;
    private  UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        recyclerView = findViewById(R.id.recyclerView);
        addRecordFab = findViewById(R.id.addRecordFab);
        usernameTxt = findViewById(R.id.usernameTxt);
       /*** ***** this for test recyclerView
        * userArrayList = new ArrayList<>();


        userArrayList.add(new User("ahgghf@gmail.com", "12345658","bjkb", R.raw.diamonds));
        userArrayList.add(new User("ahgghf@gmail.com", "12345658",",bjkbk", R.raw.diamonds));
        userArrayList.add(new User("ahgghf@gmail.com", "12345658","mn,nkj", R.raw.diamonds));

        userAdapter = new UserAdapter(this, userArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);



******/
        addRecordFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddRecordDialog();
            }
        });




    }

    private void showAddRecordDialog(){
        addRecordDialog = new AlertDialog.Builder(this);
        View addRecordDialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.add_record_dialog, null);
        addRecordDialog.setView(addRecordDialogView);
        recordBtn = addRecordDialogView.findViewById(R.id.recordBtn);
        addRecordBtn = addRecordDialogView.findViewById(R.id.addBtn);
        noteEditTxt = addRecordDialogView.findViewById(R.id.notesEditTxt);
        stopRecordBtn = addRecordDialogView.findViewById(R.id.stopRecordBtn);

        mediaFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mediaFileName += "/recorded_audio.3gp";


        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecording();
            }
        });

        stopRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRecording();
            }
        });

        addRecordDialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        addRecordDialog.create();
        addRecordDialog.show();

        addRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRecordToList();
            }
        });
    }

    private void startRecording() {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(mediaFileName);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        mediaRecorder.start();

    }

    private void stopRecording() {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
    }


    private void addRecordToList(){


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_record, menu);
        return super.onCreateOptionsMenu(menu);
    }

}

