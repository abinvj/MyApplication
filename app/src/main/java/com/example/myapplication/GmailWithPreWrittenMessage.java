package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GmailWithPreWrittenMessage extends AppCompatActivity {

    Button Send;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail_with_pre_written_message);

        Send = (Button) findViewById(R.id.bt_send);
        //send button listener
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }
    public void sendEmail()
    {
        try
        {
            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "abcd" });
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"subject");
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