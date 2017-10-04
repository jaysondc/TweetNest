
package com.shakeup.tweetnest.commons.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable
{

    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("id_str")
    @Expose
    public String idStr;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("screen_name")
    @Expose
    public String screenName;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("entities")
    @Expose
    public Entities_ entities;
    @SerializedName("protected")
    @Expose
    public Boolean _protected;
    @SerializedName("followers_count")
    @Expose
    public Long followersCount;
    @SerializedName("friends_count")
    @Expose
    public Long friendsCount;
    @SerializedName("listed_count")
    @Expose
    public Long listedCount;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("favourites_count")
    @Expose
    public Long favouritesCount;
    @SerializedName("utc_offset")
    @Expose
    public Long utcOffset;
    @SerializedName("time_zone")
    @Expose
    public String timeZone;
    @SerializedName("geo_enabled")
    @Expose
    public Boolean geoEnabled;
    @SerializedName("verified")
    @Expose
    public Boolean verified;
    @SerializedName("statuses_count")
    @Expose
    public Long statusesCount;
    @SerializedName("lang")
    @Expose
    public String lang;
    @SerializedName("contributors_enabled")
    @Expose
    public Boolean contributorsEnabled;
    @SerializedName("is_translator")
    @Expose
    public Boolean isTranslator;
    @SerializedName("is_translation_enabled")
    @Expose
    public Boolean isTranslationEnabled;
    @SerializedName("profile_background_color")
    @Expose
    public String profileBackgroundColor;
    @SerializedName("profile_background_image_url")
    @Expose
    public String profileBackgroundImageUrl;
    @SerializedName("profile_background_image_url_https")
    @Expose
    public String profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_tile")
    @Expose
    public Boolean profileBackgroundTile;
    @SerializedName("profile_image_url")
    @Expose
    public String profileImageUrl;
    @SerializedName("profile_image_url_https")
    @Expose
    public String profileImageUrlHttps;
    @SerializedName("profile_banner_url")
    @Expose
    public String profileBannerUrl;
    @SerializedName("profile_link_color")
    @Expose
    public String profileLinkColor;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    public String profileSidebarBorderColor;
    @SerializedName("profile_sidebar_fill_color")
    @Expose
    public String profileSidebarFillColor;
    @SerializedName("profile_text_color")
    @Expose
    public String profileTextColor;
    @SerializedName("profile_use_background_image")
    @Expose
    public Boolean profileUseBackgroundImage;
    @SerializedName("has_extended_profile")
    @Expose
    public Boolean hasExtendedProfile;
    @SerializedName("default_profile")
    @Expose
    public Boolean defaultProfile;
    @SerializedName("default_profile_image")
    @Expose
    public Boolean defaultProfileImage;
    @SerializedName("following")
    @Expose
    public Boolean following;
    @SerializedName("follow_request_sent")
    @Expose
    public Boolean followRequestSent;
    @SerializedName("notifications")
    @Expose
    public Boolean notifications;
    @SerializedName("translator_type")
    @Expose
    public String translatorType;
    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
            "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
    ;

    protected User(Parcel in) {
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.idStr = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.screenName = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.entities = ((Entities_) in.readValue((Entities_.class.getClassLoader())));
        this._protected = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.followersCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.friendsCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.listedCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.favouritesCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.utcOffset = ((Long) in.readValue((Long.class.getClassLoader())));
        this.timeZone = ((String) in.readValue((String.class.getClassLoader())));
        this.geoEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.verified = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.statusesCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.lang = ((String) in.readValue((String.class.getClassLoader())));
        this.contributorsEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isTranslator = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isTranslationEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.profileBackgroundColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileBackgroundImageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.profileBackgroundImageUrlHttps = ((String) in.readValue((String.class.getClassLoader())));
        this.profileBackgroundTile = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.profileImageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.profileImageUrlHttps = ((String) in.readValue((String.class.getClassLoader())));
        this.profileBannerUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.profileLinkColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileSidebarBorderColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileSidebarFillColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileTextColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileUseBackgroundImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.hasExtendedProfile = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.defaultProfile = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.defaultProfileImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.following = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.followRequestSent = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.notifications = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.translatorType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public User() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(idStr);
        dest.writeValue(name);
        dest.writeValue(screenName);
        dest.writeValue(location);
        dest.writeValue(description);
        dest.writeValue(url);
        dest.writeValue(entities);
        dest.writeValue(_protected);
        dest.writeValue(followersCount);
        dest.writeValue(friendsCount);
        dest.writeValue(listedCount);
        dest.writeValue(createdAt);
        dest.writeValue(favouritesCount);
        dest.writeValue(utcOffset);
        dest.writeValue(timeZone);
        dest.writeValue(geoEnabled);
        dest.writeValue(verified);
        dest.writeValue(statusesCount);
        dest.writeValue(lang);
        dest.writeValue(contributorsEnabled);
        dest.writeValue(isTranslator);
        dest.writeValue(isTranslationEnabled);
        dest.writeValue(profileBackgroundColor);
        dest.writeValue(profileBackgroundImageUrl);
        dest.writeValue(profileBackgroundImageUrlHttps);
        dest.writeValue(profileBackgroundTile);
        dest.writeValue(profileImageUrl);
        dest.writeValue(profileImageUrlHttps);
        dest.writeValue(profileBannerUrl);
        dest.writeValue(profileLinkColor);
        dest.writeValue(profileSidebarBorderColor);
        dest.writeValue(profileSidebarFillColor);
        dest.writeValue(profileTextColor);
        dest.writeValue(profileUseBackgroundImage);
        dest.writeValue(hasExtendedProfile);
        dest.writeValue(defaultProfile);
        dest.writeValue(defaultProfileImage);
        dest.writeValue(following);
        dest.writeValue(followRequestSent);
        dest.writeValue(notifications);
        dest.writeValue(translatorType);
    }

    public int describeContents() {
        return  0;
    }

    /**
     * Returns the profileImageUrl for an original size image
     * @return Url to obtain the full size profile image
     */
    public String getProfileImageUrlHttpsOriginal() {
        StringBuilder sb = new StringBuilder(this.profileImageUrlHttps);
        int indexRemove = sb.indexOf("_normal");
        sb.delete(indexRemove, indexRemove+7);
        return sb.toString();
    }

}
