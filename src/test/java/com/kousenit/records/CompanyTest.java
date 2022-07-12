package com.kousenit.records;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    private final Company company = new Company("NFJS");

    @Test
    void getManagerNameThatDoesExist() {
        // get Manager that does exist
        Optional<Manager> manager = company.getDepartmentById(1)
                .flatMap(Department::getManager);  // Function<Department, Optional<Manager>>
        manager.ifPresent(m -> assertThat(m.name()).isEqualTo("Mr. Burns"));

        // Extract manager
        // Manager manager1 = manager.orElseGet(() -> new Manager("None"));
        Manager manager1 = manager.orElseThrow(() -> new IllegalStateException("Manager not found"));
        assertThat(manager1.name()).isEqualTo("Mr. Burns");

        // Map manager to name
        manager.map(Manager::name)  // Function<Manager, String>
                .ifPresent(n -> assertThat(n).isEqualTo("Mr. Burns"));
    }

    @Test
    void getManagerNameThatDoesNotExist() {
        Optional<Manager> manager = company.getDepartmentById(4)
                .flatMap(Department::getManager);  // Function<Department, Optional<Manager>>
        assertThat(manager).isEmpty();
    }

    @Test
    void flatMapOnEmptyOptional() {
        Optional<String> empty = Optional.empty();
        Optional<String> emptyString = empty.flatMap(s -> Optional.of(""));
        assertThat(emptyString).isEmpty();
    }
}