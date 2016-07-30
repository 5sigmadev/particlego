package com.lanesdev.particlego.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanesdev.particlego.model.User;

public class TabAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;
    User user;

    public TabAdapter(FragmentManager fm, int NumOfTabs, User user) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.user = user;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Bundle bundle1 = new Bundle();
                bundle1.putInt("USER_LEVEL", this.user.getLevel());
                MapFragment tab1 = new MapFragment();
                tab1.setArguments(bundle1);
                return tab1;
            case 1:
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArrayList("USER_ITEMS", this.user.getCollectedParticles());
                ExperimentFragment tab2 = new ExperimentFragment();
                tab2.setArguments(bundle2);
                return tab2;
            case 3:
                ExperimentFragment tab3 = new ExperimentFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
