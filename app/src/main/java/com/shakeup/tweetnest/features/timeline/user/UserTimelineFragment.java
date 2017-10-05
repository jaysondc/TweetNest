package com.shakeup.tweetnest.features.timeline.user;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.commons.models.User;
import com.shakeup.tweetnest.commons.listeners.EndlessRecyclerViewScrollListener;
import com.shakeup.tweetnest.features.timeline.adapters.TweetAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserTimelineFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    public static final String USER = "user_tag";

    @BindView(R.id.recycler_timeline_user)
    public RecyclerView mRecyclerTimeline;

    public UserTimelineViewModel mUserTimelineViewModel;

    public static UserTimelineFragment newInstance(User user) {
        Bundle args = new Bundle();
        args.putParcelable(USER, user);
        UserTimelineFragment fragment = new UserTimelineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_timeline_user, container, false);

        ButterKnife.bind(this, view);

        mUserTimelineViewModel = ViewModelProviders.of(getActivity()).get(UserTimelineViewModel.class);

        // Store a reference to our user
        if (savedInstanceState != null) {
            mUserTimelineViewModel.setUser(savedInstanceState.getParcelable(USER));
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecycler();
    }

    private void initRecycler() {
        mRecyclerTimeline.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerTimeline.addItemDecoration(
                new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerTimeline.setAdapter(new TweetAdapter(getActivity(), new ArrayList<>()));
        final TweetAdapter tweetAdapter = (TweetAdapter) mRecyclerTimeline.getAdapter();

        // Set up Endless Scroll to load more tweets
        mRecyclerTimeline.addOnScrollListener(new EndlessRecyclerViewScrollListener(
                (LinearLayoutManager) mRecyclerTimeline.getLayoutManager()
        ) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                mUserTimelineViewModel.loadMoreTimeline();
            }
        });

        // Add our user profile to the top of the timeline
        tweetAdapter.appendProfile(mUserTimelineViewModel.getUser());

        // Load the initial timeline and listen for further changes
        mUserTimelineViewModel.getTimeline().observe(this, tweets -> {
            tweetAdapter.appendTweets(tweets);

            // Update maxId and sinceId in our ViewModel
            // TODO Factor in SinceId when refreshing the page
            if(tweets != null && tweets.size() > 0){
                mUserTimelineViewModel.setMaxId(tweets.get(tweets.size()-1).id-1);
            }
        });
    }
}
