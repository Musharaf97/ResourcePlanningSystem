package proj.repo;

import proj.entity.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceRepo extends BaseRepository<Resource, Long> {

    Optional<Resource> findFirstByVisa(String visa);
}
