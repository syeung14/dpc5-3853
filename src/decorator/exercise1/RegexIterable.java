/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package decorator.exercise1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RegexIterable<T> implements Iterable<T> {
    private final List<T> list;

    // at construction, we build up a new list and add all those
    // objects whose toString() method matches the regular expression
    // Our iterator then simply walks over that list.  remove() should not be
    // allowed
    public RegexIterable(Iterable<T> it, String regex) {
        list = StreamSupport.stream(it.spliterator(), false)
            .filter(t -> String.valueOf(t).matches(regex))
            .collect(Collectors.toUnmodifiableList());

/*
        Collection<T> lst = new ArrayList<>();
        for (T t : it) {
            if (String.valueOf(t).matches(regex)) lst.add(t);
        }

        this.list = List.copyOf(lst);
*/
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }
}
