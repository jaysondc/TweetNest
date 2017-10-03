package com.shakeup.tweetnest.features.profile;

import android.arch.lifecycle.ViewModel;

import com.shakeup.tweetnest.commons.models.User;
import com.shakeup.tweetnest.commons.repos.TwitterRepoSingleton;

/**
 * Created by Jayson on 10/3/2017.
 *
 * ViewModel to hold the state of the ProfileActivity
 */

public class ProfileViewModel extends ViewModel {

    public final String TAG = this.getClass().getSimpleName();

    private final TwitterRepoSingleton mTwitterRepo = TwitterRepoSingleton.getTwitterRepoSingleton();

    private User mUser;

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }
}
