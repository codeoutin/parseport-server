package parseport.server;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Kevin on 15.05.17.
 */

@RepositoryRestResource(collectionResourceRel = "entity", path = "entity")
public interface EntityRepository extends MongoRepository<Entity, String> {

}