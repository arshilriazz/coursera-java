package coursera.problemSolving.week4;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class BatchInversions {
    public ImageResource makeInversion(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int inPixelRed = 255 - inPixel.getRed();
            int inPixelGreen = 255 - inPixel.getGreen();
            int inPixelBlue = 255 - inPixel.getBlue();
            pixel.setRed(inPixelRed);
            pixel.setGreen(inPixelGreen);
            pixel.setBlue(inPixelBlue);
        }
        return outImage;
    }

    public void selectAndConvertAndDraw() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource imageResource = new ImageResource(f);
            makeInversion(imageResource).draw();
        }
    }

    public void selectAndConvertAndSave() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource imageResource = new ImageResource(f);
            String fileName = imageResource.getFileName();
            String newName = "gray-" + fileName;
            ImageResource out = makeInversion(imageResource);
            out.setFileName(newName);
            out.save();
        }
    }

    public static void main(String[] args) {
        BatchInversions batchInversions = new BatchInversions();
        batchInversions.selectAndConvertAndDraw();
    }
}
