package com.example.registration_application;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView textViewSubject = findViewById(R.id.textViewSubject);
        TextView textViewGender = findViewById(R.id.textViewGender);
        TextView textViewQualification = findViewById(R.id.textViewQualification);

        String selectedSubject = getIntent().getStringExtra("selectedSubject");
        String gender = getIntent().getStringExtra("gender");
        boolean hasQualification = getIntent().getBooleanExtra("hasQualification", false);

        textViewSubject.setText("Subject: " + selectedSubject);
        textViewGender.setText("Gender: " + gender);
        textViewQualification.setText("Has Qualification: " + (hasQualification ? "Yes" : "No"));
    }
}
