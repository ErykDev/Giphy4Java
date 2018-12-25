package org.giphy4j.request.search.gifs;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.giphy4j.exceptions.NoResultException;
import org.giphy4j.exceptions.response.ResponseError;
import org.giphy4j.interfaces.OnResponseError;
import org.giphy4j.interfaces.OnMultiSearchSuccess;
import org.giphy4j.request.Language;
import org.giphy4j.request.schemas.request.child.MultiResultRequest;
import org.giphy4j.request.parse.MultiParsedResult;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Eryk Szmyt
 *
 * Request on gif search Endpoint
 */
public final class ServiceSearchRequest extends MultiResultRequest {

    private int _Limit;
    private int _Offset;
    private String _Rating;
    private Language _Language;
    private OnMultiSearchSuccess _OnMultiSearchSuccess;
    private String _Query;
    private OnResponseError _OnResponseError = err -> {
        throw new Error(err.getResponseCode()+"  "+err.getMessage());
    };


    /**
     * @param ApiKey Giphy ApiKey
     * @param limit limit of results
     * @param offset minimal number of results
     * @param query searching query
     * @param rating rating query
     * @param language searching language
     * @param onMultiSearchSuccess on Success action
     * @param onResponseError on Error action
     */
    ServiceSearchRequest(String ApiKey, int limit, int offset, String query, String rating, Language language, OnMultiSearchSuccess onMultiSearchSuccess, OnResponseError onResponseError){
        super(ApiKey);
        this._Limit = limit;
        this._Offset = offset;
        this._Rating = rating;
        this._Language = language;
        this._OnMultiSearchSuccess = onMultiSearchSuccess;
        this._Query = query;
        if (onResponseError != null)
        this._OnResponseError = onResponseError;
    }


    /**
     * Builds request link
     * @return request link
     */
    @Override
    protected String generateUrl() {

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.giphy.com/v1/gifs/search").newBuilder();

        if (_Rating.equals("")) {
            urlBuilder.addQueryParameter("api_key", _ApiKey);
            urlBuilder.addQueryParameter("q", _Query);
            urlBuilder.addQueryParameter("limit", String.valueOf(_Limit));
            urlBuilder.addQueryParameter("offset", String.valueOf(_Offset));
            urlBuilder.addQueryParameter("lang", _Language.toString());
        }else {
            urlBuilder.addQueryParameter("api_key", _ApiKey);
            urlBuilder.addQueryParameter("q", _Query);
            urlBuilder.addQueryParameter("limit", String.valueOf(_Limit));
            urlBuilder.addQueryParameter("offset", String.valueOf(_Offset));
            urlBuilder.addQueryParameter("rating", _Rating);
            urlBuilder.addQueryParameter("lang", _Language.toString());
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
     * Executing request on /v1/gifs/search
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

            if (pr.getMeta().getStatus() == 200 || pr.getMeta().getStatus() == 202)
                    if (!pr.getData().isEmpty()) {
                        try {
                            _OnMultiSearchSuccess.run(pr.getData());
                        }catch (NullPointerException e){}

                        return pr;

                    }else {
                        _OnResponseError.run(new ResponseError(pr.getMeta().getStatus(),pr.getMeta().getMsg()));
                    }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            throw new NoResultException("There is no results for: "+_Query);
        }
        throw new NoResultException("There is no results for: "+_Query);
    }

    /**
     * Executing request with optional result
     * @return optional request result
     * */
    @Override
    public Optional<MultiParsedResult> executeForOptional() {
        try {
            return Optional.ofNullable(this.execute());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}
