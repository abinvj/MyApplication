package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(new PreferenceManager(this).checkPreference())
        {
            openLoginActivity();
        }

        final EditText emailId=(EditText)findViewById(R.id.email);
        final EditText password=(EditText)findViewById(R.id.password);

        emailId.getText();
        password.getText();

        final CardView b4 = (CardView)findViewById(R.id.login);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    openLoginActivity();
                }
            }
        });
    }
    public void openLoginActivity()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}