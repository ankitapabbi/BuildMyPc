package com.lambtoncollege.buildmypc.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.lambtoncollege.buildmypc.adminfragments.AddFragment;
import com.lambtoncollege.buildmypc.adminfragments.DeleteFragment;
import com.lambtoncollege.buildmypc.adminfragments.PlaceOrderFragment;
import com.lambtoncollege.buildmypc.adminfragments.ViewFragment;

public class ViewPagerAdapterForAdmin extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ViewPagerAdapterForAdmin(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ViewFragment tab1 = new ViewFragment();
                return tab1;
            case 1:
                AddFragment tab2 = new AddFragment();
                return tab2;
            case 2:
                DeleteFragment tab3 = new DeleteFragment();
                return tab3;
            case 3:
                PlaceOrderFragment tab4 = new PlaceOrderFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
