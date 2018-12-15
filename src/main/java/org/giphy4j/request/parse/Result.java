package org.giphy4j.request.parse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Result {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("bitly_gif_url")
    @Expose
    private String bitlyGifUrl;
    @SerializedName("bitly_url")
    @Expose
    private String bitlyUrl;
    @SerializedName("embed_url")
    @Expose
    private String embedUrl;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("content_url")
    @Expose
    private String contentUrl;
    @SerializedName("source_tld")
    @Expose
    private String sourceTld;
    @SerializedName("source_post_url")
    @Expose
    private String sourcePostUrl;
    @SerializedName("is_sticker")
    @Expose
    private Integer isSticker;
    @SerializedName("import_datetime")
    @Expose
    private String importDatetime;
    @SerializedName("trending_datetime")
    @Expose
    private String trendingDatetime;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("_score")
    @Expose
    private Double score;
    @SerializedName("analytics")
    @Expose
    private Analytics analytics;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getUrl() {
        return url;
    }

    public String getBitlyGifUrl() {
        return bitlyGifUrl;
    }

    public String getBitlyUrl() {
        return bitlyUrl;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }


    public String getUsername() {
        return username;
    }


    public String getSource() {
        return source;
    }

    public String getRating() {
        return rating;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public String getSourceTld() {
        return sourceTld;
    }

    public String getSourcePostUrl() {
        return sourcePostUrl;
    }

    public Integer getIsSticker() {
        return isSticker;
    }

    public String getImportDatetime() {
        return importDatetime;
    }


    public String getTrendingDatetime() {
        return trendingDatetime;
    }

    public User getUser() {
        return user;
    }

    public Images getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }

    public Double getScore() {
        return score;
    }

    public Analytics getAnalytics() {
        return analytics;
    }

}
