package org.lucidant.java11;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SampleHttpClientTest {

    private SampleHttpClient httpClient;

    @BeforeEach
    void beforeEach() {
        httpClient = new SampleHttpClient();
    }

    @Test
    @DisplayName("Tests title via HttpClient Synchronous")
    void getTitle_Sync() throws IOException, InterruptedException {
        String title = httpClient.getTitleSync().orElseThrow(RuntimeException::new);

        assertThat(title).containsIgnoringCase("google");
    }

    @Test
    @DisplayName("Tests title via HttpClient Async")
    void getTitle_Async() {
        String title = httpClient.getTitleAsync().orElseThrow(RuntimeException::new);

        assertThat(title).containsIgnoringCase("google");
    }
}
