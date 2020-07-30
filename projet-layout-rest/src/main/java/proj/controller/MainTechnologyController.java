package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import proj.entity.MainTechnology;
import proj.entity.Project;
import service.impl.MainTechnologyService;

import java.util.List;

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

}
