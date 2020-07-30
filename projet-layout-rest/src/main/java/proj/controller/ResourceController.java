package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.entity.Resource;
import service.execptions.ProjectException;
import service.impl.ResourceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@EnableAutoConfiguration
public class ResourceController {

    @Autowired
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    //SEARCH BY ID
    @GetMapping(value = "/resource/{id}")
    public ResponseEntity<Resource> findResourceById (@PathVariable(value = "id") Long id) {
        Optional<Resource> resourceById = resourceService.findResourceById(id);
        return resourceById
                .map(resource -> ResponseEntity.ok().body(resource))
                .orElseGet(() -> ResponseEntity.notFound().build()
                );
    }

    //SEARCH ALL RESOURCES
    @GetMapping("/resources")
    List<Resource> findAll(){
        List<Resource> projectList = resourceService.findAll();
        return resourceService.findAll();
    }

    //ADD RESOURCE
    @PostMapping(path = "/addresource" , consumes = "application/json", produces = "application/json")
    Resource addResource (@RequestBody Resource resource){
        String resourceVisa = resource.getVisa();
        if(resourceVisa != null && !"".equals(resourceVisa)){
            Optional<Resource> existingResource = resourceService.findFirstByVisa(resourceVisa);
            if(existingResource.isPresent()){
                throw new ProjectException("Project : "+resourceVisa+" exists!");
            }
        }
        return resourceService.save(resource);
    }

    //DELETE RESOURCE
    @DeleteMapping("/deleteresourcebyid/{id}")
    public Map<String, String> deleteResource(
            @PathVariable(value = "id") Long resourceId) {
        Resource resource = resourceService.findResourceById(resourceId)
                .orElseThrow(() -> new IllegalStateException("Resource with id : " + resourceId + " cannot be found or assigned in a project!"));
        resourceService.deleteResource(resource);
        Map<String, String> response = new HashMap<>();
        response.put("Resource :" + resourceId, "Deleted");
        return response;
    }

    //UPDATE RESOURCE
    @PutMapping("/updateresource/{id}")
    Resource updateResource(@RequestBody Resource newResource, @PathVariable Long id){
        return resourceService.findResourceById(id)
                .map(resource -> {
                    resource.setLastName(newResource.getLastName());
                    resource.setFirstName(newResource.getFirstName());
                    resource.setFactory(newResource.getFactory());
                    resource.setLevel(newResource.getLevel());
//                    resource.setVisa(newResource.getVisa());
                    resource.setProfile(newResource.getProfile());
                    resource.setStatus(newResource.getStatus());
                    return resourceService.save(resource);
                }).orElseGet(() -> {
                    newResource.setResourceId(id);
                    return resourceService.save(newResource);
                });
    }




}


