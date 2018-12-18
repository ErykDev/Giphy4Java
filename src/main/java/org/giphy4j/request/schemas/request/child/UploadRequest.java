package org.giphy4j.request.schemas.request.child;

import org.giphy4j.exceptions.UploadException;
import org.giphy4j.request.schemas.request.Request;

public abstract class UploadRequest extends Request {
    /**
     * @param ApiKey Giphy Api Key
     */
    public UploadRequest(String ApiKey) {
        super(ApiKey);
    }

    /**
     * @throws UploadException error occurred on uploading
     */
    public abstract void execute() throws UploadException;
}