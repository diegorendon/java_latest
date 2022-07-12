package com.kousenit.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class CollectDevelopers {

    public static Set<Developer> convertNamesToDevelopers(List<String> names) {
        return names.parallelStream()
                //.map(name -> new Developer(name))
                .map(Developer::new)
                .peek(x -> System.out.println(x + " on thread " + Thread.currentThread().getName()))
                .collect(Collectors.toCollection(LinkedHashSet::new));  // collect respects ordering of the input list
    }

    public static List<Developer> convertNamesToDevelopersNoOrder(List<String> names) {
        List<Developer> developers = new ArrayList<>(names.size());
        names.parallelStream()
                .forEach(name -> developers.add(new Developer(name)));
        return developers;
    }
}
