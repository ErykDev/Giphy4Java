package org.giphy4j.request.parse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Pagination {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getOffset() {
        return offset;
    }
}
