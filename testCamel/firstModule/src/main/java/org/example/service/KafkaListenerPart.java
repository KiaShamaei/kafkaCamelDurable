package org.example.service;


import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaListenerPart {


    @RetryableTopic(attempts = "4",
            backoff = @Backoff(delay = 30000L, multiplier = 2),
            retryTopicSuffix = "_RETRY",
            dltTopicSuffix = "_DLT")
    @KafkaListener(autoStartup = "true",
            topics = "topic2",
            groupId = "task-group")
    public void consume(String value) throws InterruptedException {
        log.info("listener get value  : " + value);
        if(value.equals("1")){
            throw new RuntimeException("listener get error");
        }
        log.info(String.format(" listener get value and process  : " + value));
    }
}
