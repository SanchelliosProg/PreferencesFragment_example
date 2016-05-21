package com.templates.sanchellios.countries.views;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

import com.templates.sanchellios.countries.R;

/**
 * Created by aleksandrvasilenko on 18.05.16.
 */
public class Preferences extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getFragmentManager().findFragmentById(android.R.id.content)==null){
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content, new DisplayPrefs())
                    .commit();
        }
    }

    public static class DisplayPrefs extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.main_screen_pref);
        }
    }
}
