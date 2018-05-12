package projecthello7000;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class About
{
    public About()
    {
        about();
    }
    
    private void about()
    {
        JFrame frame = new JFrame("About");
        frame.setSize(750 * ProjectHello7000.multiplier, 400 * ProjectHello7000.multiplier);
        frame.setIconImage(Icon.getImage());
        frame.setLayout(new GridLayout(2, 1));
        frame.getContentPane().setBackground(ProjectHello7000.color1);
        frame.getContentPane().add(titleLabel());
        frame.getContentPane().add(versionLabel());
        frame.setVisible(true);
    }
    
    private JLabel titleLabel()
    {
        JLabel titleLabel = new JLabel(ProjectHello7000.NAME, SwingConstants.CENTER);
        titleLabel.setFont(ProjectHello7000.largeHeader);
        titleLabel.setForeground(ProjectHello7000.color2);
        return titleLabel;
    }
    
    private JLabel versionLabel()
    {
        JLabel versionLabel = new JLabel(ProjectHello7000.VERSION, SwingConstants.CENTER);
        versionLabel.setFont(ProjectHello7000.mediumText1);
        versionLabel.setForeground(ProjectHello7000.color2);
        return versionLabel;
    }
}