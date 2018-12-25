package org.giphy4j.interfaces;

import org.giphy4j.exceptions.response.ResponseError;

public interface OnResponseError {
    void run(ResponseError err);
}
