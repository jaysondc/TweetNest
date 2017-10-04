
package com.shakeup.tweetnest.commons.models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Url___ implements Parcelable
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
    public final static Parcelable.Creator<Url___> CREATOR = new Creator<Url___>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Url___ createFromParcel(Parcel in) {
            return new Url___(in);
        }

        public Url___[] newArray(int size) {
            return (new Url___[size]);
        }

    }
    ;

    protected Url___(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.expandedUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.displayUrl = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.indices, (java.lang.Long.class.getClassLoader()));
    }

    public Url___() {
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
