/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2022, Heinz Kabutz, All rights reserved.
 */

package playground.memento;

import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class BigCompany {
    private final Map<Employee, Deque<Memento>> history =
        new ConcurrentHashMap<>();

    public void promote(Employee employee) {
        snapshot(employee);
        employee.promote();
    }

    public void pay(Employee employee) {
        snapshot(employee);
        employee.pay();
    }

    private void snapshot(Employee employee) {
        history.computeIfAbsent(employee, k -> new ConcurrentLinkedDeque<>())
            .addLast(employee.createMemento());
    }

    public void undo(Employee employee) {
        Deque<Memento> deque = history.get(employee);
        if (deque != null) {
            Memento m = deque.pollLast();
            if (m != null) employee.setMemento(m);
        }
    }
}
