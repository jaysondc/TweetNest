package com.shakeup.tweetnest.features.profile;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.commons.models.User;
import com.shakeup.tweetnest.features.timeline.user.UserTimelineFragment;
import com.shakeup.tweetnest.features.timeline.user.UserTimelineViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    public static final String USER = "user_tag";
    private final String TIMELINE_FRAGMENT = "timeline_fragment_tag";

    private ProfileViewModel mProfileViewModel;
    private UserTimelineViewModel mUserTimelineViewModel;

    @BindView(R.id.toolbar_profile)
    public Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        mProfileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        mUserTimelineViewModel = ViewModelProviders.of(this).get(UserTimelineViewModel.class);

        // Store a reference to our user
        User user = getIntent().getExtras().getParcelable(USER);
        mProfileViewModel.setUser(user);
        mUserTimelineViewModel.setUser(user);

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
        ft.add(R.id.container_profile_timeline, fragment, TIMELINE_FRAGMENT);
        ft.commit();
    }
}
