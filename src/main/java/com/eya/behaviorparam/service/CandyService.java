package com.eya.behaviorparam.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Service
public class CandyService {

    public static <T> List<T> filter(List<T> candies, Predicate<T> predicate) {
        return candies.stream().filter(predicate).collect(toList());
    }
}
