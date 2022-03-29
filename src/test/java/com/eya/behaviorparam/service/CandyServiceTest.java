package com.eya.behaviorparam.service;

import com.eya.behaviorparam.model.Cake;
import com.eya.behaviorparam.model.Chocolate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandyServiceTest {

    private final Chocolate chocoOne = new Chocolate("dark", 100);
    private final Chocolate chocoTwo = new Chocolate("white", 200);
    private final Chocolate chocoThree = new Chocolate("bitter", 300);
    private final Chocolate chocoFour = new Chocolate("bitter", 400);
    private final Chocolate chocoFive = new Chocolate("milk", 600);
    private final Cake cakeOne = new Cake("chocolate", 100);
    private final Cake cakeTwo = new Cake("blueberry", 200);
    private final Cake cakeThree = new Cake("vanilla", 300);
    private final Cake cakeFour = new Cake("redvelvet", 400);
    private final Cake cakeFive = new Cake("icecream", 600);
    private final List<Chocolate> mockedChocos = List.of(chocoOne, chocoTwo, chocoThree, chocoFour, chocoFive);
    private final List<Cake> mockedCakes = List.of(cakeOne, cakeTwo, cakeThree, cakeFour, cakeFive);

    @Test
    public void filter_CakeWeight() {
        // arrange
        Integer expectedAmountOfCandies = 4;

        // act
        List<Cake> candies = CandyService.filter(mockedCakes, (cake) -> cake.getWeight() > 100);
        Integer actualAmountOfCandies = candies.size();

        // assert
        assertEquals(expectedAmountOfCandies, actualAmountOfCandies);
    }

    @Test
    public void filter_CakeFlavor() {
        // arrange
        Integer expectedAmountOfCandies = 1;

        // act
        List<Cake> candies = CandyService.filter(mockedCakes, (cake) -> cake.getFlavor().equals("chocolate"));
        Integer actualAmountOfCandies = candies.size();

        // assert
        assertEquals(expectedAmountOfCandies, actualAmountOfCandies);
    }

    @Test
    public void filter_ChocolateWeight() {
        // arrange
        Integer expectedAmountOfCandies = 4;

        // act
        List<Chocolate> candies = CandyService.filter(mockedChocos, (chocolate) -> chocolate.getWeight() > 100);
        Integer actualAmountOfCandies = candies.size();

        // assert
        assertEquals(expectedAmountOfCandies, actualAmountOfCandies);
    }

    @Test
    public void filter_ChocolateType() {
        // arrange
        Integer expectedAmountOfCandies = 2;

        // act
        List<Chocolate> candies = CandyService.filter(mockedChocos, (chocolate) -> chocolate.getType().equals("bitter"));
        Integer actualAmountOfCandies = candies.size();

        // assert
        assertEquals(expectedAmountOfCandies, actualAmountOfCandies);
    }
}
