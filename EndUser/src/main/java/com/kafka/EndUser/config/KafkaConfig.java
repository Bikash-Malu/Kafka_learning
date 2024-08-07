package com.kafka.EndUser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {
    @KafkaListener(topics =AppConstant.LOCATION_TYPE,groupId = AppConstant.GROUP_ID)
    public void updatedLoaction(String location){
        System.out.println(location);

    }
}
