package com.kousenit.streams;

import com.kousenit.collectors.Developer;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class CompositionDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", null, "is", "a",
                null, "list", "of", "strings", null);

        List<String> evens = strings.stream()
                // .filter(s -> s != null && s.length() % 2 == 0) // short-circuiting logical AND
                // .filter(s -> s != null)
                .filter(Objects::nonNull)
                .filter(s -> s.length() % 2 == 0)
                .map(String::toUpperCase)
                .toList();
        System.out.println(evens);

        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> evenLength = s -> s.length() % 2 == 0;
        evens = strings.stream()
                .filter(nonNull.and(evenLength))  // function composition
                .map(String::toUpperCase)
                .toList();
        System.out.println(evens);

        Logger logger = Logger.getLogger(CompositionDemo.class.getName());
        Consumer<String> consolePrint = System.out::println;
        Consumer<String> loggerPrint = logger::info;
        evens.forEach(consolePrint.andThen(loggerPrint));

        Map.ofEntries(
                Map.entry("a", 1),
                Map.entry("b", 2),
                Map.entry("c", 2)
        ).forEach((k, v) -> System.out.println(k + "=" + v));

        Stream.of(new Developer("Picard"),
                        new Developer("Riker"),
                        new Developer("LaForge"),
                        new Developer("Worf"),
                        new Developer("Troi"),
                        new Developer("Crusher"))
                .sorted(Comparator.comparing((Developer developer) -> developer.getName().length())
                        .thenComparing(Developer::getName))
                .forEach(System.out::println);
    }
}
