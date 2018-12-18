package org.giphy4j.exceptions;

public class UploadException extends Exception {
    public UploadException(String msg){
        super(msg);
    }
    public UploadException(String msg, Exception superExc){
        super(msg,superExc);
    }
}