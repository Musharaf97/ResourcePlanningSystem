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


import java.time.LocalDate;


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

            LocalDate startDate = LocalDate.of(2020,7,22);
            LocalDate endDate = LocalDate.of(2022,5,4);

            Project project1 = Project.builder().title("GDD").BL("bl4").startDate("20-May-2009").endDate("20-May-2010").status("Active").winChance(.2).build();
            projectRepo.save(project1);

            Project project2 = Project.builder().title("EasyGov").BL("bl11").startDate("20-May-2009").endDate("20-May-2010").status("Active").winChance(.5).build();
            projectRepo.save(project2);

            Resource resource1 = Resource.builder().firstName("Musharaf").lastName("Mirza").factory("Engineering").level(1.0).profile("Trainee").visa("MMG").status("Active").build();
            resourceRepo.save(resource1);

            Resource resource2 = Resource.builder().firstName("Imrith").lastName("Shakeel").factory("Engineering").level(3.0).profile("PM").visa("SDI").status("Active").build();
            resourceRepo.save(resource2);

            Resource resource3 = Resource.builder().firstName("Sohun").lastName("Anoop").factory("Engineering").level(3.0).profile("Associate Architect").visa("AKN").status("Active").build();
            resourceRepo.save(resource3);

            MainTechnology Test = MainTechnology.builder().mainTechnologyName("Test").build();
            MainTechnology java = MainTechnology.builder().mainTechnologyName("Java").build();
            mainTechnologyRepo.save(Test);
            mainTechnologyRepo.save(java);

//            Assignment assignment1 = Assignment.builder().mainRole("Engineer").allotment(1.0).resource(resource1).project(project1).mainTechnology(java).startDate(startDate).endDate(endDate).build();
//            assignmentRepo.save(assignment1);
//
//            Assignment assignment2 = Assignment.builder().mainRole("PM").allotment(1.0).resource(resource2).project(project1).mainTechnology(Test).startDate(startDate).endDate(endDate).build();
//            assignmentRepo.save(assignment2);
//
//            Assignment assignment3 = Assignment.builder().mainRole("Engineer").allotment(1.0).resource(resource1).project(project1).mainTechnology(Test).startDate(startDate).endDate(endDate).build();
//            assignmentRepo.save(assignment3);
//
            Assignment assignment4 = Assignment.builder().mainRole("Architect").allotment(0.1).resource(resource3).project(project1).mainTechnology(java).startDate("startDate").endDate("endDate").build();
            assignmentRepo.save(assignment4);


        };
    }
}


