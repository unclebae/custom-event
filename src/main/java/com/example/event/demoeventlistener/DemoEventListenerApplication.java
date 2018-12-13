package com.example.event.demoeventlistener;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.*;

@Log4j2
@SpringBootApplication
public class DemoEventListenerApplication implements CommandLineRunner {

    @Autowired
    CustomEventPublisher customSpringEventPublisher;

    public static void main(String[] args) {
        final ConfigurableApplicationContext run =
                SpringApplication.run(DemoEventListenerApplication.class, args);


//        run.start();
//
//        sleep();
//
//        run.stop();
//
//        sleep();
//
//        run.close();
    }

    private static void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
    }

    @EventListener(classes = {ContextRefreshedEvent.class})
    public void refreshEvent(ContextRefreshedEvent contextRefreshedEvent) {
       log.info("[EVENT] ContextRefereshedEvent was started at: " + contextRefreshedEvent.getTimestamp());
    }

    @EventListener(classes = {ContextStartedEvent.class})
    public void startedEvent(ContextStartedEvent contextStartedEvent) {
        log.info("[EVENT] ContextStartedEvent was started at: " + contextStartedEvent.getTimestamp());
    }

    @EventListener(classes = {ContextStoppedEvent.class})
    public void stoppedEvent(ContextStoppedEvent contextStoppedEvent) {
        log.info("[EVENT] ContextStoppedEvent was started at: " + contextStoppedEvent.getTimestamp());
    }

    @EventListener(classes = {ContextClosedEvent.class})
    public void closedEvent(ContextClosedEvent contextClosedEvent) {
        log.info("[EVENT] ContextClosedEvent was started at: " + contextClosedEvent.getTimestamp());
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("[Command Line Runner] Run Command Line Runner....");
        customSpringEventPublisher.doStuffAndPublishAnEvent("Hello Event...");
        customSpringEventPublisher.doStuffAndPublishGenericEvent(GenericEvent.<String>builder()
            .what("Hello Generic ")
            .success(false)
            .build());
    }
}

