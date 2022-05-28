package com.caglareker;

import static com.caglareker.constants.GlobalConstants.EMPTY;
import static com.caglareker.constants.GlobalConstants.SPACE;

public class PlateauPosition {
    protected int x;
    protected int y;
    protected char compass;
    protected String currentPosition;
    private String errorMessage = EMPTY;

    public PlateauPosition(int x, int y, char compass) {
        this.x = x;
        this.y = y;
        this.compass = compass;
    }

    public String getPlateauPosition() {
        currentPosition = this.x + SPACE + this.y + SPACE + this.compass;
        return currentPosition;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String message) {
        errorMessage = message;
    }

    public boolean isCompassValid() {
        boolean isValid = false;
        char[] cardinal = new char[]{'N', 'E', 'S', 'W'};
        for (char c : cardinal) {
            if (compass == c) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
