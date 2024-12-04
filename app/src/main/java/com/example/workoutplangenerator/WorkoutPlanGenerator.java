package com.example.workoutplangenerator;

import android.content.Context;

import java.util.Random;

public class WorkoutPlanGenerator {

    private final Context context;
    private final Random random;

    public WorkoutPlanGenerator(Context context) {
        this.context = context;
        this.random = new Random();
    }

    public String generateWorkoutPlan() {
        StringBuilder plan = new StringBuilder();
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (String day : days) {
            plan.append(day).append(":\n");
            plan.append(generateDayWorkout());
            plan.append("\n");
        }

        return plan.toString();
    }

    private String generateDayWorkout() {
        StringBuilder workout = new StringBuilder();
        String[] exerciseTypes = {"warmup", "cardio", "strength", "cooldown"};

        for (String type : exerciseTypes) {
            int exerciseCount = type.equals("warmup") || type.equals("cooldown") ? 1 : 2 + random.nextInt(2);
            String[] exercises = getExercisesForType(type);

            for (int i = 0; i < exerciseCount; i++) {
                String exercise = exercises[random.nextInt(exercises.length)];
                String reps = type.equals("cardio") ? (5 + random.nextInt(16)) + " minutes" : (8 + random.nextInt(8)) + " reps";
                workout.append("- ").append(exercise).append(": ").append(reps).append("\n");
            }
        }

        return workout.toString();
    }

    private String[] getExercisesForType(String type) {
        int resourceId = context.getResources().getIdentifier(type + "_exercises", "array", context.getPackageName());
        return context.getResources().getStringArray(resourceId);
    }
}

