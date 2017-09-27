package com.shakeup.tweetnest;

import android.app.Application;
import android.content.Context;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.shakeup.tweetnest.commons.api.TwitterClient;

/**
 * Created by Jayson on 9/27/2017.
 */

public class TweetNestApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        FlowManager.init(new FlowConfig.Builder(this).build());
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

        TweetNestApplication.context = this;
    }

    public static TwitterClient getRestClient() {
        return (TwitterClient) TwitterClient.getInstance(TwitterClient.class, TweetNestApplication.context);
    }
}
