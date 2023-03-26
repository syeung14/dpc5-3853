/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package visitor.exercise1;

import maths.*;

import java.util.concurrent.atomic.LongAdder;

/**
 * This must count how many leaves there are in structure, how many distribution
 * lists and what the average number of contacts in a distribution list.
 * <p/>
 * Use the Statistics class to work out the mean and variance for the list
 * lengths.
 */
public class CountingVisitor implements Visitor {
    private final Statistics compositeStatistics = new Statistics();
    private final LongAdder leafcount = new LongAdder();

    public int getNumberOfLeaves() {
        return leafcount.intValue();
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

    @Override
    public void visit(Person p) {
        leafcount.increment();
        System.out.println("do some calculaion!!!");
    }

    @Override
    public void visit(DistributionList dl) {
        compositeStatistics.add(dl.getNumberOfchildren());
    }
}
