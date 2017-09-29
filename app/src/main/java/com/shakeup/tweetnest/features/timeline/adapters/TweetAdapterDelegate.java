package com.shakeup.tweetnest.features.timeline.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
        @BindView(R.id.image_avatar) public ImageView avatar;
        @BindView(R.id.text_username) public TextView username;
        @BindView(R.id.text_handle) public TextView handle;
        @BindView(R.id.text_time_posted) public TextView timePosted;
        @BindView(R.id.text_body) public TextView body;

        public TweetViewHolder(View view) {
            super(view);
            this.mView = view;
            ButterKnife.bind(this, view);
        }

        public void bind(final Tweet tweet, int position){
            // Bind tweet to views
            username.setText(tweet.getUser().getName());
            String strHandle = String.format(Locale.getDefault(), "@%s", tweet.getUser().getScreenName());
            handle.setText(strHandle);
            timePosted.setText(String.format("- %s", tweet.getCreatedAtRelative()));
            body.setText(tweet.getText());

            Glide.with(itemView.getContext())
                    .load(tweet.getUser().getProfileImageUrlHttpsOriginal())
                    .into(avatar);
        }
    }

}
