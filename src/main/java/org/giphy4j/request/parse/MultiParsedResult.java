package org.giphy4j.request.parse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class MultiParsedResult {

    @SerializedName("data")
    @Expose
    private List<Result> data = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<Result> getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public Meta getMeta() {
        return meta;
    }
}