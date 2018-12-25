package org.giphy4j.request.schemas.request;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;

public abstract class Request {


    /**
     * http client for future requests
     */
    static protected OkHttpClient client = new OkHttpClient();

    /**
     * json parser for future requests
     */
    static protected Gson gson = new Gson();

    /**
     * Giphy Api Key
     * */
    protected String _ApiKey;

    /**
     * @param ApiKey Giphy Api Key
     */
    public Request(String ApiKey){
        this._ApiKey = ApiKey;
    }


    /**
     * @return generated url ready to request
     */
    protected abstract String generateUrl();

    /**
     * Wraps request into thread
     * */
    public abstract Thread wrapIntoThread();
}
