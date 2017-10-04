package com.shakeup.tweetnest.features.timeline.mentions;

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
import com.shakeup.tweetnest.commons.listeners.EndlessRecyclerViewScrollListener;
import com.shakeup.tweetnest.features.timeline.adapters.TweetAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MentionsTimelineFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();
    @BindView(R.id.recycler_timeline_mentions)
    public RecyclerView mRecyclerTimeline;

    public MentionsTimelineViewModel mMentionsTimelineViewModel;

    public static MentionsTimelineFragment newInstance() {

        Bundle args = new Bundle();

        MentionsTimelineFragment fragment = new MentionsTimelineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_timeline_mentions, container, false);

        ButterKnife.bind(this, view);

        mMentionsTimelineViewModel = ViewModelProviders.of(getActivity()).get(MentionsTimelineViewModel.class);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMentionsTimelineViewModel.getCurrentUser();

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
                mMentionsTimelineViewModel.loadMoreTimeline();
            }
        });

        // Load the initial timeline and listen for further changes
        mMentionsTimelineViewModel.getTimeline().observe(this, tweets -> {
            tweetAdapter.appendTweets(tweets);

            // Update maxId and sinceId in our ViewModel
            // TODO Factor in SinceId when refreshing the page
            if(tweets != null && tweets.size() > 0){
                mMentionsTimelineViewModel.setMaxId(tweets.get(tweets.size()-1).id-1);
            }
        });
    }
}
