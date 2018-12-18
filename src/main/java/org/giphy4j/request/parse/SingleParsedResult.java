package org.giphy4j.request.parse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class SingleParsedResult {
    @SerializedName("data")
    @Expose
    private Result data;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public Result getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }
}