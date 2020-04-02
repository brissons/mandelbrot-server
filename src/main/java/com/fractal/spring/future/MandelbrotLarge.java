//
//package com.fractal.spring.large;
//
//import com.fractal.spring.Mandelbrot;
//import com.fractal.spring.large.ResultLarge;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//
//public class MandelbrotLarge extends Mandelbrot {
//
//    public static final BigDecimal GRAPH_WIDTH = BigDecimal.valueOf(3);
//    public static final BigDecimal GRAPH_HEIGHT = BigDecimal.valueOf(2.25);
//    private BigDecimal two = BigDecimal.valueOf(2);
//
//    private BigDecimal imageWidth;
//    private BigDecimal imageHeight;
//    private BigDecimal scale;
//    private BigDecimal translateX;
//    private BigDecimal translateY;
//
//    public MandelbrotLarge(int imageWidth, int imageHeight, BigDecimal translateX, BigDecimal translateY, BigDecimal scale, long maxIterations) {
//        this.imageWidth = new BigDecimal(imageWidth);
//        this.imageHeight = new BigDecimal(imageHeight);
//        this.translateX = (GRAPH_WIDTH.divide(this.imageWidth.divide(two))).multiply(translateX.subtract(this.imageWidth.divide(two)));
//        this.translateY = (GRAPH_HEIGHT.divide(this.imageHeight.divide(two))).multiply(translateY.subtract(this.imageHeight.divide(two)));
//        this.scale = scale;
//        super.maxIterations = maxIterations;
//    }
//
//    public BufferedImage getImage() {
//        BufferedImage buffer = new BufferedImage(imageWidth.intValue(), imageHeight.intValue(), BufferedImage.TYPE_INT_RGB);
//        BigDecimal incrementX = BigDecimal.valueOf(5.5).divide(imageWidth.multiply(scale), 25, RoundingMode.HALF_UP);         //increase increment from loss in cast from graph to image
//        BigDecimal incrementY = BigDecimal.valueOf(4).divide(imageHeight.multiply(scale), 25, RoundingMode.HALF_UP);
//        BigDecimal beginGraphX = GRAPH_WIDTH.negate().divide(scale,25, RoundingMode.HALF_UP).add(translateX);
//        BigDecimal endGraphX = GRAPH_WIDTH.divide(scale,25, RoundingMode.HALF_UP).add(translateX);
//        BigDecimal beginGraphY =  GRAPH_HEIGHT.negate().divide(scale,25, RoundingMode.HALF_UP).add(translateY);
//        BigDecimal endGraphY =  GRAPH_HEIGHT.divide(scale,25, RoundingMode.HALF_UP).add(translateY);
//
//        for (BigDecimal x = beginGraphX; x.compareTo(endGraphX) < 0; x = x.add(incrementX)) {
//            for (BigDecimal y = beginGraphY; y.compareTo(endGraphY) < 0; y = y.add(incrementY)) {
//                ResultLarge result = calculatePoint(x, y);
//                BigDecimal imageX = ((x.subtract(translateX)).multiply(imageWidth.divide(two.multiply(GRAPH_WIDTH),25, RoundingMode.HALF_UP)).multiply(scale)).add(imageWidth.divide(two));
//                BigDecimal imageY = ((y.subtract(translateY)).multiply(imageHeight.divide(two.multiply(GRAPH_HEIGHT),25, RoundingMode.HALF_UP)).multiply(scale)).add(imageHeight.divide(two));
////                float hue = (float)((result.getIterations() + 1 - Math.log(Math.log(Math.sqrt(result.getEscapeX() * result.getEscapeX() + result.getEscapeY() * result.getEscapeY()))) / Math.log(2))/maxIterations);
//                float hue = (float)((result.getIterations() + 1 - Math.log(Math.log(Math.sqrt(result.getEscapeX().doubleValue() * result.getEscapeX().doubleValue() + result.getEscapeY().doubleValue() * result.getEscapeY().doubleValue()))) / Math.log(2))/maxIterations);
//                float brightness = calculateBrightness(x.doubleValue(), y.doubleValue());
//                int color = result.getIterations() >= maxIterations ? Color.BLACK.getRGB() : Color.HSBtoRGB(hue, 1f, brightness);
//                buffer.setRGB(imageX.intValue(), imageY.intValue(), color);
//            }
//        }
//
//        return buffer;
//    }
//}