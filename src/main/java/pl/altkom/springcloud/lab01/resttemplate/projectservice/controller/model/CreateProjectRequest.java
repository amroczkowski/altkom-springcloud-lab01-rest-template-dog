package pl.altkom.springcloud.lab01.resttemplate.projectservice.controller.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class CreateProjectRequest {

    @NotNull
    private String name;
}
