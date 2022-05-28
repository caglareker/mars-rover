package com.caglareker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.caglareker.util.MarsRoverCommonUtil.isInteger;

public class CommandLineApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static Plateau plateau;
    private static int roverCount = 2;
    private static MarsRover marsRover;
    private static final List<PlateauPosition> finalPlateauPositions = new ArrayList<>();

    public static void main(String[] args) {
        getPlateauSize();
        getMarsRoverCount();

        for (int roverIndex = 1; roverIndex <= roverCount; roverIndex++) {
            getInitialPosition(roverIndex);
            PlateauPosition finalPosition = getDirectionCommands(roverIndex);
            finalPlateauPositions.add(finalPosition);
        }

        for (PlateauPosition finalPosition : finalPlateauPositions) {
            if (finalPosition.getErrorMessage().length() > 0) {
                System.out.println(finalPosition.getErrorMessage());

            } else {
                System.out.println(finalPosition.getPlateauPosition());
            }
        }
    }

    private static void getPlateauSize() {
        System.out.println("Mars rover application started.");
        System.out.println("Please enter rectangular plateau size. (Example: 5 5)");
        String dimensions = scanner.nextLine();
        plateau = new Plateau(dimensions);
    }

    private static void getMarsRoverCount() {
        System.out.println("Please enter how many mars rover will be discover plateau. (Example: 2)");
        String roverCountInput = scanner.nextLine();
        if (isInteger(roverCountInput)) {
            roverCount = Integer.parseInt(roverCountInput);
        }
    }

    private static void getInitialPosition(int roverIndex) {
        System.out.println("Please enter initial position for mars rover number " + roverIndex + ". (Example: 1 2 N)");
        String initialPosition = scanner.nextLine();
        marsRover = new MarsRover(initialPosition, plateau);
    }

    private static PlateauPosition getDirectionCommands(int roverIndex) {
        System.out.println("Please enter direction commands for mars rover number " + roverIndex + ". (Example: LMLMLMLMM)");
        String instructions = scanner.nextLine();
        return marsRover.parseInstructions(instructions);
    }
}