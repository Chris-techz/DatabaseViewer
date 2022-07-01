package bddmanager;

import bddmanager.sql.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Source {
    public static void main(String[] args) {
        //SpringApplication.run(Source.class, args);
        Database db = new Database();
        db.retrieveAllDB();
    }

}
