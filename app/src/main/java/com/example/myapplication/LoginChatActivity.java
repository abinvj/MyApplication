package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginChatActivity extends AppCompatActivity {

    TextInputEditText textEmail, textPassword;
    ProgressBar progressBar;
    FirebaseAuth auth;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        auth=FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null){
            Intent i = new Intent (LoginChatActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
        else{
            setContentView(R.layout.activity_login_chat);

            textEmail=findViewById(R.id.email_ed_login);
            textPassword=findViewById(R.id.password_ed_login);
            progressBar = findViewById(R.id.mainProgressbar);
            reference = FirebaseDatabase.getInstance().getReference().child("Users");
        }

    }
    public void LoginUser(View view){

        progressBar.setVisibility(View.VISIBLE);
        String email = textEmail.getText().toString();
        String password = textPassword.getText().toString();

        if(!email.equals("") && !password.equals(""))
        {
            auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(),"Logged In", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginChatActivity.this, MainActivity.class));
                                finish();
                            }
                            else
                            {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(),"Wrong email/password. Try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else if (email.isEmpty() && password.isEmpty())
        {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(),"Enter email and password",Toast.LENGTH_SHORT).show();
        }
    }

    public void gotoRegistration(View view)
    {
        Intent i = new Intent(LoginChatActivity.this, RegisterChatActivity.class);
        startActivity(i);
    }

    public void forgotPassword(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(LoginChatActivity.this);

        LinearLayout container = new LinearLayout(LoginChatActivity.this);
        container.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams ip = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ip.setMargins(50,0,0,100);

        final EditText input = new EditText(LoginChatActivity.this);
        input.setLayoutParams(ip);
        input.setGravity(Gravity.TOP| Gravity.START);
        input.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        input.setLines(1);
        input.setMaxLines(1);

        container.addView(input,ip);

        alert.setMessage("Enter your registerd email address");
        alert.setTitle("Forgot Password");
        alert.setView(container);

        alert.setPositiveButton("submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialogInterface, int i) {
                String entered_email = input.getText().toString();

                auth.sendPasswordResetEmail(entered_email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    dialogInterface.dismiss();
                                    Toast.makeText(getApplicationContext(),"Email sent",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}