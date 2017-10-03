package com.shakeup.tweetnest.features.compose;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shakeup.tweetnest.R;

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

    public ComposeTweetViewModel mComposeViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compose, container, false);

        ButterKnife.bind(this, view);

        // ViewModel shared by the TimelineActivity
        mComposeViewModel = ViewModelProviders.of(getActivity()).get(ComposeTweetViewModel.class);

        initUserViews();

        // Set up tweet button
        mBtnTweet.setOnClickListener( (clickedView) -> {
            mComposeViewModel.submitTweet(mEditTweet.getText().toString());
            this.dismiss();
        });

        // Set up cancel button
        mBtnCancel.setOnClickListener( (clickedView) -> this.dismiss() );

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initCharCount();
    }

    private void initCharCount() {

        mComposeViewModel.getCountObservable().observe(getActivity(),
                count -> {
                        if (count != null) {
                            mCharCount.setText(
                                    String.format(Locale.getDefault(), "%d", count));

                            if (count < 1) {
                                mCharCount.setTextColor(
                                        ContextCompat.getColor(getActivity(), R.color.colorRed));
                            } else {
                                mCharCount.setTextColor(
                                        ContextCompat.getColor(getActivity(), R.color.colorGrey));
                            }
                        }
                    });

        mEditTweet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Do nothing.
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mComposeViewModel.updateCount(charSequence.length());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Do nothing.
            }
        });

    }

    private void initUserViews() {
        mComposeViewModel.getCurrentUser().observe(this, (user) -> {
            if (user != null) {
                mHandle.setText(String.format(Locale.getDefault(), "@%s", user.getScreenName()));
                Glide.with(this)
                        .load(user.getProfileImageUrlHttpsOriginal())
                        .into(mImgAvatar);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
        int height = getResources().getDimensionPixelSize(R.dimen.popup_height);
        Window window = getDialog().getWindow();
        if (window != null)
        window.setLayout(width, height);
    }
}
