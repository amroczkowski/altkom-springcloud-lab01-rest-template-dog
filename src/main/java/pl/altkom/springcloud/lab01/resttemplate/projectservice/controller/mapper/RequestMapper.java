package pl.altkom.springcloud.lab01.resttemplate.projectservice.controller.mapper;

import pl.altkom.springcloud.lab01.resttemplate.projectservice.controller.model.CreateProjectRequest;
import pl.altkom.springcloud.lab01.resttemplate.projectservice.controller.model.UpdateProjectRequest;
import pl.altkom.springcloud.lab01.resttemplate.projectservice.repository.model.Project;

public class RequestMapper {

    public static Project bind(final CreateProjectRequest request) {
        final Project project = new Project();
        project.setName(request.getName());
        return project;
    }

    public static Project bind(final UpdateProjectRequest request, final Project destination) {
        destination.setName(request.getName());
        return destination;
    }
}
