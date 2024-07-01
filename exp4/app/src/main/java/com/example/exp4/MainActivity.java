package com.example.exp4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button implicitIntentButton = findViewById(R.id.implicitIntentButton);
        Button explicitIntentButton = findViewById(R.id.explicitIntentButton);
        Button toastButton = findViewById(R.id.toastButton);

        // Implicit Intent Example
        implicitIntentButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

        // Explicit Intent Example
        explicitIntentButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ExplicitIntentActivity.class);
            startActivity(intent);
        });

        // Toast Example
        toastButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "This is a Toast!", Toast.LENGTH_SHORT).show();
        });
    }
}
