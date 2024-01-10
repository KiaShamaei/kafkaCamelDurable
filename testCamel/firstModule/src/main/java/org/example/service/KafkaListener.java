package org.example.service;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaListener {
    @org.springframework.kafka.annotation.KafkaListener(topics = {"topic1"}, groupId = "task-group")
    public void consume(String value) {

        log.info(String.format(" listener get value  : " + value));
    }
}
