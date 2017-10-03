package com.shakeup.tweetnest.features.timeline.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.features.compose.ComposeTweetDialogFragment;
import com.shakeup.tweetnest.features.compose.ComposeTweetViewModel;
import com.shakeup.tweetnest.features.timeline.EndlessRecyclerViewScrollListener;
import com.shakeup.tweetnest.features.timeline.adapters.TweetAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeTimelineFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();
    @BindView(R.id.recycler_timeline)
    public RecyclerView mRecyclerTimeline;
    @BindView(R.id.fab_compose)
    public FloatingActionButton mFabCompose;

    public HomeTimelineViewModel mHomeTimelineViewModel;
    public ComposeTweetViewModel mComposeViewModel;

    public static HomeTimelineFragment newInstance() {

        Bundle args = new Bundle();

        HomeTimelineFragment fragment = new HomeTimelineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_timeline_home, container, false);

        ButterKnife.bind(this, view);

        mHomeTimelineViewModel = ViewModelProviders.of(getActivity()).get(HomeTimelineViewModel.class);
        mComposeViewModel = ViewModelProviders.of(getActivity()).get(ComposeTweetViewModel.class);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mHomeTimelineViewModel.getCurrentUser();

        initRecycler();

        initNewTweet();

        initFab();
    }

    private void initFab() {
        mFabCompose.setOnClickListener( view -> showComposeFragment() );
    }

    /**
     * Observes the ViewModel for a newly posted tweet and adds it to the timeline. Triggered
     * when our user successfully posts a tweet.
     */
    private void initNewTweet() {
        mComposeViewModel.getPostedTweet().observe(this, (tweet -> {
            if (tweet != null) {
                ((TweetAdapter) mRecyclerTimeline.getAdapter()).insertPostedTweet(tweet);
                mRecyclerTimeline.smoothScrollToPosition(0);
            }
        }));
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
                mHomeTimelineViewModel.loadMoreTimeline();
            }
        });

        // Load the initial timeline and listen for further changes
        mHomeTimelineViewModel.getTimeline().observe(this, tweets -> {
            tweetAdapter.appendTweets(tweets);

            // Update maxId and sinceId in our ViewModel
            // TODO Factor in SinceId when refreshing the page
            if(tweets != null && tweets.size() > 0){
                mHomeTimelineViewModel.setMaxId(tweets.get(tweets.size()-1).getId()-1);
            }
        });
    }

    public void showComposeFragment() {
        ComposeTweetDialogFragment fragment = new ComposeTweetDialogFragment();
        fragment.show(getActivity().getSupportFragmentManager(), getString(R.string.tag_compose));
    }
}
