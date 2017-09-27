package com.shakeup.tweetnest.commons.repos;

import com.shakeup.tweetnest.TweetNestApplication;
import com.shakeup.tweetnest.commons.api.TwitterClient;
import com.shakeup.tweetnest.commons.models.Tweet;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jayson on 9/27/2017.
 * </p>
 * Handles fetching and providing of Tweets from the Twitter API.
 * This class serves as an interface between
 * ViewModels and our data sources. Requests should be parsed to model objects in this layer.
 * This layer also handles fetching data from the local database if we're offline.
 */

public class TwitterRepoSingleton {
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