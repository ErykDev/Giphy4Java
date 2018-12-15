package org.giphy4j.request.parse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Meta {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("response_id")
    @Expose
    private String responseId;

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

}
