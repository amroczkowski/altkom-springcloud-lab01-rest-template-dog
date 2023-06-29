package pl.altkom.springcloud.lab01.resttemplate.projectservice.client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import pl.altkom.springcloud.lab01.resttemplate.projectservice.client.model.Employee;
import pl.altkom.springcloud.lab01.resttemplate.projectservice.configuration.ProjectClientsConfiguration;

@Service
public class EmployeeWebClient {

    private static final String GET_PROJECT_EMPLOYEES = "/employee/project/{projectId}";
    private static final String GET_ALL_EMPLOYEES = "/employee";
    private final WebClient webClient;

    public EmployeeWebClient(final ProjectClientsConfiguration projectClientsConfiguration) {
        this.webClient = WebClient.builder()
                .baseUrl(projectClientsConfiguration.getEmployee().getUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public List<Employee> getProjectEmployees(final Long projectId) {

        final Employee[] response = webClient.get()
                .uri(GET_PROJECT_EMPLOYEES, Map.of("projectId", projectId))
                .retrieve()
                .bodyToMono(Employee[].class)
                .block();
        return Optional.ofNullable(response).map(Arrays::asList).orElseThrow();
    }

    public List<Employee> getEmployees() {

        final Employee[] response = webClient.get()
                .uri(GET_ALL_EMPLOYEES)
                .retrieve()
                .bodyToMono(Employee[].class)
                .block();
        return Optional.ofNullable(response).map(Arrays::asList).orElseThrow();
    }
}
