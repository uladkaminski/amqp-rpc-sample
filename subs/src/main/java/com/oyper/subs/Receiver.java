package com.oyper.subs;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


@RabbitListener(queues = "tut.rpc.requests")
public class Receiver {
    public int a;

    public Receiver(int b) {
        a = b;
    }


    @RabbitHandler
    public int receive(Integer in) throws InterruptedException {
        System.out.println(a +
                " [x] Received '" + in + "'");
        int result = doWork(in);
        System.out.println(a +
                " [x] Done " + result );
        return result;
    }



    private int doWork(int n) throws InterruptedException {
        return n == 0 ? 0 : n == 1 ? 1 : (doWork(n - 1) + doWork(n - 2));

    }

}
