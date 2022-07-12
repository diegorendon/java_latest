package com.kousenit.collectors;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CollectDevelopersTest {

    @Test
    void convertStringsToDevelopers() {
        List<String> names = List.of("John", "Paul", "George", "Ringo");
        List<Developer> developers = CollectDevelopers.convertNamesToDevelopers(names);
        assertThat(developers).hasSize(4);
        System.out.println(developers.getClass().getName());
        System.out.println(developers);
    }

    @Test
    void convertStringsToDevelopersNoOrdering() {
        List<String> names = List.of("John", "Paul", "George", "Ringo");
        List<Developer> developers = CollectDevelopers.convertNamesToDevelopersNoOrder(names);
        assertThat(developers).hasSize(4);
        System.out.println(developers.getClass().getName());
        System.out.println(developers);
    }
}