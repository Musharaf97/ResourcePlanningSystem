package proj.repo;

import proj.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepo extends BaseRepository<Project, Long> {

    Optional<List<Project>> findProjectByStatus(String status);
    Optional<List<Project>> getByTitle(String title);

}
