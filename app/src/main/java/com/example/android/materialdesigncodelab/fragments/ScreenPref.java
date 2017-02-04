package com.example.android.materialdesigncodelab.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

         /*    //Get a Tracker (should auto-report)
        Tracker t = ((AnalyticsSampleApp) getActivity().getApplication()).getTracker(AnalyticsSampleApp.TrackerName.GLOBAL_TRACKER);
        // Enable Advertising Features.
        t.enableAdvertisingIdCollection(true);
        t.setScreenName("ScreenPref");
        t.send(new HitBuilders.ScreenViewBuilder().build());*/


        View rootView = inflater.inflate(R.layout.screen_pref, container,
                false);


        //находим элементы разметки

        userNameEditText = (EditText) rootView.findViewById(R.id.userNameEditText);
        userSurnameEditText = (EditText) rootView.findViewById(R.id.userSurnameEditText);
        //	phoneEditText = (EditText) rootView.findViewById(R.id.phoneEditText);
        emailEditText = (EditText) rootView.findViewById(R.id.emailEditText);
        FBEditText = (EditText) rootView.findViewById(R.id.FBEditText);
        VKEditText = (EditText) rootView.findViewById(R.id.VKEditText);
        //	TWEditText = (EditText) rootView.findViewById(R.id.TWEditText);
//		enterKursText = (EditText) rootView.findViewById(R.id.enterKursText);
//		enterGroupText = (EditText) rootView.findViewById(R.id.enterGroupText);

        np = (NumberPicker) rootView.findViewById(R.id.numberPicker1);
        np.setMaxValue(4);
        np.setMinValue(1);

        np2 = (NumberPicker) rootView.findViewById(R.id.numberPicker2);
        np2.setMaxValue(6);
        np2.setMinValue(1);


        //здесь заполняем данными разметку

        sPref = getActivity().getPreferences(getActivity().MODE_PRIVATE);
        //  String savedText = sPref.getString(SAVED_TEXT, "");
        userNameEditText.setText(sPref.getString("userNameEditText", ""));
        userSurnameEditText.setText(sPref.getString("userSurnameEditText", ""));
        //	    phoneEditText.setText(sPref.getString("phoneEditText", ""));
        emailEditText.setText(sPref.getString("emailEditText", ""));
        FBEditText.setText(sPref.getString("FBEditText", ""));
        VKEditText.setText(sPref.getString("VKEditText", ""));
        //	    TWEditText.setText(sPref.getString("TWEditText", ""));
        //  enterKursText.setText(sPref.getString("enterKursText", "1"));
        //  enterGroupText.setText(sPref.getString("enterGroupText", "1"));

        np.setValue((int) sPref.getLong("enterKursText", 1));
        np2.setValue((int) sPref.getLong("enterGroupText", 1));

        //   Log.i("onCreateView", "считано: "); // Oops


        return rootView;
    }


    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        super.onDetach();

        // сохраняем данные

        sPref = getActivity().getPreferences(getActivity().MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("userNameEditText", userNameEditText.getText().toString());
        ed.putString("userSurnameEditText", userSurnameEditText.getText().toString());
//	    ed.putString("phoneEditText", phoneEditText.getText().toString());
        ed.putString("emailEditText", emailEditText.getText().toString());
        ed.putString("FBEditText", FBEditText.getText().toString());
        ed.putString("VKEditText", VKEditText.getText().toString());
//	    ed.putString("TWEditText", TWEditText.getText().toString());
        //   ed.putString("enterKursText", enterKursText.getText().toString());
        //   ed.putString("enterGroupText", enterGroupText.getText().toString());

        ed.putLong("enterKursText", np.getValue());
        ed.putLong("enterGroupText", np2.getValue());


        ed.apply();
        // Log.i("afterTextChanged", "записано: "); // Oops
        //	Toast.makeText(getActivity(), "Данные сохранены", Toast.LENGTH_SHORT).show();


    }




}
