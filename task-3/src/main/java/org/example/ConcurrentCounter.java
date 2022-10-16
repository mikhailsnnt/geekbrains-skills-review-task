package org.example;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Stream;

public class ConcurrentCounter {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private volatile int value = 0;

    public int increment() {
        lock.writeLock().lock();
        try {
            return ++value;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getValue() {
        lock.readLock().lock();
        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ConcurrentCounter concurrentCounter = new ConcurrentCounter();
        Stream.generate(() -> (Runnable) () -> {
                            for (int i = 0; i < 1000; i++) {
                                concurrentCounter.increment();
                            }
                        }
                ).limit(5)
                .map(Thread::new)
                .peek(Thread::start)
                .forEach((thread) -> {
                            try {
                                thread.join();
                            } catch (InterruptedException e) {

                            }
                        }
                );
        if(concurrentCounter.getValue() == 5000)
            System.out.println("Concurrent counter is OK");
    }
}
