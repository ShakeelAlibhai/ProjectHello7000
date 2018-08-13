package projecthello7000;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class Components
{
    public static JButton standardButton(String displayText, ActionListener actionListener)
    {
        JButton button = new JButton(displayText);
        button.setBackground(ProjectHello7000.secondaryColor);
        button.setForeground(ProjectHello7000.mainColor);
        button.setFont(ProjectHello7000.mediumText1);
        button.addActionListener(actionListener);
        return button;
    }
}