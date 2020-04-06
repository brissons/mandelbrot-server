package com.fractal.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Controller
@Validated
@EnableAutoConfiguration
public class FractalController {

    @CrossOrigin
    @RequestMapping(value = "mandelbrot",
            method = RequestMethod.GET,
            produces = "image/jpg")
    @ResponseBody
    public byte[] mandelBrotView(@RequestParam(defaultValue = "1920") @Min(800) @Max(1920) int width,
                                 @RequestParam(defaultValue = "1440") @Min(600) @Max(1440) int height,
                                 @RequestParam(defaultValue = "910") @Min(0) @Max(1920) double x,
                                 @RequestParam(defaultValue = "720") @Min(0) @Max(1440) double y,
                                 @RequestParam(defaultValue = "1") @Min(1) @Max(4398046511104l) long scale,
                                 @RequestParam(defaultValue = "50") @Min(50) @Max(1000) long i) {
        Mandelbrot mandelbrot = MandelbrotFactory.getMandelbrot(width, height, x, y, scale, i);
        return ImageConverter.bufferToImage(mandelbrot.getImage());
    }
}