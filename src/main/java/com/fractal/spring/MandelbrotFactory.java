package com.fractal.spring;

public class MandelbrotFactory {

    public static Mandelbrot getMandelbrot(int width, int height, double x, double y, long scale, long i) {
        return new MandelbrotImpl(width, height, x, y, scale, i);
//        return (scale.compareTo(BigDecimal.valueOf(4398046511104l)) > 0)
//                ? new MandelbrotLarge(width, height, x, y, scale, i)
//                : new MandelbrotSmall(width, height, x.doubleValue(), y.doubleValue(), scale.longValue(), i);
    }
}
