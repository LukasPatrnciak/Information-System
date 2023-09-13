package sk.lukaspatrnciak.informationsystem.data.user.service;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private static final AtomicLong generator = new AtomicLong(0);

    public static long newId() {
        return generator.getAndIncrement();
    }
}
