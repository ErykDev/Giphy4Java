# Giphy4Java
Simply asynchronous wrapper library for Giphy Api


### Installing
Jar:

## Building the service
```
        String Giphy_Api_Key;

        GiphyService gs = GiphyService
                .getBuilder()
                .setApiKey(Giphy_Api_Key)
                .build();
```

## Example usage
### Requesting '/v1/gifs/search'
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
### More examples:

## Built With
* [okhttp3](https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp)
* [okio/1.12.0](https://mvnrepository.com/artifact/com.squareup.okio/okio/1.12.0)
* [gson/2.8.2](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.2)

## Licence
This project is licensed under the Apache 2.0 License - see the [LICENSE.md](LICENSE.md) file for details