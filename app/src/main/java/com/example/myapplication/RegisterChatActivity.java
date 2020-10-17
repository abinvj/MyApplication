package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterChatActivity extends AppCompatActivity {
    Context context = this;
    TextInputEditText textEmail, textPassword, textName;
    TextView termsandCondition;
    CheckBox checkBox;
    CardView submit;
    ProgressBar progressBar;
    DatabaseReference reference;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_chat);

        textEmail = findViewById(R.id.email_ed_register);
        textPassword = findViewById(R.id.password_ed_register);
        textName = findViewById(R.id.name_ed_register);
        checkBox = findViewById(R.id.check);
        termsandCondition = findViewById(R.id.termsandcondition);
        termsandCondition.setPaintFlags(termsandCondition.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        submit = findViewById(R.id.submit);
        progressBar = findViewById(R.id.mainProgressbar);


        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("Users");

        termsandCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("TERMS AND CONDITION");
                alertDialog.setMessage("There are no Terms and Conditions. Those are few Cliche things. Ignore. :D");
                alertDialog.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        checkBox.setChecked(true);
                    }
                });
                alertDialog.setNegativeButton("Reject", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                AlertDialog alert = alertDialog.create();
                alert.setCanceledOnTouchOutside(true);
                alert.show();
            }
        });

    }

    public void RegisterUser(View view)
    {
        progressBar.setVisibility(View.VISIBLE);
        final String email = textEmail.getText().toString();
        final String password = textPassword.getText().toString();
        final String name = textName.getText().toString();

        if (!email.equals("") && !password.equals("") && password.length()>6)
        {
            auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                progressBar.setVisibility(View.GONE);
                                //Insert Values In Database

                                FirebaseUser firebaseUser = auth.getCurrentUser();

                                User u = new User();
                                u.setName(name);
                                u.setEmail(email);

                                reference.child(firebaseUser.getUid()).setValue(u)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful())
                                                {
                                                    Toast.makeText(getApplicationContext(),"User Registered Successfully",Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(RegisterChatActivity.this, MainActivity.class));
                                                    finish();
                                                }
                                                else
                                                {
                                                    Toast.makeText(getApplicationContext(),"User could not be created",Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            }
                        }
                    });
        }
        else if (!checkBox.isChecked())
        {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "Please accept our terms and conditions", Toast.LENGTH_SHORT).show();
        }
        else
        {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "Password should have more than 6 characters", Toast.LENGTH_SHORT).show();
        }
    }

    public void gotoLogin(View view)
    {
        startActivity(new Intent(RegisterChatActivity.this, LoginChatActivity.class));
    }
}