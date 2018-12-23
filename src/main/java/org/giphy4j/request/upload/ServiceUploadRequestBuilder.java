package org.giphy4j.request.upload;

import org.giphy4j.interfaces.OnResponseError;
import org.giphy4j.interfaces.OnUploadSucces;
import org.giphy4j.request.schemas.builder.RequestBuilder;
import org.giphy4j.request.schemas.request.child.UploadRequest;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public final class ServiceUploadRequestBuilder extends RequestBuilder {

    private File _Gif = null;
    private String _Username = null;
    private String _Source_image_url = null;
    private String _Source_post_url = null;
    private ArrayList<String> _Tags = null;
    private OnUploadSucces _OnUploadSuccess = null;
    private OnResponseError _OnResponseError = err -> {
        throw new Error(err.getResponseCode()+"  "+err.getMessage());
    };

    /**
     * @param ApiKey Giphy Api Key
     */
    public ServiceUploadRequestBuilder(String ApiKey) {
        super(ApiKey);
    }

    /**
     * setting uploading file
     * @param file uploading file
     */
    public ServiceUploadRequestBuilder setFile(File file){
        if (file.getName().endsWith(".gif") || file.getName().endsWith(".mp4") && file.canRead()){
            _Gif = file;
        }
        return this;
    }


    /**
     * Setting users name in request
     * @param name Giphy Username
     */
    public ServiceUploadRequestBuilder setUserName(String name){
        this._Username = name;
        return this;
    }

    /**
     * Setting file as a link source
     * @param url gif link
     * */
    public ServiceUploadRequestBuilder setSourceUrl(String url){
        this._Source_image_url = url;
        return this;
    }

    /**
     * Setting file as a link source
     * @param url gif link
     * */
    public ServiceUploadRequestBuilder setSourceUrl(URL url){
        this._Source_image_url = url.getPath();
        return this;
    }

    /**
     * Setting future gifs tags
     * @param _Tags future gif tags
     */
    public ServiceUploadRequestBuilder setTags(ArrayList<String> _Tags) {
        this._Tags = _Tags;
        return this;
    }

    /**
     * Setting future gifs tags
     * @param _Tags future gif tags
     */
    public ServiceUploadRequestBuilder setTags(String[] _Tags) {
        this._Tags = new ArrayList<String>(Arrays.asList(_Tags));
        return this;
    }

    /**
     * @param url The URL source of the asset.
     */
    public ServiceUploadRequestBuilder setSourcePostUrl(String url){
        this._Source_post_url = url;
        return this;
    }

    /**
     * @param url The URL source of the asset.
     */
    public ServiceUploadRequestBuilder setSourcePostUrl(URL url){
        this._Source_post_url = url.getPath();
        return this;
    }

    /**
     * Setting on success action
     * @param _OnUploadSuccess on succes action
     */
    public ServiceUploadRequestBuilder setOnSuccess(OnUploadSucces _OnUploadSuccess) {
        this._OnUploadSuccess = _OnUploadSuccess;
        return this;
    }

    /**
     * @param _OnResponseError on bad server response action
     */
    public ServiceUploadRequestBuilder setOnError(OnResponseError _OnResponseError) {
        this._OnResponseError = _OnResponseError;
        return this;
    }

    /**
     * @return new ServiceUploadRequest
     */
    @Override
    public UploadRequest build() {
        if (_Username == null){
            throw  new Error("Not specified User Name");
        }
        if (_Source_image_url == null && _Gif == null){
            throw new Error("Not specified Source url or File");
        }

        return new ServiceUploadRequest(_ApiKey,_Gif,_Username,_Source_image_url,_Source_post_url,_Tags, _OnUploadSuccess, _OnResponseError);
    }
}
