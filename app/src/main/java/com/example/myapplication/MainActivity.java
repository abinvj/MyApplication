package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String currentDateTimeString = java.text.DateFormat.getDateInstance().format(new Date());

        // textView is the TextView view that should display it
        TextView datetextView = findViewById(R.id.datetextview);
        datetextView.setText(currentDateTimeString);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.signOut:
                finish();
                signOut();
                break;
            case R.id.addData:
                startActivity(new Intent(MainActivity.this, AddData.class));
        }
        return super.onOptionsItemSelected(item);
    }
    public void openSteciBApp(View view) {
        Intent intent=new Intent(this,Stecibapp.class);
        startActivity(intent);
    }
    public void openCalneder(View view) {
        Intent intent=new Intent(this,Calender.class);
        startActivity(intent);
    }
    public void signOut(){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();

        finish();
        new PreferenceManager(this).clearPreference();
        startActivity(new Intent(MainActivity.this, SignInActivity.class));

    }
}