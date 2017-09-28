
package com.shakeup.tweetnest.commons.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entities implements Parcelable
{

    @SerializedName("urls")
    @Expose
    private List<Object> urls = null;
    @SerializedName("hashtags")
    @Expose
    private List<Object> hashtags = null;
    @SerializedName("user_mentions")
    @Expose
    private List<Object> userMentions = null;
    public final static Parcelable.Creator<Entities> CREATOR = new Creator<Entities>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Entities createFromParcel(Parcel in) {
            return new Entities(in);
        }

        public Entities[] newArray(int size) {
            return (new Entities[size]);
        }

    }
    ;

    protected Entities(Parcel in) {
        in.readList(this.urls, (java.lang.Object.class.getClassLoader()));
        in.readList(this.hashtags, (java.lang.Object.class.getClassLoader()));
        in.readList(this.userMentions, (java.lang.Object.class.getClassLoader()));
    }

    public Entities() {
    }

    public List<Object> getUrls() {
        return urls;
    }

    public void setUrls(List<Object> urls) {
        this.urls = urls;
    }

    public List<Object> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Object> hashtags) {
        this.hashtags = hashtags;
    }

    public List<Object> getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(List<Object> userMentions) {
        this.userMentions = userMentions;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(urls);
        dest.writeList(hashtags);
        dest.writeList(userMentions);
    }

    public int describeContents() {
        return  0;
    }

}
