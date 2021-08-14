package com.example.digitalmarketingschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {
    TextInputEditText change;
    Button cha;
    FirebaseAuth firebaseauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        change = findViewById(R.id.change);
        cha = findViewById(R.id.cha);

        firebaseauth = FirebaseAuth.getInstance();
        cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });

    }

    private void resetPassword() {
        String Email = change.getText().toString().trim();

        if (Email.isEmpty()) {
            change.setError("Please enter email");
            change.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            change.setError("Please enter email");
            change.requestFocus();
            return;


        }

        firebaseauth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(forgotpassword.this, "Check email to reset your password", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(forgotpassword.this, "Please try again something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

