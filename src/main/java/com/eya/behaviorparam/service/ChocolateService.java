package com.eya.behaviorparam.service;

import com.eya.behaviorparam.model.Chocolate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ChocolateService {

   public static List<Chocolate> filterBitterChocolate(List<Chocolate> chocolates , String type){
        return chocolates.stream().filter(chocolate -> chocolate.getType().equals(type)).collect(toList());
    }

    public static List<Chocolate> filterChocolatesByWeight(List<Chocolate> chocolates, Integer weight) {
        return chocolates.stream().filter(chocolate -> chocolate.getWeight() > weight).collect(toList());
    }

    public static List<Chocolate> filterChocolatesByAnyAttribute(List<Chocolate> chocolates, String type, Integer weight, Boolean flag) {
        if (flag) return chocolates.stream().filter(chocolate -> chocolate.getWeight() > weight).collect(toList());
        return chocolates.stream().filter(chocolate -> chocolate.getType().equals(type)).collect(toList());
    }

    public static List<Chocolate> filterChocolatesWithAbstraction(List<Chocolate> chocolates, DarkChocolateFilter<Chocolate> predicate) {
        return chocolates.stream().filter(predicate).collect(toList());
    }

    public static List<Chocolate> filterChocolatesWithFunctionalInterfaces(List<Chocolate> chocolates, Predicate<Chocolate> predicate) {
        return chocolates.stream().filter(predicate).collect(toList());
    }

    public static List<Chocolate> filterChocolatesWithLambdas(List<Chocolate> chocolates, Predicate<Chocolate> predicate) {
        return chocolates.stream().filter(predicate).collect(toList());
    }
}
