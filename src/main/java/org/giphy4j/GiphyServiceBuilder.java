package org.giphy4j;

/**
 * @author Eryk Szmyt
 * GiphyServiceBuilder is responsible fo building GiphyService class
 * */
public final class GiphyServiceBuilder {

    private String Api_Key ="";

    /**
     * @param ApiKey Giphy Api Key
     */
    public GiphyServiceBuilder setApiKey(String ApiKey){
        this.Api_Key = ApiKey;
        return this;
    }

    /**
     * Building GiphyService
     * */
    public GiphyService build(){
        if (Api_Key.trim().isEmpty()){
            throw new Error("Missing Api Key");
        }else
            return new GiphyService(Api_Key);
    }
}