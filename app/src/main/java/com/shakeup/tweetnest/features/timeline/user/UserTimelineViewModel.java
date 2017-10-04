package com.shakeup.tweetnest.features.timeline.user;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.shakeup.tweetnest.commons.api.TwitterClient;
import com.shakeup.tweetnest.commons.models.Tweet;
import com.shakeup.tweetnest.commons.models.User;
import com.shakeup.tweetnest.commons.repos.TwitterRepoSingleton;

import java.util.List;

/**
 * Created by Jayson on 10/3/2017.
 * <p>
 * ViewModel for the UserTimelineFragment
 */

public class UserTimelineViewModel extends ViewModel {

    public final String TAG = this.getClass().getSimpleName();
    private final TwitterRepoSingleton mTwitterRepo = TwitterRepoSingleton.getTwitterRepoSingleton();

    private MutableLiveData<List<Tweet>> tweetListLiveData = new MutableLiveData<>();
    private User mUser;

    private Long mMaxId = null;
    private Long mSinceId = null;

    /**
     * Load the Timeline for the first time.
     *
     * @return a reference to our LiveData object that the Activity can hook into.
     */
    public LiveData<List<Tweet>> getTimeline() {
        mTwitterRepo.getTimeline(
                mMaxId, mSinceId, TwitterClient.TIMELINE_USER, mUser.getScreenName(), tweetListLiveData);
        return tweetListLiveData;
    }

    public void loadMoreTimeline() {
        mTwitterRepo.getTimeline(
                mMaxId, mSinceId, TwitterClient.TIMELINE_USER, mUser.getScreenName(), tweetListLiveData);
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public void setMaxId(Long mMaxId) {
        this.mMaxId = mMaxId;
    }

    public void setSinceId(Long mSinceId) {
        this.mSinceId = mSinceId;
    }

}
