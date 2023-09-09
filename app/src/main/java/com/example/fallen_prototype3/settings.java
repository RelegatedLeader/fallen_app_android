package com.example.fallen_prototype3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class settings extends AppCompatActivity {

    private TextView sign_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize the TextView
        sign_out = findViewById(R.id.sign_out);

        activate_sign_out();
    }

    public void activate_sign_out() {
        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the MainActivity when sign out is clicked
                startActivity(new Intent(settings.this, MainActivity.class));
            }
        });
    }
}
