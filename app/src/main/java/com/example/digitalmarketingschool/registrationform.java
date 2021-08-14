package com.example.digitalmarketingschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class registrationform extends AppCompatActivity {
    TextInputEditText name, password, address, email;

    Button register;
    FirebaseAuth firebaseauth;
    FirebaseDatabase firebase;
    FirebaseUser firebaseuser;
    DatabaseReference databaseReference;
    private static final String USER = "user";
    private  static final String TAG = "registrationform";
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);
        connectxml();

        firebase= FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference(USER);
        firebaseauth = FirebaseAuth.getInstance();

        firebaseuser  = firebaseauth.getCurrentUser();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email_text = email.getText().toString().trim();
                String password_text = password.getText().toString().trim();
                String name_text = name.getText().toString().trim();


                user = new User(email_text, password_text, name_text);
                userregistration(email_text, password_text, name_text);
            }
        });
    }



    private void userregistration(String email_text, String password_text, String name_text) {
        firebaseauth.createUserWithEmailAndPassword(email_text,password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    firebaseauth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(registrationform.this, "Registration successful Please verify email address", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = firebaseauth.getCurrentUser();
                                updateUI(user);
                            } else {

                                Toast.makeText(registrationform.this, task.getException().getMessage(), Toast.LENGTH_SHORT);



                            }
                        }

                    });
                    String userid = firebaseauth.getCurrentUser().getUid();
                    databaseReference = FirebaseDatabase.getInstance().getReference("rules").child(userid);


                    HashMap<String,String> datauser = new HashMap<>();
                    datauser.put("userid",userid);
                    datauser.put("email",email_text);
                    datauser.put("password",password_text);
                    datauser.put("name",name_text);
                    databaseReference.setValue(datauser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {

                                startActivity(new Intent(registrationform.this,Email.class));
                                finish();

                            }else

                                Toast.makeText(registrationform.this,"error "+task.getException(), Toast.LENGTH_SHORT);
                            {




                            }

                        }
                    });
                    startActivity(new Intent(registrationform.this,Email.class));
                    finish();

                } else
                {
                    Toast.makeText(registrationform.this,"error "+task.getException(), Toast.LENGTH_SHORT);

                }

            }

            private void updateUI(FirebaseUser currentuser) {
                String KeyId = databaseReference.push().getKey();
                databaseReference.child(KeyId).setValue(user);
            }
        });
    }





    private void connectxml() {
        name = findViewById(R.id.nameid);
        address = findViewById(R.id.addressid);
        password = findViewById(R.id.passwordid);
        email = findViewById(R.id.emailid);
        register = findViewById(R.id.registration);




    }
}



