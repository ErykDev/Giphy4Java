/**
 * Exception wrapper classes
 * */
package org.giphy4j.exceptions.response;

/**
 * Class for encapsulating server error response code and callback message
 */
public final class ResponseError {
    private int _ResponseCode;
    private String _Message;

    public ResponseError(int responseCode, String message){
        _ResponseCode = responseCode;
        _Message = message;
    }

    /**
     * @return response code
     */
    public int getResponseCode() {
        return _ResponseCode;
    }


    /**
     * @return response message
     */
    public String getMessage() {
        return _Message;
    }
}
