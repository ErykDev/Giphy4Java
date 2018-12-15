package org.giphy4j.request.search.gifs;

import org.giphy4j.interfaces.OnError;
import org.giphy4j.interfaces.OnMultiSearchSuccess;
import org.giphy4j.request.Language;
import org.giphy4j.request.schemas.builder.RequestBuilder;

/**
 * @author Eryk Szmyt
 * Builder for ServiceSearchRequest
 */
public final class ServiceSearchRequestBuilder extends RequestBuilder {

    private int _Limit = 20;
    private int _Offset = 20;
    private String _Rating = "";
    private String _Query = null;
    private Language _Language = Language.English;
    private OnMultiSearchSuccess _OnMultiSearchSuccess = null;
    private OnError _OnError = null;

    /**
     * @param ApiKey Giphy Api Key
     */
    public ServiceSearchRequestBuilder(String ApiKey){
        super(ApiKey);
    }

    /**
     * Setting max number of results
     * @param _Limit max numbers of results
     */
    public ServiceSearchRequestBuilder setLimit(int _Limit) {
        if (_Limit > 1)
        this._Limit = _Limit;
        return this;
    }

    /**
     * Setting minimal number of results
     * @param _Offset min number of results
     */
    public ServiceSearchRequestBuilder setOffset(int _Offset) {
        if (_Offset > 1)
        this._Offset = _Offset;
        return this;
    }

    /**
     * Setting the rate query
     * @param _Rating sticker rating
     */
    public ServiceSearchRequestBuilder setRating(String _Rating) {
        this._Rating = _Rating;
        return this;
    }

    /**
     * @param _Language setting aiming Language
     */
    public ServiceSearchRequestBuilder setLanguage(Language _Language) {
        this._Language = _Language;
        return this;
    }

    /**
     * Setting on Success request action
     * @param _OnMultiSearchSuccess onSuccess Action
     */
    public ServiceSearchRequestBuilder setOnSuccess(OnMultiSearchSuccess _OnMultiSearchSuccess) {
        this._OnMultiSearchSuccess = _OnMultiSearchSuccess;
        return this;
    }

    /**
     * @param _Query setting searching query
     */
    public ServiceSearchRequestBuilder setQuery(String _Query) {
        this._Query = _Query;
        return this;
    }

    /**
     * Setting on failed request action
     * @param _OnError on Error action
     */
    public ServiceSearchRequestBuilder setOnError(OnError _OnError){
        this._OnError = _OnError;
        return this;
    }

    /**
     * building new ServiceSearchRequest
     * @return new ServiceSearchRequest
     */
    @Override
    public ServiceSearchRequest build() {
        if (_Query == null)
            throw new Error("Missing search Query");

            return new ServiceSearchRequest(_ApiKey,_Limit,_Offset, _Query, _Rating,_Language, _OnMultiSearchSuccess, _OnError);
    }
}
