package com.caglareker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlateauTest {

    @Test
    void checkUserCanCreatePlateau() {
        Plateau plateau = new Plateau(5, 5);
        String expectedResult = "The plateau dimensions are 5 5.";

        String actual = plateau.getDimensions();

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    void checkUserCanNotCreatePlateau() {
        Plateau plateau = new Plateau(0, 0);
        String expectedResult = "Values not valid. Please enter the positive numbers.";

        String actual = plateau.getDimensions();

        Assertions.assertEquals(expectedResult, actual);
    }
}