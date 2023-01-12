/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package state.exercise1;

/**
 * Code without clear state machine transitions.  It is very
 * ugly.  Your job is to use the state pattern to clean things
 * up.
 */
public class Employee {
    private State state;
    private int type = 0;

    public Employee() {
        type = 1; // programmer - that's what you start with
        setState(State.PROGRAMMER);
    }

    public int pay() {
        return state.pay(this);
    }

    public void setState(State state) {
        Employee.this.state = state;
    }

    public void advance() {
        state.advance(this);
    }

    public void fire() {
        state.fire(this);
    }
}
