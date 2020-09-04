package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;

public class WhatsAppActivity extends AppCompatActivity {
    EditText  Phone1,Phone2;
Button Button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app);
        Phone1 = findViewById(R.id.editTextPhone);
        Phone2 = findViewById(R.id.editTextPhone2);

        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        final String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        Phone2.setHint(currentDate+" "+currentTime);
        /*Button1 = findViewById(R.id.button3);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Button1.performClick();
            }
        }, 1000);*/


//11:12:13 on 15/03/2014

        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.MONTH,7);//because is started from 0
        cal.set(Calendar.YEAR,2020);
        cal.set(Calendar.DAY_OF_MONTH,18);
        cal.set(Calendar.HOUR_OF_DAY,16);
        cal.set(Calendar.MINUTE,48);

        //PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 1253, intent, PendingIntent.FLAG_UPDATE_CURRENT|  Intent.FILL_IN_DATA);


        Intent intent = new Intent(this, VicarsDeskDemo.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT|  Intent.FILL_IN_DATA);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent );

    }
    public void openWhatsApp(View view) {
        String text1 = Phone1.getText().toString();
        String text2 = Phone2.getText().toString();
        Intent intent1 = new Intent(Intent.ACTION_SENDTO);

        if(!text1.isEmpty() && !text2.isEmpty())
        {
            intent1.setData(Uri.parse("smsto:" + text1));
            intent1.setPackage("com.whatsapp");
            //startActivity(intent1);
        }
        else
        {
            if(text1.isEmpty())
            {
                Phone1.setError("Please enter correct mobile number");
            }
            if(text2.isEmpty())
            {
                Phone2.setError("Please enter correct mobile number");
            }
        }
    }
}