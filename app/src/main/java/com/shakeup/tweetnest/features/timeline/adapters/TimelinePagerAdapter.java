package com.shakeup.tweetnest.features.timeline.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.features.timeline.home.HomeTimelineFragment;

/**
 * Created by Jayson on 10/3/2017.
 *
 * Adapter for paging between fragments
 */

public class TimelinePagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 1;

    private Context mContext;

    public TimelinePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HomeTimelineFragment.newInstance();
            case 1:
                // TODO Add Mentions Fragment
                return null;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.tab_title_home);
            case 1:
                return mContext.getString(R.string.tab_title_mentions);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
