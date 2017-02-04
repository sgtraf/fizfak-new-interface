package com.example.android.materialdesigncodelab.fragments;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.android.materialdesigncodelab.R;


/**
 * Created by gad on 12.09.2015.
 */
public class ScreenPref extends Fragment {

    private EditText userNameEditText, userSurnameEditText, phoneEditText, emailEditText,
            FBEditText, VKEditText, TWEditText;

    private SharedPreferences sPref;

    private NumberPicker np, np2;

    public ScreenPref() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.screen_pref, container,
                false);

        return rootView;
    }





}
