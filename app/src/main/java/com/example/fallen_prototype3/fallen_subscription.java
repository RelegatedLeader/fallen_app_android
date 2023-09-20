package com.example.fallen_prototype3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fallen_subscription extends AppCompatActivity {
    private Button showPopupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fallen_subscription);

        showPopupButton = findViewById(R.id.join_fallen);

        showPopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomPopupDialog customDialog = new CustomPopupDialog(fallen_subscription.this);
                customDialog.show();

            }
        });
    }
}