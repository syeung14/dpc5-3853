/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2022, Heinz Kabutz, All rights reserved.
 */

package playground;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class BuilderDemo {
    public static <K, V> Map<V, List<K>> reverse(Map<K, V> map) {
        return map.entrySet().stream()
            .collect(Collectors.groupingBy(Map.Entry::getValue,
                ConcurrentHashMap::new, // "ConcreteBuilder" declared as Supplier
                Collectors.mapping(
                    Map.Entry::getKey,
                    Collectors.toCollection(CopyOnWriteArrayList::new) // "ConcreteBuilder" declared as Supplier
                )));
    }

    public static void main(String... args) {
        Map<String, Integer> numbers = Map.of("one", 1, "eins", 1, "ένα", 1, "two", 2);
        Map<Integer, List<String>> reversed = reverse(numbers);
        reversed.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
