package org.giphy4j.interfaces;

import org.giphy4j.request.parse.Result;

public interface OnSingleSearchSuccess {
    void run(Result res);
}
