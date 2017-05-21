package parseport.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by patrick on 21.05.17.
 */

@Api
@RestController
public class DataController {

    @Autowired
    private EntityRepository repository;

    @ApiOperation(value = "Get single Entity",
            notes = "Returns a single Entity",
            response = Entity.class,
            httpMethod = "GET")
    @RequestMapping("/entities/{eid}")
    public List<Entity> getProperty(@PathVariable("eid") String eid){
        return repository.findByEid(eid);
    }

    @ApiOperation(value = "Get all Entities",
            notes = "Returns a List of all Entities",
            response = Entity.class,
            httpMethod = "GET")
    @RequestMapping("/entities")
    public List<Entity> getEntities(){
        return repository.findAll();
    }

    @ApiOperation(
            nickname = "addEntity",
            value = "Create Entity",
            notes = "Create Entity record",
            httpMethod = "POST",
            response = Entity.class
    )
    @PostMapping("/entities")
    public ResponseEntity<String> addEntity(@RequestBody Entity entity){
        repository.save(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete Entity",
            notes = "Deletes an Entities record",
            response = Entity.class,
            httpMethod = "DELETE")
    @DeleteMapping("/entities/{eid}")
    public ResponseEntity<String> deleteEntity(@PathVariable  String eid){
        List<Entity> entities = repository.findByEid(eid);
        if(entities.size() == 1) {
            Entity entity = entities.get(0);
            repository.delete(entity);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
