package com.example.fallen_prototype3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class forgot_password extends AppCompatActivity {


    private Button forgot_password_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);



       activate_button();
    }




    public void activate_button(){

        forgot_password_button = findViewById(R.id.forgot_password_button);
        forgot_password_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(forgot_password.this, "Request Sent", Toast.LENGTH_SHORT).show();
            }
        });

    }


}






