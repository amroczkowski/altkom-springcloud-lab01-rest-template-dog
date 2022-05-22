package pl.altkom.springcloud.lab01.resttemplate.projectservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.springcloud.lab01.resttemplate.projectservice.repository.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
