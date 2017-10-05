package com.shakeup.tweetnest.features.timeline.adapters;

/**
 * Created by Jayson on 9/27/2017.
 */

import android.app.Activity;

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;
import com.shakeup.tweetnest.commons.models.Tweet;
import com.shakeup.tweetnest.commons.models.User;

import java.util.List;

/**
 * Created by Jayson on 9/27/2017.
 *
 * Adapter for displaying tweets to the RecyclerView using delegate adapters
 */

public class TweetAdapter extends ListDelegationAdapter<List<Tweet>> {

    public TweetAdapter(Activity activity, List<Tweet> articles) {
        // DelegatesManager is a protected Field in ListDelegationAdapter
        delegatesManager.addDelegate(new TweetAdapterDelegate(activity));
        delegatesManager.addDelegate(new ProfileAdapterDelegate(activity));

        // Set the items from super class.
        setItems(articles);
    }

    public void setTweets(List<Tweet> tweetList) {
        this.items.clear();
        this.items.addAll(tweetList);
        this.notifyDataSetChanged();
    }

    public void appendTweets(List<Tweet> articleList) {
        int startChange = items.size();
        this.items.addAll(articleList);
        this.notifyItemRangeInserted(startChange, items.size()-1);
    }

    public void appendProfile(User user) {
        Tweet tweet = new Tweet();
        tweet.user = user;
        this.items.add(0, tweet);
        this.notifyItemInserted(0);
    }

    public void insertPostedTweet(Tweet tweet) {
        this.items.add(0, tweet);
        this.notifyDataSetChanged();
    }
}
