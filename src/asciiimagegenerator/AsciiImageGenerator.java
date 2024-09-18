// Code modified from: https://www.tutorialspoint.com/java_dip/grayscale_conversion.htm

package asciiimagegenerator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AsciiImageGenerator
{
    // Change this file name if you would like.  Other file names:
    //   * ducks.jpg
    //   * items.jpg
    // You can also put your own file in the NetBeansProjects / AsciiImageGenerator folder.
    public final static String FILE_NAME = "dog.jpg";
    //public final static String FILE_NAME = "ducks.jpg";
    //public final static String FILE_NAME = "items.jpg";

    public static void outputAscii(int grayScaleValue)
    {
        // Use the grayScaleValue variable to determine what character you would
        // like to output.  You need to output at least three different characters.
        // The grayScaleValue variable will contain a value between 0 and 255. 
        // 0 corresponds to black and 255 corresponds to white.
        // System.out.printf("%3d ", grayScaleValue);   // this line will print out the actual gray value
        
        if (grayScaleValue > 50)
        {
            System.out.print("M");
        }
        else
        {
            System.out.print(" ");
        }
    }
    
    /*******************************************************************
     *  Do not modify any code below this line.
     *******************************************************************/
    public static void main(String[] args) throws IOException
    {
        // Read in the image file.
        BufferedImage image = ImageIO.read(new File(FILE_NAME));
        
        // Obtain the width and height.
        int width = image.getWidth();
        int height = image.getHeight();
        
        // Variables used to convert color to grayscale.
        Color color;
        //Color newColor;
        int red;
        int green;
        int blue;
        int grayScaleValue;

        // Iterate through each pixel in each row and column.
        for(int heightCounter = 0; heightCounter < height; heightCounter++) {
            for(int widthCounter = 0; widthCounter < width; widthCounter++) {
                // Get the color if this pixel.
                color = new Color(image.getRGB(widthCounter, heightCounter));

                // Get the red, green, and blue color values and convert them to grayscale values.
                red = (int) (color.getRed() * 0.299);
                green = (int) (color.getGreen() * 0.587);
                blue = (int) (color.getBlue() * 0.114);
                
                // Assemble the grayscale value.
                grayScaleValue = red + green + blue;

                // Print out an appropriate ASCII character for this grayscale value.
                outputAscii(grayScaleValue);
            }
            
            System.out.println();
        }
    }
}
