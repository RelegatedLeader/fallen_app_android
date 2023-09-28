package com.example.fallen_prototype3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class settings extends AppCompatActivity {

    private TextView signOut, accountSettings, payment_settings,your_orders,fallen_membership,custom_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize the TextViews
        signOut = findViewById(R.id.sign_out);
        accountSettings = findViewById(R.id.account_settings);
        payment_settings = findViewById(R.id.payment_settings);
        your_orders = findViewById(R.id.your_orders);
        fallen_membership = findViewById(R.id.fallen_membership);
        custom_settings = findViewById(R.id.custom_settings);

        setupOptionClickListeners();

        // Activate the sign-out functionality
        activateSignOut();
    }

    private void setupOptionClickListeners() {
        accountSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment dialogFragment = new MyDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "MyDialogFragment");



                // Handle the Account Settings option click
                //showFragment(new account_settings());
            }




        });


        payment_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payment_settings paymentSettings = new payment_settings();
                paymentSettings.show(getSupportFragmentManager(), "payment_settings");
            }
        });


        your_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                your_orders yourOrders = new your_orders();
                yourOrders.show(getSupportFragmentManager(), "your_orders");
            }
        });

        fallen_membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fallen_membership fallenMembership = new fallen_membership();
                fallenMembership.show(getSupportFragmentManager(),"fallen_membership");
            }
        });


        custom_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_settings customSettings = new custom_settings();
                customSettings.show(getSupportFragmentManager(), "custom_settings");
            }
        });


    }

   /* private void showFragment(Fragment fragment) {
        // Replace the contents of the fragment_container with the specified fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null); // Optionally add to the back stack
        transaction.commit();
    }
*/
    private void activateSignOut() {
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the MainActivity when sign out is clicked
                startActivity(new Intent(settings.this, MainActivity.class));
                finish(); // Finish the SettingsActivity to prevent going back to it from the MainActivity
            }
        });
    }
}
