package com.example.android.materialdesigncodelab.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.materialdesigncodelab.R;


/**
 * Created by gad on 12.09.2015.
 */
public class ScreenBells extends Fragment {

    public ScreenBells() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.screen_bells, container,
                false);

        return rootView;
    }

}
