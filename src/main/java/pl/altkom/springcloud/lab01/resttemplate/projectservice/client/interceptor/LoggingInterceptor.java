package pl.altkom.springcloud.lab01.resttemplate.projectservice.client.interceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    public static final String EMPTY = "EMPTY";

    @Override
    public ClientHttpResponse intercept(final HttpRequest req, final byte[] reqBody, final ClientHttpRequestExecution ex)
            throws IOException {

        final String requestBody = new String(reqBody, StandardCharsets.UTF_8);
        log.info("Request: {}", StringUtils.hasText(requestBody) ? requestBody : EMPTY);
        final ClientHttpResponse response = ex.execute(req, reqBody);
        final InputStreamReader isr = new InputStreamReader(response.getBody(), StandardCharsets.UTF_8);
        final String responseBody = new BufferedReader(isr).lines().collect(Collectors.joining("\n"));
        log.info("Response: {}", StringUtils.hasText(responseBody) ? responseBody : EMPTY);
        return response;
    }
}
