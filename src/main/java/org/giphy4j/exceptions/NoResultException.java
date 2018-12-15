package org.giphy4j.exceptions;

public class NoResultException extends Exception {
    public NoResultException(String msg){
        super(msg);
    }
    public NoResultException(String msg, Exception superExc){
        super(msg,superExc);
    }
}
