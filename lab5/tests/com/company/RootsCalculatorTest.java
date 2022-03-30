package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

class RootsCalculatorTest {

    @Test
     void calculate_roots() {
        assertEquals(new ArrayList<Double>(Arrays.asList(3d,2d)),RootsCalculator.calculate_roots(1,-5,6));
        assertEquals(new ArrayList<Double>(List.of(2d)),RootsCalculator.calculate_roots(1,-4,4));
        assertEquals(new ArrayList<Double>(),RootsCalculator.calculate_roots(1,1,6));
        assertEquals(new ArrayList<Double>(List.of(-6d)),RootsCalculator.calculate_roots(0,1,6));
        assertEquals(new ArrayList<Double>(),RootsCalculator.calculate_roots(0,0,7));
        assertEquals(new ArrayList<Double>(List.of(Double.POSITIVE_INFINITY)),RootsCalculator.calculate_roots(0,0,0));
    }
}