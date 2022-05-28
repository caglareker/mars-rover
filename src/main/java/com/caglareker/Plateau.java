package com.caglareker;

import lombok.Getter;

import static com.caglareker.constants.GlobalConstants.PLATEAU_INPUT_SPLITTER;

@Getter
public class Plateau {

    private final int xDimension;
    private final int yDimension;

    public Plateau(int xDimension, int yDimension) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
    }

    public Plateau(String dimensions) {
        String[] points = dimensions.split(PLATEAU_INPUT_SPLITTER);
        this.xDimension = Integer.parseInt(points[0]);
        this.yDimension = Integer.parseInt(points[1]);
    }

    public String getDimensions() {
        if (xDimension > 0 && yDimension > 0) {
            return String.format("The plateau dimensions are %d %d.", xDimension, yDimension);
        } else
            return "Values not valid. Please enter the positive numbers.";
    }
}
