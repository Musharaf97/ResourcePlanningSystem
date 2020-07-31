package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import proj.entity.MainTechnology;
import proj.entity.Project;
import service.execptions.ProjectException;
import service.impl.MainTechnologyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class MainTechnologyController {

    @Autowired
    private final MainTechnologyService mainTechnologyService;

    public MainTechnologyController(MainTechnologyService mainTechnologyService) {
        this.mainTechnologyService = mainTechnologyService;
    }

    //SEARCH ALL
    @GetMapping("/maintechnology")
    List<MainTechnology> findAll(){
        List<MainTechnology> mainTechnologyList = mainTechnologyService.findAll();
        return mainTechnologyService.findAll();
    }

    //ADD
    @PostMapping(path = "/addmaintechnology" , consumes = "application/json", produces = "application/json")
    MainTechnology addMaintechnology (@RequestBody MainTechnology mainTechnology){
        return mainTechnologyService.save(mainTechnology);
    }

    //DELETE MAINTECHNOLOGY
    @DeleteMapping("/deletemaintechnology/{id}")
    public Map<String, String> deleteMaintechnology(
            @PathVariable(value = "id") Long mainId) {
        MainTechnology mainTechnology = mainTechnologyService.findById(mainId)
                .orElseThrow(() -> new IllegalArgumentException("Main Technology with id : " + mainId + " not found"));
        mainTechnologyService.deletMainTech(mainTechnology);
        Map<String, String> response = new HashMap<>();
        response.put("Main Technology :" + mainId, "Deleted");
        return response;
    }
}
