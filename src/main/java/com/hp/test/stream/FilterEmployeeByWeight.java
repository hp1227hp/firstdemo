package com.hp.test.stream;

public class FilterEmployeeByWeight implements MyPredicate<Employee> {

    @Override
    public boolean filter(Employee employee) {
        return employee.getWeight() > 50;
    }

}
