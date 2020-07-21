package proj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import proj.controller.AssignmentController;
import proj.controller.MainTechnologyController;
import proj.controller.ProjectController;
import proj.controller.ResourceController;
import proj.entity.Assignment;
import proj.entity.MainTechnology;
import proj.entity.Project;
import proj.entity.Resource;
import proj.repo.AssignmentRepo;
import proj.repo.MainTechnologyRepo;
import proj.repo.ProjectRepo;
import proj.repo.ResourceRepo;
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

    @Bean
    public CommandLineRunner mappingDemo(ProjectRepo projectRepo,
                                         ResourceRepo resourceRepo, AssignmentRepo assignmentRepo, MainTechnologyRepo mainTechnologyRepo) {
        return args -> {

            Project project1 = Project.builder().title("GDD").BL("bl4").startDate("20-May-2009").endDate("20-May-2010").status("Active").winChance(.2).build();
            projectRepo.save(project1);

            Project project2 = Project.builder().title("EasyGov").BL("bl11").startDate("20-May-2009").endDate("20-May-2010").status("Not-Active").winChance(.5).build();
            projectRepo.save(project2);

            Resource resource1 = Resource.builder().firstName("Musharaf").lastName("Mirza").factory("Engineering").level(2.1).profile("Front End").visa("MMG").status("Active").build();
            resourceRepo.save(resource1);

            MainTechnology nodeJs = MainTechnology.builder().mainTechnologyName("Node.js").build();
            MainTechnology java = MainTechnology.builder().mainTechnologyName("Java").build();
            mainTechnologyRepo.save(nodeJs);
            mainTechnologyRepo.save(java);

            Assignment assignment1 = Assignment.builder().main_role("PM").allotment(0.3).resource(resource1).project(project2).mainTechnologies(nodeJs).build();
            assignmentRepo.save(assignment1);

            Assignment assignment2 = Assignment.builder().main_role("Engineer").allotment(0.2).resource(resource1).project(project2).mainTechnologies(nodeJs).build();
            assignmentRepo.save(assignment2);

        };
    }
}


