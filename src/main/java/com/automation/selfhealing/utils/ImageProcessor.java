package com.automation.selfhealing.utils;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ImageProcessor {
    static {
        // Load OpenCV native library
        System.load("C:\\opencv\\build\\java\\x64\\opencv_java4100.dll");
    }

    public static Mat cropToElement(File fullPageScreenshot, WebElement element) throws IOException {
        
        // Read the fullsize image into OpenCV Mat format
        Mat image = Imgcodecs.imread(fullPageScreenshot.getAbsolutePath());
        Point location = new Point(element.getLocation().x, element.getLocation().y);
        Size size = new Size(element.getSize().width, element.getSize().height);
        Rect roi = new Rect(location, size);
        return new Mat(image, roi);
    }

    public static String matToBase64(Mat image) {
        MatOfByte mob = new MatOfByte();
        Imgcodecs.imencode(".png", image, mob);
        return Base64.getEncoder().encodeToString(mob.toArray());
    }

    public static Mat loadImage(File screenshot) {
        return Imgcodecs.imread(screenshot.getAbsolutePath());
    }

    public static Mat cropToRegion(Mat fullImage, int x, int y, int width, int height) {
        Rect region = new Rect(x, y, width, height);
        return new Mat(fullImage, region);
    }
}