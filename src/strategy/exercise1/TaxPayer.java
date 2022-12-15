/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package strategy.exercise1;

import java.util.Objects;

public class TaxPayer {
    public static final TaxStrategy COMPANY = new CompanyTaxStrategy();
    public static final TaxStrategy EMPLOYEE = new EmployeeTaxStrategy();
    public static final TaxStrategy TRUST = new TrustTaxStrategy();

    private final TaxStrategy strategy;
    private final double income;

    public TaxPayer(TaxStrategy strategy, double income) {
        this.strategy = Objects.requireNonNull(strategy);
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public double extortCash() {
        return strategy.extortCash(this);
    }

    private static class CompanyTaxStrategy implements TaxStrategy {
        private static final double RATE = 0.30;

        @Override
        public double extortCash(TaxPayer payer) {
            return payer.getIncome() * RATE;
        }
    }

    private static class EmployeeTaxStrategy implements TaxStrategy {
        private static final double RATE = 0.45;

        @Override
        public double extortCash(TaxPayer payer) {
            return payer.getIncome() * RATE;
        }
    }

    private static class TrustTaxStrategy implements TaxStrategy {
        private static final double RATE = 0.35;

        @Override
        public double extortCash(TaxPayer payer) {
            return payer.getIncome() * RATE;
        }
    }
}
