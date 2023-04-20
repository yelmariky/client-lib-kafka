package com.baeldung.spring.kafka;

import com.baeldung.spring.kafka.utils.Constants;
import fr.younes.lib.spring.kafka.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import fr.younes.lib.spring.kafka.MessageProducer;

@SpringBootApplication
public class StarterKafkaApplication implements CommandLineRunner {
    @Autowired
    MessageProducer messageProducer;

    @Autowired
    MessageListener messageListener;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StarterKafkaApplication.class, args);



    }

    @Override
    public void run(String... args) throws Exception {
        messageProducer.sendMessage("hello");

        System.out.println("connect consumer");
        String in = "";
        messageListener.readTopicsObject( in);
        System.out.println("final consumer");
    }
}
