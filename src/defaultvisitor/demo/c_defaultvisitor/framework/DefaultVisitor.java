/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package defaultvisitor.demo.c_defaultvisitor.framework;

public interface DefaultVisitor extends Visitor {
    default void visitNumber(Number n) {
        visitExpression(n);
    }

    default void visitPlus(Plus p) {
        visitExpression(p);
    }

    default void visitExpression(Expression e) {
        // do nothing
    }
}
