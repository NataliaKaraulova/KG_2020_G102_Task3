package ru.vsu.cs.kg2020.g102.karaulova_n_a;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BuffereImagePixelDrawer implements PixelDrawer {
    private BufferedImage bi;

    public BuffereImagePixelDrawer(BufferedImage bi) {
        this.bi = bi;
    }

    @Override
    public void drawPixel(int x, int y, Color c) {
        if (x >= 0 && y >= 0 && x < bi.getWidth() && y < bi.getHeight())
            bi.setRGB(x, y, c.getRGB());
    }
}
