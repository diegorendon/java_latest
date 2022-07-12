package com.kousenit.records;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class Company {
    private String name;
    private static final Map<Integer, Department> departments =
            Collections.synchronizedMap(new java.util.HashMap<>());

    public Company(String name) {
        this.name = name;

        // initialize departments
        departments.put(1, new Department(1, "Sales"));
        departments.put(2, new Department(2, "Marketing"));
        departments.put(3, new Department(3, "IT"));
        departments.put(4, new Department(4, "HR"));

        // initialize managers
        departments.get(1).setManager(new Manager("Mr. Burns"));
        departments.get(2).setManager(new Manager("Mr. Slate"));
        departments.get(3).setManager(new Manager("Mr. Scott"));
    }

    public Optional<Department> getDepartmentById(int id) {
        return Optional.ofNullable(departments.get(id));
    }
}
