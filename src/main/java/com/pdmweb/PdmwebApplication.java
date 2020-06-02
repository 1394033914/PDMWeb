package com.pdmweb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author MrBird
 */
@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
public class PdmwebApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PdmwebApplication.class).run(args);
    }

}
