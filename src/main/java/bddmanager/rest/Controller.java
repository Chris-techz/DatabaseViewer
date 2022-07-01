package bddmanager.rest;

import bddmanager.sql.Database;
import bddmanager.sql.tables.TableDatabase;
import org.springframework.web.bind.annotation.*;

/**
 * TODO : Make the rest controllers to retrieve tables from DB
 */

@RestController
public class Controller {

    @GetMapping("/retrieve/database/{ID}")
    TableDatabase getDatabase(@PathVariable int ID) {
        Database db = new Database();
        return db.retrieveDB(ID);
    }
}
