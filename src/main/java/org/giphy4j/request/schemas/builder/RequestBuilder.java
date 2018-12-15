/**
 * Package for request builder schema
 * */
package org.giphy4j.request.schemas.builder;

import org.giphy4j.request.schemas.request.Request;

public abstract class RequestBuilder {

    /**
     * Giphy Api Key
     */
    protected String _ApiKey;


    /**
     * @param ApiKey Giphy Api Key
     */
    public RequestBuilder(String ApiKey){
        this._ApiKey = ApiKey;
    }


    /**
     * @return new Request
     */
    public abstract Request build();
}
