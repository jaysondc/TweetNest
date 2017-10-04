
package com.shakeup.tweetnest.commons.models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Url_ implements Parcelable
{

    @SerializedName("urls")
    @Expose
    public List<Url__> urls = new ArrayList<Url__>();
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
        in.readList(this.urls, (com.shakeup.tweetnest.commons.models.Url__.class.getClassLoader()));
    }

    public Url_() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(urls);
    }

    public int describeContents() {
        return  0;
    }

}
