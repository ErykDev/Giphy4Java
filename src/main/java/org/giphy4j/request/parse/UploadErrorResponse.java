package org.giphy4j.request.parse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class UploadErrorResponse {

    @SerializedName("data")
    @Expose
    private List<Object> data = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<Object> getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }

}