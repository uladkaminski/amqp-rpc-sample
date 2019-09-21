package com.oyper.subs;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("tut.rpc");
    }
    @Bean
    public Receiver receiver1(){
        return new Receiver(1);
    }
    @Bean
    public Receiver receiver2(){
        return new Receiver(2);
    }
}
