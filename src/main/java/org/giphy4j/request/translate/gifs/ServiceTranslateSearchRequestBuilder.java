package org.giphy4j.request.translate.gifs;

import org.giphy4j.interfaces.OnError;
import org.giphy4j.interfaces.OnSingleSearchSuccess;
import org.giphy4j.request.schemas.builder.RequestBuilder;

/**
 * @author Eryk Szmyt
 * Builder for ServiceTranslateSearchRequest
 */
public final class ServiceTranslateSearchRequestBuilder extends RequestBuilder {

    private String _Query = null;
    private int _Weirdness = 5;
    private OnSingleSearchSuccess _OnSearchSuccess = null;
    private OnError _OnError = null;


    /**
     * @param ApiKey Giphy ApiKey
     */
    public ServiceTranslateSearchRequestBuilder(String ApiKey){
        super(ApiKey);
    }

    /**
     * Setting on failed request action
     * @param OnError on Error action
     */
    public ServiceTranslateSearchRequestBuilder setOnError(OnError OnError){
        this._OnError = OnError;
        return this;
    }

    /**
     * Setting on Success request action
     * @param onSingleSearchSuccess onSuccess Action
     */
    public ServiceTranslateSearchRequestBuilder setOnSuccess(OnSingleSearchSuccess onSingleSearchSuccess){
        this._OnSearchSuccess = onSingleSearchSuccess;
        return this;
    }

    /**
     * @param Query setting searching query
     */
    public ServiceTranslateSearchRequestBuilder setQuery(String Query) {
        this._Query = Query;
        return this;
    }

    /**
     * @param _Weirdness value from 0-10 which makes results more or less weird/random/wtf
     * */
    public ServiceTranslateSearchRequestBuilder setWeirdness(int _Weirdness) {
        if (_Weirdness > -1 && _Weirdness < 11)
        this._Weirdness = _Weirdness;
        return this;
    }

    /**
     * building new RequestTranslateSearch
     * @return new RequestTranslateSearch
     */
    @Override
    public RequestTranslateSearch build(){
        if (_Query == null)
            throw new Error("Missing query");

        return new RequestTranslateSearch(_ApiKey,_Query, _Weirdness, _OnSearchSuccess,_OnError);
    }
}
