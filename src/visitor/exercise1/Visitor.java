/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2022, Heinz Kabutz, All rights reserved.
 */

package visitor.exercise1;

public interface Visitor {
    void visitPerson(Person p);
    void visitDistributionList(DistributionList dl);
}
