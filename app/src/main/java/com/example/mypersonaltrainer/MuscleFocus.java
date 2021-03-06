package com.example.mypersonaltrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.mypersonaltrainer.ObjectClasses.Constants;
import com.example.mypersonaltrainer.ObjectClasses.User;
import com.example.mypersonaltrainer.ObjectClasses.Workout;
import com.example.mypersonaltrainer.ObjectClasses.WorkoutGenerator;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MuscleFocus extends AppCompatActivity {
    private User user;
    private SharedPreferences mPrefs;
    private View previousView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_focus);
        mPrefs = getSharedPreferences("user_data", Context.MODE_PRIVATE);
    }

    public void muscleFocusCollection(View view){
        Gson gson = new Gson();
        String json = mPrefs.getString("user", "User not found");
        user = gson.fromJson(json, User.class);
        int radioButtonId = ((RadioGroup) findViewById(R.id.radio_group_muscle_focus)).getCheckedRadioButtonId();
        String muscleFocus;
        switch (radioButtonId){
            case R.id.radio_shoulders: muscleFocus = Constants.SHOULDERS; break;
            case R.id.radio_chest: muscleFocus = Constants.CHEST; break;
            case R.id.radio_biceps: muscleFocus = Constants.BICEPS; break;
            case R.id.radio_triceps: muscleFocus = Constants.TRICEPS; break;
            case R.id.radio_back: muscleFocus = Constants.BACK; break;
            case R.id.radio_abs: muscleFocus = Constants.ABS; break;
            case R.id.radio_butt: muscleFocus = Constants.BUTT; break;
            case R.id.radio_quads: muscleFocus = Constants.QUADS; break;
            case R.id.radio_ham: muscleFocus = Constants.HAM; break;
            case R.id.radio_calves: muscleFocus = Constants.CALVES; break;
            default: muscleFocus = Constants.NONE;
        }
        user.setMuscleFocus(muscleFocus);
        WorkoutGenerator wg = new WorkoutGenerator(getApplicationContext());
        ArrayList<Workout> routine;
        routine = wg.getRoutine(user.getDays(), user.getTrainingLocation(), user.getMuscleFocus());
        user.setRoutine(routine);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        json = gson.toJson(user);
        prefsEditor.putString("user", json);
        prefsEditor.commit();
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }

    public void returnToWorkoutPref(View view){
        this.finish();
    }

    public void darkenImage(View view){
        if(previousView!=null) previousView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.darkened), PorterDuff.Mode.DARKEN);
        previousView = view;
        view.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.undarkened), PorterDuff.Mode.DARKEN);
    }
}
