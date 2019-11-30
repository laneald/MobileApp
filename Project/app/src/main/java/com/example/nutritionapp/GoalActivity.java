package com.example.nutritionapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GoalActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView gw;
    Button nextButton;
    Spinner timeCount, timeMeasure;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_goals);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor prefsEditor = sharedpreferences.edit();

        gw = findViewById(R.id.goalWeight);
        gw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                prefsEditor.putString("user_GoalWeight", s.toString());
                prefsEditor.apply();
            }
        });

        timeCount = findViewById(R.id.timeUnit);
        timeCount.setOnItemSelectedListener(this);
        timeMeasure = findViewById(R.id.timeType);
        timeMeasure.setOnItemSelectedListener(this);


        nextButton = findViewById(R.id.saveButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoalActivity.this,
                        MealActivity.class));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long arg3) {
        int id = parent.getId();
        final SharedPreferences.Editor prefsEditor = sharedpreferences.edit();
        //UserInformation inf = new UserInformation();
        switch (id)
        {
            case R.id.timeUnit:
                Spinner mSpinnerFeet = findViewById(R.id.timeUnit);
                mSpinnerFeet.setSelection(position, true);
                prefsEditor.putString("user_GoalTimeUnit", mSpinnerFeet.getSelectedItem().toString());
                //inf.setTimeUnit(mSpinnerFeet.getSelectedItem().toString());
                break;
            case R.id.timeType:
                Spinner mSpinnerIn = findViewById(R.id.timeType);
                mSpinnerIn.setSelection(position, true);
                prefsEditor.putString("user_GoalTimeType", mSpinnerIn.getSelectedItem().toString());
                //inf.setTimeType(mSpinnerIn.getSelectedItem().toString());
                break;
        }
        prefsEditor.apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
