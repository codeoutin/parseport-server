package parseport.server;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Kevin on 15.05.17.
 */

@RepositoryRestResource(collectionResourceRel = "entity", path = "entity")
public interface EntityRepository extends MongoRepository<Entity, String> {
    List<Entity> findByEid(@Param("eid") String eid);
}