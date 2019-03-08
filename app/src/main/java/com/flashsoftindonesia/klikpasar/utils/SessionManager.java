package com.flashsoftindonesia.klikpasar.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private Context context;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "klikpasar_preference";
    private static final String KEY_IS_FIRST = "isFirst";
    public SessionManager(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);

    }
    public void setFirstLaunch(boolean isFirst){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_IS_FIRST, isFirst);
        editor.apply();
    }
    public boolean isFirstLaunch(){
        return  sharedPreferences.getBoolean(KEY_IS_FIRST,true);
    }

}
