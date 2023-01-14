package com.example.uas_0017orientation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DataSensor extends AppCompatActivity {
    String attr[] = {
            "Data Sensor : ",
            "Data Sensor : ",
            "Data Sensor : ",
    };

    String val[] = {
            "Putar Kanan",
            "Putar Kiri",
            "Putar Kanan",
    };

    ListView l;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_sensor);
        l = findViewById(R.id.data);
        DataSensor.AdapterProfile adapter = new DataSensor.AdapterProfile(this, attr, val);
        l.setAdapter((DataSensor.AdapterProfile) adapter);

    }

    private class AdapterProfile extends ArrayAdapter {
        String attr[];
        String val[];
        Activity activity;

        //konstruktor
        public AdapterProfile(DataSensor DataSensor, String[] attr, String[] val) {
            super(DataSensor, R.layout.list_about_me, attr);
            this.attr = attr;
            activity = DataSensor;
            this.val = val;

        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // panggil layout list
            LayoutInflater inflater = (LayoutInflater) activity.getLayoutInflater();
            View v = inflater.inflate(R.layout.list_about_me, null);
            // kenalkan widget yang ada pada list
            TextView attr1;
            TextView val1;

            //casting widget id
            attr1 = (TextView) v.findViewById(R.id.attribute);
            val1 = (TextView) v.findViewById(R.id.ket_kompetensi);


            // set data kedalam image
            attr1.setText(attr[position]);
            val1.setText(val[position]);


            return v;
        }
    }

}
