package me;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);
    
	public static void main(String[] args) {
        
	    new SpringApplicationBuilder(App.class).web(WebApplicationType.NONE).run(args);

        try {

            log.info("=== before wait");
            
            synchronized (App.class) {
                App.class.wait();
            }

            log.info("=== after wait");
        } catch (InterruptedException e) {
            log.error("=== after wait interrupt", e);
        }
	}
}
