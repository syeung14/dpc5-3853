/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package state.exercise1;

public abstract class State {
    public int pay(Employee employee) {
        return 0;
    }

    public void advance(Employee employee) {
    }

    public void fire(Employee employee) {
    }
}
