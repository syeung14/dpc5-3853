/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2022, Heinz Kabutz, All rights reserved.
 */

package state.exercise1;

public class ManagerState extends State {
    @Override
    public int pay(Employee employee) {
        System.out.println("Paying lots of $$$ to manager");
        return 30000;
    }

    @Override
    public void advance(Employee employee) {
        employee.setState(new RetireeState());
    }

    @Override
    public void fire(Employee employee) {
        employee.setState(new EndState());
    }
}
