package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class FloatingButtonActivity extends AppCompatActivity {

    private FloatingActionButton fab_main, fab1_mail, fab2_whatsapp;
    private Animation fab_open, fab_close, fab_clock, fab_anticlock;
    TextView textview_mail, textview_whatsapp;

    Boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_button);

        fab_main = findViewById(R.id.fab);
        fab1_mail = findViewById(R.id.fab1);
        fab2_whatsapp = findViewById(R.id.fab2);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close_animation);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open_animation);
        fab_clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock);
        fab_anticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anticlock);

        textview_mail = (TextView) findViewById(R.id.textview_mail);
        textview_whatsapp = (TextView) findViewById(R.id.textview_share);

        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen) {

                    textview_mail.setVisibility(View.INVISIBLE);
                    textview_whatsapp.setVisibility(View.INVISIBLE);
                    fab2_whatsapp.startAnimation(fab_close);
                    fab1_mail.startAnimation(fab_close);
                    fab_main.startAnimation(fab_anticlock);
                    fab2_whatsapp.setClickable(false);
                    fab1_mail.setClickable(false);
                    isOpen = false;
                } else {
                    textview_mail.setVisibility(View.VISIBLE);
                    textview_whatsapp.setVisibility(View.VISIBLE);
                    fab2_whatsapp.startAnimation(fab_open);
                    fab1_mail.startAnimation(fab_open);
                    fab_main.startAnimation(fab_clock);
                    fab2_whatsapp.setClickable(true);
                    fab1_mail.setClickable(true);
                    isOpen = true;
                }

            }
        });


        fab2_whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "Dear Name,\n" +
                        "Receipt of amount ₹1234 has been generated on 23/08/20.\n" +
                        "To view detailed receipt, kindly check our Iglesia application.\n"+"Thank you for your contribution.\n"+"God bless you.\n\n" +
                        "Regards,\n" +
                        "Shirley Jobby\n"+"(Treasurer)";// Replace with your message.
                String toNumber = "+919769148068"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
                //Suppose your country is India and your  phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ toNumber +"&text="+text));
                startActivity(intent);
            }
        });

        fab1_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }
    public void sendEmail()
    {
        try
        {
            String message = "Dear Name,\n" +
                    "Receip of amount ₹1234 has been generated on 23/08/20.\n" +
                    "To view detailed receipt, kindly check our Iglesia application.\n"+"Thank you for your contribution.\n"+"God bless you.\n\n" +
                    "Regards,\n" +
                    "Shirley Jobby\n"+"(Treasurer)";
            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "abinvjacob20@gmail.com" });
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"STECI Bhandup - Receipt");
            emailIntent.setPackage("com.google.android.gm");
            //emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://"+"/storage/emulated/0/Download/Demo.jpg"));
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
            this.startActivity(Intent.createChooser(emailIntent,"Sending email..."));
        }
        catch (Throwable t)
        {
            Toast.makeText(this, "Request failed try again: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }
}