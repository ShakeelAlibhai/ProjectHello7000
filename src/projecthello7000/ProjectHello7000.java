package projecthello7000;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
public class ProjectHello7000
{
    public static final String NAME = "Project Hello 1.0";
    public static final String VERSION = "Version 1.0";
    public static final File FOLDER = new File(System.getProperty("user.home"), "Project Hello7000");
    
    public static String username;
    
    public static boolean homework = false;
    public static boolean homework2 = false;
    public static boolean howAreYouDisplayed = false;
    public static boolean howAreYouTyped = false;
    public static boolean likeIceCream = false;
    public static boolean iceCreamFlavor = false;
    public static boolean likeCookies = false;
    public static boolean typeOfCookies = false;
    
    //Fonts
    public static Font largeHeader;
    public static Font mediumHeader;
    public static Font mediumText1;
    public static Font mediumText2;
    public static Font mediumText3;
    public static Font bodyText1;
    public static Font bodyText2;
    
    //Font Sizes
    public static final int LARGE_HEADER_SIZE = 22;
    public static final int MEDIUM_HEADER_SIZE = 20;
    public static final int MEDIUM_TEXT_SIZE1 = 16;
    public static final int MEDIUM_TEXT_SIZE2 = 16;
    public static final int MEDIUM_TEXT_SIZE3 = 12;
    public static final int BODY_TEXT_SIZE1 = 14;
    public static final int BODY_TEXT_SIZE2 = 14;
    
    public static int multiplier;
    public static int width;
    public static int height;
    
    public static Color color1;
    public static Color color2;
    
    public static void main(String[] args)
    {
        widthAndHeight();
        color1 = Color.blue;
        color2 = Color.yellow;
        new Start();
    }
    
    private static void widthAndHeight()
    {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenResolution = t.getScreenSize();
        width = screenResolution.width;
        height = screenResolution.height;
        if(width >= 3840 && height >= 2160)
        {
            multiplier = 3;
        }
        else if(width > 1920 && height > 1080)
        {
            multiplier = 2;
        }
        else
        {
            multiplier = 1;
        }
    }
}