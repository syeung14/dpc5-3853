/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package chainofresponsibility.exercise1;

import java.util.function.Function;

public class GeneralConverter<E, R> extends Converter {
    private final Class<E> type;
    private final Function<E, R> convertFunction;

    public GeneralConverter(Converter next, Class<E> type, Function<E, R> convertFunction) {
        super(next);
        this.type = type;
        this.convertFunction = convertFunction;
    }

    public final Object handle(Object o) {
        if (type.isInstance(o)) o = convertFunction.apply(type.cast(o));
        return super.handle(o);
    }
}
