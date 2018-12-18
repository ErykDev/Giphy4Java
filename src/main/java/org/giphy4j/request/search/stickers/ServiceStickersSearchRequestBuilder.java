package org.giphy4j.request.search.stickers;

import org.giphy4j.interfaces.OnResponseError;
import org.giphy4j.interfaces.OnMultiSearchSuccess;
import org.giphy4j.request.Language;
import org.giphy4j.request.Rating;
import org.giphy4j.request.schemas.builder.RequestBuilder;

/**
 * @author Eryk Szmyt
 * Builder for ServiceStickersSearchRequest
 */
public final class ServiceStickersSearchRequestBuilder extends RequestBuilder {

    private int _Limit = 20;
    private int _Offset = 20;
    private String _Rating = "";
    private String _Query = null;
    private Language _Language = Language.English;
    private OnMultiSearchSuccess _OnMultiSearchSuccess = null;
    private OnResponseError _OnResponseError = null;

    /**
     * @param ApiKey Giphy Api Key
     */
    public ServiceStickersSearchRequestBuilder(String ApiKey){
        super(ApiKey);
    }

    /**
     * Setting max number of results
     * @param _Limit max numbers of results
     */
    public ServiceStickersSearchRequestBuilder setLimit(int _Limit) {
        this._Limit = _Limit;
        return this;
    }

    /**
     * Setting minimal number of results
     * @param _Offset min number of results
     */
    public ServiceStickersSearchRequestBuilder setOffset(int _Offset) {
        this._Offset = _Offset;
        return this;
    }

    /**
     * Setting the rate query
     * @param _Rating sticker rating
     */
    public ServiceStickersSearchRequestBuilder setRating(Rating _Rating) {
        this._Rating = _Rating.toString();
        return this;
    }

    /**
     * @param _Query setting searching query
     */
    public ServiceStickersSearchRequestBuilder setQuery(String _Query) {
        this._Query = _Query;
        return this;
    }

    /**
     * @param _Language setting aiming Language
     */
    public ServiceStickersSearchRequestBuilder setLanguage(Language _Language) {
        this._Language = _Language;
        return this;
    }


    /**
     * Setting on Success request action
     * @param _OnMultiSearchSuccess onSuccess Action
     */
    public ServiceStickersSearchRequestBuilder setOnSuccess(OnMultiSearchSuccess _OnMultiSearchSuccess) {
        this._OnMultiSearchSuccess = _OnMultiSearchSuccess;
        return this;
    }

    /**
     * Setting on failed request action
     * @param _OnResponseError on Error action
     */
    public ServiceStickersSearchRequestBuilder setOnError(OnResponseError _OnResponseError) {
        this._OnResponseError = _OnResponseError;
        return this;
    }

    /**
     * building new RequestStickersSearch
     * @return new RequestStickersSearch
     */
    @Override
    public RequestStickersSearch build(){
        if (_Query == null)
            throw new Error("Missing Query");

        return new RequestStickersSearch(_ApiKey,_Limit,_Offset,_Query,_Rating,_Language, _OnMultiSearchSuccess, _OnResponseError);
    }
}
