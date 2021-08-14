package com.example.digitalmarketingschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Email extends AppCompatActivity {

    TextInputEditText enteremail, enterpassword;

    Button loginbutton, sighnup,forgot_password;
    FirebaseAuth firebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        enteremail = findViewById(R.id.email);
        enterpassword = findViewById(R.id.password);
        loginbutton = findViewById(R.id.Button);
        sighnup = findViewById(R.id.Sighnup);
        forgot_password= findViewById(R.id.forg);

        firebaseauth = FirebaseAuth.getInstance();
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Email.this, forgotpassword.class));
            }
        });
        sighnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Email.this, registrationform.class));


            }
        });


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_text = enteremail.getText().toString().trim();
                String password_text = enterpassword.getText().toString().trim();
                if (TextUtils.isEmpty(email_text)) {
                    enteremail.setError("Please Enter Your Email");
                } else if (TextUtils.isEmpty(password_text)) {
                    enterpassword.setError("Please Enter your Password");
                } else {
                    loginuser(email_text, password_text);
                }

            }
        });
    }

    private void loginuser(String email_text, String password_text) {
        firebaseauth.signInWithEmailAndPassword(email_text, password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    if (firebaseauth.getCurrentUser().isEmailVerified()) {
                        startActivity(new Intent(Email.this, Affiliatefield.class));
                    } else {
                        Toast.makeText(Email.this, "Please verify the email", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Email.this, "Please verify the email", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
