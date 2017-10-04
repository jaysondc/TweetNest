
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
    public Url_ url;
    @SerializedName("description")
    @Expose
    public Description description;
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
        this.url = ((Url_) in.readValue((Url_.class.getClassLoader())));
        this.description = ((Description) in.readValue((Description.class.getClassLoader())));
    }

    public Entities_() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(description);
    }

    public int describeContents() {
        return  0;
    }

}
