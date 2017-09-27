package com.shakeup.tweetnest.features.timeline;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.features.timeline.adapters.TweetAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    @BindView(R.id.recycler_timeline) public RecyclerView mRecyclerTimeline;

    TimelineViewModel mTimelineViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);

        mTimelineViewModel = ViewModelProviders.of(this).get(TimelineViewModel.class);

        initRecycler();
    }

    private void initRecycler() {
        mRecyclerTimeline.setLayoutManager(new LinearLayoutManager(this));

        mTimelineViewModel.getTimeline().observe(this, tweets -> {
            mRecyclerTimeline.setAdapter(new TweetAdapter(this, tweets));
        });
    }
}
