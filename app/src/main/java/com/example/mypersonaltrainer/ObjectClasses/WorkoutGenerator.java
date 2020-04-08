package com.example.mypersonaltrainer.ObjectClasses;

import android.os.CpuUsageInfo;

import java.util.ArrayList;

public class WorkoutGenerator {
    private ExerciseBank eBank;
    private ArrayList<Workout> routine;
    private ArrayList<Exercise> exercises;
    public WorkoutGenerator(){
        eBank = new ExerciseBank();
        routine = new ArrayList<Workout>();
        exercises = new ArrayList<Exercise>();
    }


    public ArrayList get4DaySplit(String trainingLocation, String targetArea){

        exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
        exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.BICEPS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.TRICEPS, trainingLocation);
        routine.add(new Workout(exercises, "Day 1: Upper Day"));

        //exercises.clear() when starting a new set of exercises for next day.
        return routine;
    }



    private String getSetsAndReps(User user, Exercise e){
        String experience = user.getExperience();
        if(e.getLocationType().equals(Constants.GYM)){
            if(e.getType().equals(Constants.POWER)){
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x8";
                    case Constants.NOVICE:
                        return "3x5";
                    case Constants.INTER:
                        return "4x5";
                    case Constants.ADVAN:
                        return "5x5";
                    case Constants.ELITE:
                        return "5x5";
                }
            }
            else if(e.getType().equals(Constants.HYPER)){
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x10";
                    case Constants.NOVICE:
                        return "3x12";
                    case Constants.INTER:
                        return "4x12";
                    case Constants.ADVAN:
                        return "4x12";
                    case Constants.ELITE:
                        return "4x12";
                }
            }
            else if(e.getType().equals(Constants.ENDU)) {
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x15";
                    case Constants.NOVICE:
                        return "4x15";
                    case Constants.INTER:
                        return "4x20";
                    case Constants.ADVAN:
                        return "5x18";
                    case Constants.ELITE:
                        return "5x20";
                }
            }
        }
        else if(e.getLocationType().equals(Constants.BODY)){
            if(e.getType().equals(Constants.POW_HYPE)){
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x8";
                    case Constants.NOVICE:
                        return "3x5";
                    case Constants.INTER:
                        return "4x5";
                    case Constants.ADVAN:
                        return "5x5";
                    case Constants.ELITE:
                        return "5x5";
                }
            }
            else if(e.getType().equals(Constants.ENDU)) {
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x15";
                    case Constants.NOVICE:
                        return "4x15";
                    case Constants.INTER:
                        return "4x20";
                    case Constants.ADVAN:
                        return "5x18";
                    case Constants.ELITE:
                        return "5x20";
                }
            }
        }
        else if(e.getLocationType().equals(Constants.DUMB)){
            if(e.getType().equals(Constants.POWER)){
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x8";
                    case Constants.NOVICE:
                        return "3x5";
                    case Constants.INTER:
                        return "4x5";
                    case Constants.ADVAN:
                        return "5x5";
                    case Constants.ELITE:
                        return "5x5";
                }
            }
            else if(e.getType().equals(Constants.HYPER)){
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x10";
                    case Constants.NOVICE:
                        return "3x12";
                    case Constants.INTER:
                        return "4x12";
                    case Constants.ADVAN:
                        return "4x12";
                    case Constants.ELITE:
                        return "4x12";
                }
            }
            else if(e.getType().equals(Constants.ENDU)) {
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x15";
                    case Constants.NOVICE:
                        return "4x15";
                    case Constants.INTER:
                        return "4x20";
                    case Constants.ADVAN:
                        return "5x18";
                    case Constants.ELITE:
                        return "5x20";
                }
            }
        }
        return "3x8";
    }
}
