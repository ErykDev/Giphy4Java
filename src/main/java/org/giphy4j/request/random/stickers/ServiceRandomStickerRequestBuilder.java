package org.giphy4j.request.random.stickers;

import org.giphy4j.interfaces.OnError;
import org.giphy4j.interfaces.OnSingleSearchSuccess;
import org.giphy4j.request.Rating;
import org.giphy4j.request.schemas.builder.RequestBuilder;
import org.giphy4j.request.search.gifs.ServiceSearchRequestBuilder;

/**
 * @author Eryk Szmyt
 * Builder for ServiceRandomStickerRequest
 */
public final class ServiceRandomStickerRequestBuilder extends RequestBuilder {

    private String _Rating = null;
    private String _Tag = null;
    private OnSingleSearchSuccess _OnSingleSearchSuccess = null;
    private OnError _OnError = null;

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
     * @param _OnError on Error action
     */
    public ServiceRandomStickerRequestBuilder setOnError(OnError _OnError){
        this._OnError = _OnError;
        return this;
    }

    /**
     * building new ServiceRandomStickerRequest
     * @return new ServiceRandomStickerRequest
     */
    @Override
    public ServiceRandomStickerRequest build() {
        return new ServiceRandomStickerRequest(_ApiKey, _OnSingleSearchSuccess,_OnError,_Rating,_Tag);
    }

}
