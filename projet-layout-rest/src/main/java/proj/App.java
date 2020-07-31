package proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import proj.controller.AssignmentController;
import proj.controller.MainTechnologyController;
import proj.controller.ProjectController;
import proj.controller.ResourceController;
import service.impl.AssignmentService;
import service.impl.MainTechnologyService;
import service.impl.ProjectService;
import service.impl.ResourceService;




@SpringBootApplication

@Import({ProjectController.class, ResourceController.class, ProjectService.class, ResourceService.class, AssignmentService.class, AssignmentController.class, MainTechnologyController.class, MainTechnologyService.class})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}


