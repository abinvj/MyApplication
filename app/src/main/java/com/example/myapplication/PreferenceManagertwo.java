package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManagertwo {
    private Context context;
    private SharedPreferences sharedPreferences;

    public PreferenceManagertwo(Context context)
    {
        this.context=context;
        getSharedPreference();
    }

    private void getSharedPreference()
    {
        sharedPreferences=context.getSharedPreferences(context.getString(R.string.my_preference_key),Context.MODE_PRIVATE);
    }

    public void writePreferencetwo()
    {
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(context.getString(R.string.my_preference_key),"INIT_OK");
        editor.commit();
    }
    public boolean checkPreferencetwo()
    {
        boolean status = false;
        if(sharedPreferences.getString(context.getString(R.string.my_preference_key),"null").equals("null"))
        {
            status=false;
        }
        else
        {
            status=true;
        }
        return status;
    }
    public void clearPreferencetwo()
    {
        sharedPreferences.edit().clear().commit();
    }
}
