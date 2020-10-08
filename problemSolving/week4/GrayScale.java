package coursera.problemSolving.week4;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class GrayScale {
    public ImageResource makeGray(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int inPixelAvg = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue()) / 3;
            pixel.setBlue(inPixelAvg);
            pixel.setGreen(inPixelAvg);
            pixel.setRed(inPixelAvg);
        }
        return outImage;
    }

    public void selectAndConvertAndDraw() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource imageResource = new ImageResource(f);
            makeGray(imageResource).draw();
        }
    }

    public void selectAndConvertAndSave() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource imageResource = new ImageResource(f);
            String fileName = imageResource.getFileName();
            String newName = "gray-" + fileName;
            ImageResource out = makeGray(imageResource);
            out.setFileName(newName);
            out.save();
        }
    }

    public static void main(String[] args) {
        GrayScale grayScale = new GrayScale();
        grayScale.selectAndConvertAndSave();
    }
}
