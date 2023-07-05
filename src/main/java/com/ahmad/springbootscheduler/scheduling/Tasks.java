package com.ahmad.springbootscheduler.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Tasks {

    private static final Logger log = LoggerFactory.getLogger(Tasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    //https://crontab.guru/#41_9_*_*_* ------ https://www.crondrive.com/test-cron-expression
    // every day at 09:50:00 AM
    @Scheduled(cron = "0 50 9 * * *", zone = "Iran")
    public void doOnSpecificTime() {
        log.info("the task have done in: {}", dateFormat.format(new Date()));
    }

}
