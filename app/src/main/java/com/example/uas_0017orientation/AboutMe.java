package com.example.uas_0017orientation;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AboutMe extends AppCompatActivity {
    String attr[] = {
            "Prodi :",
            "Email :",
            "No Telp :",
    };

    String val[] = {
            "Teknik Informatika",
            "ajifahrozi20@gmail.com",
            "081226488675",
    };

    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        l = findViewById(R.id.list);
        AboutMe.AdapterProfile adapter = new AboutMe.AdapterProfile(this, attr, val);
        l.setAdapter((AboutMe.AdapterProfile) adapter);

    }

    private class AdapterProfile extends ArrayAdapter {
        String attr[];
        String val[];
        Activity activity;

        //konstruktor
        public AdapterProfile(AboutMe aboutMe, String[] attr, String[] val) {
            super(aboutMe, R.layout.list_about_me, attr);
            this.attr = attr;
            activity = aboutMe;
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
