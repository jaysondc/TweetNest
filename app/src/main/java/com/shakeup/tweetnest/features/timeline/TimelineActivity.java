package com.shakeup.tweetnest.features.timeline;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.features.timeline.adapters.TimelinePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity {

    private static final String HOME_TIMELINE_FRAGMENT = "home_fragment";

    private final String TAG = this.getClass().getSimpleName();

    @BindView(R.id.toolbar_timeline)
    public Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);

        initToolbar();
        initPager();
    }

    private void initToolbar() {
        mToolbar.setTitle("Twitter!");
        this.setSupportActionBar(mToolbar);
    }

    private void initPager() {
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = findViewById(R.id.pager_timeline);
        viewPager.setAdapter(
                new TimelinePagerAdapter(getSupportFragmentManager(), this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.tab_timeline);
        tabLayout.setupWithViewPager(viewPager);
    }
}
