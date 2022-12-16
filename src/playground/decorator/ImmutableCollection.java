/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2022, Heinz Kabutz, All rights reserved.
 */

package playground.decorator;

import java.util.Collection;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public interface ImmutableCollection<E> {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Object[] toArray();

    <T> T[] toArray(T[] a);

    <T> T[] toArray(IntFunction<T[]> generator);

    boolean containsAll(Collection<?> c);

    Spliterator<E> spliterator();

    Stream<E> stream();

    Stream<E> parallelStream();

    void forEach(Consumer<? super E> action);

    E get(int index);
//    void printAll();
}
