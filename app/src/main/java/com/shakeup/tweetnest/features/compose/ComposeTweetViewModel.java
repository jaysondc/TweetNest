package com.shakeup.tweetnest.features.compose;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.shakeup.tweetnest.commons.models.Tweet;
import com.shakeup.tweetnest.commons.models.User;
import com.shakeup.tweetnest.commons.repos.TwitterRepoSingleton;

/**
 * Created by Jayson on 10/3/2017.
 *
 * Holds the state of the Compose Tweet dialog
 */

public class ComposeTweetViewModel extends ViewModel {
    public final String TAG = this.getClass().getSimpleName();

    private MutableLiveData<Tweet> mPostedTweet = new MutableLiveData<>();
    private MutableLiveData<Integer> mCharsRemaining = new MutableLiveData<>();
    private MutableLiveData<User> mCurrentUser = new MutableLiveData<>();

    private final TwitterRepoSingleton mTwitterRepo = TwitterRepoSingleton.getTwitterRepoSingleton();

    public void submitTweet(String string) {
        Log.d(TAG, "submitTweet: " + string);

        mTwitterRepo.postTweet(string, mPostedTweet);
    }

    public MutableLiveData<Tweet> getPostedTweet() {
        return mPostedTweet;
    }

    public LiveData<Integer> getCountObservable() {
        this.mCharsRemaining.setValue(280);
        return mCharsRemaining;
    }

    public void updateCount(int charCount) {
        this.mCharsRemaining.setValue(280 - charCount);
    }

    public LiveData<User> getCurrentUser() {
        if (mCurrentUser.getValue() == null) {
            mTwitterRepo.getCurrentUser(mCurrentUser);
        }

        return mCurrentUser;
    }
}
