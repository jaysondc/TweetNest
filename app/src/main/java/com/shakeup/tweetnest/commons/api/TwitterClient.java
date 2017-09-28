package com.shakeup.tweetnest.commons.api;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.api.BaseApi;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/scribejava/scribejava/tree/master/scribejava-apis/src/main/java/com/github/scribejava/apis
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 */
public class TwitterClient extends OAuthBaseClient {
	public static final BaseApi REST_API_INSTANCE = TwitterApi.instance();
	public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
	public static final String REST_CONSUMER_KEY = "iIT9EZ6EuY7jEZga9l5onXbCz";
	public static final String REST_CONSUMER_SECRET = "jVzn6Ukpv5VHVcKU5Jv5NZeXAcn9ag9U9hTecXNZINBaBjPhx2";
	public static final String REST_CALLBACK_URL = "x-oauthflow-twitter://arbitraryname.com";

	// Landing page to indicate the OAuth flow worked in case Chrome for Android 25+ blocks navigation back to the app.
	public static final String FALLBACK_URL =
			"https://codepath.github.io/android-rest-client-template/success.html";

	// See https://developer.chrome.com/multidevice/android/intents
	public static final String REST_CALLBACK_URL_TEMPLATE =
			"intent://%s#Intent;action=android.intent.action.VIEW;scheme=%s;package=%s;S.browser_fallback_url=%s;end";

	public TwitterClient(Context context) {
		super(context, REST_API_INSTANCE,
				REST_URL,
				REST_CONSUMER_KEY,
				REST_CONSUMER_SECRET,
				REST_CALLBACK_URL);
	}

	// DEFINE METHODS for different API endpoints here
	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */

	/**
	 * Request the Home Timeline for the authenticated user. Callback is handled through the
	 * {@link JsonHttpResponseHandler} argument
	 * @param maxId Returns results with an ID less than
	 *                 (that is, older than) or equal to the specified ID.
	 * @param sinceId 	Returns results with an ID greater than
	 *                     (that is, more recent than) the specified ID. There are limits to
	 *                     the number of Tweets which can be accessed through the API. If the
	 *                     limit of Tweets has occured since the since_id, the since_id will
	 *                     be forced to the oldest ID available.
	 * @param handler Handler callback that is used to handle request results.
	 */
	public void getHomeTimeline(Integer maxId, Integer sinceId, JsonHttpResponseHandler handler) {
		String apiUrl = getApiUrl("statuses/home_timeline.json");
		// Can specify query string params directly or through RequestParams.
		RequestParams params = new RequestParams();
		if (maxId != null) params.put("max_id", maxId);
		if (sinceId != null) params.put("since_id", sinceId);
		client.get(apiUrl, params, handler);
	}

}
