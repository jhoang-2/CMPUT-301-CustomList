package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<>());
    }
    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(listSize + 1, list.getCount());
    }
    @Test
    public void hasCityTest() {
        City city = new City("Edmonton", "Alberta");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }
    @Test
    public void deleteCityTest() {
        City city = new City("Toronto", "Ontario");
        list.addCity(city);
        list.delete(city);
        assertFalse(list.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city);
        });
    }
    @Test
    public void countCitiesTest() {
        assertEquals(list.getCount(), list.countCities());
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);
        assertEquals(list.getCount(), list.countCities());
    }
}
