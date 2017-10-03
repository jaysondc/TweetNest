package com.shakeup.tweetnest.features.profile;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.features.timeline.user.UserTimelineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    public static final String USER = "user_tag";
    private final String TIMELINE_FRAGMENT = "timeline_fragment_tag";

    private ProfileViewModel mProfileViewModel;

    @BindView(R.id.toolbar_profile)
    public Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        mProfileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);

        // Store a reference to our user
        Intent intent = getIntent();
        String user = getIntent().getExtras().getString(USER);
//        mProfileViewModel.setUser(user);

        initToolbar();
        initFragment();
    }

    private void initToolbar() {
        mToolbar.setTitle("User Timeline!");
        this.setSupportActionBar(mToolbar);
    }

    private void initFragment() {
        Fragment fragment = UserTimelineFragment.newInstance(mProfileViewModel.getUser());

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(fragment, TIMELINE_FRAGMENT);
        ft.commit();
    }
}
