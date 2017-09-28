
package com.shakeup.tweetnest.commons.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Url implements Parcelable
{

    @SerializedName("urls")
    @Expose
    private List<Url_> urls = null;
    public final static Parcelable.Creator<Url> CREATOR = new Creator<Url>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Url createFromParcel(Parcel in) {
            return new Url(in);
        }

        public Url[] newArray(int size) {
            return (new Url[size]);
        }

    }
    ;

    protected Url(Parcel in) {
        in.readList(this.urls, (com.shakeup.tweetnest.commons.models.Url_.class.getClassLoader()));
    }

    public Url() {
    }

    public List<Url_> getUrls() {
        return urls;
    }

    public void setUrls(List<Url_> urls) {
        this.urls = urls;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(urls);
    }

    public int describeContents() {
        return  0;
    }

}
