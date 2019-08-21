package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    static BufferedImage bfImg0, bfImg1;


    public static void main(String[] args) {
	// write your code here
        /*e.g
        String [][] no1 = new String[][]{{"000000", "0000ff"}, {"00ff00", "ff0000"}};
        String [][] no2 = new String[][]{{"00ff00", "000000"}, {"ff0000", "0000ff"}};*/
        System.out.println(isImageRandomlyScattered("file:///C:/Users/johndoe/Desktop/images/img.jpg", "file:///C:/Users/johndoe/Desktop/images/img1.jpg") == true ? "true" : "false");

    }
    public static boolean isImageRandomlyScattered(String stringUrl0, String stringUrl1){
        int i;

        try{
            URL url0 = new URL(stringUrl0);
            URL url1 = new URL(stringUrl1);
            try{
                bfImg0 = ImageIO.read(url0);
                bfImg1 = ImageIO.read(url1);
            }catch (IOException io){
                System.out.println("IOException: "+io.getLocalizedMessage());
            }
        }catch(MalformedURLException malURL){
            System.out.println("MalformedURLException: "+malURL.getLocalizedMessage());
        }

        i = 0;
        for(int x0 = 0; x0 < bfImg0.getWidth(); x0++){
            for(int y0 = 0; y0 < bfImg0.getHeight(); y0++){
                int currentPixel0 = bfImg0.getRGB(x0, y0);
                for(int x1 = 0; x1 < bfImg1.getWidth(); x1++){
                    for(int y1 = 0; y1 < bfImg1.getHeight(); y1++){
                        int currentPixel1 = bfImg1.getRGB(x1, y1);
                        if(currentPixel0 == currentPixel1){
                            i++;
                            if(i==bfImg0.getWidth()*bfImg0.getHeight()){
                                return true;
                            }
                        }
                    }
                }

            }
        }
        return false;
    }
}
