package coursera.problemSolving.week4;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

import java.io.File;

public class ImageSaver {
    public void doSave() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            String fname = image.getFileName();
            String newFileName = "copy-" + fname;
            image.setFileName(newFileName);
            image.draw();
            image.save();
        }
    }

    public static void main(String[] args) {
        ImageSaver imageSaver = new ImageSaver();
        imageSaver.doSave();

    }
}
