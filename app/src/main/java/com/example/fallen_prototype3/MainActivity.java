package com.example.fallen_prototype3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;



    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.un_tv); // Replace with actual ID of the username EditText
        password = findViewById(R.id.pw_tv); // Replace with actual ID of the password EditText

        logo = findViewById(R.id.fallen_logo);
        set_menu_buttons();
    }

    public boolean admin_sign_in() {
        String accepted_username = "relegated";
        String accepted_password = "password";

        String enteredUsername = username.getText().toString().trim();
        String enteredPassword = password.getText().toString().trim();

        return accepted_username.equals(enteredUsername) && accepted_password.equals(enteredPassword);
    }

    public void set_menu_buttons() {
        Button login_button = findViewById(R.id.sign_in);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUsername = username.getText().toString().trim();
                String enteredPassword = password.getText().toString().trim();

                if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                } else if (admin_sign_in()) {
                    Toast.makeText(MainActivity.this, "Signed in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, signed_in_menu.class));
                } else {
                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView forgotPasswordLink = findViewById(R.id.forgot_password);
        forgotPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, forgot_password.class));
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] quotes = {
                        "You are what you create",
                        "Be the best version of yourself",
                        "Dream big, work hard",
                        "Innovate and inspire",
                        "Success starts with a single step",
                        "Embrace challenges, they make you stronger",
                        "Create your own path to greatness",
                        "Believe in your abilities",
                        "Keep going, even when it's tough",
                        "Strive for progress, not perfection",
                        "Make today amazing",
                        "Your only limit is you"
                };

                // Generate a random quote index
                Random random = new Random();
                int randomQuoteIndex = random.nextInt(quotes.length);

                // Get the random quote
                String randomQuote = quotes[randomQuoteIndex];

                // Display the random quote in a Toast
                Toast.makeText(MainActivity.this, randomQuote, Toast.LENGTH_SHORT).show();
            }
        });






    }
}