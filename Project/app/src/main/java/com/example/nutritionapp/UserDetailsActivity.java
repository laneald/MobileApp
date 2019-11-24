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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView cw;
    Spinner hft, hin, sLevel;
    Button nextButton;
    RadioButton weightMetric;
//    public static final String MyPREFERENCES = "MyPrefs" ;
//    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_userdetail);
        //sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        cw = findViewById(R.id.currentWeight);
        cw.addTextChangedListener(new GenericTextWatcher(cw));
        hft = findViewById(R.id.heightFeet);
        hft.setOnItemSelectedListener(this);
        hin = findViewById(R.id.heightIn);
        hin.setOnItemSelectedListener(this);
        sLevel = findViewById(R.id.spinner);
        sLevel.setOnItemSelectedListener(this);
        
        //Use the radio button group to set the weight metric

        nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDetailsActivity.this,
                        GoalActivity.class));
            }
        });
//        cw.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(!s.equals("")) {
//                    final SharedPreferences.Editor editor = sharedpreferences.edit();
//                    editor.putString("currentWeight", s.toString());
//                    editor.apply();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long arg3) {
        int id = parent.getId();
        UserInformation inf = new UserInformation();
        switch (id)
        {
            case R.id.heightFeet:
                Spinner mSpinnerFeet = findViewById(R.id.heightFeet);
                mSpinnerFeet.setSelection(position, true);
                inf.setHeightFeet(mSpinnerFeet.getSelectedItem().toString());
                break;
            case R.id.heightIn:
                Spinner mSpinnerIn = findViewById(R.id.heightIn);
                mSpinnerIn.setSelection(position, true);
                inf.setHeightIn(mSpinnerIn.getSelectedItem().toString());
                break;
            case R.id.spinner:
                Spinner mSpinnerActivity = findViewById(R.id.spinner);
                mSpinnerActivity.setSelection(position, true);
                inf.setSedentaryActivity(mSpinnerActivity.getSelectedItem().toString());
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
