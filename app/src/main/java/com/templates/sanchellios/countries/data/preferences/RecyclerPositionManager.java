package com.templates.sanchellios.countries.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by aleksandrvasilenko on 12.05.16.
 */
public class RecyclerPositionManager {
    public static String RECYCLER_POSITION = "RECYCLER_POSITION";
    public static String POSITION = "POSITION";
    private SharedPreferences positionPref;
    private SharedPreferences.Editor editor;


    public RecyclerPositionManager(Context context){
        positionPref = context.getSharedPreferences(RECYCLER_POSITION, 0);
        editor = positionPref.edit();
    }

    public int getPosition(){
        return positionPref.getInt(POSITION, 0);
    }

    public void savePosition(int position){
        editor.putInt(POSITION, position);
        editor.apply();
    }

    public void resetPosition(){
        editor.putInt(POSITION, 0);
        editor.apply();
    }
}
