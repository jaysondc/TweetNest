package com.shakeup.tweetnest.features.compose;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.features.timeline.TimelineViewModel;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jayson on 9/29/2017.
 *
 * Fragment for composing new tweets
 */

public class ComposeTweetDialogFragment extends DialogFragment {
    @BindView(R.id.compose_avatar) public ImageView mImgAvatar;
    @BindView(R.id.compose_cancel) public ImageView mBtnCancel;
    @BindView(R.id.button_tweet) public Button mBtnTweet;
    @BindView(R.id.text_char_count) public TextView mCharCount;
    @BindView(R.id.compose_handle) public TextView mHandle;
    @BindView(R.id.edit_tweet) public EditText mEditTweet;

    public TimelineViewModel mTimelineViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compose, container, false);

        ButterKnife.bind(this, view);

        // ViewModel shared by the TimelineActivity
        mTimelineViewModel = ViewModelProviders.of(getActivity()).get(TimelineViewModel.class);

        initUserViews();

        initCharCount();

        // Set up tweet button
        mBtnTweet.setOnClickListener( (clickedView) -> {
            mTimelineViewModel.submitTweet(mEditTweet.getText().toString());
            this.dismiss();
        });

        // Set up cancel button
        mBtnCancel.setOnClickListener( (clickedView) -> this.dismiss() );

        return view;
    }

    private void initCharCount() {
        // TODO implement tweet character count
    }

    private void initUserViews() {
        mTimelineViewModel.getCurrentUser().observe(this, (user) -> {
            mHandle.setText(String.format(Locale.getDefault(), "@%s", user.getScreenName()));
            Glide.with(this)
                    .load(user.getProfileImageUrlHttpsOriginal())
                    .into(mImgAvatar);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
        int height = getResources().getDimensionPixelSize(R.dimen.popup_height);
        getDialog().getWindow().setLayout(width, height);
    }
}
