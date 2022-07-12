package com.kousenit.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectDevelopers {

    public static List<Developer> convertNamesToDevelopers(List<String> names) {
        return names.parallelStream()
                .map(name -> new Developer(name))
                .peek(x -> System.out.println(x + " on thread " + Thread.currentThread().getName()))
                .collect(Collectors.toList());  // collect respects ordering of the input list
    }

    public static List<Developer> convertNamesToDevelopersNoOrder(List<String> names) {
        List<Developer> developers = new ArrayList<>(names.size());
        names.parallelStream()
                .forEach(name -> developers.add(new Developer(name)));
        return developers;
    }
}
