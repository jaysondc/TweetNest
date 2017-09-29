
package com.shakeup.tweetnest.commons.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shakeup.tweetnest.commons.Utils;

public class Tweet implements Parcelable
{

    @SerializedName("coordinates")
    @Expose
    private Object coordinates;
    @SerializedName("truncated")
    @Expose
    private Boolean truncated;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("favorited")
    @Expose
    private Boolean favorited;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("in_reply_to_user_id_str")
    @Expose
    private Object inReplyToUserIdStr;
    @SerializedName("entities")
    @Expose
    private Entities entities;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("contributors")
    @Expose
    private Object contributors;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("retweet_count")
    @Expose
    private Long retweetCount;
    @SerializedName("in_reply_to_status_id_str")
    @Expose
    private Object inReplyToStatusIdStr;
    @SerializedName("geo")
    @Expose
    private Object geo;
    @SerializedName("retweeted")
    @Expose
    private Boolean retweeted;
    @SerializedName("in_reply_to_user_id")
    @Expose
    private Object inReplyToUserId;
    @SerializedName("place")
    @Expose
    private Object place;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("in_reply_to_screen_name")
    @Expose
    private Object inReplyToScreenName;
    @SerializedName("in_reply_to_status_id")
    @Expose
    private Object inReplyToStatusId;
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
        this.coordinates = ((Object) in.readValue((Object.class.getClassLoader())));
        this.truncated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.favorited = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.idStr = ((String) in.readValue((String.class.getClassLoader())));
        this.inReplyToUserIdStr = ((Object) in.readValue((Object.class.getClassLoader())));
        this.entities = ((Entities) in.readValue((Entities.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.contributors = ((Object) in.readValue((Object.class.getClassLoader())));
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.retweetCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.inReplyToStatusIdStr = ((Object) in.readValue((Object.class.getClassLoader())));
        this.geo = ((Object) in.readValue((Object.class.getClassLoader())));
        this.retweeted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.inReplyToUserId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.place = ((Object) in.readValue((Object.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.inReplyToScreenName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.inReplyToStatusId = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Tweet() {
    }

    public Object getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
    }

    public Boolean getTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCreatedAtRelative() {
        return Utils.getRelativeTimeAgo(createdAt);
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public Object getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getContributors() {
        return contributors;
    }

    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Long retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Object getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    public Object getGeo() {
        return geo;
    }

    public void setGeo(Object geo) {
        this.geo = geo;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    public Object getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(Object inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public Object getPlace() {
        return place;
    }

    public void setPlace(Object place) {
        this.place = place;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Object getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(Object inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public Object getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(Object inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(coordinates);
        dest.writeValue(truncated);
        dest.writeValue(createdAt);
        dest.writeValue(favorited);
        dest.writeValue(idStr);
        dest.writeValue(inReplyToUserIdStr);
        dest.writeValue(entities);
        dest.writeValue(text);
        dest.writeValue(contributors);
        dest.writeValue(id);
        dest.writeValue(retweetCount);
        dest.writeValue(inReplyToStatusIdStr);
        dest.writeValue(geo);
        dest.writeValue(retweeted);
        dest.writeValue(inReplyToUserId);
        dest.writeValue(place);
        dest.writeValue(source);
        dest.writeValue(user);
        dest.writeValue(inReplyToScreenName);
        dest.writeValue(inReplyToStatusId);
    }

    public int describeContents() {
        return  0;
    }

}
