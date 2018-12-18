package org.giphy4j.request.random.stickers;

import org.giphy4j.interfaces.OnResponseError;
import org.giphy4j.interfaces.OnSingleSearchSuccess;
import org.giphy4j.request.Rating;
import org.giphy4j.request.schemas.builder.RequestBuilder;

/**
 * @author Eryk Szmyt
 * Builder for ServiceRandomStickerRequest
 */
public final class ServiceRandomStickerRequestBuilder extends RequestBuilder {

    private String _Rating = null;
    private String _Tag = null;
    private OnSingleSearchSuccess _OnSingleSearchSuccess = null;
    private OnResponseError _OnResponseError = null;

    /**
     * @param ApiKey Giphy ApiKey
     */
    public ServiceRandomStickerRequestBuilder(String ApiKey){
        super(ApiKey);
    }

    /**
     * Setting the rate query
     * @param _Rating sticker rating
     */
    public ServiceRandomStickerRequestBuilder setRating(Rating _Rating) {
        this._Rating = _Rating.toString();
        return this;
    }

    /**
     * Setting searching tag
     * @param _Tag searching tag
     */
    public ServiceRandomStickerRequestBuilder setTag(String _Tag) {
        this._Tag = _Tag;
        return this;
    }

    /**
     * Setting on Success request action
     * @param _OnSearchSuccess onSuccess Action
     */
    public ServiceRandomStickerRequestBuilder setOnSuccess(OnSingleSearchSuccess _OnSearchSuccess) {
        this._OnSingleSearchSuccess = _OnSearchSuccess;
        return this;
    }

    /**
     * Setting on failed request action
     * @param _OnResponseError on Error action
     */
    public ServiceRandomStickerRequestBuilder setOnError(OnResponseError _OnResponseError){
        this._OnResponseError = _OnResponseError;
        return this;
    }

    /**
     * building new ServiceRandomStickerRequest
     * @return new ServiceRandomStickerRequest
     */
    @Override
    public ServiceRandomStickerRequest build() {
        return new ServiceRandomStickerRequest(_ApiKey, _OnSingleSearchSuccess, _OnResponseError,_Rating,_Tag);
    }

}
