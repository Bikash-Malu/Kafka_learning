package com.kafka.deliveryBoy.controller;

import com.kafka.deliveryBoy.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TopicController {
    @Autowired
    private KafkaMessagePublisher kafkaService;
//    private KafkaMessagePublisher kafkaMessagePublisher;
    @GetMapping("/{message}")
    public ResponseEntity<?> updateLocation(@PathVariable String message) {
        try {
            kafkaService.updateMessage(message);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(Map.of("meassge","message update"), HttpStatus.OK);

    }
}
