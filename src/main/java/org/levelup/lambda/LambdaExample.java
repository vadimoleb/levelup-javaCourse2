package org.levelup.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExample {

    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Hello");
        listOfStrings.add("Goodbye");
        listOfStrings.add("Ten thousands");
        listOfStrings.add("Midnight");
        listOfStrings.add("Lost is sleepers");
        listOfStrings.add("d");

        List<String> filtered = new ArrayList<>();
        StringLengthPredicate predicate = new StringLengthPredicate(5);

        for (String el : listOfStrings) {
            if (predicate.test(el)) {
                filtered.add(el);
            }
        }
        System.out.println("Original: " + listOfStrings);
        System.out.println("Filtered: " + filtered);

        int length = 5;

        //Анонимный внутренний класс
        Predicate<String> innerClassPredicate = new Predicate<String>() {
            @Override
            public boolean test(String value) {
                return value.length() > length;
            }
        };
        List<String> filteredByInnerPredicate = new ArrayList<>();
        for (String el : listOfStrings) {
            if (innerClassPredicate.test(el)) {
                filteredByInnerPredicate.add(el);
            }
        }
        System.out.println("Filtered: " + filteredByInnerPredicate);

        //Лямбда. Аргумент s, а справа тело метода, который переопределяется
        Predicate<String> lambdaPredicate = (s) -> s.length() > length;

        Function<String, String> stringToHex = value -> {
          int intValue = Integer.parseInt(value);
          return Integer.toHexString(intValue);
        };

        System.out.println("456 -> HEX: "+ stringToHex.apply("456"));


    }
}
