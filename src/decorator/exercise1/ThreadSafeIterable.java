/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package decorator.exercise1;

import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

// this class should implement Iterable<T>
public class ThreadSafeIterable<T> {
    private final Iterable<T> copy;

    // synchronize on the lock and copy the source into a new collection
    public ThreadSafeIterable(Iterable<T> source, Object lock) {
        synchronized (lock) {
            this.copy = copy(source);
        }
    }

    private Iterable<T> copy(Iterable<T> src) {
        return StreamSupport.stream(src.spliterator(), false)
            .collect(Collectors.toUnmodifiableList());
    }

    // lock() the Java 5 lock and copy the source into a new collection
    public ThreadSafeIterable(Iterable<T> source, Lock lock) {
        lock.lock();
        try {
            copy = copy(source);
        } finally {
            lock.unlock();
        }
    }

    public Iterator<T> iterator() {
        return copy.iterator();
    }
}
