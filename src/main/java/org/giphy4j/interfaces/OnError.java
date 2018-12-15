/**
 * Interfaces for rest of project
 * */
package org.giphy4j.interfaces;

import org.giphy4j.exceptions.response.ResponseError;

public interface OnError {
    void run(ResponseError err);
}
