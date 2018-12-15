package org.giphy4j.request.searchbyID.gifs;

import org.giphy4j.interfaces.OnError;
import org.giphy4j.interfaces.OnSingleSearchSuccess;
import org.giphy4j.request.schemas.builder.RequestBuilder;

/**
 * @author Eryk Szmyt
 * ServiceByIDRequest builder
 */
public final class ServiceByIDRequestBuilder extends RequestBuilder {

    private String _IDs = null;
    private OnSingleSearchSuccess onSingleSearchSuccess;
    private OnError _OnError;

    /**
     * @param ApiKey Giphy ApiKey
     */
    public ServiceByIDRequestBuilder(String ApiKey){
        super(ApiKey);
    }


    /**
     * Setting searching gif's id query
     * @param ID gif ID
     */
    public ServiceByIDRequestBuilder setID(String ID) {
        this._IDs = ID;
        return this;
    }

    /**
     * Setting on Success request action
     * @param onSingleSearchSuccess onSuccess Action
     */
    public ServiceByIDRequestBuilder setOnSuccess(OnSingleSearchSuccess onSingleSearchSuccess) {
        this.onSingleSearchSuccess = onSingleSearchSuccess;
        return this;
    }

    /**
     * Setting on failed request action
     * @param _OnError on Error action
     */
    public ServiceByIDRequestBuilder setOnError(OnError _OnError) {
        this._OnError = _OnError;
        return this;
    }

    /**
     * building new ServiceByIDRequest
     * @return new ServiceByIDRequest
     */
    @Override
    public ServiceByIDRequest build(){
        return new ServiceByIDRequest(_ApiKey,_IDs, onSingleSearchSuccess,_OnError);
    }

}
