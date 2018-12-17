/**
 * Package for search sticker request
 * */
package org.giphy4j.request.search.stickers;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.giphy4j.exceptions.NoResultException;
import org.giphy4j.exceptions.response.ResponseError;
import org.giphy4j.interfaces.OnError;
import org.giphy4j.interfaces.OnMultiSearchSuccess;
import org.giphy4j.request.Language;
import org.giphy4j.request.schemas.request.child.MultiResultRequest;
import org.giphy4j.request.parse.MultiParsedResult;

import java.io.IOException;

/**
 * @author Eryk Szmyt
 * Request for StickersSearch Endpoint
 */
public final class RequestStickersSearch extends MultiResultRequest {

    private int _Limit;
    private int _Offset;
    private String _Rating ="";
    private Language _Lang;
    private OnMultiSearchSuccess _OnMultiSearchSuccess = null;
    private String _Query;
    private OnError _OnError = err -> {
        throw new Error(err.getResponseCode()+"  "+err.getMessage());
    };


    /**
     * @param ApiKey Giphy ApiKey
     * @param limit limit of results
     * @param offset minimal number of results
     * @param rating rating query
     * @param language searching language
     * @param onMultiSearchSuccess on Success action
     * @param onError on Error action
     */
    RequestStickersSearch(String ApiKey, int limit, int offset, String query, String rating, Language language, OnMultiSearchSuccess onMultiSearchSuccess, OnError onError){
        super(ApiKey);
        this._Limit = limit;
        this._Offset = offset;
        this._Query = query;
        if (rating != null)
        this._Rating = rating;
        this._Lang = language;
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

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.giphy.com/v1/stickers/search").newBuilder();

        if (_Rating.equals("")) {
            urlBuilder.addQueryParameter("api_key", _ApiKey);
            urlBuilder.addQueryParameter("q", _Query);
            urlBuilder.addQueryParameter("limit", String.valueOf(_Limit));
            urlBuilder.addQueryParameter("offset", String.valueOf(_Offset));
            urlBuilder.addQueryParameter("lang", _Lang.toString());
        }else {
            urlBuilder.addQueryParameter("api_key", _ApiKey);
            urlBuilder.addQueryParameter("q", _Query);
            urlBuilder.addQueryParameter("limit", String.valueOf(_Limit));
            urlBuilder.addQueryParameter("offset", String.valueOf(_Offset));
            urlBuilder.addQueryParameter("rating", _Rating);
            urlBuilder.addQueryParameter("lang", _Lang.toString());
        }

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
     * Executing request on /v1/stickers/search
     * @return MultiParsedResult
     * @throws NoResultException while results counts is equal to zero
     */
    @Override
    public MultiParsedResult execute() throws NoResultException {
        try {
            Request request = new Request.Builder()
                    .url(generateUrl())
                    .build();

            Response res = client.newCall(request).execute();

            assert res.body() != null;
            MultiParsedResult pr = gson.fromJson(res.body().string(),MultiParsedResult.class);

            if (pr.getMeta().getStatus() == 200 || pr.getMeta().getStatus() == 202)

                    if (!pr.getData().isEmpty()) {
                        try {
                            _OnMultiSearchSuccess.run(pr.getData());
                        }catch (NullPointerException ignored){}
                    }else {
                        _OnError.run(new ResponseError(pr.getMeta().getStatus(),pr.getMeta().getMsg()));
                        throw new NoResultException("There is no results for: "+_Query);
                    }

            return pr;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            throw new NoResultException("There is no results for: "+_Query);
        }
        return null;
    }
}
