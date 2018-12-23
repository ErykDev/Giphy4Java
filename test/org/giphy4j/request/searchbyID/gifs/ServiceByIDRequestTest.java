package org.giphy4j.request.searchbyID.gifs;

import org.giphy4j.GiphyService;
import org.giphy4j.exceptions.NoResultException;
import org.giphy4j.request.Rating;
import org.giphy4j.request.schemas.request.child.SingleResultRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceByIDRequestTest {

    @Test
    public void execute() {

        String ApiKey = "";

        if (ApiKey.isEmpty()){
            System.out.println("Provide ApiKey to test class");
        }

        GiphyService gs = GiphyService.getBuilder().setApiKey(ApiKey).build();

        //getting random gif
        SingleResultRequest sr = gs.getRandomEndpointRequestBuilder().setTag("guy fierri").build();

        //if request succeeded
        sr.executeForOptional().ifPresent(gif -> {

            try {
                //requesting giphy with previous gif id
                SingleResultRequest rss = gs.getIDRequestBuilder().setID(gif.getData().getId()).setOnSuccess((res) -> {

                    //checking are responses id equal
                    assertEquals(gif.getData().getId(), res.getId());

                }).build();

                rss.execute();

            } catch (NoResultException e) {
                e.printStackTrace();
            }
        });

    }
}