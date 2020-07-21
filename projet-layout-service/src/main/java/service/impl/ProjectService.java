package service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.Project;
import proj.entity.QAssignment;
import proj.entity.QProject;
import proj.repo.ProjectRepo;
import service.model.ProjectDto;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class ProjectService {

    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Optional<Project> findProjectById(Long id) {
        return projectRepo.findById(id);
    }

    public Optional<List<Project>> findProjectByStatus(String status) {
        return projectRepo.findProjectByStatus(status);
    }

    public Optional<List<Project>> getByTitle(String title) {
        return projectRepo.getByTitle(title);
    }

    public List<Project> findAll()
    {
        return projectRepo.findAll();
    }

    public Project save(Project project)
    {
        return projectRepo.save(project);
    }

    public void deleteProject(Project project){
        projectRepo.delete(project);
    }

    public List<Project> findAllProject (ProjectDto request){
        return projectRepo.findAll();
    }

}
