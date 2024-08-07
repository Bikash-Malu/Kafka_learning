package com.kafka.deliveryBoy.service;

import com.kafka.deliveryBoy.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    public void updateMessage( String message) {
        CompletableFuture<SendResult<String, Object>> send = kafkaTemplate.send(AppConstant.TOPIC_TYPE, message);
       send.whenComplete((result, ex) -> {
           if (ex != null) {
               ex.getMessage();
           }
           else {
               System.out.println(message+" with offset:"+result.getRecordMetadata().offset());
           }
       });
    }
}
