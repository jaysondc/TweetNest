package com.shakeup.tweetnest.features.timeline.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.commons.models.Tweet;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jayson on 9/27/2017.
 *
 * Adpter delegate used by the {@link TweetAdapter} to
 * display {@link com.shakeup.tweetnest.commons.models.Tweet}s
 */


public class TweetAdapterDelegate extends AdapterDelegate<List<Tweet>> {

    private final String TAG = this.getClass().getSimpleName();

    private LayoutInflater mInflater;

    public TweetAdapterDelegate(Activity activity) {
        this.mInflater = activity.getLayoutInflater();
    }

    @Override
    protected boolean isForViewType(@NonNull List<Tweet> items, int position) {
        return true;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new TweetViewHolder(
                mInflater.inflate(R.layout.listietm_tweet, parent, false));
    }

    @Override
    protected void onBindViewHolder(
            @NonNull List<Tweet> items,
            int position,
            @NonNull RecyclerView.ViewHolder holder,
            @NonNull List<Object> payloads) {
        TweetViewHolder viewHolder = (TweetViewHolder) holder;
        viewHolder.bind(items.get(position), position);
    }

    public class TweetViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        @BindView(R.id.tweet_text) TextView textViewTweet;

        public TweetViewHolder(View view) {
            super(view);
            this.mView = view;
            ButterKnife.bind(this, view);
        }

        public void bind(final Tweet tweet, int position){
            // Bind tweet to views
            textViewTweet.setText(
                    String.format(Locale.getDefault(), "%s %d", tweet.getText(), position));
        }
    }

}
