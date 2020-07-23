package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.entity.Project;
import service.execptions.ProjectException;
import service.impl.ProjectService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@EnableAutoConfiguration
public class ProjectController {

    @Autowired
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //SEARCH ALL
    @GetMapping("/projects")
    List<Project> findAll(){
            List<Project> projectList = projectService.findAll();
            return projectService.findAll();
    }

    //SEARCH BY STATUS
    @GetMapping(value = "/project/{status}")
    public ResponseEntity<List<Project>> searchByStatus(@PathVariable(value = "status") String status) {
        Optional<List<Project>> projectOptional = Optional.ofNullable(projectService.findProjectByStatus(status)
                .orElseThrow(() -> new ProjectException("Project with status "+status+" not found")));
        return projectOptional
                .map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.notFound().build()
                );
    }

    //SEARCH BY ID
    @GetMapping(value = "/projects/{id}")
    public ResponseEntity<Project> searchById(@PathVariable(value = "id") Long id) {
        Optional<Project> projectById = projectService.findProjectById(id);
        return projectById
                .map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.notFound().build()
                );
    }

    //ADD PROJECT
    @PostMapping(path = "/addproject" , consumes = "application/json", produces = "application/json")
    Project addProject (@RequestBody Project project){
        String projectTitle = project.getTitle();
        if(projectTitle != null && !"".equals(projectTitle)){
            Optional<List<Project>> newProject = projectService.getByTitle(projectTitle);
            if(newProject.isPresent()){
                throw new ProjectException("Project : "+projectTitle+" exists!");
            }
        }
        return projectService.save(project);
    }

    //UPDATE PROJECT
    @PutMapping("/updateproject/{id}")
    Project updateProject(@RequestBody Project newProject, @PathVariable Long id){
        return projectService.findProjectById(id)
                .map(project -> {
                    project.setBL(newProject.getBL());
                    project.setTitle(newProject.getTitle());
                    project.setEndDate(newProject.getEndDate());
                    project.setStartDate(newProject.getStartDate());
                    project.setStatus(newProject.getStatus());
                    project.setWinChance(newProject.getWinChance());
                    return projectService.save(project);
                }).orElseGet(() -> {
                    newProject.setProjectId(id);
                    return projectService.save(newProject);
                });
    }

    //DELETE PROJECT
    @DeleteMapping("/deleteProjectById/{id}")
    public Map<String, String> deleteProject(
            @PathVariable(value = "id") Long projectId) {
        Project project = projectService.findProjectById(projectId)
                .orElseThrow(() -> new ProjectException("Project with id : " + projectId + " not found"));
        projectService.deleteProject(project);
        Map<String, String> response = new HashMap<>();
        response.put("Project :" + projectId, "Deleted");
        return response;
    }
}
