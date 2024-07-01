package com.example.pract7;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pract7.R;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        String selectedSubject = getIntent().getStringExtra("selectedSubject");
        String selectedGender = getIntent().getStringExtra("selectedGender");
        String selectedQualifications = getIntent().getStringExtra("selectedQualifications");

        TextView textViewSubject = findViewById(R.id.textViewSubject);
        TextView textViewGender = findViewById(R.id.textViewGender);
        TextView textViewQualifications = findViewById(R.id.textViewQualifications);

        textViewSubject.setText("Selected Subject: " + selectedSubject);
        textViewGender.setText("Selected Gender: " + selectedGender);
        textViewQualifications.setText("Selected Qualifications: " + selectedQualifications);
    }
}
