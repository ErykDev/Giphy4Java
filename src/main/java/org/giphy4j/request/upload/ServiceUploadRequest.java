package org.giphy4j.request.upload;

import okhttp3.*;
import org.giphy4j.exceptions.UploadException;
import org.giphy4j.exceptions.response.ResponseError;
import org.giphy4j.interfaces.OnResponseError;
import org.giphy4j.interfaces.OnUploadSucces;
import org.giphy4j.request.parse.UploadErrorResponse;
import org.giphy4j.request.schemas.request.child.UploadRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public final class ServiceUploadRequest extends UploadRequest {

    private File _Gif = null;
    private String _Username = null;
    private String _Source_image_url = null;
    private String _Source_post_url = null;
    private ArrayList<String> _Tags = null;
    private OnUploadSucces _OnUploadSucces = null;
    private OnResponseError _OnResponseError = err -> {
        throw new Error(err.getResponseCode()+"  "+err.getMessage());
    };

    /**
     * @param ApiKey Giphy Api Key
     */
    ServiceUploadRequest(String ApiKey, File Gif, String Username, String _Source_image_url, String _Source_post_url, ArrayList<String> _Tags, OnUploadSucces onUploadSucces, OnResponseError onResponseError) {
        super(ApiKey);
        this._Gif = Gif;
        this._Username = Username;
        this._Source_image_url = _Source_image_url;
        this._Source_post_url = _Source_post_url;
        this._Tags = _Tags;
        this._OnUploadSucces = onUploadSucces;
        if (onResponseError != null)
        this._OnResponseError = onResponseError;
    }

    /**
     * Builds request link
     * @return request link
     */
    @Override
    protected String generateUrl() {
        return "https://upload.giphy.com/v1/gifs?api_key=" + super._ApiKey;
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
                } catch (UploadException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Executes upload request
     * @throws UploadException when exception inside occurs
     */
    @Override
    public void execute() throws UploadException {
        RequestBody requestBody = null;
        try {
                MultipartBody.Builder bodybuilder = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("api_key", _ApiKey)
                        .addFormDataPart("username", _Username);

            if (_Gif != null) {
                bodybuilder.addFormDataPart("file", _Gif.getName(),
                        RequestBody.create(
                                MediaType.parse(
                                        Files.probeContentType(_Gif.toPath())),
                                Files.readAllBytes(_Gif.toPath())));
            }else {
                bodybuilder.addFormDataPart("source_image_url",_Source_image_url);
            }

            if (_Source_post_url != null)
                bodybuilder.addFormDataPart("source_post_url", _Source_post_url);


            requestBody = bodybuilder.build();

        } catch (IOException e) {
            throw new UploadException("Error while creating request",e);
        }

        try {
            Request request = new Request.Builder()
                    .url(this.generateUrl())
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()){
                assert response.body() != null;
                UploadErrorResponse up = gson.fromJson(response.body().string(),UploadErrorResponse.class);
                _OnResponseError.run(new ResponseError(up.getMeta().getStatus(),up.getMeta().getMsg()));
            }
        } catch (IOException e) {
            throw new UploadException("Can not upload "+_Gif.getName(),e);
        }
    }
}