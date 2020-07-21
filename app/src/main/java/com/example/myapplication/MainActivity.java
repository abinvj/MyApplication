package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*Button b4 = (Button)findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           openGmailWithPrewrittenMessage();
            }
        });*/
    }

    public void openWhatsApp(View view) {
        Intent intent1 = new Intent(Intent.ACTION_SENDTO);
        intent1.setData(Uri.parse("smsto: 9769148068"));
        intent1.setPackage("com.whatsapp");
        startActivity(intent1);
    }
    public void openGmailWithPrewrittenMessage(View view){
        Intent intent=new Intent(this,GmailWithPreWrittenMessage.class);
        startActivity(intent);
    }
    public void openVicarsDewskDemo(View view){
        Intent intent=new Intent(this,VicarsDeskDemo.class);
        startActivity(intent);
    }
    public void openAboutUsDemo(View view){
        Intent intent=new Intent(this,AboutUsDemo.class);
        startActivity(intent);
    }
    public void openUserDetails(View view){
        Intent intent=new Intent(this,UserDetails.class);
        startActivity(intent);
    }
    public void openFamilyView(View view){
        Intent intent=new Intent(this,FamilyView.class);
        startActivity(intent);
    }
   public void redirectToWhatsApp(View view){
       try {
           String text = "Hiiiii Helllooooo";// Replace with your message.
           String toNumber = "+919769148068"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
           //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.

           Intent intent = new Intent(Intent.ACTION_VIEW);
           intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ toNumber +"&text="+text));
           startActivity(intent);
       }
       catch (Exception e){
           e.printStackTrace();
       }
   }
}