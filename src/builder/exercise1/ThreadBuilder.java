/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package builder.exercise1;

import java.util.Optional;
import java.util.OptionalInt;

public class ThreadBuilder {
    private final Runnable target;
    private Thread.Builder.OfPlatform builder;

    public ThreadBuilder(Runnable target, String name) {
        this.target = target;
        builder = Thread.ofPlatform().name(name);
    }

    public Thread build() {
        return builder.unstarted(target);
    }

    public Thread start() {
        Thread thread = build();
        thread.start();
        return thread;
    }

    public ThreadBuilder threadGroup(ThreadGroup threadGroup) {
        builder = builder.group(threadGroup);
        return this;
    }

    public ThreadBuilder stackSize(long stackSize) {
        builder = builder.stackSize(stackSize);
        return this;
    }

    public ThreadBuilder inheritThreadLocals(boolean inheritThreadLocals) {
        builder = builder.inheritInheritableThreadLocals(inheritThreadLocals);
        return this;
    }

    public ThreadBuilder daemon(boolean daemon) {
        builder = builder.daemon(daemon);
        return this;
    }

    public ThreadBuilder priority(int priority) {
        builder = builder.priority(priority);
        return this;
    }

    public ThreadBuilder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        builder = builder.uncaughtExceptionHandler(uncaughtExceptionHandler);
        return this;
    }
}
