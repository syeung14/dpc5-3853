/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package visitor.exercise1;

public class Person implements Contact {
    private final String email;

    public Person(String email) {
        this.email = email;
    }

    @Override
    public void accept(Visitor v) {
        v.visitPerson(this);
    }

    public String getEmail() {
        return email;
    }
}
