package org.giphy4j.exceptions;

/**
 * Exception foe uploads error
 */
public class UploadException extends Exception {
    /**
     * @param msg Exception message
     */
    public UploadException(String msg){
        super(msg);
    }

    /**
     * @param msg Exception message
     * @param superExc Super exception
     */
    public UploadException(String msg, Exception superExc){
        super(msg,superExc);
    }
}