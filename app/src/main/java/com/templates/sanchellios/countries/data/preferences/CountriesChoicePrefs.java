package com.templates.sanchellios.countries.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

import static com.templates.sanchellios.countries.country.ContinentConst.AFRICA;
import static com.templates.sanchellios.countries.country.ContinentConst.ASIA;
import static com.templates.sanchellios.countries.country.ContinentConst.AUSTRALIA_AND_OCEANIA;
import static com.templates.sanchellios.countries.country.ContinentConst.EUROPE;
import static com.templates.sanchellios.countries.country.ContinentConst.NORTH_AMERICA;
import static com.templates.sanchellios.countries.country.ContinentConst.SOUTH_AMERICA;

/**
 * Created by aleksandrvasilenko on 18.05.16.
 */
public class CountriesChoicePrefs {
    public static final String IS_AFRICA_ENABLED = "enableAfrica";
    public static final String IS_EUROPE_ENABLED = "enableEurope";
    public static final String IS_ASIA_ENABLED = "enableAsia";
    public static final String IS_AUSTRALIA_ENABLED = "enableAustralia";
    public static final String IS_N_AMERICA_ENABLED = "enableNAmerica";
    public static final String IS_S_AMERICA_ENABLED = "enableSAmerica";
    private SharedPreferences preferences = null;

    public CountriesChoicePrefs(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public HashMap<String, Boolean> getCountryStatuses(){
        HashMap<String, Boolean> statuses = new HashMap<>();
        statuses.put(AFRICA, getAfricaStatus());
        statuses.put(ASIA, getAsiaStatus());
        statuses.put(EUROPE, getEuropeStatus());
        statuses.put(AUSTRALIA_AND_OCEANIA, getAustraliaStatus());
        statuses.put(NORTH_AMERICA, getNorthAmericaStatus());
        statuses.put(SOUTH_AMERICA, getSouthAmericaStatus());
        return statuses;
    }

    private boolean getAfricaStatus(){
        return preferences.getBoolean(IS_AFRICA_ENABLED, true);
    }

    private boolean getEuropeStatus(){
        return preferences.getBoolean(IS_EUROPE_ENABLED, true);
    }

    private boolean getAsiaStatus(){
        return preferences.getBoolean(IS_ASIA_ENABLED, true);
    }

    private boolean getAustraliaStatus(){
        return preferences.getBoolean(IS_AUSTRALIA_ENABLED, true);
    }

    private boolean getNorthAmericaStatus(){
        return preferences.getBoolean(IS_N_AMERICA_ENABLED, true);
    }

    private boolean getSouthAmericaStatus(){
        return preferences.getBoolean(IS_S_AMERICA_ENABLED, true);
    }
}
