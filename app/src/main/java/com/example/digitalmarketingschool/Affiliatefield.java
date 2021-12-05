package com.example.digitalmarketingschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Affiliatefield extends AppCompatActivity {
    ImageButton button1, button2, button3, button4,button6,button7,button9,button10,button12,button44,button30,button0,button21;
    FirebaseAuth firebaseauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiliatefield);
        firebaseauth = FirebaseAuth.getInstance();
        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        ImageButton button3 = (ImageButton) findViewById(R.id.button3);
        ImageButton button4 = (ImageButton) findViewById(R.id.button4);
        ImageButton button5 = (ImageButton) findViewById(R.id.button5);
        ImageButton button6 = (ImageButton) findViewById(R.id.button6);
        button7 = (ImageButton) findViewById(R.id.button7);
        button9 = (ImageButton) findViewById(R.id.button9);
        button10 = (ImageButton) findViewById(R.id.button10);
        button12 = (ImageButton) findViewById(R.id.button11);
        button44 = (ImageButton) findViewById(R.id.button44);
        button30 = (ImageButton) findViewById(R.id.button30);
        button0 = (ImageButton) findViewById(R.id.button0);
        button21 = (ImageButton) findViewById(R.id.button20);



        final Context context = this;

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Whataffiliatemarketing.class);
                startActivity(intent);

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Niche.class);
                startActivity(intent);
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebHosting.class);
                startActivity(intent);
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(context, Contentmarketing.class);

                startActivity(intent);

            }

        });



        button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Blogging.class);
                        startActivity(intent);
                    }
                });
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, SEO.class);
                        startActivity(intent);
                    }
                });

                button44.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, LandingPage.class);
                        startActivity(intent);
                    }
                });

                button30.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Googleads1.class);
                        startActivity(intent);
                    }
                });

                button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, paidmarketing.class);
                        startActivity(intent);
                    }
                });
                button6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Socialmedia.class);
                        startActivity(intent);
                    }
                });

                button7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Backlinks.class);
                        startActivity(intent);


                    }
                });

                button9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Instagrammarketing.class);
                        startActivity(intent);

                    }
                });
                button10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Emailmarketing.class);
                        startActivity(intent);
                    }
                });
                button12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(context, Googlesitemap.class);
                        startActivity(intent);

                    }
                });
            }


                @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() ==(R.id.logout))
        {
            firebaseauth.signOut();
            startActivity(new Intent(Affiliatefield.this,Email.class));
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}

