package com.example.pract6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

                private EditText editText;
                private TextView textView;
                private Button shareButton;

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);

                        editText = findViewById(R.id.editText);
                        textView = findViewById(R.id.textView);
                        shareButton = findViewById(R.id.shareButton);

                        shareButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                        String inputText = editText.getText().toString();
                                        textView.setText(inputText);
                                }
                        });
                }
        }
