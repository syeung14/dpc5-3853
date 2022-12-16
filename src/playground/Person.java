/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2022, Heinz Kabutz, All rights reserved.
 */

package playground;

import java.util.Comparator;

public record Person(String firstName, String lastName, int age) {
    public static final Comparator<Person> NATURAL_OLD = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            int result = o1.firstName.compareTo(o2.firstName);
            if (result != 0) return result;
            result = o1.lastName.compareTo(o2.lastName);
            if (result != 0) return result;
            return Integer.compare(o1.age, o2.age);
        }
    };
    public static final Comparator<Person> NATURAL_NEW =
        Comparator.comparing(Person::firstName)
            .thenComparing(Person::lastName)
            .thenComparingInt(Person::age);

    public static final class PersonBuilder {
        private String firstName;
        private String lastName;
        private int age;

        private PersonBuilder() {
        }

        public static PersonBuilder aPerson() {
            return new PersonBuilder();
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(firstName, lastName, age);
        }
    }
}
