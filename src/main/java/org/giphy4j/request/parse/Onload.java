package org.giphy4j.request.parse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Onload {

    @SerializedName("url")
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }
}