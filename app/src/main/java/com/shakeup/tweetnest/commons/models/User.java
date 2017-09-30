
package com.shakeup.tweetnest.commons.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;
    @SerializedName("profile_background_tile")
    @Expose
    private Boolean profileBackgroundTile;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("follow_request_sent")
    @Expose
    private Boolean followRequestSent;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("is_translator")
    @Expose
    private Boolean isTranslator;
    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;
    @SerializedName("entities")
    @Expose
    private Entities_ entities;
    @SerializedName("default_profile")
    @Expose
    private Boolean defaultProfile;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("contributors_enabled")
    @Expose
    private Boolean contributorsEnabled;
    @SerializedName("favourites_count")
    @Expose
    private Long favouritesCount;
    @SerializedName("utc_offset")
    @Expose
    private Object utcOffset;
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("listed_count")
    @Expose
    private Long listedCount;
    @SerializedName("profile_use_background_image")
    @Expose
    private Boolean profileUseBackgroundImage;
    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;
    @SerializedName("followers_count")
    @Expose
    private Long followersCount;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("protected")
    @Expose
    private Boolean _protected;
    @SerializedName("geo_enabled")
    @Expose
    private Boolean geoEnabled;
    @SerializedName("notifications")
    @Expose
    private Boolean notifications;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("time_zone")
    @Expose
    private Object timeZone;
    @SerializedName("profile_background_image_url_https")
    @Expose
    private String profileBackgroundImageUrlHttps;
    @SerializedName("statuses_count")
    @Expose
    private Long statusesCount;
    @SerializedName("profile_background_image_url")
    @Expose
    private String profileBackgroundImageUrl;
    @SerializedName("default_profile_image")
    @Expose
    private Boolean defaultProfileImage;
    @SerializedName("friends_count")
    @Expose
    private Long friendsCount;
    @SerializedName("following")
    @Expose
    private Boolean following;
    @SerializedName("show_all_inline_media")
    @Expose
    private Boolean showAllInlineMedia;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
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
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.profileSidebarFillColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileBackgroundTile = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.profileSidebarBorderColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileImageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.followRequestSent = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.idStr = ((String) in.readValue((String.class.getClassLoader())));
        this.isTranslator = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.profileLinkColor = ((String) in.readValue((String.class.getClassLoader())));
        this.entities = ((Entities_) in.readValue((Entities_.class.getClassLoader())));
        this.defaultProfile = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.contributorsEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.favouritesCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.utcOffset = ((Object) in.readValue((Object.class.getClassLoader())));
        this.profileImageUrlHttps = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.listedCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.profileUseBackgroundImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.profileTextColor = ((String) in.readValue((String.class.getClassLoader())));
        this.followersCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.lang = ((String) in.readValue((String.class.getClassLoader())));
        this._protected = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.geoEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.notifications = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.profileBackgroundColor = ((String) in.readValue((String.class.getClassLoader())));
        this.verified = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.timeZone = ((Object) in.readValue((Object.class.getClassLoader())));
        this.profileBackgroundImageUrlHttps = ((String) in.readValue((String.class.getClassLoader())));
        this.statusesCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.profileBackgroundImageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.defaultProfileImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.friendsCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.following = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.showAllInlineMedia = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.screenName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public Boolean getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(Boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
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

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(Boolean followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public Boolean getIsTranslator() {
        return isTranslator;
    }

    public void setIsTranslator(Boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public Entities_ getEntities() {
        return entities;
    }

    public void setEntities(Entities_ entities) {
        this.entities = entities;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public Long getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Long favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public Object getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Object utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getListedCount() {
        return listedCount;
    }

    public void setListedCount(Long listedCount) {
        this.listedCount = listedCount;
    }

    public Boolean getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public Long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Long followersCount) {
        this.followersCount = followersCount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getProtected() {
        return _protected;
    }

    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public Boolean getNotifications() {
        return notifications;
    }

    public void setNotifications(Boolean notifications) {
        this.notifications = notifications;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Object getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Object timeZone) {
        this.timeZone = timeZone;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public Long getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(Long statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public Boolean getDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(Boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public Long getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Long friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Boolean getFollowing() {
        return following;
    }

    public void setFollowing(Boolean following) {
        this.following = following;
    }

    public Boolean getShowAllInlineMedia() {
        return showAllInlineMedia;
    }

    public void setShowAllInlineMedia(Boolean showAllInlineMedia) {
        this.showAllInlineMedia = showAllInlineMedia;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(profileSidebarFillColor);
        dest.writeValue(profileBackgroundTile);
        dest.writeValue(profileSidebarBorderColor);
        dest.writeValue(profileImageUrl);
        dest.writeValue(createdAt);
        dest.writeValue(location);
        dest.writeValue(followRequestSent);
        dest.writeValue(idStr);
        dest.writeValue(isTranslator);
        dest.writeValue(profileLinkColor);
        dest.writeValue(entities);
        dest.writeValue(defaultProfile);
        dest.writeValue(url);
        dest.writeValue(contributorsEnabled);
        dest.writeValue(favouritesCount);
        dest.writeValue(utcOffset);
        dest.writeValue(profileImageUrlHttps);
        dest.writeValue(id);
        dest.writeValue(listedCount);
        dest.writeValue(profileUseBackgroundImage);
        dest.writeValue(profileTextColor);
        dest.writeValue(followersCount);
        dest.writeValue(lang);
        dest.writeValue(_protected);
        dest.writeValue(geoEnabled);
        dest.writeValue(notifications);
        dest.writeValue(description);
        dest.writeValue(profileBackgroundColor);
        dest.writeValue(verified);
        dest.writeValue(timeZone);
        dest.writeValue(profileBackgroundImageUrlHttps);
        dest.writeValue(statusesCount);
        dest.writeValue(profileBackgroundImageUrl);
        dest.writeValue(defaultProfileImage);
        dest.writeValue(friendsCount);
        dest.writeValue(following);
        dest.writeValue(showAllInlineMedia);
        dest.writeValue(screenName);
    }

    public int describeContents() {
        return  0;
    }

}
