# Giphy4Java
Simply asynchronous wrapper library for Giphy Api


### Installing

Jar: [link](https://github.com/BadlyDrunkScotsman/Giphy4Java/releases/tag/V1.0.3)


## Building the service
```
        String Giphy_Api_Key;

        GiphyService gs = GiphyService
                .getBuilder()
                .setApiKey(Giphy_Api_Key)
                .build();
```

## Example usage
### Requesting '/v1/gifs/search', search all GIPHY GIFs for a matching query.
```
        MultiResultRequest mrr = gs.getSearchRequestBuilder()
                .setLanguage(Language.English) //search query language
                .setOffset(5)
                .setLimit(5)
                .setQuery("guy fieri") // searching query
                .setOnSuccess(new OnMultiSearchSuccess() {
                    @Override
                    public void run(List<Result> list) {
                       list.forEach(gif -> {
                           System.out.println(gif.getImages().getFixedHeight().getUrl());
                       });
                    }
                }).build();

        try {
            mrr.execute();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
```

### Uploading gifs programmatically to giphy.com
```
        String userame;
        String path;
        String[] giftags;//or Arraylist<String>

        UploadRequest up = gs.getUploadRequestBuilder()
                .setUserName(userame)
                .setFile(new File(path))
                .setTags(giftags)
                .setOnSuccess(new OnUploadSuccess() {
                    @Override
                    public void run() {
                        System.out.println("Success!!!");
                    }
                }).build();

        try {
            up.execute();
        } catch (UploadException e) {
            e.printStackTrace();
        }
```

### More examples:[link](https://github.com/BadlyDrunkScotsman/Giphy4Java/wiki/More-Examples)

## Built With
* [okhttp3](https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp)
* [okio/1.12.0](https://mvnrepository.com/artifact/com.squareup.okio/okio/1.12.0)
* [gson/2.8.2](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.2)

## Licence
This project is licensed under the Apache 2.0 License - see the [LICENSE.md](LICENSE.md) file for details

![alt text](https://www.danasilver.org/giphymessages/PoweredBy_Horizontal_Light-Backgrounds.gif)
