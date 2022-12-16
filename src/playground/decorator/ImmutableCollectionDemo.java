/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2022, Heinz Kabutz, All rights reserved.
 */

package playground.decorator;

import eu.javaspecialists.books.dynamicproxies.Proxies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableCollectionDemo {
    public static void main(String... args) {
        List<String> students = new ArrayList<>();
        Collections.addAll(students, "PG", "MG", "U1", "CJ");

        ImmutableCollection<String> immutableStudents =
            Proxies.filter(ImmutableCollection.class, students);
//        immutableStudents.clear();
        System.out.println(immutableStudents);
        System.out.println("immutableStudents.size() = " + immutableStudents.size());

//        students = Collections.unmodifiableList(students);
//        students.clear(); // exception
//        System.out.println(students);
//        System.out.println("students.size() = " + students.size());
    }
}
