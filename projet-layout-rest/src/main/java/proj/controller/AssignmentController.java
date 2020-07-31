package proj.controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.entity.Assignment;
import proj.entity.QResource;
import proj.repo.AssignmentRepo;
import proj.repo.ResourceRepo;
import service.execptions.ProjectException;
import service.impl.AssignmentService;

import java.util.List;
import java.util.Optional;


@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:4200")
public class AssignmentController {

    @Autowired
    private final AssignmentService assignmentService;

    @Autowired
    private final AssignmentRepo assignmentRepo;



    public AssignmentController(AssignmentService assignmentService, AssignmentRepo assignmentRepo) {
        this.assignmentService = assignmentService;
        this.assignmentRepo = assignmentRepo;
    }

    // SEARCH ALL
    @GetMapping("/assignments")
    List<Assignment> findAll() {
        List<Assignment> assignmentList = assignmentService.findAll();
        return assignmentService.findAll();
    }

    //SEARCH BY ID
    @GetMapping(value = "/assignment/{id}")
    public ResponseEntity<Assignment> searchById(@PathVariable(value = "id") Long id) {
        Optional<Assignment> assignmentOptional = assignmentService.findAssignmentById(id);
        return assignmentOptional
                .map(assignment -> ResponseEntity.ok().body(assignment))
                .orElseGet(() -> ResponseEntity.notFound().build()
                );
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

//    Add assignment by projectId, maintechnologyId, resourceId
    @PostMapping(path = "/assignresource" , consumes = "application/json", produces = "application/json")
    Assignment addResource(@RequestBody Assignment assignment){
        BooleanExpression getResource = QResource.resource.eq(assignment.getResource());
        List<Assignment> existingAssignment = (List<Assignment>) assignmentRepo.findAll(getResource);

        Double totalAllotment = existingAssignment
                .stream()
                .map(Assignment::getAllotment)
                .reduce(0.0, Double::sum);

        if (totalAllotment >= 1) {
            throw new IllegalStateException("Resource is over-allocated!");
        }else {
            return assignmentService.save(assignment);
        }
    }

//        @PostMapping(path = "/assignresource" , consumes = "application/json", produces = "application/json")
//    Assignment addResource(@RequestBody Assignment assignment){
//        return assignmentService.assignResource(AssignResourceDto.builder().build());
//    }


    //UPDATE ASSIGNMENT
    @PutMapping("/updateassignment/{id}")
    Assignment updateProject(@RequestBody Assignment newAssignment, @PathVariable Long id){
        return assignmentService.findAssignmentById(id)
                .map(assignment -> {
                    assignment.setAllotment(newAssignment.getAllotment());
                    assignment.setEndDate(newAssignment.getEndDate());
                    assignment.setStartDate(newAssignment.getStartDate());
                    assignment.setMainRole(newAssignment.getMainRole());
                    assignment.setProject(newAssignment.getProject());
                    assignment.setMainTechnology(newAssignment.getMainTechnology());
                    assignment.setResource(newAssignment.getResource());
                    return assignmentService.save(assignment);
                }).orElseGet(() -> {
                    newAssignment.setAssignmentId(id);
                    return assignmentService.save(newAssignment);
                });
    }
}
