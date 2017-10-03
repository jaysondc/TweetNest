package com.shakeup.tweetnest.features.timeline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.features.timeline.home.HomeTimelineFragment;

import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity {

    private static final String HOME_TIMELINE_FRAGMENT = "home_fragment";

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);

        initFragment();
    }

    private void initFragment() {
        Fragment fragment = HomeTimelineFragment.newInstance();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container_timeline, fragment, HOME_TIMELINE_FRAGMENT)
                .commit();
    }
}
