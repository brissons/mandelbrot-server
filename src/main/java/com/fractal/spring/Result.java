package com.fractal.spring;

class Result {

    private double escapeX;
    private double escapeY;
    private long iterations;

    public Result(double escapeX, double escapeY, long iterations) {
        this.escapeX = escapeX;
        this.escapeY = escapeY;
        this.iterations = iterations;
    }

    public double getEscapeX() {
        return escapeX;
    }

    public void setEscapeX(double escapeX) {
        this.escapeX = escapeX;
    }

    public double getEscapeY() {
        return escapeY;
    }

    public void setEscapeY(double escapeY) {
        this.escapeY = escapeY;
    }

    public long getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
