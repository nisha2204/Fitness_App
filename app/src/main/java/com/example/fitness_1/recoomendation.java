package com.example.fitness_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class recoomendation extends AppCompatActivity {
    TextView cardio, strength, balance;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    androidx.appcompat.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoomendation);
        cardio = findViewById(R.id.tv1);
        strength = findViewById(R.id.tv2);
        balance = findViewById(R.id.tv3);


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
                        Intent intent = new Intent(recoomendation.this , recoomendation.class);
                        startActivity(intent);
                        break;


                    /*case R.id.menu_settings:
                        Toast.makeText(getApplicationContext(), "Settings Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(recoomendation.this , settings.class);
                        startActivity(intent1);
                        break;*/
                   /*case R.id.menu_logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(recoomendation.this);
                        builder.setTitle("Confirmation PopUp!").
                                setMessage("You sure, that you want to logout?");
                        builder.setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent i = new Intent(getApplicationContext(),
                                               login.class);
                                        startActivity(i);
                                    }
                                });
                        builder.setNegativeButton("No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert11 = builder.create();
                        alert11.show();
                        break;*/
                    case R.id.menu_aerobic:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent3 = new Intent(recoomendation.this , MainActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.menu_balance:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent4 = new Intent(recoomendation.this , balance.class);
                        startActivity(intent4);
                        break;
                    case R.id.menu_strength:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent5 = new Intent(recoomendation.this , workout.class);
                        startActivity(intent5);
                        break;
                    case R.id.menu_cardio:
                        Toast.makeText(getApplicationContext(), "Activity Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(recoomendation.this , cardioactivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.menu_exercise:
                        Toast.makeText(getApplicationContext(), "Exercise Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent2 = new Intent(recoomendation.this , activity.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });


        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(recoomendation.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(recoomendation.this, workout.class);
                startActivity(intent2);
            }
        });
        balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(recoomendation.this, balance.class);
                startActivity(intent1);
            }
        });

    }
    private void setSupportActionBar(Toolbar toolbar) {
    }
}