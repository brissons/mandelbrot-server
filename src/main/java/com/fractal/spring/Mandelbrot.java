package com.fractal.spring;

import java.awt.image.BufferedImage;

public abstract class Mandelbrot {

    protected long maxIterations;

    public abstract BufferedImage getImage();

    public Result calculatePoint(double x, double y) {
        double xN = x;
        double yN = y;
        double xN1 = 1;
        double yN1 = 1;
        boolean escape = false;
        long i;

        for (i = 0; i <= this.maxIterations && !escape; i++) {
            xN1 = xN * xN - yN * yN + x;
            yN1 = 2 * xN * yN + y;
            xN = xN1;
            yN = yN1;
            escape = xN1 * xN1 + yN1 * yN1 >= 4;
        }

        return escape ? new Result(xN1, yN1, i) : new Result(0, 0, i);
    }

    public float calculateHue(long i, long max, double x, double y) {
        return (float) (i + 1 - Math.log(Math.log(Math.sqrt(x * x + y * y))) / Math.log(2)) / max;
    }

    public float calculateBrightness(double x, double y) {
        return (float) (Math.log(7 - Math.sqrt((x * x + y * y))) / 2);
    }
}
