package com.shakeup.tweetnest.features.timeline;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.shakeup.tweetnest.commons.models.Tweet;
import com.shakeup.tweetnest.commons.repos.TwitterRepo;

import java.util.List;

/**
 * Created by Jayson on 9/27/2017.
 */

public class TimelineViewModel extends AndroidViewModel {

    public final String TAG = this.getClass().getSimpleName();
    private TwitterRepo mTwitterRepo = new TwitterRepo();

    public TimelineViewModel(Application application) {
        super(application);
    }

    public List<Tweet> getTimeline(){
        return mTwitterRepo.getTweets();
    }
}
