/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package strategy.exercise1;

public class TaxPayer {
    public static final int COMPANY = 0;
    public static final int EMPLOYEE = 1;
    public static final int TRUST = 2;

    private final TaxStrategy strategy;
    private final double income;

    public TaxPayer(int type, double income) {
        this.strategy = switch (type) {
            case COMPANY -> new CompanyTaxStrategy();
            case EMPLOYEE -> new EmployeeTaxStrategy();
            case TRUST -> new TrustTaxStrategy();
            default -> throw new IllegalArgumentException();
        };
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public double extortCash() {
        return strategy.extortCash();
    }

    private class CompanyTaxStrategy implements TaxStrategy {
        private static final double RATE = 0.30;

        @Override
        public double extortCash() {
            return getIncome() * RATE;
        }
    }

    private class EmployeeTaxStrategy implements TaxStrategy {
        private static final double RATE = 0.45;

        @Override
        public double extortCash() {
            return getIncome() * RATE;
        }
    }

    private class TrustTaxStrategy implements TaxStrategy {
        private static final double RATE = 0.35;

        @Override
        public double extortCash() {
            return getIncome() * RATE;
        }
    }
}
