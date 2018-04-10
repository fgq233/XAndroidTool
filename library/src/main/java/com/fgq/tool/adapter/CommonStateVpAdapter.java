package com.fgq.tool.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class CommonStateVpAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles;

    public CommonStateVpAdapter(FragmentManager fm) {
        super(fm);
    }

    public CommonStateVpAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public CommonStateVpAdapter(FragmentManager fm, String[] titles, List<Fragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }

    public void addFragment(Fragment frag) {
        fragments.add(frag);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments != null ? fragments.get(position) : null;
    }

    @Override
    public int getCount() {
        if (titles == null) {
            return fragments != null ? fragments.size() : 0;
        } else {
            return fragments != null && fragments.size() == titles.length ? fragments.size() : 0;
        }
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles != null && titles.length > 0 ? titles[position] : null;
    }
}
