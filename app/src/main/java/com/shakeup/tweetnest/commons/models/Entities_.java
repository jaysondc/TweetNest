
package com.shakeup.tweetnest.commons.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entities_ implements Parcelable
{

    @SerializedName("url")
    @Expose
    private Url url;
    @SerializedName("description")
    @Expose
    private Object description;
    public final static Parcelable.Creator<Entities_> CREATOR = new Creator<Entities_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Entities_ createFromParcel(Parcel in) {
            return new Entities_(in);
        }

        public Entities_[] newArray(int size) {
            return (new Entities_[size]);
        }

    }
    ;

    protected Entities_(Parcel in) {
        this.url = ((Url) in.readValue((Url.class.getClassLoader())));
        this.description = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Entities_() {
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(description);
    }

    public int describeContents() {
        return  0;
    }

}
