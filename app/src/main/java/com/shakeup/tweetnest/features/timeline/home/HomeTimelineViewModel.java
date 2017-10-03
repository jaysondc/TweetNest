package com.shakeup.tweetnest.features.timeline.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.shakeup.tweetnest.commons.api.TwitterClient;
import com.shakeup.tweetnest.commons.models.Tweet;
import com.shakeup.tweetnest.commons.models.User;
import com.shakeup.tweetnest.commons.repos.TwitterRepoSingleton;

import java.util.List;

/**
 * Created by Jayson on 9/27/2017.
 * <p>
 * ViewModel for the TimelineActivity
 */

public class HomeTimelineViewModel extends ViewModel {

    private MutableLiveData<List<Tweet>> tweetListLiveData = new MutableLiveData<>();
    private MutableLiveData<User> mCurrentUser = new MutableLiveData<>();
    private Long mMaxId = null;
    private Long mSinceId = null;

    public final String TAG = this.getClass().getSimpleName();

    private final TwitterRepoSingleton mTwitterRepo = TwitterRepoSingleton.getTwitterRepoSingleton();

    /**
     * Load the Timeline for the first time.
     *
     * @return a reference to our LiveData object that the Activity can hook into.
     */
    public LiveData<List<Tweet>> getTimeline() {
        mTwitterRepo.getTimeline(mMaxId, mSinceId, TwitterClient.TIMELINE_HOME, tweetListLiveData);
        return tweetListLiveData;
    }

    public void loadMoreTimeline() {
        mTwitterRepo.getTimeline(mMaxId, mSinceId, TwitterClient.TIMELINE_HOME, tweetListLiveData);
    }

    public LiveData<User> getCurrentUser() {
        if (mCurrentUser.getValue() == null) {
            mTwitterRepo.getCurrentUser(mCurrentUser);
        }

        return mCurrentUser;
    }

    public void setMaxId(Long mMaxId) {
        this.mMaxId = mMaxId;
    }

    public void setSinceId(Long mSinceId) {
        this.mSinceId = mSinceId;
    }

}
