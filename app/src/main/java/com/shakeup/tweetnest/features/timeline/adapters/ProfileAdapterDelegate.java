package com.shakeup.tweetnest.features.timeline.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.shakeup.tweetnest.commons.Utils;
import com.shakeup.tweetnest.commons.models.Tweet;
import com.shakeup.tweetnest.commons.models.User;
import com.shakeup.tweetnest.features.profile.ProfileActivity;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jayson on 9/27/2017.
 * <p>
 * Adpter delegate used by the {@link TweetAdapter} to
 * display {@link User}s
 */


public class ProfileAdapterDelegate extends AdapterDelegate<List<Tweet>> {

    private final String TAG = this.getClass().getSimpleName();

    private LayoutInflater mInflater;

    public ProfileAdapterDelegate(Activity activity) {
        this.mInflater = activity.getLayoutInflater();
    }

    @Override
    protected boolean isForViewType(@NonNull List<Tweet> items, int position) {
        return (position == 0) && items.get(0).text == null;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ProfileViewHolder(
                mInflater.inflate(R.layout.listitem_profile_header, parent, false));
    }

    @Override
    protected void onBindViewHolder(
            @NonNull List<Tweet> items,
            int position,
            @NonNull RecyclerView.ViewHolder holder,
            @NonNull List<Object> payloads) {
        ProfileViewHolder viewHolder = (ProfileViewHolder) holder;
        viewHolder.bind(items.get(position), position);
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        @BindView(R.id.image_avatar)
        public ImageView avatar;
        @BindView(R.id.text_username)
        public TextView username;
        @BindView(R.id.text_handle)
        public TextView handle;
        @BindView(R.id.text_tagline)
        public TextView tagline;
        @BindView(R.id.text_followers)
        public TextView followers;
        @BindView(R.id.text_following)
        public TextView following;

        public ProfileViewHolder(View view) {
            super(view);
            this.mView = view;
            ButterKnife.bind(this, view);
        }

        public void bind(final Tweet tweet, int position) {
            // Bind tweet to views
            username.setText(tweet.user.name);
            String strHandle = String.format(Locale.getDefault(), "@%s", tweet.user.screenName);
            handle.setText(strHandle);
            tagline.setText(tweet.user.description);
            String sFollowers = Utils.getCompactNumber(tweet.user.followersCount) + " Followers";
            followers.setText(sFollowers);
            String sFollowing = Utils.getCompactNumber(tweet.user.friendsCount) + " Following";
            following.setText(sFollowing);

            Glide.with(itemView.getContext())
                    .load(tweet.user.getProfileImageUrlHttpsOriginal())
                    .into(avatar);

            avatar.setOnClickListener(view -> openUserProfile(tweet.user));
        }

        private void openUserProfile(User user) {
            Context context = mView.getContext();

            Intent intent = new Intent(context, ProfileActivity.class);
            intent.putExtra(ProfileActivity.USER, user);
            context.startActivity(intent);
        }
    }
}
