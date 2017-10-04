
package com.shakeup.tweetnest.commons.models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Description implements Parcelable
{

    @SerializedName("urls")
    @Expose
    public List<Url___> urls = new ArrayList<Url___>();
    public final static Parcelable.Creator<Description> CREATOR = new Creator<Description>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Description createFromParcel(Parcel in) {
            return new Description(in);
        }

        public Description[] newArray(int size) {
            return (new Description[size]);
        }

    }
    ;

    protected Description(Parcel in) {
        in.readList(this.urls, (com.shakeup.tweetnest.commons.models.Url___.class.getClassLoader()));
    }

    public Description() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(urls);
    }

    public int describeContents() {
        return  0;
    }

}
