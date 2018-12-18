package org.giphy4j.request.random.gifs;

import org.giphy4j.interfaces.OnResponseError;
import org.giphy4j.interfaces.OnSingleSearchSuccess;
import org.giphy4j.request.Rating;
import org.giphy4j.request.schemas.builder.RequestBuilder;

/**
 * @author Eryk Szmyt
 * Builder for ServiceRandomEndpointRequest
 */
public final class ServiceRandomEndpointRequestBuilder extends RequestBuilder {

    private String _Rating = null;
    private String _Tag = null;
    private OnSingleSearchSuccess _OnSingleSearchSuccess = null;
    private OnResponseError _OnResponseError = null;

    /**
     * @param ApiKey Giphy Api Key
     */
    public ServiceRandomEndpointRequestBuilder(String ApiKey){
        super(ApiKey);
    }

    /**
     * Setting the rate query
     * @param _Rating sticker rating
     */
    public ServiceRandomEndpointRequestBuilder setRating(Rating _Rating) {
        this._Rating = _Rating.toString();
        return this;
    }

    /**
     * Setting searching tag
     * @param _Tag searching tag
     */
    public ServiceRandomEndpointRequestBuilder setTag(String _Tag) {
        this._Tag = _Tag;
        return this;
    }

    /**
     * Setting on Success request action
     * @param _OnSearchSuccess onSuccess Action
     */
    public ServiceRandomEndpointRequestBuilder setOnSuccess(OnSingleSearchSuccess _OnSearchSuccess) {
        this._OnSingleSearchSuccess = _OnSearchSuccess;
        return this;
    }

    /**
     * Setting on failed request action
     * @param _OnResponseError on Error action
     */
    public ServiceRandomEndpointRequestBuilder setOnError(OnResponseError _OnResponseError){
        this._OnResponseError = _OnResponseError;
        return this;
    }

    /**
     * building new ServiceRandomEndpointRequest
     * @return new ServiceRandomEndpointRequest
     */
    @Override
    public ServiceRandomEndpointRequest build() {
        return new ServiceRandomEndpointRequest(_ApiKey, _OnSingleSearchSuccess, _OnResponseError,_Rating,_Tag);
    }
}
