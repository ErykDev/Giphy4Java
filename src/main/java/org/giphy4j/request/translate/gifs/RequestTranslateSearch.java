/**
 * Package for translate gif request
 * */
package org.giphy4j.request.translate.gifs;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.giphy4j.exceptions.NoResultException;
import org.giphy4j.exceptions.response.ResponseError;
import org.giphy4j.interfaces.OnResponseError;
import org.giphy4j.interfaces.OnSingleSearchSuccess;
import org.giphy4j.request.parse.SingleParsedResult;
import org.giphy4j.request.schemas.request.child.SingleResultRequest;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Eryk Szmyt
 * Requesting TranslateSearch EndPoint
 */
public final class RequestTranslateSearch extends SingleResultRequest {

    private String _Query;
    private int _Weirdness;
    private OnSingleSearchSuccess _OnSearchSuccess = null;
    private OnResponseError _OnResponseError = err -> {
        throw new Error(err.getResponseCode()+"  "+err.getMessage());
    };

    /**
     * @param _ApiKey Giphy ApiKey
     * @param _Query Searching query
     * @param weirdness Weirdness level 0~10
     * @param onSearchSuccess on success action
     * @param onResponseError on error action
     */
    RequestTranslateSearch(String _ApiKey, String _Query, int weirdness, OnSingleSearchSuccess onSearchSuccess, OnResponseError onResponseError){
        super(_ApiKey);
        this._Query = _Query;
        this._OnSearchSuccess = onSearchSuccess;
        this._Weirdness = weirdness;
        if (onResponseError != null)
        this._OnResponseError = onResponseError;
    }

    /**
     * Builds request link
     * @return request link
     */
    @Override
    protected String generateUrl() {

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.giphy.com/v1/gifs/translate").newBuilder();

            urlBuilder.addQueryParameter("api_key", _ApiKey);
            urlBuilder.addQueryParameter("s", _Query);
            urlBuilder.addQueryParameter("weirdness", String.valueOf(_Weirdness));

        return urlBuilder.build().toString();
    }

    /**
     * Wraps request into new thread
     * */
    @Override
    public Thread wrapIntoThread() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    execute();
                } catch (NoResultException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Executing request on /v1/gifs/translate
     * @return SingleParsedResult
     * @throws NoResultException while results counts is equal to zero
     */
    @Override
    public SingleParsedResult execute() throws NoResultException {
        try {
            Request request = new Request.Builder()
                    .url(generateUrl())
                    .build();

            Response res = client.newCall(request).execute();

            assert res.body() != null;
            SingleParsedResult pr = gson.fromJson(res.body().string(),SingleParsedResult.class);

            if (pr.getMeta().getStatus() == 200 || pr.getMeta().getStatus() == 202) {

                if (pr.getData() != null) {
                    try {
                        _OnSearchSuccess.run(pr.getData());
                    } catch (java.lang.NullPointerException ignored) {}

                    return pr;

                } else
                    throw new NoResultException("There is no results for: " + _Query);
            }else{
                    _OnResponseError.run(new ResponseError(pr.getMeta().getStatus(),pr.getMeta().getMsg()));
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        throw new NoResultException("There is no results for: "+_Query);
    }

    /**
     * Executing request with optional result
     * @return optional request result
     * */
    @Override
    public Optional<SingleParsedResult> executeForOptional() {
        try {
            return Optional.ofNullable(this.execute());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}
