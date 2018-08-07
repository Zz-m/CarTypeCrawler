package com.adj;

import com.adj.service.CrawlCarAndSerialService;
import com.adj.service.PrintKeyValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * Created by dhx on 2018/7/16.
 */
@SpringBootApplication
public class Application {

    private Logger logger = LoggerFactory.getLogger(Application.class);

    private static boolean crawlAllCarAndSerial = false;
    private static boolean printKeyValue = false;

    @Resource
    private CrawlCarAndSerialService crawlCarAndSerialService;
    @Resource
    private PrintKeyValueService printKeyValueService;

    public static void main(String[] args) {
        crawlAllCarAndSerial = false;
        printKeyValue = true;
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner crawlAllCarAndSerial() {
        return (args) -> {
            if (!crawlAllCarAndSerial) return;
            crawlCarAndSerialService.startCrawl();
        };
    }

    @Bean
    public CommandLineRunner printKeyValue() {
        return (args -> {
            if (!printKeyValue) return;
            printKeyValueService.printAll();
        });
    }
}
