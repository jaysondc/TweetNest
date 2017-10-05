package com.shakeup.tweetnest.features.timeline;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.features.profile.ProfileActivity;
import com.shakeup.tweetnest.features.timeline.adapters.TimelinePagerAdapter;
import com.shakeup.tweetnest.features.timeline.home.HomeTimelineViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity {

    private static final String HOME_TIMELINE_FRAGMENT = "home_fragment";

    private final String TAG = this.getClass().getSimpleName();

    private HomeTimelineViewModel mHomeTimelineViewModel;

    @BindView(R.id.toolbar_timeline)
    public Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);

        mHomeTimelineViewModel = ViewModelProviders.of(this).get(HomeTimelineViewModel.class);

        initToolbar();
        initPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_profile:
                openUserProfile();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        mToolbar.setTitle("Tweet Nest");
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

    private void openUserProfile() {
        mHomeTimelineViewModel.getCurrentUser().observe(this, user -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra(ProfileActivity.USER, user);
            this.startActivity(intent);
        });
    }
}
