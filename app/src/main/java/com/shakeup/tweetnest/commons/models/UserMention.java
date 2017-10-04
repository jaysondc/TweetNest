
package com.shakeup.tweetnest.commons.models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserMention implements Parcelable
{

    @SerializedName("screen_name")
    @Expose
    public String screenName;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("id_str")
    @Expose
    public String idStr;
    @SerializedName("indices")
    @Expose
    public List<Long> indices = new ArrayList<Long>();
    public final static Parcelable.Creator<UserMention> CREATOR = new Creator<UserMention>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserMention createFromParcel(Parcel in) {
            return new UserMention(in);
        }

        public UserMention[] newArray(int size) {
            return (new UserMention[size]);
        }

    }
    ;

    protected UserMention(Parcel in) {
        this.screenName = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.idStr = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.indices, (java.lang.Long.class.getClassLoader()));
    }

    public UserMention() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(screenName);
        dest.writeValue(name);
        dest.writeValue(id);
        dest.writeValue(idStr);
        dest.writeList(indices);
    }

    public int describeContents() {
        return  0;
    }

}
