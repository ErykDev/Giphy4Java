/**
 * Package for random sticker request
 * */
package org.giphy4j.request.random.stickers;

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
 * Request for RandomSticker Endpoint
 */
public final class ServiceRandomStickerRequest extends SingleResultRequest {

    private String _Rating = null;
    private String _Tag = null;
    private OnSingleSearchSuccess _OnSingleSearchSuccess;
    private OnResponseError _OnResponseError = err -> {
        throw new Error(err.getResponseCode()+"  "+err.getMessage());
    };

    /**
     * @param ApiKey Giphy Api Key
     * @param onSearchSuccess on success action
     * @param onResponseError on error action
     * @param Rating rating query to search
     * @param Tag tag query to search
     */
    ServiceRandomStickerRequest(String ApiKey, OnSingleSearchSuccess onSearchSuccess, OnResponseError onResponseError, String Rating, String Tag){
        super(ApiKey);
        this._Rating = Rating;
        this._Tag = Tag;
        this._OnSingleSearchSuccess = onSearchSuccess;
        if (onResponseError != null)
            this._OnResponseError = onResponseError;
    }

    /**
     * Builds request link
     * @return request link
     */
    @Override
    protected String generateUrl() {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.giphy.com/v1/stickers/random").newBuilder();

        urlBuilder.addQueryParameter("api_key", _ApiKey);

        if (_Rating != null)
            urlBuilder.addQueryParameter("rating", _Rating);

        if (_Tag != null)
            urlBuilder.addQueryParameter("tag", _Tag);

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
     * Executing request on /v1/gifs/random
     * @return SingleParsedResult
     * @throws NoResultException while results counts is equal to zero
     */
    @Override
    public SingleParsedResult execute() throws NoResultException {
        try {
            Request request = new Request.Builder()
                    .url(generateUrl())
                    .build();

            Response response = client.newCall(request).execute();

            assert response.body() != null;
            SingleParsedResult prr = gson.fromJson(response.body().string(),SingleParsedResult.class);

            if (prr.getMeta().getStatus() == 200 || prr.getMeta().getStatus() == 202) {
                try {
                    _OnSingleSearchSuccess.run(prr.getData());
                } catch (NullPointerException ignored) {}

                return prr;
            }else{
                _OnResponseError.run(new ResponseError(prr.getMeta().getStatus(),prr.getMeta().getMsg()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new NoResultException("There is no results for: "+_Tag);
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
