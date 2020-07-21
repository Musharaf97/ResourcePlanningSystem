package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.entity.Project;
import proj.entity.Resource;
import proj.execptions.ProjectNotFoundException;
import service.impl.ResourceService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ResourceController {

    @Autowired
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    //all resources
    @GetMapping("/resources")
    List<Resource> findAll(){
        List<Resource> projectList = resourceService.findAll();
        return resourceService.findAll();
    }

    //SEARCH BY ID
    @GetMapping(value = "/resource/{id}")
    public ResponseEntity<Resource> searchById(@PathVariable(value = "id") Long id) {
        Optional<Resource> resourceById = resourceService.findResourceById(id);
        return resourceById
                .map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.notFound().build()
                );
    }

//    //SEARCH BY STATUS
//    @GetMapping(value = "/resources/{assignment}")
//    public ResponseEntity<List<Project>> searchByAssignment(@PathVariable(value = "assignment") Double assignment) {
//        Optional<List<Project>> optionalResources = Optional.ofNullable(resourceService.findResourceByAssignment(assignment)
//                .orElseThrow(() -> new ProjectNotFoundException("No resource found!")));
//        return optionalResources
//                .map(resource -> ResponseEntity.ok().body(resource))
//                .orElseGet(() -> ResponseEntity.notFound().build()
//                );

    //ADD RESOURCE
    @PostMapping(path = "/addresource" , consumes = "application/json", produces = "application/json")
//    @CrossOrigin(origins = "http://localhost:4200/addproject")
    Resource addResource (@RequestBody Resource resource){
        String resourceVisa = resource.getVisa();
        if(resourceVisa != null && !"".equals(resourceVisa)){
            Optional<Resource> existingResource = resourceService.findFirstByVisa(resourceVisa);
            if(existingResource.isPresent()){
                throw new ProjectNotFoundException("Project : "+resourceVisa+" exists!");
            }
        }
        return resourceService.save(resource);
    }


}


