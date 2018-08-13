package projecthello7000;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Start
{
    public static JFrame frame;
    public static JTextField usernameTextField;
    
    public Start()
    {
        start();
    }
    
    private void start()
    {
        setFonts();
        if(!ProjectHello7000.FOLDER.exists())
        {
            ProjectHello7000.FOLDER.mkdir();
        }
        /*
         * Attempt to import the "username.txt" file from the Project Hello7000 folder.
         * If the "oldVersion.txt" file is not found, then display a welcome message and ask the user to enter a username.
         */
        File usernameTemp = new File(ProjectHello7000.FOLDER, "username.txt");
        try
        {
            Scanner s11 = new Scanner(usernameTemp).useDelimiter("\\Z");
            ProjectHello7000.username = s11.next();
            s11.close();
            double r = Math.random();
            int randomResponse = (int)(r * 2);
            if(randomResponse == 0)
            {
                new Window("Hello, how are you?");
                ProjectHello7000.howAreYouDisplayed = true;
            }
            else
            {
                new Window("Hi, " + ProjectHello7000.username + "!");
                ProjectHello7000.howAreYouDisplayed = false;
            }
        }
        catch(FileNotFoundException e)
        {
            frame = new JFrame("Project Hello7000");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(750 * ProjectHello7000.multiplier, 425 * ProjectHello7000.multiplier);
            frame.getContentPane().setBackground(ProjectHello7000.mainColor);
            frame.setLayout(new GridLayout(5, 1));
            frame.setIconImage(Icon.getImage());
            JLabel welcomeLabel = new JLabel("Welcome to Project Hello7000!", SwingConstants.CENTER);
            welcomeLabel.setForeground(ProjectHello7000.secondaryColor);
            welcomeLabel.setFont(ProjectHello7000.largeHeader);
            frame.add(welcomeLabel);
            JLabel descriptionLabel = new JLabel("A personal assistant with a chat-based interface", SwingConstants.CENTER);
            descriptionLabel.setForeground(ProjectHello7000.secondaryColor);
            descriptionLabel.setFont(ProjectHello7000.mediumHeader);
            frame.add(descriptionLabel);
            JLabel instructionsLabel = new JLabel("To get started, please enter your username, and then click Continue or press Enter.");
            instructionsLabel.setForeground(ProjectHello7000.secondaryColor);
            instructionsLabel.setFont(ProjectHello7000.mediumText1);
            frame.add(instructionsLabel);
            JPanel usernamePanel = new JPanel();
            usernamePanel.setBackground(ProjectHello7000.mainColor);
            usernamePanel.setLayout(new GridLayout(1, 2));
            JLabel usernameLabel = new JLabel("Username:");
            usernameLabel.setForeground(ProjectHello7000.secondaryColor);
            usernameLabel.setFont(ProjectHello7000.bodyText1);
            usernamePanel.add(usernameLabel);
            usernameTextField = new JTextField("");
            usernameTextField.setFont(ProjectHello7000.bodyText1);
            usernameTextField.setForeground(ProjectHello7000.mainColor);
            usernameTextField.addActionListener(new SubmitUsernameListener());
            usernamePanel.add(usernameTextField);
            frame.add(usernamePanel);
            frame.add(Components.standardButton("Continue", new SubmitUsernameListener()));
            frame.setVisible(true);
        }
    }
    
    private void setFonts()
    {
        ProjectHello7000.largeHeader = new java.awt.Font("Open Sans Extrabold", Font.PLAIN, ProjectHello7000.LARGE_HEADER_SIZE * ProjectHello7000.multiplier);
        ProjectHello7000.mediumHeader = new java.awt.Font("Open Sans Extrabold", Font.PLAIN, ProjectHello7000.MEDIUM_HEADER_SIZE * ProjectHello7000.multiplier);
        ProjectHello7000.mediumText1 = new java.awt.Font("Open Sans Bold", Font.PLAIN, ProjectHello7000.MEDIUM_TEXT_SIZE1 * ProjectHello7000.multiplier);
        ProjectHello7000.mediumText2 = new java.awt.Font("Open Sans Semibold", Font.PLAIN, ProjectHello7000.MEDIUM_TEXT_SIZE2 * ProjectHello7000.multiplier);
        ProjectHello7000.mediumText3 = new java.awt.Font("Open Sans Bold", Font.PLAIN, ProjectHello7000.MEDIUM_TEXT_SIZE3 * ProjectHello7000.multiplier);
        ProjectHello7000.bodyText1 = new java.awt.Font("Open Sans Semibold", Font.PLAIN, ProjectHello7000.BODY_TEXT_SIZE1 * ProjectHello7000.multiplier);
        ProjectHello7000.bodyText2 = new java.awt.Font("Open Sans", Font.PLAIN, ProjectHello7000.BODY_TEXT_SIZE2 * ProjectHello7000.multiplier);
    }
    
    public class SubmitUsernameListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            ProjectHello7000.username = usernameTextField.getText();
            if("".equals(ProjectHello7000.username))
            {
                JOptionPane.showMessageDialog(null, "No Username Entered", "Setup", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                PrintWriter out;
                try
                {
                    File file = new File(ProjectHello7000.FOLDER, "username.txt");
                    out = new PrintWriter(file);
                    out.println(ProjectHello7000.username);
                    out.close();
                }
                catch(FileNotFoundException e2)
                {

                }
                new Window("Hi, " + ProjectHello7000.username + "! I'm Project Hello7000, a personal assistant!");
                ProjectHello7000.howAreYouDisplayed = false;
                frame.dispose();
            }
        }
    }
}