package com.sudoajay.a9xplayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class Tab_Page_Adapter extends FragmentPagerAdapter {
    List<Fragment> mFragmentCollection = new ArrayList<>();
    List<String> mTitleCollection = new ArrayList<>();


    public Tab_Page_Adapter(FragmentManager fm) {
        super(fm);

    }

    public void addFragment(String title, Fragment fragment)
    {
        mTitleCollection.add(title);
        mFragmentCollection.add(fragment);
    }
    //Needed for
    @Override
    public CharSequence getPageTitle(int position) {

        return mTitleCollection.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentCollection.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentCollection.size();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
