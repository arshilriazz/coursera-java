package coursera.course1.week4;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class Picture {
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

    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource imageResource = new ImageResource(f);
            makeGray(imageResource).draw();
        }
    }

    public static void main(String[] args) {
        Picture picture = new Picture();
//        ImageResource imageResource = new ImageResource();
//        ImageResource output = picture.makeGray(imageResource);
//        output.draw();
        picture.selectAndConvert();
    }
}
