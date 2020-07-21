//package proj.Runner;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import proj.entity.Project;
//import proj.repo.ProjectRepo;
//
//public class MyRunnerProject implements CommandLineRunner {
//
//    private static final Logger logger = LoggerFactory.getLogger(MyRunnerProject.class);
//
//    @Autowired
//    private ProjectRepo projectRepo;
//    @Override
//    public void run(String... args) throws Exception {
//        projectRepo.deleteAll();
//        projectRepo.save(new Project("IPension", "Neosis", "Occupied", "20-May-2020", "20-Jun-2021","Appian", 0.3));
//        projectRepo.save(new Project("APGM 2020", "BL10", "Active", "20-May-2020", "20-Jun-2021","Java" ,0.2));
//        projectRepo.save(new Project("InfoFito", "BL8", "Active", "20-May-2020", "20-Jun-2021","Java" ,0.5));
//
//        projectRepo.findAll().forEach((project) -> {
//            logger.info("{}", project);
//        });
//    }
//}
