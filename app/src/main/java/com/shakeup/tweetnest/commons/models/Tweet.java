
package com.shakeup.tweetnest.commons.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shakeup.tweetnest.commons.Utils;

public class Tweet implements Parcelable
{

    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("id_str")
    @Expose
    public String idStr;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("truncated")
    @Expose
    public Boolean truncated;
    @SerializedName("entities")
    @Expose
    public Entities entities;
    @SerializedName("source")
    @Expose
    public String source;
    @SerializedName("in_reply_to_status_id")
    @Expose
    public Object inReplyToStatusId;
    @SerializedName("in_reply_to_status_id_str")
    @Expose
    public Object inReplyToStatusIdStr;
    @SerializedName("in_reply_to_user_id")
    @Expose
    public Object inReplyToUserId;
    @SerializedName("in_reply_to_user_id_str")
    @Expose
    public Object inReplyToUserIdStr;
    @SerializedName("in_reply_to_screen_name")
    @Expose
    public Object inReplyToScreenName;
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("geo")
    @Expose
    public Object geo;
    @SerializedName("coordinates")
    @Expose
    public Object coordinates;
    @SerializedName("place")
    @Expose
    public Object place;
    @SerializedName("contributors")
    @Expose
    public Object contributors;
    @SerializedName("is_quote_status")
    @Expose
    public Boolean isQuoteStatus;
    @SerializedName("retweet_count")
    @Expose
    public Long retweetCount;
    @SerializedName("favorite_count")
    @Expose
    public Long favoriteCount;
    @SerializedName("favorited")
    @Expose
    public Boolean favorited;
    @SerializedName("retweeted")
    @Expose
    public Boolean retweeted;
    @SerializedName("possibly_sensitive")
    @Expose
    public Boolean possiblySensitive;
    @SerializedName("possibly_sensitive_appealable")
    @Expose
    public Boolean possiblySensitiveAppealable;
    @SerializedName("lang")
    @Expose
    public String lang;
    public final static Parcelable.Creator<Tweet> CREATOR = new Creator<Tweet>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Tweet createFromParcel(Parcel in) {
            return new Tweet(in);
        }

        public Tweet[] newArray(int size) {
            return (new Tweet[size]);
        }

    }
    ;

    protected Tweet(Parcel in) {
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.idStr = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.truncated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.entities = ((Entities) in.readValue((Entities.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.inReplyToStatusId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.inReplyToStatusIdStr = ((Object) in.readValue((Object.class.getClassLoader())));
        this.inReplyToUserId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.inReplyToUserIdStr = ((Object) in.readValue((Object.class.getClassLoader())));
        this.inReplyToScreenName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.geo = ((Object) in.readValue((Object.class.getClassLoader())));
        this.coordinates = ((Object) in.readValue((Object.class.getClassLoader())));
        this.place = ((Object) in.readValue((Object.class.getClassLoader())));
        this.contributors = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isQuoteStatus = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.retweetCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.favoriteCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.favorited = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.retweeted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.possiblySensitive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.possiblySensitiveAppealable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.lang = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Tweet() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(createdAt);
        dest.writeValue(id);
        dest.writeValue(idStr);
        dest.writeValue(text);
        dest.writeValue(truncated);
        dest.writeValue(entities);
        dest.writeValue(source);
        dest.writeValue(inReplyToStatusId);
        dest.writeValue(inReplyToStatusIdStr);
        dest.writeValue(inReplyToUserId);
        dest.writeValue(inReplyToUserIdStr);
        dest.writeValue(inReplyToScreenName);
        dest.writeValue(user);
        dest.writeValue(geo);
        dest.writeValue(coordinates);
        dest.writeValue(place);
        dest.writeValue(contributors);
        dest.writeValue(isQuoteStatus);
        dest.writeValue(retweetCount);
        dest.writeValue(favoriteCount);
        dest.writeValue(favorited);
        dest.writeValue(retweeted);
        dest.writeValue(possiblySensitive);
        dest.writeValue(possiblySensitiveAppealable);
        dest.writeValue(lang);
    }

    public int describeContents() {
        return  0;
    }

    public String getCreatedAtRelative() {
        return Utils.getRelativeTimeAgo(createdAt);
    }

}
