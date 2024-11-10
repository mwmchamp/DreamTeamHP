package com.example.pilly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
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
        pills.add(new Pill("Very Cool Pill", "Many", "9 PM", "Wednesday", false));
        pills.add(new Pill("Very Cool Pill", "Many", "9 PM", "Wednesday", false));
        pills.add(new Pill("Very Cool Pill", "Many", "9 PM", "Wednesday", false));
        pills.add(new Pill("Very Cool Pill", "Many", "9 PM", "Wednesday", false));
        pills.add(new Pill("Very Cool Pill", "Many", "9 PM", "Wednesday", false));
        pills.add(new Pill("Very Cool Pill", "Many", "9 PM", "Wednesday", false));
        upcomingPill = findViewById(R.id.nextPillTime_textView);
        pillList = findViewById(R.id.pill_list_recycler_view);
        addPillButton = findViewById(R.id.addPill_floatingActionButton);
        pillListAdapter = new PillListAdapter(pills);

        upcomingPill.setText("Next pill to be taken at " + pills.get(0).getTimeToBeTaken());

        pillList.setLayoutManager(new LinearLayoutManager(this));
        pillList.setAdapter(pillListAdapter);

    }
}