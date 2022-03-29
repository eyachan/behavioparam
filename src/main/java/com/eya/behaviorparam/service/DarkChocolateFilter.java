package com.eya.behaviorparam.service;

import com.eya.behaviorparam.model.Chocolate;

import java.util.function.Predicate;

public class DarkChocolateFilter<T> implements Predicate<T> {

    @Override
    public boolean test(T t) {
        Chocolate chocolate = (Chocolate) t;
        return chocolate.getType().equals("dark");
    }
}