/**
 * Package for trending gif request
 * */
package org.giphy4j.request.trending.gifs;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.giphy4j.exceptions.NoResultException;
import org.giphy4j.exceptions.response.ResponseError;
import org.giphy4j.interfaces.OnError;
import org.giphy4j.interfaces.OnMultiSearchSuccess;
import org.giphy4j.request.schemas.request.child.MultiResultRequest;
import org.giphy4j.request.parse.MultiParsedResult;

import java.io.IOException;


/**
 * @author Eryk Szmyt
 * Requesting Trending Endpoint
 */
public final class ServiceTrendingRequest extends MultiResultRequest {
    private int _Limit;
    private int _Offset;
    private String _Rating;
    private OnMultiSearchSuccess _OnMultiSearchSuccess;
    private OnError _OnError = err -> {
        throw new Error(err.getResponseCode()+"  "+err.getMessage());
    };

    /**
     * @param ApiKey Giphy ApiKey
     * @param limit limit of results
     * @param offset minimal number of results
     * @param rating rating query
     * @param onMultiSearchSuccess on Success action
     * @param onError on Error action
     */
    ServiceTrendingRequest(String ApiKey, int limit, int offset, String rating, OnMultiSearchSuccess onMultiSearchSuccess, OnError onError) {
        super(ApiKey);
        this._Limit = limit;
        this._Offset = offset;
        this._Rating = rating;
        this._OnMultiSearchSuccess = onMultiSearchSuccess;
        if (onError != null)
            this._OnError = onError;
    }

    /**
     * Builds request link
     * @return request link
     */
    @Override
    protected String generateUrl() {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.giphy.com/v1/gifs/trending").newBuilder();

        urlBuilder.addQueryParameter("api_key", _ApiKey);

        if (!_Rating.equals(""))
            urlBuilder.addQueryParameter("rating", _Rating);

            urlBuilder.addQueryParameter("limit", String.valueOf(_Limit));
            urlBuilder.addQueryParameter("offset", String.valueOf(_Offset));

        return urlBuilder.build().toString();
    }


    /**
     * Executing request on /v1/gifs/trending
     * @return MultiParsedResult
     * @throws NoResultException while results counts is equal to zero
     */
    @Override
    public MultiParsedResult execute() throws NoResultException {
        try {
            Request request = new Request.Builder()
                    .url(generateUrl())
                    .build();

            Response response = client.newCall(request).execute();

            assert response.body() != null;
            MultiParsedResult pr = gson.fromJson(response.body().string(),MultiParsedResult.class);

            if (pr.getMeta().getStatus() == 200 || pr.getMeta().getStatus() == 202) {
                if (pr.getData().isEmpty()) {
                    throw new NoResultException("There is no trending");
                }
                try {
                    _OnMultiSearchSuccess.run(pr.getData());
                }catch (NullPointerException ignored){}
            }else{
                _OnError.run(new ResponseError(pr.getMeta().getStatus(),pr.getMeta().getMsg()));
            }
            return pr;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            throw new NoResultException("There is no trending");
        }
        return null;
    }
}