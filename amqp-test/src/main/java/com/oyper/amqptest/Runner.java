package com.oyper.amqptest;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Runner {

    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() throws InterruptedException {
        int i = 0;
        while (true) {
            System.out.println(" [x] Sent '" + i + "'");
            Integer o = (Integer) rabbitTemplate.convertSendAndReceive("rpc", i++, new CorrelationData());
            System.out.println(" [x] Got '" + o + "'");
            Thread.sleep(500);
        }
    }

}

