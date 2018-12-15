package org.giphy4j.request.parse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Images {

    @SerializedName("fixed_height_still")
    @Expose
    private FixedHeightStill fixedHeightStill;
    @SerializedName("original_still")
    @Expose
    private OriginalStill originalStill;
    @SerializedName("fixed_width")
    @Expose
    private FixedWidth fixedWidth;
    @SerializedName("fixed_height_small_still")
    @Expose
    private FixedHeightSmallStill fixedHeightSmallStill;
    @SerializedName("fixed_height_downsampled")
    @Expose
    private FixedHeightDownsampled fixedHeightDownsampled;
    @SerializedName("preview")
    @Expose
    private Preview preview;
    @SerializedName("fixed_height_small")
    @Expose
    private FixedHeightSmall fixedHeightSmall;
    @SerializedName("downsized_still")
    @Expose
    private DownsizedStill downsizedStill;
    @SerializedName("downsized")
    @Expose
    private Downsized downsized;
    @SerializedName("downsized_large")
    @Expose
    private DownsizedLarge downsizedLarge;
    @SerializedName("fixed_width_small_still")
    @Expose
    private FixedWidthSmallStill fixedWidthSmallStill;
    @SerializedName("preview_webp")
    @Expose
    private PreviewWebp previewWebp;
    @SerializedName("fixed_width_still")
    @Expose
    private FixedWidthStill fixedWidthStill;
    @SerializedName("fixed_width_small")
    @Expose
    private FixedWidthSmall fixedWidthSmall;
    @SerializedName("downsized_small")
    @Expose
    private DownsizedSmall downsizedSmall;
    @SerializedName("fixed_width_downsampled")
    @Expose
    private FixedWidthDownsampled fixedWidthDownsampled;
    @SerializedName("downsized_medium")
    @Expose
    private DownsizedMedium downsizedMedium;
    @SerializedName("original")
    @Expose
    private Original original;
    @SerializedName("fixed_height")
    @Expose
    private FixedHeight fixedHeight;
    @SerializedName("looping")
    @Expose
    private Looping looping;
    @SerializedName("original_mp4")
    @Expose
    private OriginalMp4 originalMp4;
    @SerializedName("preview_gif")
    @Expose
    private PreviewGif previewGif;
    @SerializedName("480w_still")
    @Expose
    private org.giphy4j.request.parse._480wStill _480wStill;

    public FixedHeightStill getFixedHeightStill() {
        return fixedHeightStill;
    }

    public OriginalStill getOriginalStill() {
        return originalStill;
    }

    public FixedWidth getFixedWidth() {
        return fixedWidth;
    }

    public FixedHeightSmallStill getFixedHeightSmallStill() {
        return fixedHeightSmallStill;
    }

    public FixedHeightDownsampled getFixedHeightDownsampled() {
        return fixedHeightDownsampled;
    }

    public Preview getPreview() {
        return preview;
    }

    public FixedHeightSmall getFixedHeightSmall() {
        return fixedHeightSmall;
    }

    public DownsizedStill getDownsizedStill() {
        return downsizedStill;
    }

    public Downsized getDownsized() {
        return downsized;
    }

    public DownsizedLarge getDownsizedLarge() {
        return downsizedLarge;
    }

    public FixedWidthSmallStill getFixedWidthSmallStill() {
        return fixedWidthSmallStill;
    }

    public PreviewWebp getPreviewWebp() {
        return previewWebp;
    }

    public FixedWidthStill getFixedWidthStill() {
        return fixedWidthStill;
    }

    public FixedWidthSmall getFixedWidthSmall() {
        return fixedWidthSmall;
    }

    public DownsizedSmall getDownsizedSmall() {
        return downsizedSmall;
    }

    public FixedWidthDownsampled getFixedWidthDownsampled() {
        return fixedWidthDownsampled;
    }

    public DownsizedMedium getDownsizedMedium() {
        return downsizedMedium;
    }

    public Original getOriginal() {
        return original;
    }

    public FixedHeight getFixedHeight() {
        return fixedHeight;
    }

    public Looping getLooping() {
        return looping;
    }


    public OriginalMp4 getOriginalMp4() {
        return originalMp4;
    }


    public PreviewGif getPreviewGif() {
        return previewGif;
    }

    public org.giphy4j.request.parse._480wStill get480wStill() {
        return _480wStill;
    }

}