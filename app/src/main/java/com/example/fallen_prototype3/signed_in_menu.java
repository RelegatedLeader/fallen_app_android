package com.example.fallen_prototype3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class signed_in_menu extends AppCompatActivity {

    private ImageView logo,cart;
    private TextView for_you, new_products,FALLEN;

    private VideoView video;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in_menu);

        // Initialize views correctly by finding them using findViewById
        logo = findViewById(R.id.breadcrumb_logo);
        cart = findViewById(R.id.shopping_cart);
        for_you = findViewById(R.id.breadcrumb_for_you);
        new_products= findViewById(R.id.breadcrumb_newProducts);
        FALLEN = findViewById(R.id.breadcrumb_FALLEN);

        video = findViewById(R.id.videoView);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (vibrator.hasVibrator()) {
                    // Vibrate for 100 milliseconds (adjust the duration as needed)
                    vibrator.vibrate(80);
                }

                showPopupMenu(view);

            }
        });
cart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
    Intent intent = new Intent(signed_in_menu.this, shopping_cart.class);
    startActivity(intent);
    }
});
        // Call the method to set up click listeners for other TextViews
        setupTextViewClickListeners();


        turn_video_on();
        set_cart_button(); //set the cart button
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_dropdown, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.menu_item_settings) {


                    startActivity(new Intent(signed_in_menu.this, settings.class));

                } else {

                }
                return false;
            }
        });

        popupMenu.show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void setupTextViewClickListeners() {
        // Set up click listeners for other TextViews here and define their behavior
        for_you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Define behavior for the "About Us" TextView click
            }
        });

        new_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signed_in_menu.this, new_products.class);
                startActivity(intent);
            }
        });

        FALLEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Define behavior for the "Contact" TextView click
            }
        });




    }


    public void turn_video_on() {
        // Initialize the VideoView
        video = findViewById(R.id.videoView);

        // Set the video URI (replace "R.raw.future_video1" with your actual video resource)
        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.future_video1));

        // Set a listener to mute the video when it's prepared
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f, 0f); // Set volume to 0 (mute)
                video.start(); // Start playing the video
            }
        });

        // Set a listener to restart the video when it reaches the end (looping)
        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Restart the video from the beginning
                video.seekTo(0);
                video.start();
            }
        });
    }


    public void set_cart_button(){
        FALLEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(signed_in_menu.this, fallen_subscription.class));
            }
        });
    }


}