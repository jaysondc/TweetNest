package com.shakeup.tweetnest.commons.repos;

import com.shakeup.tweetnest.commons.models.Tweet;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jayson on 9/27/2017.
 * </p>
 * Handles fetching and providing of Tweets from the Twitter API.
 * This class serves as an interface between
 * ViewModels and our data sources.
 */

public class TwitterRepo {

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