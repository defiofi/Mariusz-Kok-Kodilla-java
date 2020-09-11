package com.kodilla.testing.collection;
import org.junit.jupiter.api.*;

import java.util.*;

public class CollectionTestSuite {
    @BeforeEach
    public void beforeEach(){
        System.out.println("Test klasy: OddNumbersExterminator");
    }
    @AfterEach
    public void afterEach() {
        System.out.println("Test klasy zakonczony.");
    }
    @DisplayName("Sprawdzam, czy klasa zachowuje sie poprawnie, gdy lista jest pusta.")
    @Test
    void testOddNumbersExterminatorEmptyList(){
                //Given
        Integer a[] = new Integer[] {};
        List<Integer> lista1 = Arrays.asList(a);
        List<Integer> rezultat = new ArrayList<>();

                //When
        OddNumbersExterminator obiektTestowy = new OddNumbersExterminator();
        rezultat = obiektTestowy.exterminate(lista1);

                //Then
        Assertions.assertTrue(rezultat.isEmpty());
    }
    @DisplayName("Sprawdzam, czy klasa zachowuje sie poprawnie, gdy lista zawiera liczby parzyste i nieparzyste.")
    @Test
    void testOddNumbersExterminatorNormalList(){
                //Given
        List<Integer> pytanie = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        final List<Integer> poprawnaOdpowiedz = Arrays.asList(new Integer[] {2, 4, 6, 8, 10});
        List<Integer> rezultat = new ArrayList<>();
                //When
        OddNumbersExterminator obiektTestowy = new OddNumbersExterminator();
        rezultat = obiektTestowy.exterminate(pytanie);
                //Then
        Assertions.assertEquals(poprawnaOdpowiedz, rezultat);
    }
}
