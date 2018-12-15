package org.giphy4j.request.parse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Analytics {

    @SerializedName("onload")
    @Expose
    private Onload onload;
    @SerializedName("onclick")
    @Expose
    private Onclick onclick;
    @SerializedName("onsent")
    @Expose
    private Onsent onsent;

    public Onload getOnload() {
        return onload;
    }

    public Onclick getOnclick() {
        return onclick;
    }

    public Onsent getOnsent() {
        return onsent;
    }
}