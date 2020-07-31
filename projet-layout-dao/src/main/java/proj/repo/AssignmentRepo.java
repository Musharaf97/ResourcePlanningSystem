package proj.repo;

import proj.entity.Assignment;
import proj.entity.Project;
import proj.entity.Resource;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepo extends BaseRepository<Assignment, Long> {

    Optional<List<Assignment>> findByProject_ProjectId(long projectId);
    Optional<List<Assignment>> findByResource_ResourceId(long resourceId);
    Optional<List<Assignment>> findByResource(Resource resource);
}
