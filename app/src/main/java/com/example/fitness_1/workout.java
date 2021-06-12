package com.example.fitness_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class workout extends AppCompatActivity {
    Button save;
    TextView a,b,c,d,e,f,g,h,i,j;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        save=findViewById(R.id.saveactivity);
        a=findViewById(R.id.shoulders);
        b=findViewById(R.id.chest);
        c=findViewById(R.id.abdominal);
        d=findViewById(R.id.glutes);
        e=findViewById(R.id.quads);
        f=findViewById(R.id.calves);
        g=findViewById(R.id.forearms);
        h=findViewById(R.id.traps);
        i=findViewById(R.id.lowerback);
        j=findViewById(R.id.surya);


        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav = (NavigationView) findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(workout.this , recoomendation.class);
                        startActivity(intent);
                        break;


                    /*case R.id.menu_settings:
                        Toast.makeText(getApplicationContext(), "Settings Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(workout.this , settings.class);
                        startActivity(intent1);
                        break;*/
                    case R.id.menu_aerobic:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent3 = new Intent(workout.this , MainActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.menu_balance:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent4 = new Intent(workout.this , balance.class);
                        startActivity(intent4);
                        break;
                    case R.id.menu_strength:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent5 = new Intent(workout.this , workout.class);
                        startActivity(intent5);
                        break;
                    case R.id.menu_cardio:
                        Toast.makeText(getApplicationContext(), "Activity Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent2 = new Intent(workout.this , cardioactivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.menu_exercise:
                        Toast.makeText(getApplicationContext(), "Exercise Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(workout.this , activity.class);
                        startActivity(intent1);
                        break;
                }
                return true;
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(workout.this, workoutprogress.class);
                startActivity(intent);
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(workout.this, shoulders.class);
                startActivity(intent1);

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(workout.this, chest.class);
                startActivity(intent1);

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(workout.this, abdominal.class);
                startActivity(intent1);

            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(workout.this, glutes.class);
                startActivity(intent1);

            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(workout.this, quads.class);
                startActivity(intent1);

            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(workout.this, calves.class);
                startActivity(intent1);

            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(workout.this, forearms.class);
                startActivity(intent1);

            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(workout.this, traps.class);
                startActivity(intent1);

            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(workout.this, lowerback.class);
                startActivity(intent1);

            }
        });
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(workout.this, suryanamaskar.class);
                startActivity(intent1);

            }
        });
    }
}
