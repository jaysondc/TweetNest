package com.shakeup.tweetnest.commons.repos;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.shakeup.tweetnest.TweetNestApplication;
import com.shakeup.tweetnest.commons.api.TwitterClient;
import com.shakeup.tweetnest.commons.models.Tweet;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Jayson on 9/27/2017.
 * </p>
 * Handles fetching and providing of Tweets from the Twitter API.
 * This class serves as an interface between
 * ViewModels and our data sources. Requests should be parsed to model objects in this layer.
 * This layer also handles fetching data from the local database if we're offline.
 */

public class TwitterRepoSingleton {

    private final String TAG = getClass().getSimpleName();

    private static TwitterRepoSingleton sTwitterRepo;
    private TwitterClient mTwitterClient;

    private TwitterRepoSingleton () {
        mTwitterClient = TweetNestApplication.getRestClient();
    }

    public static TwitterRepoSingleton getTwitterRepoSingleton() {
        if (sTwitterRepo == null) {
            sTwitterRepo = new TwitterRepoSingleton();
        }
        return sTwitterRepo;
    }

    /**
     *
     */
    public List<Tweet> getTimeline() {
        mTwitterClient.getHomeTimeline(null, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.d(TAG, "onSuccess: " + response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, "onFailure: " + throwable.toString());
            }
        });

        // TODO Change to retrieved data
        return getTweets();
    }

    /**
     * Creates a dummy list of Tweets
     *
     * @return list of Tweets
     */
    public List<Tweet> getTweets() {
        List<Tweet> tweetList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Tweet tweet = new Tweet();
            tweet.someText = "TWEET";

            tweetList.add(tweet);
        }

        return tweetList;
    }

}