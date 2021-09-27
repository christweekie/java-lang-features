package org.lucidant.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleHttpClient {

    private HttpClient httpClient = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .followRedirects(HttpClient.Redirect.NORMAL)
        .connectTimeout(Duration.ofSeconds(20))
//        .proxy(ProxySelector.of(new InetSocketAddress("www.google.co.uk", 80)))
//        .authenticator(Authenticator.getDefault())
        .build();


    public Optional<String> getTitleSync() throws IOException, InterruptedException {

        HttpRequest request = getHttpRequest();
        HttpResponse<String> resp = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // We'd use a library like JSOUP
        return Optional.ofNullable(getTitle(resp));
    }

    public Optional<String> getTitleAsync() {

        HttpRequest request = getHttpRequest();
        CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(request, BodyHandlers.ofString());

        String title = future.thenApply(res -> getTitle(res)).join();

        log.info("Done work now");

        return Optional.ofNullable(title);
    }

    private HttpRequest getHttpRequest() {
        return HttpRequest.newBuilder(URI.create("https://www.google.co.uk"))
            .GET()
            .setHeader("User-Agent", "Java 11 HttpClient Bot")
            .build();
    }

    private String getTitle(HttpResponse<String> resp) {
        log.info("Getting title on HttpResponse");
        final String[] strings1 = resp.body().split("</title>");
        String title = null;
        if (strings1.length >= 1) {
            String[] pre = strings1[0].split("<title>");
            title = pre.length >= 1 ? pre[1] : null;
        }
        return title;
    }

}
