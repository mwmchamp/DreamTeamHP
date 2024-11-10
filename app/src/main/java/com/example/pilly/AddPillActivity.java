package com.example.pilly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddPillActivity extends AppCompatActivity {
    private EditText pillName;
    private EditText dosage;
    private RadioGroup daysOfTheWeek;
    private Button addNewPillButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pill);

        pillName = findViewById(R.id.pillnameEditText);
        dosage = findViewById(R.id.dosageEditText);
        daysOfTheWeek = findViewById(R.id.frequencyRadioGroup);
        findViewById(R.id.submitNewPillButton);

        addNewPillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add to file from here
            }
        });
    }
}