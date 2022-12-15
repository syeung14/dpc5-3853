/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2022, Heinz Kabutz, All rights reserved.
 */

package strategy.exercise1;

public class EmployeeTaxStrategy implements TaxStrategy {
    private static final double RATE = 0.45;
    public static final double COMPANY_RATE = 0.30;
    public static final double TRUST_RATE = 0.35;
    private final TaxPayer payer;

    public EmployeeTaxStrategy(TaxPayer payer) {
        this.payer = payer;
    }

    @Override
    public double extortCash() {
        return payer.getIncome() * RATE;
    }
}
