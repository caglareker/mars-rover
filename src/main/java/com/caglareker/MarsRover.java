package com.caglareker;

import com.caglareker.exception.CoordinateException;

import static com.caglareker.constants.GlobalConstants.SPACE;

public class MarsRover {
    private final PlateauPosition roverPosition;
    private final Plateau plateau;

    public MarsRover(String initialPosition, Plateau plateau) {
        String[] position = initialPosition.split(SPACE);
        this.roverPosition = new PlateauPosition(
                Integer.parseInt(position[0]),
                Integer.parseInt(position[1]),
                position[2].toCharArray()[0]);
        this.plateau = plateau;
    }

    public PlateauPosition parseInstructions(String instructions) {
        char[] arrInstructions = instructions.toUpperCase().toCharArray();
        try {
            if (!roverPosition.isCompassValid()) {
                throw new CoordinateException("Not a valid compass direction.");
            }
            for (char arrInstruction : arrInstructions) {
                if (arrInstruction == 'L') {
                    leftTurn(roverPosition.compass);
                } else if (arrInstruction == 'R') {
                    rightTurn(roverPosition.compass);
                } else if (arrInstruction == 'M') {
                    moveForward(roverPosition.compass);
                }
            }
        } catch (Exception exception) {
            roverPosition.setErrorMessage(exception.getMessage());
        }
        return roverPosition;
    }

    private void moveForward(char compass) {
        switch (compass) {
            case 'N':
                this.roverPosition.y++;
                break;
            case 'E':
                this.roverPosition.x++;
                break;
            case 'S':
                this.roverPosition.y--;
                break;
            case 'W':
                this.roverPosition.x--;
                break;
            default:
        }
    }

    private void leftTurn(char compass) {
        switch (compass) {
            case 'N':
                this.roverPosition.compass = 'W';
                break;
            case 'W':
                this.roverPosition.compass = 'S';
                break;
            case 'S':
                this.roverPosition.compass = 'E';
                break;
            case 'E':
                this.roverPosition.compass = 'N';
                break;
            default:
        }
    }

    private void rightTurn(char compass) {
        switch (compass) {
            case 'N':
                this.roverPosition.compass = 'E';
                break;
            case 'E':
                this.roverPosition.compass = 'S';
                break;
            case 'S':
                this.roverPosition.compass = 'W';
                break;
            case 'W':
                this.roverPosition.compass = 'N';
                break;
            default:
        }
    }
}
