package pl.altkom.springcloud.lab01.resttemplate.projectservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.altkom.springcloud.lab01.resttemplate.projectservice.client.interceptor.LoggingInterceptor;

@Slf4j
@Getter
@Setter
@ConfigurationProperties("pl.altkom")
@Configuration
public class ProjectClientsConfiguration {

    private ClientConfiguration employee;

    @Bean
    public RestTemplate restTemplate() {

        final RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        restTemplate.getInterceptors().add(new LoggingInterceptor());
        return restTemplate;
    }
}
