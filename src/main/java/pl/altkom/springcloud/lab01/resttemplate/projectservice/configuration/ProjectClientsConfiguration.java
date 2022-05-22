package pl.altkom.springcloud.lab01.resttemplate.projectservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("pl.altkom")
@Configuration
public class ProjectClientsConfiguration {

    private ClientConfiguration employee;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
