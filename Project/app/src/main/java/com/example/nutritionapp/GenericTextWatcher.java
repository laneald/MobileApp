package com.example.nutritionapp;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

class GenericTextWatcher implements TextWatcher {
    UserInformation inf = new UserInformation();
    private View view;
    public GenericTextWatcher(View view) {
        this.view = view;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String text = s.toString();
        switch(view.getId()){
            case R.id.currentWeight:
                inf.setCurrentWeight(text);
                break;
        }
    }
}
