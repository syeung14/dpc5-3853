/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package chainofresponsibility.exercise1;

public class DoubleTrimmerConverter extends GeneralConverter<Double, Double> {
    public DoubleTrimmerConverter(Converter next) {
        super(next, Double.class, d -> (double)Math.round(d));
    }
}
