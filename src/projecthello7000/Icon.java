package projecthello7000;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
public class Icon
{
    //Returns the Project Hello7000 icon as an Image
    public static Image getImage()
    {
        URL url = ProjectHello7000.class.getResource("/images/ProjectHello7000Icon.png");
        Image image = Toolkit.getDefaultToolkit().getImage(url);
        return image;
    }
}