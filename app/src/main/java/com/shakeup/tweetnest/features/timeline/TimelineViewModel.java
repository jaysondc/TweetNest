package com.shakeup.tweetnest.features.timeline;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.shakeup.tweetnest.commons.models.Tweet;
import com.shakeup.tweetnest.commons.models.User;
import com.shakeup.tweetnest.commons.repos.TwitterRepoSingleton;

import java.util.List;

/**
 * Created by Jayson on 9/27/2017.
 * <p>
 * ViewModel for the TimelineActivity
 */

public class TimelineViewModel extends AndroidViewModel {

    private MutableLiveData<List<Tweet>> tweetListLiveData = new MutableLiveData<>();
    private MutableLiveData<User> mCurrentUser = new MutableLiveData<>();
    private MutableLiveData<Tweet> mPostedTweet = new MutableLiveData<>();
    private Long mMaxId = null;
    private Long mSinceId = null;
    private MutableLiveData<Integer> mCharsRemaining = new MutableLiveData<>();

    public final String TAG = this.getClass().getSimpleName();

    private TwitterRepoSingleton mTwitterRepo = TwitterRepoSingleton.getTwitterRepoSingleton();

    public TimelineViewModel(Application application) {
        super(application);
    }

    /**
     * Load the Timeline for the first time.
     *
     * @return a reference to our LiveData object that the Activity can hook into.
     */
    public LiveData<List<Tweet>> getTimeline() {
        mTwitterRepo.getTimeline(mMaxId, mSinceId, tweetListLiveData);
        return tweetListLiveData;
    }

    public void loadMoreTimeline() {
        mTwitterRepo.getTimeline(mMaxId, mSinceId, tweetListLiveData);
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
}
