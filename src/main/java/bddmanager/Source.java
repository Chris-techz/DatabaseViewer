package bddmanager;

import bddmanager.sql.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@SpringBootApplication
public class Source {
    public static void main(String[] args) {
        SpringApplication.run(Source.class, args);
        //Database db = new Database();
        //List<LinkedHashMap<String, String>> mymap = new ArrayList<>();
        //mymap = db.retrieveAllEntries("STUDY");
    }

}
