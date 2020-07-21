package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import proj.entity.Assignment;
import proj.entity.Project;
import proj.execptions.ProjectNotFoundException;
import service.impl.AssignmentService;

import java.util.List;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
public class AssignmentController {

    @Autowired
    private final AssignmentService assignmentService;
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    //SEARCH ALL
    @GetMapping("/assignment")
    List<Assignment> findAll(){
        List<Assignment> assignmentList = assignmentService.findAll();
        return assignmentService.findAll();
    }

}
