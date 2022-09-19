package org.example;


import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentPingPong {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        Thread ping = new Thread(()->{
            while(count.getAndDecrement() > 0){
                synchronized (count) {
                    count.notifyAll();
                    System.out.println("Ping"+count.get());
                    try {
                        count.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread pong = new Thread(()->{
            while(count.getAndDecrement() > 0) {
                synchronized (count) {
                    count.notifyAll();
                    System.out.println("Pong "+count.get());
                    try {
                        count.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        ping.start();
        pong.start();


    }
}
