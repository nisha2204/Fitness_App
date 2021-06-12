package com.example.fitness_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class yogaprogress extends AppCompatActivity {
    private EditText time, repeat,name;
    private Button save;
    FirebaseDatabase db;
    DatabaseReference rdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yogaprogress);
        time=(EditText)findViewById(R.id.time);
        repeat=(EditText)findViewById(R.id.repeatation);
        name=(EditText)findViewById(R.id.name);
        save=(Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=FirebaseDatabase.getInstance();
                rdb=db.getReference("progress");
                String t= time.getText().toString();
                String r=repeat.getText().toString();
                String n=name.getText().toString();
                progress p=new progress(t,r,n);

                rdb.child(n).setValue(p);
            }
        });
    }
    public class progress{
        String time;
        String repeat;
        String name;

        public progress(String time, String repeat, String name) {
            this.time = time;
            this.repeat = repeat;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getRepeat() {
            return repeat;
        }

        public void setRepeat(String repeat) {
            this.repeat = repeat;
        }
    }
}
