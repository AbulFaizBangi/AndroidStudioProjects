package com.example.sppuadmissionapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sppuadmissionapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdmission = findViewById(R.id.buttonAdmission);
        buttonAdmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAdmissionDialog();
            }
        });
    }

    private void showAdmissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Admission Form");

        // Set up the input
        final EditText inputName = new EditText(this);
        inputName.setHint("Enter Your Name");
        builder.setView(inputName);

        // Set up the buttons
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = inputName.getText().toString();
                // Handle the input
                showPopupMenu(name);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void showPopupMenu(String name) {
        PopupMenu popupMenu = new PopupMenu(this, findViewById(R.id.buttonAdmission));
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.subject1) {
                    // Handle subject 1 selection
                    return true;
                } else if (item.getItemId() == R.id.subject2) {
                    // Handle subject 2 selection
                    return true;
                }
                return false;
            }
        });

        popupMenu.show();
    }

}
