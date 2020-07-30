package proj.controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.entity.Assignment;
import proj.entity.Project;
import proj.entity.QAssignment;
import service.execptions.ProjectException;
import service.impl.AssignmentService;
import service.model.AssignResourceDto;

import java.util.List;
import java.util.Optional;


@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:4200")
public class AssignmentController {

    @Autowired
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    // SEARCH ALL
    @GetMapping("/assignments")
    List<Assignment> findAll() {
        List<Assignment> assignmentList = assignmentService.findAll();
        return assignmentService.findAll();
    }
    //TODO /assignments/resource/{resourceId}

    //SEARCH BY Project id
    @GetMapping(value = "/assignments/project/{projectId}")
    public ResponseEntity<List<Assignment>> searchByProjectId(@PathVariable(value = "projectId") long projectId) {
        Optional<List<Assignment>> assignmentList = Optional.ofNullable(assignmentService.findAssignmentByProjectId(projectId)
                .orElseThrow(() -> new ProjectException("Project with ID " + projectId + " not found !")));
        return assignmentList
                .map(assignments -> ResponseEntity.ok().body(assignments))
                .orElseGet(() -> ResponseEntity.notFound().build()
                );
    }

    //SEARCH BY Resource id
    @GetMapping(value = "/assignments/resource/{resourceId}")
    public ResponseEntity<List<Assignment>> searchByResourceId(@PathVariable(value = "resourceId") long resourceId) {
        Optional<List<Assignment>> assignmentList = Optional.ofNullable(assignmentService.findAssignmentByResourceId(resourceId)
                .orElseThrow(() -> new ProjectException("Resource with ID " + resourceId + " not found !")));
        return assignmentList
                .map(assignments -> ResponseEntity.ok().body(assignments))
                .orElseGet(() -> ResponseEntity.notFound().build()
                );
    }

    //Add assignment by projectId, maintechnologyId, resourceId
    @PostMapping(path = "/assignresource" , consumes = "application/json", produces = "application/json")
    Assignment addResource(@RequestBody Assignment assignment){
        return assignmentService.save(assignment);
    }
}
