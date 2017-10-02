package com.shakeup.tweetnest.commons.repos;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.shakeup.tweetnest.TweetNestApplication;
import com.shakeup.tweetnest.commons.api.TwitterClient;
import com.shakeup.tweetnest.commons.models.Tweet;
import com.shakeup.tweetnest.commons.models.User;

import org.json.JSONArray;
import org.json.JSONObject;

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

    private TwitterRepoSingleton() {
        mTwitterClient = TweetNestApplication.getRestClient();
    }

    public static TwitterRepoSingleton getTwitterRepoSingleton() {
        if (sTwitterRepo == null) {
            sTwitterRepo = new TwitterRepoSingleton();
        }
        return sTwitterRepo;
    }

    public void getHomeTimeline(
            Long maxId,
            Long sinceId,
            final MutableLiveData<List<Tweet>> tweets) {
        getTimeline(maxId, sinceId, TwitterClient.TIMELINE_HOME, tweets);
    }

    public void getMentionsTimeline(
            Long maxId,
            Long sinceId,
            final MutableLiveData<List<Tweet>> tweets) {
        getTimeline(maxId, sinceId, TwitterClient.TIMELINE_MENTIONS, tweets);
    }

    public void getUserTimeline(
            Long maxId,
            Long sinceId,
            final MutableLiveData<List<Tweet>> tweets) {
        getTimeline(maxId, sinceId, TwitterClient.TIMELINE_USER, tweets);
    }

    /**
     * Obtains the users Timeline and uses the list of {@link Tweet}s to populate the
     * {@link android.arch.lifecycle.LiveData} argument.
     */
    public void getTimeline(
            Long maxId,
            Long sinceId,
            int timelineType,
            final MutableLiveData<List<Tweet>> tweets) {

        mTwitterClient.getTimeline(maxId, sinceId, timelineType, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.d(TAG, "getTimeline.onSuccess: " + response.toString());

                List<Tweet> tweetList = new ArrayList<>();

                for (int i = 0; i < response.length(); i++) {
                    try {
                        String string = response.get(i).toString();
                        Gson gson = new GsonBuilder().create();
                        Tweet tweet = gson.fromJson(string, Tweet.class);
                        tweetList.add(tweet);
                    } catch (Exception e) {
                        Log.d(TAG, "getTimeline.onSuccess: JSON parsing error!");
                    }
                }

                tweets.setValue(tweetList);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d(TAG, "onFailure: " + throwable.toString());
            }
        });
    }

    public void getCurrentUser(final MutableLiveData<User> user) {
        mTwitterClient.getCurrentUser(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d(TAG, "getCurrentUser.onSuccess: " + response.toString());

                try {
                    Gson gson = new GsonBuilder().create();
                    user.setValue(gson.fromJson(response.toString(), User.class));
                } catch (Exception e) {
                    Log.d(TAG, "getCurrentUser.onSuccess: JSON parsing error!");
                }
            }
        });
    }

    public void postTweet(String tweetText, final MutableLiveData<Tweet> tweet) {
        mTwitterClient.postTweet(tweetText, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d(TAG, "postTweet.onSuccess: " + response.toString());
                try {
                    Gson gson = new GsonBuilder().create();
                    tweet.setValue(gson.fromJson(response.toString(), Tweet.class));
                } catch (Exception e) {
                    Log.d(TAG, "postTweet.onSuccess: JSON parsing error!");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d(TAG, "onFailure: " + throwable.toString());
            }

        });
    }

}