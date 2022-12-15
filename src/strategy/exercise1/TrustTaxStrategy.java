/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2022, Heinz Kabutz, All rights reserved.
 */

package strategy.exercise1;

public class TrustTaxStrategy implements TaxStrategy {
    private static final double RATE = 0.35;
    private final TaxPayer payer;

    public TrustTaxStrategy(TaxPayer payer) {
        this.payer = payer;
    }

    @Override
    public double extortCash() {
        return payer.getIncome() * RATE;
    }
}
