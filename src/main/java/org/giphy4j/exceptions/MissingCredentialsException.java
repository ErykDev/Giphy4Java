/**
 * Exceptions for rest of project
 * */
package org.giphy4j.exceptions;

public class MissingCredentialsException extends Exception {
    public MissingCredentialsException(String msg){
        super(msg);
    }
    public MissingCredentialsException(String msg, Exception superExc){
        super(msg,superExc);
    }
}
