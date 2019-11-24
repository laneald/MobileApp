package com.example.nutritionapp;

import android.content.Context;

import java.io.Serializable;

public class UserInformation implements Serializable {
    private String currentWeight;
    private String heightFeet;
//    private String currentWeight;
//    private String currentWeight;
//    private String currentWeight;
//    private String currentWeight;
    private String heightIn;
    private String sedentaryActivity;


    public void setCurrentWeight(String presentWeight) {
        this.currentWeight = presentWeight;
    }

    public void setHeightFeet(String itemAtPosition) {

        this.heightFeet = itemAtPosition;
    }

    public void setHeightIn(String itemAtPosition) {
        this.heightIn = itemAtPosition;
    }

    public void setSedentaryActivity(String itemAtPosition) {
        this.sedentaryActivity = itemAtPosition;
    }
}
