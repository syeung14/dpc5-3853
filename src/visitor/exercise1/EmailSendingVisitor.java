/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package visitor.exercise1;

public class EmailSendingVisitor implements Visitor {
    private final String msg;

    public EmailSendingVisitor(String msg) {
        this.msg = msg;
    }

    @Override
    public void visitPerson(Person p) {
        System.out.println("To: " + p.getEmail());
        System.out.println("Msg: " + msg);
        System.out.println();
    }

    @Override
    public void visitDistributionList(DistributionList dl) {
        // do nothing
    }
}
