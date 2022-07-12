package com.kousenit.records;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ManagerTest {
    Manager mrBurns = new Manager("Mr. Burns");

    @Test
    void checkName() {
        assertThat(mrBurns.name()).isEqualTo("Mr. Burns");
    }

    @Test
    void checkEquivalence() {
        Manager mrBurns2 = new Manager("Mr. Burns");
        assertThat(mrBurns).isEqualTo(mrBurns2);
    }
}