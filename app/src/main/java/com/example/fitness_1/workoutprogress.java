package com.example.fitness_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class workoutprogress extends AppCompatActivity {
    public EditText pullup,pushup,squat,plunk,situp;
    public Button save;
    public FirebaseDatabase dbs;
    public DatabaseReference rdbs;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutprogress);
        save=findViewById(R.id.Save);
        pullup=findViewById(R.id.pullup);
        pushup=findViewById(R.id.pushup);
        squat=findViewById(R.id.squat);
        plunk=findViewById(R.id.plunk);
        situp=findViewById(R.id.situp);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbs = FirebaseDatabase.getInstance();
                uid=FirebaseAuth.getInstance().getCurrentUser().getUid();
                rdbs = dbs.getReference("progress");
                String pullups = pullup.getText().toString();
                String pushups = pushup.getText().toString();
                String squats= squat.getText().toString();
                String plank = plunk.getText().toString();
                String situps = situp.getText().toString();
                String date= DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

                workoutprogress.activity u = new workoutprogress.activity(pullups, pushups,squats,plank,situps,date);
                rdbs.child(uid).child(date).setValue(u);

                Intent intent = new Intent(workoutprogress.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

public class activity{
        String pullups, pushups,squats,plunk,situps,date;

    public activity(String pullups, String pushups, String squats, String plunk, String situps, String date) {
        this.pullups = pullups;
        this.pushups = pushups;
        this.squats = squats;
        this.plunk = plunk;
        this.situps = situps;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPullups() {
        return pullups;
    }

    public void setPullups(String pullups) {
        this.pullups = pullups;
    }

    public String getPushups() {
        return pushups;
    }

    public void setPushups(String pushups) {
        this.pushups = pushups;
    }

    public String getSquats() {
        return squats;
    }

    public void setSquats(String squats) {
        this.squats = squats;
    }

    public String getPlunk() {
        return plunk;
    }

    public void setPlunk(String plunk) {
        this.plunk = plunk;
    }

    public String getSitups() {
        return situps;
    }

    public void setSitups(String situps) {
        this.situps = situps;
    }
}
}
