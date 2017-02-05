package com.example.android.materialdesigncodelab.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.materialdesigncodelab.days.WeContentFragment;
import com.example.android.materialdesigncodelab.days.FrContentFragment;
import com.example.android.materialdesigncodelab.days.MoContentFragment;
import com.example.android.materialdesigncodelab.R;
import com.example.android.materialdesigncodelab.days.SatContentFragment;
import com.example.android.materialdesigncodelab.days.ThuContentFragment;
import com.example.android.materialdesigncodelab.days.TuContentFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gad on 12.09.2015.
 */
public class ScreenTimetable extends Fragment {

    private int Kurs, Group;
    private TextView WhatIsKurs;

    /*public ScreenTimetable() {
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.screen_timetable, container,
                false);


        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.container);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        WhatIsKurs = (TextView) rootView.findViewById(R.id.WhatIsKurs);

        SharedPreferences sPref = getActivity().getPreferences(getActivity().MODE_PRIVATE);

        // проверяем, установлена ли прога на телефоне ( первый ли раз открывается программа)
        boolean hasFirst = sPref.getBoolean("hasFirst", false);

        if (!hasFirst) {
            // стираем данные в настройках если они были до этого (необходимо при переходе от edittext на numberpick)
            //выходила ошибка при обновлении, из за чтения строки - лонгом
            //	sPref.edit().clear();
            SharedPreferences.Editor e = sPref.edit();
            e.clear();
            e.commit(); // не забудьте подтвердить изменения
            e.putBoolean("hasFirst", true);
            e.commit();
        }

        Kurs =  (int)sPref.getLong("enterKursText", 1);
        Group  =  (int)sPref.getLong("enterGroupText", 1);

        WhatIsKurs.setText(sPref.getLong("enterKursText", 1)+" курс "+sPref.getLong("enterGroupText", 1)+" группа");



        return rootView;
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getFragmentManager());
        adapter.addFragment(new MoContentFragment(), "Пн");
        adapter.addFragment(new TuContentFragment(), "Вт");
        adapter.addFragment(new WeContentFragment(), "Ср");

        adapter.addFragment(new ThuContentFragment(), "Чт");
        adapter.addFragment(new FrContentFragment(), "Пт");
        adapter.addFragment(new SatContentFragment(), "Сб");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
