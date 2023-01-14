package com.example.uas_0017orientation;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.uas_0017orientation.databinding.ActivityMainBinding;

import android.view.Menu;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor orientationSensor;
    private final float[] accelerometerReading = new float[3];
    private final float[] magnetometerReading = new float[3];

    private final float[] rotationMatrix = new float[9];
    private final float[] orientationAngles = new float[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sensor = findViewById(R.id.sensor);
        Button about = findViewById(R.id.about);

        sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DataSensor = new Intent(MainActivity.this,DataSensor.class);
                startActivity(DataSensor);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DataSensor = new Intent(MainActivity.this,AboutMe.class);
                startActivity(DataSensor);
            }
        });

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        orientationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        if (orientationSensor != null) {
            sensorManager.registerListener(this, orientationSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            // Show message or do something else
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
            String Putar = null;
            float azimuth = event.values[0];
            float pitch = event.values[1];
            float roll = event.values[2];
            if(event.values[2]>0){
                Putar = "Putar Kiri";
            }
            else if(event.values[2]<0){
                Putar = "Putar Kanan";
            }
            // Do something with the sensor values, for example update TextView

            TextView rollValue = findViewById(R.id.roll_value);
            rollValue.setText("Roll: " + Putar);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }




}