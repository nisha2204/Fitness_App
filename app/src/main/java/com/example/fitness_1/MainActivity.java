package com.example.fitness_1;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener {
    private static double precision = 2;
    public FirebaseDatabase dbs;
    public DatabaseReference rdbs;
    String uid;

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private double deltaX = 0, deltaY = 0, deltaZ = 0;
    private double lastX = 0, lastY = 0, lastZ = 0;
    private int steps = 0, counter = 0, oldSteps = 0;
    private double height = 0.0;

    private long startTime = 0, startWatch = 0, stopWatch = 0;
    private int walked = 0;
    private double meters = 0, runningSpeed = 0;

    private ArrayList<Double> x;
    private ArrayList<Double> y;
    private ArrayList<Double> z;

    private ArrayList<Double> dataX;
    private ArrayList<Double> dataY;
    private ArrayList<Double> dataZ;

    private TextView stepsNumber, distance, speed, calories;
    private Chronometer watch;
    private Button start, stop, setgoalb;
    private EditText heightData;
    private EditText setgoal,weight;



    public void initializeViews() {
        stepsNumber = (TextView) findViewById(R.id.stepsNumber);
        distance = (TextView) findViewById(R.id.distance);
        speed = (TextView) findViewById(R.id.speed);
        calories = (TextView) findViewById(R.id.calories);
        watch = (Chronometer) findViewById(R.id.chronometer5);
        heightData = (EditText) findViewById(R.id.heightData);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.Stop);

    }

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    androidx.appcompat.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();


        startTime = System.currentTimeMillis();

        x = new ArrayList<Double>();
        y = new ArrayList<Double>();
        z = new ArrayList<Double>();

        dataX = new ArrayList<Double>();
        dataY = new ArrayList<Double>();
        dataZ = new ArrayList<Double>();

        start.setOnClickListener((View.OnClickListener) this);
        stop.setOnClickListener((View.OnClickListener) this);

        stepsNumber.setEnabled(false);
        distance.setEnabled(false);
        speed.setEnabled(false);
        calories.setEnabled(false);
        stop.setEnabled(false);
        start.setEnabled(true);

        //checking for sensor availability

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            // success
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        } else {
            // error
        }

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
                        break;


                    /*case R.id.menu_settings:
                        Toast.makeText(getApplicationContext(), "Settings Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(MainActivity.this , settings.class);
                        startActivity(intent);
                        break;*/
                    case R.id.menu_aerobic:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent3 = new Intent(MainActivity.this , MainActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.menu_balance:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent4 = new Intent(MainActivity.this , balance.class);
                        startActivity(intent4);
                        break;
                    case R.id.menu_strength:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent5 = new Intent(MainActivity.this , workout.class);
                        startActivity(intent5);
                        break;
                    case R.id.menu_cardio:
                        Toast.makeText(getApplicationContext(), "Activity Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent2 = new Intent(MainActivity.this , cardioactivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.menu_exercise:
                        Toast.makeText(getApplicationContext(), "Exercise Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(MainActivity.this , activity.class);
                        startActivity(intent1);
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {

        if (v.equals(start)) {   //onclick for start button

            watch.setBase(SystemClock.elapsedRealtime() + stopWatch);
            watch.start();  //start watch

            startWatch = System.currentTimeMillis();  //time in milliseconds

            height = Double.parseDouble(heightData.getText().toString());   //get height as input
            stepsNumber.setEnabled(true);   //enable all parameters
            distance.setEnabled(true);
            speed.setEnabled(true);
            calories.setEnabled(true);
            stop.setEnabled(true);
            start.setEnabled(false);
            heightData.setEnabled(false);

            resetValues();

            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        } else if (v.equals(stop)) {

            stepsNumber.setEnabled(false);
            distance.setEnabled(false);
            speed.setEnabled(false);
            calories.setEnabled(false);
            stop.setEnabled(false);
            start.setEnabled(true);
            heightData.setEnabled(true);
            dbs = FirebaseDatabase.getInstance();
            uid= FirebaseAuth.getInstance().getCurrentUser().getUid();
            rdbs = dbs.getReference("cardio");
            String date= DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
            String distance1 = Double.toString(Math.ceil(meters));
            String speed1=Double.toString(Math.ceil(runningSpeed));
            aerobic u=new aerobic(distance1,speed1,date);
            rdbs.child(uid).child(date).setValue(u);

            stopWatch = watch.getBase() - SystemClock.elapsedRealtime();
            watch.stop();

            sensorManager.unregisterListener(this);

        }
    }
    public class aerobic{
        String distance1, speed1,date;

        public aerobic(String distance, String speed,String date) {
            this.distance1 = distance;
            this.speed1 = speed;
            this.date=date;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDistance() {
            return distance1;
        }

        public void setDistance(String distance) {
            this.distance1 = distance;
        }

        public String getSpeed() {
            return speed1;
        }

        public void setSpeed(String speed) {
            this.speed1 = speed;
        }
    }

    public void resetValues() {    //to set all values to 0 initially

        watch.setBase(SystemClock.elapsedRealtime());
        meters = 0;
        steps = 0;
        runningSpeed = 0;

        distance.setText("0");
        stepsNumber.setText("0");
        speed.setText("0");
        calories.setText("0");
    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener((SensorEventListener) this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener((SensorEventListener) this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        deltaX = Math.abs(lastX - event.values[0]);
        deltaY = Math.abs(lastY - event.values[1]);
        deltaZ = Math.abs(lastZ - event.values[2]);


        // if the change is below 2, it is just noise
        if (deltaX > precision) {
            x.add((double) event.values[0]);
            lastX = event.values[0];
        } else {
            x.add(lastX);
        }
        if (deltaY > precision) {
            y.add((double) event.values[1]);
            lastY = event.values[1];
        } else {
            y.add(lastY);
        }
        if (deltaZ > precision) {
            z.add((double) event.values[2]);
            lastZ = event.values[2];
        } else {
            z.add(lastZ);
        }

        counter++;

        if (counter == 200) {
            if (System.currentTimeMillis() > startTime + 200) {
                walked = steps - oldSteps;
                startTime = System.currentTimeMillis();
                oldSteps = steps;

            }
            updateSteps();
            calculateData();
            counter = 0;

        }

    }

    public void calculateData() {

        // distance
        if (walked > 0 && walked < 2) {
            meters += height / 5.0;
        } else if (walked >= 2 && walked < 3) {
            meters += height / 4.0;
        } else if (walked >= 3 && walked < 4) {
            meters += height / 3.0;
        } else if (walked >= 4 && walked < 5) {
            meters += height / 2.0;
        } else if (walked >= 5 && walked < 6) {
            meters += height / 1.2;
        } else if (walked >= 6 && walked < 8) {
            meters += height;
        } else if (walked >= 8) {
            meters += height * 1.2;
        }

        // update speed
        runningSpeed = meters / (((System.currentTimeMillis() - startWatch) * 1000));
        speed.setText(Double.toString(Math.ceil(runningSpeed)));

        // update calories
        calories.setText(Double.toString(Math.ceil((runningSpeed * 3.6) * 1.25)));

        // update distance
        distance.setText(Double.toString(Math.ceil(meters)));

    }




    public void updateSteps() {

        // Filter Out the data
        for (int i = 0; i < 200; i += 4) {
            double sumX = 0, sumY = 0, sumZ = 0;
            for (int j = 0; j < 4 && i + j < 200; j++) {
                sumX += x.get(i + j);
                sumY += y.get(i + j);
                sumZ += z.get(i + j);
            }
            dataX.add(sumX / 4);
            dataY.add(sumY / 4);
            dataZ.add(sumZ / 4);

        }

        // clear the array list of input
        x.clear();
        y.clear();
        z.clear();

        // select the axis to work on
        int workingAxis = -1; // 0 = x, 1 = y, 2 = z

        double maxX = Collections.max(dataX), minX = Collections.min(dataX);
        double maxY = Collections.max(dataY), minY = Collections.min(dataY);
        double maxZ = Collections.max(dataZ), minZ = Collections.min(dataZ);

        double diffX = maxX - minX ;
        double diffY = maxY - minY;
        double diffZ = maxZ - minZ;

        double maxDiff = Math.max(diffX, Math.max(diffY, diffZ));

        if (maxDiff == diffX) {
            workingAxis = 0;
        } else if (maxDiff == diffY) {
            workingAxis = 1;
        } else if (maxDiff == diffZ) {
            workingAxis = 2;
        }

        // check how many steps now
        if (workingAxis == 0) {
            double average = (maxX + minX) / 2;
            for (int i = 0, j = 1; i < 49; i++, j++) {
                if (average > dataX.get(j) && average < dataX.get(i)) {
                    steps++;
                    displayCurrentsValues();
                }
            }

        } else if (workingAxis == 1) {
            double average = (maxY + minY) / 2;
            for (int i = 0, j = 1; i < 49; i++, j++) {
                if (average > dataY.get(j) && average < dataY.get(i)) {
                    steps++;
                    displayCurrentsValues();
                }
            }

        } else if (workingAxis == 2) {
            double average = (maxZ + minZ) / 2;
            for (int i = 0, j = 1; i < 49; i++, j++) {
                if (average > dataZ.get(j) && average < dataZ.get(i)) {
                    steps++;
                    displayCurrentsValues();
                }
            }

        } else {
            // error
        }

        // clear the array list of filter
        dataX.clear();
        dataY.clear();
        dataZ.clear();


    }


    public void displayCurrentsValues() {
        stepsNumber.setText(Integer.toString(steps));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }








    private void setSupportActionBar(Toolbar toolbar) {
    }
}
