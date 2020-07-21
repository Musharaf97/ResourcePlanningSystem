//package proj.Runner;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import proj.entity.Resource;
//import proj.repo.ResourceRepo;
//
//public class MyRunnerResource implements CommandLineRunner {
//    private static final Logger logger = LoggerFactory.getLogger(MyRunnerResource.class);
//
//    @Autowired
//    private ResourceRepo resourceRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//        resourceRepo.save(new Resource("Sohun","Anoop","AKN",3.0,"Y","PM","Engineering"));
//        resourceRepo.save(new Resource("Toorabally","Faraaz","TFM",1.0,"Y","Engineer","Engineering"));
//        resourceRepo.save(new Resource("Gukhool","Pooroosh","GPJ",2.1,"Y","PM","Engineering"));
//        resourceRepo.findAll().forEach((resource -> {
//            logger.info("{}", resource);
//        }));
//    }
//}
