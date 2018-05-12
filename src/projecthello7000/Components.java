package projecthello7000;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class Components
{
    public static JButton standardButton(String displayText, ActionListener actionListener)
    {
        JButton button = new JButton(displayText);
        button.setBackground(ProjectHello7000.color2);
        button.setForeground(ProjectHello7000.color1);
        button.setFont(ProjectHello7000.mediumText1);
        button.addActionListener(actionListener);
        return button;
    }
}