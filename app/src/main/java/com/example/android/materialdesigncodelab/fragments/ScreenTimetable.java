package com.example.android.materialdesigncodelab.fragments;

import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.android.materialdesigncodelab.CardContentFragment;
import com.example.android.materialdesigncodelab.ListContentFragment;
import com.example.android.materialdesigncodelab.R;
import com.example.android.materialdesigncodelab.TileContentFragment;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by gad on 12.09.2015.
 */
public class ScreenTimetable extends Fragment {



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


        return rootView;
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getFragmentManager());
        adapter.addFragment(new ListContentFragment(), "List");
        adapter.addFragment(new TileContentFragment(), "Tile");
        adapter.addFragment(new CardContentFragment(), "Card");
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
