package pl.kazmierski.orcsystem2;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

@Service
public class OcrService {

    public String doOCR(String url) {
        try {
        URL imageFile = new URL(url);
        BufferedImage bufferedImage = ImageIO.read(imageFile);
        /**
         * JNA Interface Mapping
         **/
        ITesseract instance = new Tesseract();

        /**
         * You either set your own tessdata folder with your custom language pack or
         * use LoadLibs to load the default tessdata folder for you.
         **/
        instance.setDatapath("tessdata");
        instance.setLanguage("pol");

        return instance.doOCR(bufferedImage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "";
    }
}