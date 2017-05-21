package parseport.server;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EntityRepository extends MongoRepository<Entity, String> {
    public List<Entity> findByEid(String eid);
}