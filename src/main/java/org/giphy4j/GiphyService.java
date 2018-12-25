package org.giphy4j;

import org.giphy4j.request.random.stickers.ServiceRandomStickerRequestBuilder;
import org.giphy4j.request.schemas.request.child.UploadRequest;
import org.giphy4j.request.search.gifs.ServiceSearchRequestBuilder;
import org.giphy4j.request.random.gifs.ServiceRandomEndpointRequestBuilder;
import org.giphy4j.request.searchbyID.gifs.ServiceByIDRequestBuilder;
import org.giphy4j.request.search.stickers.ServiceStickersSearchRequestBuilder;
import org.giphy4j.request.translate.gifs.ServiceTranslateSearchRequestBuilder;
import org.giphy4j.request.translate.stickers.ServiceStickersTranslateRequestBuilder;
import org.giphy4j.request.trending.gifs.ServiceTrendingRequestBuilder;
import org.giphy4j.request.trending.stickers.ServiceTrendingStickersRequestBuilder;
import org.giphy4j.request.upload.ServiceUploadRequestBuilder;

/**
 * @author Eryk Szmyt
 * GiphyService class is responsible encapsulating Api key and passing it to requests builders
 */
public final class GiphyService {

    private String API_KEY;

    /**
     * @param ApiKey Api Key
     */
    GiphyService(String ApiKey){
        this.API_KEY = ApiKey;
    }

    /**
     * getting ServiceSearchRequest builder
     * @return builder for ServiceSearchRequest
     */
    public ServiceSearchRequestBuilder getSearchRequestBuilder(){
        return new ServiceSearchRequestBuilder(API_KEY);
    }

    /**
     * getting ServiceRandomEndpointRequest builder
     * @return builder for ServiceRandomEndpointRequest
     */
    public ServiceRandomEndpointRequestBuilder getRandomEndpointRequestBuilder(){
        return new ServiceRandomEndpointRequestBuilder(API_KEY);
    }

    /**
     * getting ServiceTrendingRequest builder
     * @return builder for ServiceTrendingRequest
     */
    public ServiceTrendingRequestBuilder getTrendingRequestBuilder(){
        return new ServiceTrendingRequestBuilder(API_KEY);
    }

    /**
     * getting RequestStickersSearch builder
     * @return builder for RequestStickersSearch
     */
    public ServiceStickersSearchRequestBuilder getStickersSearchBuilder(){
        return new ServiceStickersSearchRequestBuilder(API_KEY);
    }

    /**
     * getting ServiceByIDRequest builder
     * @return builder for ServiceByIDRequest
     */
    public ServiceByIDRequestBuilder getIDRequestBuilder(){
        return new ServiceByIDRequestBuilder(API_KEY);
    }

    /**
     * getting RequestTranslateSearch builder
     * @return builder for RequestTranslateSearch
     * */
    public ServiceTranslateSearchRequestBuilder getTranslateSearchBuilder(){
        return new ServiceTranslateSearchRequestBuilder(API_KEY);
    }

    /**
     * getting ServiceStickersTranslate builder
     * @return builder for ServiceStickersTranslate
     * */
    public ServiceStickersTranslateRequestBuilder getStickersTranslateSearchBuilder(){
        return new ServiceStickersTranslateRequestBuilder(API_KEY);
    }

    /**
     * getting ServiceRandomStickerRequest builder
     * @return builder for ServiceRandomStickerRequest
     * */
    public ServiceRandomStickerRequestBuilder getRandomStickerBuilder(){
        return new ServiceRandomStickerRequestBuilder(API_KEY);
    }

    /**
     * getting ServiceTrendingStickersRequest builder
     * @return builder for ServiceTrendingStickersRequest
     * */
    public ServiceTrendingStickersRequestBuilder getTrendingStickersBuilder(){
        return new ServiceTrendingStickersRequestBuilder(API_KEY);
    }

    /**
     * getting ServiceUploadRequestBuilder builder
     * @return builder for ServiceUploadRequestBuilder
     * */
    public ServiceUploadRequestBuilder getUploadRequestBuilder(){
        return new ServiceUploadRequestBuilder(API_KEY);
    }

    /**
     * getting GiphyService builder
     * @return builder for GiphyService
     * */
    public static GiphyServiceBuilder getBuilder(){
        return new GiphyServiceBuilder();
    }

    /**
     * getting passed api key
     * @return passed api key
     * */
    public String getApiKey(){
        return this.API_KEY;
    }
}