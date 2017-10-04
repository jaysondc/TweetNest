
package com.shakeup.tweetnest.commons.models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Url__ implements Parcelable
{

    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("expanded_url")
    @Expose
    public String expandedUrl;
    @SerializedName("display_url")
    @Expose
    public String displayUrl;
    @SerializedName("indices")
    @Expose
    public List<Long> indices = new ArrayList<Long>();
    public final static Parcelable.Creator<Url__> CREATOR = new Creator<Url__>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Url__ createFromParcel(Parcel in) {
            return new Url__(in);
        }

        public Url__[] newArray(int size) {
            return (new Url__[size]);
        }

    }
    ;

    protected Url__(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.expandedUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.displayUrl = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.indices, (java.lang.Long.class.getClassLoader()));
    }

    public Url__() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(expandedUrl);
        dest.writeValue(displayUrl);
        dest.writeList(indices);
    }

    public int describeContents() {
        return  0;
    }

}
