package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Stecibapp extends AppCompatActivity {
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stecibapp);

        cardView = (CardView) findViewById(R.id.b4);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGmailWithPrewrittenMessage();
            }
        });

    }

    public void openWhatsApp(View view) {
        Intent intent=new Intent(this,WhatsAppActivity.class);
        startActivity(intent);
    }
    public void openGmailWithPrewrittenMessage(){
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
        Intent intent=new Intent(this, UserDetailsSteci.class);
        startActivity(intent);
    }
    public void openFamilyView(View view){
        Intent intent=new Intent(this,FamilyView.class);
        startActivity(intent);
    }
    public void openUserReceipt(View view){
        Intent intent=new Intent(this,UserReceipt.class);
        startActivity(intent);
    }
    public void openPdf(View view){
        Intent intent=new Intent(this,pdf.class);
        startActivity(intent);
    }
    public void openFloatingButtonActivity(View view){
        Intent intent=new Intent(this,FloatingButtonActivity.class);
        startActivity(intent);
    }
    public void redirectToWhatsApp(View view){
        try {
            String text = "Hiiiii Helllooooo";// Replace with your message.
            String toNumber = "+919769148068"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your  phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}