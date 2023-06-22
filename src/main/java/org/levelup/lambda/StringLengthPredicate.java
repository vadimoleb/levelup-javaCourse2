package org.levelup.lambda;

import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class StringLengthPredicate implements Predicate<String> {

    private final int length;

    @Override
    public boolean test(String s) {
        return s.length() > length;
    }
}
