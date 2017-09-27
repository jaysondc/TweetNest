package com.shakeup.tweetnest.features.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.codepath.oauth.OAuthLoginActionBarActivity;
import com.shakeup.tweetnest.R;
import com.shakeup.tweetnest.commons.api.TwitterClient;
import com.shakeup.tweetnest.features.timeline.TimelineActivity;

public class LoginActivity extends OAuthLoginActionBarActivity<TwitterClient> {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    // OAuth authenticated successfully, launch primary authenticated activity
    // i.e Display application "homepage"
    @Override
    public void onLoginSuccess() {
        Log.d(TAG, "onLoginSuccess: Authentication success!");
        Intent intent = new Intent(this, TimelineActivity.class);
        startActivity(intent);
    }

    // OAuth authentication flow failed, handle the error
    // i.e Display an error dialog or toast
    @Override
    public void onLoginFailure(Exception e) {
        Log.d(TAG, "onLoginFailure: Authentication failed!");
        e.printStackTrace();
    }

    // Click handler method for the button used to start OAuth flow
    // Uses the client to initiate OAuth authorization
    // This should be tied to a button used to login
    public void loginToRest(View view) {
        Log.d(TAG, "loginToRest: Authentication initiated!");
        getClient().connect();
    }

}
