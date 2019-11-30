package com.example.nutritionapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class InitialActivity extends AppCompatActivity {
    Button newUser, existingUser;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_initial);

        newUser = findViewById(R.id.button3);
        existingUser = findViewById(R.id.button4);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        existingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sharedpreferences.contains("initialized")) {
                    Toast.makeText(InitialActivity.this,"User Information " +
                                    "Unavailable, Please Create a new User.",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Gson gson = new Gson();
                    String json = sharedpreferences.getString("user_CurrentWeight", "");
//                    UserInformation obj = gson.fromJson(json, UserInformation.class);
                    Toast.makeText(InitialActivity.this, "User Information "
                            + json, Toast.LENGTH_LONG).show();
                }
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InitialActivity.this,
                        UserDetailsActivity.class));
            }
        });


    }
}
