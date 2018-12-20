/**
 * Package for child request schemas
 * */
package org.giphy4j.request.schemas.request.child;

import org.giphy4j.exceptions.NoResultException;
import org.giphy4j.request.parse.MultiParsedResult;
import org.giphy4j.request.schemas.request.Request;

import java.util.Optional;

public abstract class MultiResultRequest extends Request {

    /**
     * @param ApiKey Giphy Api Key
     */
    public MultiResultRequest(String ApiKey) {
        super(ApiKey);
    }

    /**
     * @return MultiParsedResult
     * @throws NoResultException while empty result
     */
    public abstract MultiParsedResult execute() throws NoResultException;

    /**
     * @return optional MultiResultRequest
     * */
    public abstract Optional<MultiParsedResult> executeForOptional();
}
