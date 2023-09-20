package com.example.fallen_prototype3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {


    private Button sign_up_button;
    private EditText password, same_password,first_name,last_name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        activate_buttons();


    }


    public void activate_buttons(){
        sign_up_button=  findViewById(R.id.sign_up_button);

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean same_password = checkPassword();
                Boolean filled_fields = check_for_empty_fields(); // if true, we'll let the user proceed
                if(same_password && filled_fields){
                    startActivity(new Intent(sign_up.this, signed_in_menu.class));
                    Toast.makeText(sign_up.this, "Welcome Eagle!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public boolean checkPassword() {
        password = findViewById(R.id.password_ev);
        same_password = findViewById(R.id.same_password_ev);

        // Store them in strings to compare.
        String password_ = password.getText().toString();
        String confirmPassword = same_password.getText().toString();

        if (password_.isEmpty() || confirmPassword.isEmpty()) {
            // Both password fields are empty, display an error.
            Toast.makeText(this, "Please fill in both password fields.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password_.equals(confirmPassword)) {
            // Passwords match.
            return true;
        } else {
            // Passwords don't match.
            Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }





    public boolean check_for_empty_fields() {
        EditText firstName = findViewById(R.id.firstname_ev);
        EditText lastName = findViewById(R.id.lastname_ev);
        EditText email = findViewById(R.id.email_ev);

        String firstNameText = firstName.getText().toString();
        String lastNameText = lastName.getText().toString();
        String emailText = email.getText().toString();

        //use .isEmpty or .equals(""), dont use == "" in Java
        if (firstNameText.isEmpty() || lastNameText.isEmpty() || emailText.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }





}