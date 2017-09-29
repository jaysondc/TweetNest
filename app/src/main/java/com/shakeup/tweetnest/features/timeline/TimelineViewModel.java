package com.shakeup.tweetnest.features.timeline;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.shakeup.tweetnest.commons.models.Tweet;
import com.shakeup.tweetnest.commons.repos.TwitterRepoSingleton;

import java.util.List;

/**
 * Created by Jayson on 9/27/2017.
 *
 * ViewModel for the TimelineActivity
 */

public class TimelineViewModel extends AndroidViewModel {

    private MutableLiveData<List<Tweet>> tweetListLiveData = new MutableLiveData<>();
    private Long mMaxId = null;
    private Long mSinceId = null;

    public final String TAG = this.getClass().getSimpleName();

    private TwitterRepoSingleton mTwitterRepo = TwitterRepoSingleton.getTwitterRepoSingleton();

    public TimelineViewModel(Application application) {
        super(application);
    }

    /**
     * Load the Timeline for the first time.
     * @return a reference to our LiveData object that the Activity can hook into.
     */
    public LiveData<List<Tweet>> getTimeline(){
        mTwitterRepo.getTimeline(mMaxId, mSinceId, tweetListLiveData);
        return tweetListLiveData;
    }

    public void loadMoreTimeline() {
        mTwitterRepo.getTimeline(mMaxId, mSinceId, tweetListLiveData);
    }

    public void setMaxId(Long mMaxId) {
        this.mMaxId = mMaxId;
    }

    public void setSinceId(Long mSinceId) {
        this.mSinceId = mSinceId;
    }
}
