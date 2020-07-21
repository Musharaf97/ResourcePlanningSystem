package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.MainTechnology;
import proj.entity.Project;
import proj.repo.MainTechnologyRepo;

import java.util.List;

@Component
@Transactional
public class MainTechnologyService {

    @Autowired
    private final MainTechnologyRepo mainTechnologyRepo;

    public MainTechnologyService(MainTechnologyRepo mainTechnologyRepo) {
        this.mainTechnologyRepo = mainTechnologyRepo;
    }

    public MainTechnology save(MainTechnology mainTechnology)
    {
        return mainTechnologyRepo.save(mainTechnology);
    }

    public List<MainTechnology> findAll()
    {
        return mainTechnologyRepo.findAll();
    }



}
