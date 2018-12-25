package org.giphy4j.exceptions;

/**
 * Exception for missing credential
 */
public class MissingCredentialsException extends Exception {

    /**
     * @param msg message of exception
     */
    public MissingCredentialsException(String msg){
        super(msg);
    }

    /**
     * @param msg message of exception
     * @param superExc super exception
     */
    public MissingCredentialsException(String msg, Exception superExc){
        super(msg,superExc);
    }
}
