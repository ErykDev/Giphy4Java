package org.giphy4j.exceptions;

/**
 * Class responsible for carrying exception and response message
 * */
public class NoResultException extends Exception {


    /**
     * @param msg response message
     */
    public NoResultException(String msg){
        super(msg);
    }

    /**
     * @param msg response message
     * @param superExc super exception
     */
    public NoResultException(String msg, Exception superExc){
        super(msg,superExc);
    }
}
