package com.example.registrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pract7.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerSubjects = findViewById(R.id.spinnerSubjects);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.subjects_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubjects.setAdapter(adapter);

        Button submitButton = findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the form submission
                String selectedSubject = spinnerSubjects.getSelectedItem().toString();
                String selectedGender = "";
                RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
                int selectedId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton radioButtonGender = findViewById(selectedId);
                selectedGender = radioButtonGender.getText().toString();

                List<String> qualifications = new ArrayList<>();
                CheckBox checkBoxQualification1 = findViewById(R.id.checkBoxQualification1);
                CheckBox checkBoxQualification2 = findViewById(R.id.checkBoxQualification2);
                if (checkBoxQualification1.isChecked()) qualifications.add("Qualification 1");
                if (checkBoxQualification2.isChecked()) qualifications.add("Qualification 2");

                Intent intent = new Intent(MainActivity.this, com.example.registrationapp.ShowActivity.class);
                intent.putExtra("selectedSubject", selectedSubject);
                intent.putExtra("selectedGender", selectedGender);
                intent.putExtra("selectedQualifications", qualifications.toString());
                startActivity(intent);
            }
        });
    }
}
