package com.example.fallen_prototype3;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class CustomPopupDialog extends Dialog {

    private Button closeButton, join_button;

    public CustomPopupDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_layout);

        join_button = findViewById(R.id.join_button);
        closeButton = findViewById(R.id.close_button);

        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the activity when the "Join" button is clicked
                Intent intent = new Intent(getContext(), shopping_cart.class);
                intent.putExtra("itemName", "FALLEN+ Membership");
                intent.putExtra("itemPrice", 100.0);
                intent.putExtra("itemQuantity", 1);
                getContext().startActivity(intent);
                dismiss(); // Close the popup after starting the activity
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
