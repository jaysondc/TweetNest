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

    public final String TAG = this.getClass().getSimpleName();

    private TwitterRepoSingleton mTwitterRepo = TwitterRepoSingleton.getTwitterRepoSingleton();

    public TimelineViewModel(Application application) {
        super(application);
    }

    public LiveData<List<Tweet>> getTimeline(){
        MutableLiveData<List<Tweet>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(mTwitterRepo.getTweets());
        return mutableLiveData;
    }
}
