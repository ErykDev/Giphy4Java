package org.giphy4j.request.parse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Preview {

    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("mp4")
    @Expose
    private String mp4;
    @SerializedName("mp4_size")
    @Expose
    private String mp4Size;

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getMp4() {
        return mp4;
    }

    public String getMp4Size() {
        return mp4Size;
    }
}