package org.giphy4j.request.parse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Original {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("frames")
    @Expose
    private String frames;
    @SerializedName("mp4")
    @Expose
    private String mp4;
    @SerializedName("mp4_size")
    @Expose
    private String mp4Size;
    @SerializedName("webp")
    @Expose
    private String webp;
    @SerializedName("webp_size")
    @Expose
    private String webpSize;

    public String getUrl() {
        return url;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getSize() {
        return size;
    }

    public String getFrames() {
        return frames;
    }

    public String getMp4Link() {
        return mp4;
    }

    public String getMp4Size() {
        return mp4Size;
    }

    public String getWebp() {
        return webp;
    }

    public String getWebpSize() {
        return webpSize;
    }
}
