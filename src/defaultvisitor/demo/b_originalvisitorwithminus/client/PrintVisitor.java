/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package defaultvisitor.demo.b_originalvisitorwithminus.client;

import defaultvisitor.demo.b_originalvisitorwithminus.framework.Minus;
import defaultvisitor.demo.b_originalvisitorwithminus.framework.Number;
import defaultvisitor.demo.b_originalvisitorwithminus.framework.Plus;
import defaultvisitor.demo.b_originalvisitorwithminus.framework.Visitor;

public class PrintVisitor implements Visitor {
    protected final StringBuilder sb = new StringBuilder();

    public void visitPlus(Plus s) {
        sb.append("+ ");
    }

    @Override
    public void visitMinus(Minus m) {
        sb.append("- ");
    }

    public void visitNumber(Number n) {
        sb.append(n.getValue()).append(' ');
    }

    public String toString() {
        return sb.toString().trim();
    }
}
