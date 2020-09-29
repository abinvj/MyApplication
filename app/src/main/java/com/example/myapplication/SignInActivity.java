package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;

    private FirebaseAuth auth;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        if(new PreferenceManagertwo(this).checkPreferencetwo())
        {
            startActivity(new Intent(SignInActivity.this, AddData.class));
            finish();
        }

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        CardView login = findViewById(R.id.login);
        TextView register =findViewById(R.id.registration);

        auth= FirebaseAuth.getInstance();
    }

    public void onLogin(View view) {
        String txt_email = email.getText().toString();
        String txt_password =password.getText().toString();
        if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
            Snackbar.make(view, "Empty Credentials!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            //Toast.makeText(SignInActivity.this,"Empty Credentials!",Toast.LENGTH_SHORT).show();
        }
        else
            loginUser(txt_email, txt_password);
        new PreferenceManagertwo(this).writePreferencetwo();
    }

    private void loginUser(String email, String password) {
    auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
        @Override
        public void onSuccess(AuthResult authResult) {
            Toast.makeText(SignInActivity.this,"LogIn Successful!",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignInActivity.this,AddData.class));
            finish();
        }
    });
    }
    public void redirectToRegistration(View view)
    {
        startActivity(new Intent(SignInActivity.this, RegisterActivity.class));
    }
}