package com.fractal.spring;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MandelbrotImpl extends Mandelbrot {

    public static final double GRAPH_WIDTH = 3;
    public static final double GRAPH_HEIGHT = 2.25;

    private int imageWidth;
    private int imageHeight;
    private long scale = 1;
    private double translateX = 0;
    private double translateY = 0;

    public MandelbrotImpl(int imageWidth, int imageHeight, double translateX, double translateY, long scale, long maxIterations) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.translateX = (GRAPH_WIDTH / (imageWidth / 2)) * (translateX - (imageWidth / 2));
        this.translateY = (GRAPH_HEIGHT / (imageHeight / 2)) * (translateY - (imageHeight / 2));
        this.scale = scale;
        super.maxIterations = maxIterations;
    }

    public BufferedImage getImage() {
        BufferedImage buffer = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        double incrementX = 5.5 / (imageWidth * scale);
        double incrementY = 4.0 / (imageHeight * scale);
        double beginGraphX = (-GRAPH_WIDTH / scale) + translateX;
        double endGraphX = (GRAPH_WIDTH / scale) + translateX;
        double beginGraphY = (-GRAPH_HEIGHT / scale) + translateY;
        double endGraphY = (GRAPH_HEIGHT / scale) + translateY;

        for (double x = beginGraphX; x < endGraphX; x += incrementX) {
            for (double y = beginGraphY; y < endGraphY; y += incrementY) {
                Result result = calculatePoint(x, y);
                int imageX = (int) ((x - translateX) * (imageWidth / (2 * GRAPH_WIDTH)) * scale) + imageWidth / 2;
                int imageY = (int) ((y - translateY) * (imageHeight / (2 * GRAPH_HEIGHT)) * scale) + imageHeight / 2;
                float hue = calculateHue(result.getIterations(), maxIterations, result.getEscapeX(), result.getEscapeY());
                //float brightness = calculateBrightness(x, y);
                int color = result.getIterations() >= maxIterations ? Color.BLACK.getRGB() : Color.getHSBColor((float) hue, 0.8f, 1).getRGB();
                buffer.setRGB(imageX, imageY, color);
            }
        }

        return buffer;
    }
}
