package bddmanager.rest;

import bddmanager.sql.Database;
import bddmanager.sql.tables.TableDatabase;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/retrieve/databases")
    List<LinkedHashMap<String, String>> getAllDatabases() {
        Database db = new Database();
        return db.retrieveAllEntries("DB");
    }
    @GetMapping("/retrieve/studies")
    List<LinkedHashMap<String, String>> getAllStudies() {
        Database db = new Database();
        return db.retrieveAllEntries("STUDY");
    }
    @GetMapping("/retrieve/series")// TODO : need fix
    List<LinkedHashMap<String, String>> getAllSeries() {
        Database db = new Database();
        return db.retrieveAllEntries("SERIES");
    }
    @GetMapping("/retrieve/junctions")
    List<LinkedHashMap<String, String>> getAllJunctions() {
        Database db = new Database();
        return db.retrieveAllEntries("JUNCTION");
    }
}
