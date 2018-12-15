package org.giphy4j.interfaces;

import org.giphy4j.request.parse.Result;

import java.util.List;

public interface OnMultiSearchSuccess {
    void run(List<Result> Data);
}
