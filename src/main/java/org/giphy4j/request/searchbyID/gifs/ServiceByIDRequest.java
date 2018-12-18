/**
 * Package for requesting gif by id
 * */
package org.giphy4j.request.searchbyID.gifs;

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

/**
 * @author Eryk Szmyt
 * Request for Get by ID Endpoint
 */
public final class ServiceByIDRequest extends SingleResultRequest {

    private String _IDs;
    private OnSingleSearchSuccess _onSingleSearchSuccess;
    private OnResponseError _OnResponseError = err -> {
        throw new Error(err.getResponseCode()+"  "+err.getMessage());
    };

    /**
     * @param ApiKey Giphy ApiKey
     * @param Ids Searching gif id
     * @param onSingleSearchSuccess on success request action
     * @param onResponseError on failed request action
     */
    ServiceByIDRequest(String ApiKey, String Ids, OnSingleSearchSuccess onSingleSearchSuccess, OnResponseError onResponseError){
        super(ApiKey);
        this._IDs = Ids;
        this._onSingleSearchSuccess = onSingleSearchSuccess;
        if (onResponseError != null)
        this._OnResponseError = onResponseError;
    }

    /**
     * Builds request link
     * @return request link
     */
    @Override
    protected String generateUrl() {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.giphy.com/v1/gifs/"+_IDs).newBuilder();

            urlBuilder.addQueryParameter("api_key", _ApiKey);

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
     * Executing request on /v1/gifs/{ID}
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

            if (prr.getMeta().getStatus() == 200 || prr.getMeta().getStatus() == 202)
                try {
                    _onSingleSearchSuccess.run(prr.getData());
                }catch (NullPointerException ignored){ }
            else{
                _OnResponseError.run(new ResponseError(prr.getMeta().getStatus(),prr.getMeta().getMsg()));
            }
            return prr;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
