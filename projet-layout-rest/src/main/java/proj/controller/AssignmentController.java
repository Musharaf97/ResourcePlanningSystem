package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import proj.entity.Assignment;
import proj.entity.Project;
import service.impl.AssignmentService;
import service.impl.ProjectService;


import java.util.List;


@RestController
@EnableAutoConfiguration
public class AssignmentController {

    @Autowired
    private final AssignmentService assignmentService;

    @Autowired
    private final ProjectService projectService;

    public AssignmentController(AssignmentService assignmentService, ProjectService projectService) {
        this.assignmentService = assignmentService;
        this.projectService = projectService;
    }

   // SEARCH ALL
    @GetMapping("/assignments")
    List<Assignment> findAll() {
        List<Assignment> assignmentList = assignmentService.findAll();
        return assignmentService.findAll();
    }

}
