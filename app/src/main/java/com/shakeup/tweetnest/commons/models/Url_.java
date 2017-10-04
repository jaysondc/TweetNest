
package com.shakeup.tweetnest.commons.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Url_ implements Parcelable
{

    @SerializedName("expanded_url")
    @Expose
    private Object expandedUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("indices")
    @Expose
    private List<Long> indices = null;
    @SerializedName("display_url")
    @Expose
    private Object displayUrl;
    public final static Parcelable.Creator<Url_> CREATOR = new Creator<Url_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Url_ createFromParcel(Parcel in) {
            return new Url_(in);
        }

        public Url_[] newArray(int size) {
            return (new Url_[size]);
        }

    }
    ;

    protected Url_(Parcel in) {
        this.expandedUrl = ((Object) in.readValue((Object.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        if (this.indices != null) {
            in.readList(this.indices, (java.lang.Long.class.getClassLoader()));
        }
        this.displayUrl = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Url_() {
    }

    public Object getExpandedUrl() {
        return expandedUrl;
    }

    public void setExpandedUrl(Object expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Long> getIndices() {
        return indices;
    }

    public void setIndices(List<Long> indices) {
        this.indices = indices;
    }

    public Object getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(Object displayUrl) {
        this.displayUrl = displayUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(expandedUrl);
        dest.writeValue(url);
        dest.writeList(indices);
        dest.writeValue(displayUrl);
    }

    public int describeContents() {
        return  0;
    }

}
