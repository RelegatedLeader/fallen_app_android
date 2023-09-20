package com.example.fallen_prototype3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class shopping_cart extends AppCompatActivity {

    private Button pay_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);


        //set buttons
        set_buttons();


        // Retrieve data from the intent
        Intent intent = getIntent();
        String itemName = intent.getStringExtra("itemName");
        double itemPrice = intent.getDoubleExtra("itemPrice", 0.0);
        int itemQuantity = intent.getIntExtra("itemQuantity", 0);

        TextView itemNameTextView = findViewById(R.id.itemNameTextView);
        TextView itemPriceTextView = findViewById(R.id.itemPriceTextView);
        TextView itemQuantityTextView = findViewById(R.id.itemQuantityTextView);
        TextView totalPriceTextview = findViewById(R.id.total);

        if (itemName != null && itemPrice > 0 && itemQuantity > 0) {
            // Update the UI to display the received item details
            itemNameTextView.setText("Item Name: " + itemName);
            itemPriceTextView.setText("Price: $" + itemPrice);
            itemQuantityTextView.setText("Quantity: " + itemQuantity);
            totalPriceTextview.setText("$100");
        } else {
            // Handle the case where data is missing or invalid
            itemNameTextView.setText("Item Name: N/A");
            itemPriceTextView.setText("Price: $0.00");
            itemQuantityTextView.setText("Quantity: 0");

        }
    }

    public void set_buttons(){
        pay_button = findViewById(R.id.pay_button);
        pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will create another popup or activity that will ask the user to enter their credit card information
                //note that FOR GUESTS, they will have to do this every time!
                //you may want to create

                //test
                Toast.makeText(shopping_cart.this, "Testing..", Toast.LENGTH_SHORT).show();
            }
        });
    }



}