/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
 * Provides UI for the view with Cards.
 */
public class TuContentFragment extends Fragment {
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
                        + "2" + ".png") //адрес изображения
                .into((ImageView) rootView.findViewById(R.id.imageView1)); //ссылка на ImageView

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {





        super.onViewCreated(view, savedInstanceState);
    }
}

