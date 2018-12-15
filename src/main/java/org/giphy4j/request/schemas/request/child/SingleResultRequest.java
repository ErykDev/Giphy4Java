package org.giphy4j.request.schemas.request.child;

import org.giphy4j.exceptions.NoResultException;
import org.giphy4j.request.parse.SingleParsedResult;
import org.giphy4j.request.schemas.request.Request;

public abstract class SingleResultRequest extends Request {
    /**
     * @param ApiKey Giphy Api Key
     */
    public SingleResultRequest(String ApiKey) {
        super(ApiKey);
    }

    /**
     * @return SingleParsedResult
     * @throws NoResultException while empty result
     */
    public abstract SingleParsedResult execute() throws NoResultException;
}
