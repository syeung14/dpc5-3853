/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2023, Heinz Kabutz, All rights reserved.
 */

package visitor.exercise1;

public interface Visitor {
    void visit(Person p);

    void visit(DistributionList dl);
}
