package com.hp.test.stream;

public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean filter(Employee employee) {
        return employee.getAge() > 18;
    }

}
