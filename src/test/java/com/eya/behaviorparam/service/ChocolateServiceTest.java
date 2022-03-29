package com.eya.behaviorparam.service;

import com.eya.behaviorparam.model.Chocolate;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChocolateServiceTest {

    private final Chocolate chocoOne = new Chocolate("dark", 100);
    private final Chocolate chocoTwo = new Chocolate("white", 200);
    private final Chocolate chocoThree = new Chocolate("bitter", 300);
    private final Chocolate chocoFour = new Chocolate("bitter", 400);
    private final Chocolate chocoFive = new Chocolate("milk", 600);
    private final List<Chocolate> mockedChocos = List.of(chocoOne, chocoTwo, chocoThree, chocoFour, chocoFive);
    private final DarkChocolateFilter<Chocolate> predicate = new DarkChocolateFilter<>();

    @Test
    public void filterBitterChocolates() {
        // arrange
        Integer expectedAmountOfChocos = 2;

        // act
        List<Chocolate> chocos = ChocolateService.filterBitterChocolate(mockedChocos, "bitter");
        Integer actualAmountOfChocos = chocos.size();

        // assert
        assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
    }

    @Test
    public void filterChocolatesByWeight() {
        // arrange
        Integer expectedAmountOfChocos = 3;

        // act
        List<Chocolate> chocos = ChocolateService.filterChocolatesByWeight(mockedChocos, 200);
        Integer actualAmountOfChocos = chocos.size();

        // assert
        assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
    }

    @Test
    public void filterChocolatesByAnyAttribute_Type() {
        // arrange
        Integer expectedAmountOfChocos = 1;

        // act
        List<Chocolate> chocos = ChocolateService.filterChocolatesByAnyAttribute(mockedChocos, "white", 0, false);
        Integer actualAmountOfChocos = chocos.size();

        // assert
        assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
    }

    @Test
    public void filterChocolatesByAnyAttribute_Weight() {
        // arrange
        Integer expectedAmountOfChocos = 4;

        // act
        List<Chocolate> chocos = ChocolateService.filterChocolatesByAnyAttribute(mockedChocos, "", 100, true);
        Integer actualAmountOfChocos = chocos.size();

        // assert
        assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
    }

    @Test
    public void filterChocolatesWithAbstraction_DarkType() {
        // arrange
        Integer expectedAmountOfChocos = 1;

        // act
        List<Chocolate> chocos = ChocolateService.filterChocolatesWithAbstraction(mockedChocos, predicate);
        Integer actualAmountOfChocos = chocos.size();

        // assert
        assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
    }

    @Test
    public void filterChocolatesWithAbstraction_DarkTypeAnonymousClass() {
        // arrange
        Integer expectedAmountOfChocos = 1;

        // act
        List<Chocolate> chocos = ChocolateService.filterChocolatesWithAbstraction(mockedChocos, new DarkChocolateFilter<>() {
            public boolean test(Chocolate chocolate) {
                return chocolate.getType().equals("dark");
            }
        });
        Integer actualAmountOfChocos = chocos.size();

        // assert
        assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
    }

    @Test
    public void filterChocolatesWithFunctionalInterfaces_TypeAndWeight() {
        // arrange
        Integer expectedAmountOfChocos = 1;
        Predicate<Chocolate> predicate = (chocolate) -> chocolate.getWeight() >= 100 && chocolate.getType().equals("dark");

        // act
        List<Chocolate> chocos = ChocolateService.filterChocolatesWithFunctionalInterfaces(mockedChocos, predicate);
        Integer actualAmountOfChocos = chocos.size();

        // assert
        assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
    }

    @Test
    public void filterChocolatesWithLambdas_Type() {
        // arrange
        Integer expectedAmountOfChocos = 1;

        // act
        List<Chocolate> chocos = ChocolateService.filterChocolatesWithLambdas(mockedChocos, (chocolate) -> chocolate.getType().equals("dark"));
        Integer actualAmountOfChocos = chocos.size();

        // assert
        assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
    }

}
