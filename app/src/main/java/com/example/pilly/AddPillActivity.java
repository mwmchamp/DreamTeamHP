package com.example.pilly;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddPillActivity extends AppCompatActivity {
    private EditText pillName;
    private EditText dosage;
    private CheckBox sunday;
    private CheckBox monday;
    private CheckBox tuesday;
    private CheckBox wednesday;
    private CheckBox thursday;
    private CheckBox friday;
    private CheckBox saturday;
    private Button addNewPillButton;
    private List<String> daysOfTheWeek;
    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pill);

        pillName = findViewById(R.id.pillnameEditText);
        dosage = findViewById(R.id.dosageEditText);
        sunday = findViewById(R.id.checkBox);
        monday = findViewById(R.id.checkBox2);
        tuesday = findViewById(R.id.checkBox3);
        wednesday = findViewById(R.id.checkBox4);
        thursday = findViewById(R.id.checkBox5);
        friday = findViewById(R.id.checkBox6);
        saturday = findViewById(R.id.checkBox7);
        addNewPillButton = findViewById(R.id.submitNewPillButton);
        time = findViewById(R.id.timeSelector);
        daysOfTheWeek = new ArrayList<>();

        sunday.setOnClickListener(v -> daysOfTheWeek.add("Sunday"));
        monday.setOnClickListener(v -> daysOfTheWeek.add("Monday"));
        tuesday.setOnClickListener(v -> daysOfTheWeek.add("Tuesday"));
        wednesday.setOnClickListener(v -> daysOfTheWeek.add("Wednesday"));
        thursday.setOnClickListener(v -> daysOfTheWeek.add("Thursday"));
        friday.setOnClickListener(v -> daysOfTheWeek.add("Friday"));
        saturday.setOnClickListener(v -> daysOfTheWeek.add("Saturday"));

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddPillActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
                timePickerDialog.show();
            }
        });

        addNewPillButton.setOnClickListener(v -> {
            // add to file from here
            if (sunday.isChecked()) {
                daysOfTheWeek.add("Sunday");
            }
            if (monday.isChecked()) {
                daysOfTheWeek.add("Monday");
            }
            if (tuesday.isChecked()) {
                daysOfTheWeek.add("Tuesday");
            }
            if (wednesday.isChecked()) {
                daysOfTheWeek.add("Wednesday");
            }
            if (thursday.isChecked()) {
                daysOfTheWeek.add("Thursday");
            }
            if (friday.isChecked()) {
                daysOfTheWeek.add("Friday");
            }
            if (saturday.isChecked()) {
                daysOfTheWeek.add("Saturday");
            }

            List<Pill> newPills = new ArrayList<>();
            for (String day : daysOfTheWeek) {
                Pill pillToAdd = new Pill(pillName.getText().toString(), dosage.getText().toString(), time.getText().toString(), day, false);
                newPills.add(pillToAdd);
            }

            Intent backToMainActivityIntent = new Intent(AddPillActivity.this, MainActivity.class);
            backToMainActivityIntent.putExtra("New pills", (CharSequence) newPills.toString());
            startActivity(backToMainActivityIntent);
        });
    }
}