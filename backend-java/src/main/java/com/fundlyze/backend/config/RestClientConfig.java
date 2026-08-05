package com.fundlyze.backend.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.beans.factory.annotation.Value;


@Configuration
public class RestClientConfig {

   @Value("${analysis.engine.base-url}")
    private String analysisEngineBaseUrl;

    @Bean
public RestClient analysisEngineRestClient() {
    return RestClient.builder()
            .baseUrl(analysisEngineBaseUrl)
            .build();
}

}
