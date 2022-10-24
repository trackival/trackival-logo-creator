package com.trackival.logo;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            buildTrackivalLogo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void buildTrackivalLogo() throws IOException {
        System.out.println("Building Trackival Logo...");
        final int width = 3024;
        final int height = 1964;
        final int fontSize = 200;
        final String font = "Comfortaa";
        final String text = "trackival.";
        final String fileName = "trackival-logo.png";
        final java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(
                width,
                height,
                java.awt.image.BufferedImage.TYPE_INT_RGB
        );
        final java.awt.Graphics2D graphics = image.createGraphics();
        graphics.setColor(java.awt.Color.BLACK);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(java.awt.Color.WHITE);
        graphics.setFont(new java.awt.Font(font, java.awt.Font.PLAIN, fontSize));
        final java.awt.FontMetrics fontMetrics = graphics.getFontMetrics();
        int x = (width - fontMetrics.stringWidth(text)) / 2;
        int y = (fontMetrics.getAscent() + (height - (fontMetrics.getAscent() + fontMetrics.getDescent())) / 2);
        graphics.drawString(text, x, y);
        graphics.dispose();
        javax.imageio.ImageIO.write(image, "png", new java.io.File(fileName));
        System.out.println("Creation of logo successfull");
    }
}
