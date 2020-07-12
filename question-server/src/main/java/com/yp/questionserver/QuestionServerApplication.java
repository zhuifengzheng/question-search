package com.yp.questionserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class QuestionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionServerApplication.class, args);
        log.info("QuestionServerApplication start success ...");

    }

}
