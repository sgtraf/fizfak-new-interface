package com.example.android.materialdesigncodelab.days;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.materialdesigncodelab.R;
import com.squareup.picasso.Picasso;

/**
 * Created by gad on 05.02.2017.
 */
public class SatContentFragment extends Fragment {
    private int Kurs, Group;
    private TextView WhatIsKurs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.item_card, container,
                false);


        SharedPreferences sPref = getActivity().getPreferences(getActivity().MODE_PRIVATE);

        Kurs =  (int)sPref.getLong("enterKursText", 1);
        Group  =  (int)sPref.getLong("enterGroupText", 1);


     /*   String Tag = "Test kurs";
        Log.d(Tag, Integer.toString(Kurs));
        Log.d(Tag, Integer.toString(Group));
        Log.d(Tag, "http://vitoelexir.ru/android/timetable/"+Kurs+"/"+Group+"/"
                + "3" + ".png");*/


//для вывода изображений используем библиотеку Picasso
        Picasso.with(getActivity()) //передаем контекст приложения
                .load( "http://vitoelexir.ru/android/timetable/"+Kurs+"/"+Group+"/"
                        + "6" + ".png") //адрес изображения
                .into((ImageView) rootView.findViewById(R.id.imageView1)); //ссылка на ImageView

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {





        super.onViewCreated(view, savedInstanceState);
    }
}
