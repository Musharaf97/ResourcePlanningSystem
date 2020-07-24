package service.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.Project;
import proj.entity.Resource;
import proj.repo.ResourceRepo;

import java.util.List;
import java.util.Optional;


@Component
@Transactional
public class ResourceService {

    private final ResourceRepo resourceRepo;

    public ResourceService(ResourceRepo resourceRepo) {
        this.resourceRepo = resourceRepo;
    }

    public List<Resource> findAll()
    {
        return resourceRepo.findAll();
    }

    public Resource save(Resource resource)
    {
        return resourceRepo.save(resource);
    }

    public Optional<Resource> findFirstByVisa(String visa) {
        return resourceRepo.findFirstByVisa(visa);
    }

    public Optional<Resource> findResourceById(Long id) {
        return resourceRepo.findById(id);
    }

    public void deleteResource(Resource resource){
        resourceRepo.delete(resource);
    }
}
