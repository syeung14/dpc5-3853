/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package strategy.exercise1;

//DON'T CHANGE
public sealed interface TaxStrategy permits
    CompanyTaxStrategy, EmployeeTaxStrategy, TrustTaxStrategy {
    TaxStrategy COMPANY = new CompanyTaxStrategy();
    TaxStrategy EMPLOYEE = new EmployeeTaxStrategy();
    TaxStrategy TRUST = new TrustTaxStrategy();
    double extortCash(TaxPayer payer);
}
