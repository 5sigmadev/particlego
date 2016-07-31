package com.lanesdev.particlego.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanesdev.particlego.model.Collider;
import com.lanesdev.particlego.model.User;

import java.util.HashMap;

public class TabAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;
    User user;
    HashMap<Integer, Collider> colliderMap;

    public TabAdapter(FragmentManager fm, int NumOfTabs, User user, HashMap<Integer, Collider> colliders) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.user = user;
        this.colliderMap = colliders;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Bundle bundle1 = new Bundle();
                bundle1.putParcelable("USER", this.user);
                MapFragment tab1 = new MapFragment();
                tab1.setArguments(bundle1);
                return tab1;
            case 1:
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("USER", this.user);
                bundle2.putSerializable("COLLIDERS", this.colliderMap);
                ExperimentFragment tab2 = new ExperimentFragment();
                tab2.setArguments(bundle2);
                return tab2;
            case 2:
                Bundle bundle3 = new Bundle();
                bundle3.putParcelable("USER", this.user);
                StatusFragment tab3 = new StatusFragment();
                tab3.setArguments(bundle3);
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
