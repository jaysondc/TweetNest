
package com.shakeup.tweetnest.commons.models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entities implements Parcelable
{

    @SerializedName("hashtags")
    @Expose
    public List<Object> hashtags = new ArrayList<Object>();
    @SerializedName("symbols")
    @Expose
    public List<Object> symbols = new ArrayList<Object>();
    @SerializedName("user_mentions")
    @Expose
    public List<UserMention> userMentions = new ArrayList<UserMention>();
    @SerializedName("urls")
    @Expose
    public List<Url> urls = new ArrayList<Url>();
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
        in.readList(this.hashtags, (java.lang.Object.class.getClassLoader()));
        in.readList(this.symbols, (java.lang.Object.class.getClassLoader()));
        in.readList(this.userMentions, (com.shakeup.tweetnest.commons.models.UserMention.class.getClassLoader()));
        in.readList(this.urls, (com.shakeup.tweetnest.commons.models.Url.class.getClassLoader()));
    }

    public Entities() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(hashtags);
        dest.writeList(symbols);
        dest.writeList(userMentions);
        dest.writeList(urls);
    }

    public int describeContents() {
        return  0;
    }

}
