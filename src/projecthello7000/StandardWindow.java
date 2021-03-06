package projecthello7000;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
public class StandardWindow
{
    protected JFrame frame;
    
    public StandardWindow(String title)
    {
        frame = new JFrame(title);
        frame.setIconImage(Icon.getImage());
    }
    
    public void makeVisible()
    {
        frame.setVisible(true);
    }
    
    public void setJMenuBar(JMenuBar menuBar)
    {
        frame.setJMenuBar(menuBar);
    }
    
    public void setInstructionsMenuBar(String instructions)
    {
        frame.setJMenuBar(instructionsMenuBar(instructions));
    }
    
    public void setLayout(GridLayout g)
    {
        frame.setLayout(g);
    }
    
    public void setSize(int a, int b)
    {
        frame.setSize(a, b);
    }
    
    private JMenuBar instructionsMenuBar(String instructions)
    {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(ProjectHello7000.mainColor);
        menuBar.add(instructionsLabel(instructions));
        return menuBar;
    }
    
    private JLabel instructionsLabel(String instructions)
    {
        JLabel instructionsLabel = new JLabel(instructions);
        instructionsLabel.setForeground(ProjectHello7000.secondaryColor);
        instructionsLabel.setFont(ProjectHello7000.mediumText1);
        return instructionsLabel;
    }
}