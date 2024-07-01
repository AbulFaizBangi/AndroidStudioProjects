package com.example.registration_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerSubjects;
    private RadioButton radioMale, radioFemale;
    private CheckBox checkBoxQualification;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerSubjects = findViewById(R.id.spinnerSubjects);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        checkBoxQualification = findViewById(R.id.checkBoxQualification);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Populate the spinner with subjects
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.subjects_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubjects.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });
    }

    private void submitData() {
        String selectedSubject = spinnerSubjects.getSelectedItem().toString();
        String gender = radioMale.isChecked() ? "Male" : "Female";
        boolean hasQualification = checkBoxQualification.isChecked();

        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        intent.putExtra("selectedSubject", selectedSubject);
        intent.putExtra("gender", gender);
        intent.putExtra("hasQualification", hasQualification);
        startActivity(intent);
    }
}
