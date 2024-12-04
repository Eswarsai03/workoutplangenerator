package com.example.workoutplangenerator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView workoutPlanTextView;
    private WorkoutPlanGenerator workoutPlanGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutPlanTextView = findViewById(R.id.workoutPlanTextView);
        Button generateButton = findViewById(R.id.generateButton);
        workoutPlanGenerator = new WorkoutPlanGenerator(this);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String workoutPlan = workoutPlanGenerator.generateWorkoutPlan();
                workoutPlanTextView.setText(workoutPlan);
            }
        });
    }
}
