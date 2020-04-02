package com.fractal.spring;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageConverter {

    public static byte[] bufferToImage(BufferedImage image) {
        ImageIO.setUseCache(false);
        byte[] imageByte = null;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "jpg", baos);
            imageByte = baos.toByteArray();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return imageByte;
    }
}
