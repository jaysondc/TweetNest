package com.shakeup.tweetnest.features.compose;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.features.timeline.TimelineViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jayson on 9/29/2017.
 *
 * Fragment for composing new tweets
 */

public class ComposeTweetFragment extends DialogFragment {
    @BindView(R.id.compose_avatar) public ImageView mImgAvatar;
    @BindView(R.id.compose_cancel) public Button mBtnCancel;
    @BindView(R.id.button_tweet) public Button mBtnTweet;
    @BindView(R.id.text_char_count) public TextView mCharCount;

    public TimelineViewModel mTimelineViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compose, container, false);

        ButterKnife.bind(this, view);

        // ViewModel shared by the TimelineActivity
        mTimelineViewModel = ViewModelProviders.of(getActivity()).get(TimelineViewModel.class);

        return view;
    }


}
