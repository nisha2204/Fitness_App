package com.example.fitness_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomappbar.BottomAppBar;

public class exercise extends AppCompatActivity {
    private Button yoga, workout, stretching, meditation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        meditation=findViewById(R.id.Button4);
        stretching=findViewById(R.id.Button3);
        yoga =(Button) findViewById(R.id.yogab);
        workout=(Button) findViewById(R.id.workoutb);

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercise.this , yoga.class);
                startActivity(intent);

            }
        });

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(exercise.this , workout.class);
                startActivity(intent1);

            }
        });
        meditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(exercise.this , meditation.class);
                startActivity(intent2);

            }
        });
        stretching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(exercise.this , suryanamaskar.class);
                startActivity(intent3);
            }
        });
    }
}
