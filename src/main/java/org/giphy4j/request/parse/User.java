package org.giphy4j.request.parse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class User {

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("banner_url")
    @Expose
    private String bannerUrl;
    @SerializedName("banner_image")
    @Expose
    private String bannerImage;
    @SerializedName("profile_url")
    @Expose
    private String profileUrl;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("is_verified")
    @Expose
    private Boolean isVerified;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }
}
