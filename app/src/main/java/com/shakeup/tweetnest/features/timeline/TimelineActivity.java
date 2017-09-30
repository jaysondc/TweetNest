package com.shakeup.tweetnest.features.timeline;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.features.compose.ComposeTweetDialogFragment;
import com.shakeup.tweetnest.features.timeline.adapters.TweetAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    @BindView(R.id.recycler_timeline)
    public RecyclerView mRecyclerTimeline;

    TimelineViewModel mTimelineViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);

        mTimelineViewModel = ViewModelProviders.of(this).get(TimelineViewModel.class);

        mTimelineViewModel.getCurrentUser();

        initRecycler();
    }

    private void initRecycler() {
        mRecyclerTimeline.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerTimeline.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerTimeline.setAdapter(new TweetAdapter(this, new ArrayList<>()));
        final TweetAdapter tweetAdapter = (TweetAdapter) mRecyclerTimeline.getAdapter();

        // Set up Endless Scroll to load more tweets
        mRecyclerTimeline.addOnScrollListener(new EndlessRecyclerViewScrollListener(
                (LinearLayoutManager) mRecyclerTimeline.getLayoutManager()
        ) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                mTimelineViewModel.loadMoreTimeline();
            }
        });

        // Load the initial timeline and listen for further changes
        mTimelineViewModel.getTimeline().observe(this, tweets -> {
            tweetAdapter.appendTweets(tweets);

            // Update maxId and sinceId in our ViewModel
            // TODO Factor in SinceId when refreshing the page
            if(tweets != null && tweets.size() > 0){
                mTimelineViewModel.setMaxId(tweets.get(tweets.size()-1).getId()-1);
            }
        });
    }

    public void showComposeFragment(View view) {
        ComposeTweetDialogFragment fragment = new ComposeTweetDialogFragment();
        fragment.show(getSupportFragmentManager(), getString(R.string.tag_compose));
    }
}
