/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package visitor.exercise1;

import maths.*;

/**
 * This must count how many leaves there are in structure, how many distribution
 * lists and what the average number of contacts in a distribution list.
 * <p/>
 * Use the Statistics class to work out the mean and variance for the list
 * lengths.
 */
public class CountingVisitor implements Visitor {
    private final Statistics compositeStatistics = new Statistics();
    private int leaves;

    @Override
    public void visitPerson(Person p) {
        leaves++;
    }

    @Override
    public void visitDistributionList(DistributionList dl) {
        compositeStatistics.add(dl.getNumberOfChildrenContacts());
    }

    public int getNumberOfLeaves() {
        return leaves;
    }

    public int getNumberOfComposites() {
        return compositeStatistics.size();
    }

    public double getAverageNumberOfChildrenPerComposite() {
        return compositeStatistics.getMean();
    }

    public double getVarianceNumberOfChildrenPerComposite() {
        return compositeStatistics.getVariance();
    }
}
