package com.example.nutritionapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MealActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner mpd;
    Button saveButton;
    CheckBox cb1, cb2, cb3, cb4;
    List<String> ingredientList = new ArrayList<String>();
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_meals);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mpd = findViewById(R.id.mealSpinner);
        mpd.setOnItemSelectedListener(this);

        cb1 = findViewById(R.id.checkBox8);
        cb1.setOnClickListener(this);
        cb2 = findViewById(R.id.checkBox9);
        cb2.setOnClickListener(this);
        cb3 = findViewById(R.id.checkBox10);
        cb3.setOnClickListener(this);
        cb4 = findViewById(R.id.checkBox11);
        cb4.setOnClickListener(this);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SharedPreferences.Editor prefsEditor = sharedpreferences.edit();
                prefsEditor.putString("initialized", "true");
                prefsEditor.apply();
                startActivity(new Intent(MealActivity.this,
                        MainActivity.class));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long arg3) {
        int id = parent.getId();
        final SharedPreferences.Editor prefsEditor = sharedpreferences.edit();
        //UserInformation inf = new UserInformation();
        if(id == R.id.mealSpinner) {
            Spinner mSpinnerFeet = findViewById(R.id.mealSpinner);
            mSpinnerFeet.setSelection(position, true);
            prefsEditor.putString("user_MealNumber", mSpinnerFeet.getSelectedItem().toString());
            //inf.setNumberOfMeals(mSpinnerFeet.getSelectedItem().toString());
        }
        prefsEditor.apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        final SharedPreferences.Editor prefsEditor = sharedpreferences.edit();
        //UserInformation inf = new UserInformation();
        switch (v.getId()) {
            case R.id.checkBox8:
                if(cb1.isChecked()) {
                    ingredientList.add((String) cb1.getText());
                    //inf.addIngredient((String) cb1.getText());
                }
                else {
                    ingredientList.remove((String) cb1.getText());
                }
                break;
            case R.id.checkBox9:
                if(cb2.isChecked()) {
                    ingredientList.add((String) cb2.getText());
                }
                else {
                    ingredientList.remove((String) cb2.getText());
                }
                break;
            case R.id.checkBox10:
                if(cb3.isChecked()) {
                    ingredientList.add((String) cb3.getText());
                }
                else {
                    ingredientList.remove((String) cb3.getText());;
                }
                break;
            case R.id.checkBox11:
                if(cb4.isChecked()) {
                    ingredientList.add((String) cb4.getText());
                }
                else {
                    ingredientList.remove((String) cb4.getText());
                }
                break;
        }
        prefsEditor.putString("user_IngredientList", String.valueOf(ingredientList));
        prefsEditor.apply();
    }
}
