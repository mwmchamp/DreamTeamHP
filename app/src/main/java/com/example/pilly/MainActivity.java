package com.example.pilly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView upcomingPill;
    private RecyclerView pillList;
    private FloatingActionButton addPillButton;
    private PillListAdapter pillListAdapter;
    private List<Pill> pills;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pills = new ArrayList<>();
        pills = PillReader.readPills(getApplicationContext());
        pills.sort(Comparator.naturalOrder());
        upcomingPill = findViewById(R.id.nextPillTime_textView);
        pillList = findViewById(R.id.pill_list_recycler_view);
        addPillButton = findViewById(R.id.addPill_floatingActionButton);
        pillListAdapter = new PillListAdapter(pills);

        if (pills.size() > 0) {
            upcomingPill.setText("Next pill to be taken on " + pills.get(0).getDayToTake() + " " + militaryTimeTo12Hour(pills.get(0).getTimeToBeTaken()));
        } else {
            upcomingPill.setText("Add pills to get started");
        }

        pillList.setLayoutManager(new LinearLayoutManager(this));
        pillList.setAdapter(pillListAdapter);

        addPillButton.setOnClickListener(v -> {
            Intent newPillIntent = new Intent(MainActivity.this, AddPillActivity.class);
            startActivity(newPillIntent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String newPills = (String) intent.getCharSequenceExtra("New pills");
        if (newPills != null) {
            Log.d("new pill data", newPills);
            newPills = newPills.substring(1, newPills.length() - 1);
            String[] splitPills = newPills.split(",");
            for (int i = 0; i <= splitPills.length - 5; i += 5) {
                String name = splitPills[i].trim();
                String dose = splitPills[i + 1].trim();
                String time = splitPills[i + 2].trim();
                String day = splitPills[i + 3].trim();
                boolean isTaken = splitPills[i + 4].trim().equals("true");
                Pill currentPill = new Pill(name, dose, time, day, isTaken);
                if (pills.isEmpty()) {
                    pills.add(currentPill);
                } else {
                    int index = 0;
                    while (index < pills.size() && pills.get(index).getTimeToBeTaken().compareTo(currentPill.getTimeToBeTaken()) < 0) {
                        index++;
                    }
                    pills.add(index, currentPill);
                }
            }
        }

        pills.sort(Comparator.naturalOrder());
    }

    public String militaryTimeTo12Hour(String militaryTime) {
        String[] timeParts = militaryTime.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        String minutes = timeParts[1];

        String period = hour >= 12 ? "PM" : "AM";

        if (hour > 12) {
            hour -= 12;
        } else if (hour == 0) {
            hour = 12;
        }

        return String.format("%d:%s %s", hour, minutes, period);
    }
}