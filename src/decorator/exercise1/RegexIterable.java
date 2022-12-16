/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package decorator.exercise1;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

public class RegexIterable<T> implements Iterable<T> {
    private final Iterable<T> source;
    private final Pattern pattern;

    // at construction, we build up a new list and add all those
    // objects whose toString() method matches the regular expression
    // Our iterator then simply walks over that list.  remove() should not be
    // allowed
    public RegexIterable(Iterable<T> it, String regex) {
        this.source = it;
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public Iterator<T> iterator() {
        return  StreamSupport.stream(source.spliterator(), false)
            .filter(t -> pattern.matcher(String.valueOf(t)).matches())
            .iterator();
    }
}
