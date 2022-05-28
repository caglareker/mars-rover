package com.caglareker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarsRoverTest {
    private Plateau plateau;

    @BeforeEach
    public void setUpPlateau() {
        plateau = new Plateau(5, 5);
    }

    @Test
    void checkRoverCanMoveOneGridIfFacingNorth() {
        MarsRover marsRover = new MarsRover("1 2 N", plateau);
        String expectedResult = "1 3 N";

        PlateauPosition actual = marsRover.parseInstructions("M");

        Assertions.assertEquals(expectedResult, actual.getPlateauPosition());
    }

    @Test
    void checkRoverCanTurnFromNorthToEast() {
        MarsRover marsRover = new MarsRover("1 2 N", plateau);
        char expectedResult = 'E';

        PlateauPosition actual = marsRover.parseInstructions("R");

        Assertions.assertEquals(expectedResult, actual.compass);

    }

    @Test
    void checkRoverCanTurnFromNorthToWest() {
        MarsRover marsRover = new MarsRover("1 2 N", plateau);
        char expectedResult = 'W';

        PlateauPosition actual = marsRover.parseInstructions("L");

        Assertions.assertEquals(expectedResult, actual.compass);
    }

    @Test
    void checkRoverCanTurnRightThenMoveOneSquare() {
        MarsRover marsRover = new MarsRover("1 2 N", plateau);
        String expectedResult = "2 2 E";

        PlateauPosition actual = marsRover.parseInstructions("RM");

        Assertions.assertEquals(expectedResult, actual.getPlateauPosition());
    }

    @Test
    void checkRoverCanMoveLMLMLMLMM() {
        MarsRover marsRover = new MarsRover("1 2 N", plateau);
        String expectedResult = "1 3 N";

        PlateauPosition actual = marsRover.parseInstructions("LMLMLMLMM");

        Assertions.assertEquals(expectedResult, actual.getPlateauPosition());
    }

    @Test
    void checkMarsRoverCanMoveMMRMMRMRRM() {
        MarsRover marsRover = new MarsRover("3 3 E", plateau);
        String expectedResult = "5 1 E";

        PlateauPosition actual = marsRover.parseInstructions("MMRMMRMRRM");

        Assertions.assertEquals(expectedResult, actual.getPlateauPosition());
    }
}