package projecthello7000;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Window
{
    public static ArrayList<String> messages = new ArrayList<String>();
    public static JFrame frame;
    public static JTextField inputField;
    public static String temp;
    
    public Window(String message)
    {
        talk(message);
    }
    
    private void talk(String message)
    {
        inputField = new JTextField("");
        inputField.setFont(ProjectHello7000.bodyText2);
        inputField.setForeground(ProjectHello7000.mainColor);
        setupFrame();
        if(messages.isEmpty())
        {
            for(int i = 0; i < 9; i++)
            {
                messages.add("");
            }
        }
        if(messages.size() > 9)
        {
            int temp = messages.size() - 9;
            for(int i = 0; i < temp; i++)
            {
                messages.remove(i);
            }
        }
        messages.add(message);
        frame.setLayout(new GridLayout(11, 1));
        frame.setResizable(true);
        JLabel[] messagesLabels = new JLabel[messages.size()];
        for(int i = 0; i < messages.size(); i++)
        {
            messagesLabels[i] = new JLabel(messages.get(i));
            messagesLabels[i].setFont(ProjectHello7000.bodyText2);
            messagesLabels[i].setOpaque(true);
            //Set every other message to have a theme-related color
            if(i % 2 == 0)
            {
                messagesLabels[i].setBackground(Color.white);
                messagesLabels[i].setForeground(ProjectHello7000.mainColor);
            }
        }
        //Add the messages from the array list to the talk frame
        for(int i = 0; i < messages.size(); i++)
        {
            frame.add(messagesLabels[i]);
        }
        frame.setIconImage(Icon.getImage());
        inputField.setText("");
        inputField.addActionListener(new TalkInputListener());
        frame.add(inputField);
        //Set the focus of the JFrame to be on the JTextField when the JFrame opens
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowOpened(WindowEvent e)
            {
                inputField.requestFocus();
            }
        });
        frame.setVisible(true);
    }
    
    private void setupFrame()
    {
        frame = new JFrame("Project Hello7000");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750 * ProjectHello7000.multiplier, 425 * ProjectHello7000.multiplier);
        frame.setJMenuBar(menuBar());
        frame.setVisible(true);
    }
    
    private JMenuBar menuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(ProjectHello7000.mainColor);
        menuBar.add(Components.standardButton("About", new AboutListener()));
        menuBar.add(Components.standardButton("Disclaimer", new DisclaimerListener()));
        menuBar.add(Components.standardButton("Clear Chat History", new ClearChatHistoryListener()));
        menuBar.add(Components.standardButton("Tips", new TipsListener()));
        return menuBar;
    }
    
    private void processInput(String input)
    {
        input = input.toLowerCase();    //Convert the user's input to lower case
        if("".equals(input))
        {
            temp = "Why don't you say something?";
        }
        else if((input.indexOf("hello") >= 0 ||
                input.indexOf("hi, talk") >= 0) &&
                input.indexOf("how are you") <= 0)
        {
            if(!ProjectHello7000.howAreYouDisplayed)
            {
                temp = "How are you?";
            }
            else
            {
                double r = Math.random();
                int randomResponse = (int)(r * 2);
                if(randomResponse == 0)
                {
                    temp = "What's up?";
                }
                else
                {
                    temp = "How's it going?";
                }
            }
        }
        else if(input.indexOf("hola") >= 0 ||
                input.indexOf("spanish") >= 0)
        {
            temp = "¡Hola! (That's about all the Spanish I know.)";
        }
        else if(input.indexOf("bonjour") >= 0 ||
                input.indexOf("french") >= 0)
        {
            temp = "Bonjour! (That's about all the French I know.)";
        }
        else if(input.indexOf("salam") >= 0 ||
                input.indexOf("salaam") >= 0)
        {
            temp = "W/Salaam!";
        }
        else if(input.indexOf("bye") >= 0 &&
                input.indexOf("said") <= 0)
        {
            System.exit(0);
        }
        else if("no".equals(input) ||
                "nope".equals(input) ||
                "no thanks".equals(input) ||
                "no, that's all".equals(input) ||
                "nope, that's all".equals(input))
        {
            temp = "Oh, okay.";
        }
        else if(input.indexOf("story") >= 0)
        {
            Story s = new Story(0);
            String output = s.getStory();
            JOptionPane.showMessageDialog(null, output, "Story", JOptionPane.INFORMATION_MESSAGE);
            temp = "Anything else?";
        }
        else if(input.indexOf("weather") >= 0)
        {
            temp = "Hmm . . . I'm not sure what the weather will be like.";
        }
        else if(input.indexOf("what are you doing") >= 0 ||
                input.indexOf("what r u doing") >= 0 ||
                input.indexOf("what're you doing") >= 0 ||
                input.indexOf("what're u doing") >= 0 ||
                input.indexOf("what you doing") >= 0 ||
                input.indexOf("what u doing") >= 0)
        {
            temp = "I'm talking to you! (I think...)";
        }
        else if(input.indexOf("what can you do") >= 0)
        {
            temp = "I can try to have a conversation with you, and maybe even help you with basic productivity tasks!";
        }
        else if(input.indexOf("+") >= 0)
        {
            temp = addition(input);
        }
        else if(input.indexOf("-") >= 0)
        {
            temp = subtraction(input);
        }
        else if(input.indexOf("capital") >= 0)
        {
            temp = capitals(input);
        }
        else if((input.indexOf("date") >= 0 ||
                input.indexOf("time") >= 0) &&
                input.indexOf("tomorrow") <= 0)
        {
            Date today = new Date();
            temp = "The date and time is: " + today;
        }
        else if(input.indexOf("my") >= 0 &&
                input.indexOf("name") >= 0)
        {
            temp = "I call you " + ProjectHello7000.username + ".";
        }
        else if(input.indexOf("good") >= 0 &&
                input.indexOf("your") >= 0 &&
                input.indexOf("name") >= 0)
        {
            temp = "You can just call me Project Hello7000.";
        }
        else if(input.indexOf("good") >= 0 &&
                input.indexOf("you") >= 0)
        {
            temp = "I'm fine, thanks for asking.";
        }
        else if(input.indexOf("where are you") >= 0 ||
                input.indexOf("where r u") >= 0 ||
                input.indexOf("where you at") >= 0 ||
                input.indexOf("where u at") >= 0)
        {
            temp = "I'm in your computer!";
        }
        else if(input.indexOf("question") >= 0 &&
                input.indexOf("?") <= 0 &&
                input.indexOf(":") <= 0)
        {
            temp = "What is your question?";
        }
        else if((input.indexOf("book") >= 0 ||
                input.indexOf("read") >= 0) &&
                input.indexOf("like") >= 0)
        {
            temp = "What are some of your favorite books?";
        }
        else if(input.indexOf("homework") >= 0)
        {
            if(!ProjectHello7000.homework)
            {
                temp = "What do you have to do for your homework?";
                ProjectHello7000.homework = true;
            }
            else if(!ProjectHello7000.homework2)
            {
                temp = "What else do you have to do for your homework?";
                if(input.indexOf("no") >= 0 ||
                        input.indexOf("finished ") >= 0 ||
                        input.indexOf("done") >= 0 ||
                        input.indexOf("don't") >= 0)
                {
                    ProjectHello7000.homework2 = true;
                }
            }
            else
            {
                temp = "Oh, you're doing homework?";
            }
        }
        else if((input.indexOf("book") >= 0 ||
                input.indexOf("read") >= 0) &&
                (input.indexOf("favorite") >= 0 ||
                input.indexOf("favourite") >= 0))
        {
            temp = "Do you like to read?";
        }
        else if((input.indexOf("book") >= 0 ||
                input.indexOf("read") >= 0) &&
                input.indexOf("?") <= 0)
        {
            double r = Math.random();
            int randomResponse = (int)(r * 2);
            if(randomResponse == 0)
            {
                temp = "Do you like to read?";
            }
            else
            {
                temp = "What are some of your favorite books?";
            }
        }
        else if((input.indexOf("your") >= 0 &&
                input.indexOf("name") >= 0) ||
                (input.indexOf("what") >= 0 &&
                input.indexOf("call") >= 0 &&
                input.indexOf("you") >= 0))
        {
            temp = "You can call me Project Hello7000.";
        }
        else if(input.indexOf("how are you") >= 0)
        {
            double r = Math.random();
            int randomResponse = (int)(r * 2);
            if(randomResponse == 1)
            {
                temp = "I'm fine, thanks for asking.";
                ProjectHello7000.howAreYouTyped = true;
            }
            else
            {
                temp = "I'm doing well, thanks for asking.";
                ProjectHello7000.howAreYouTyped = true;
            }
        }
        else if(input.indexOf("russia") >= 0)
        {
            temp = "Russia is a country in Europe and Asia.";
        }
        else if(input.indexOf("america") >= 0 ||
                input.indexOf("united states") >= 0 ||
                input.indexOf("u.s.") >= 0)
        {
            double r = Math.random();
            int randomResponse = (int)(r * 2);
            if(randomResponse == 0)
            {
                temp = "The United States of America is a country in North America.";
            }
            else
            {
                temp = "As of 2017, there are 50 states in the United States of America.";
            }
        }
        else if("hi".equals(input) ||
                "hi!".equals(input) ||
                "hello".equals(input) ||
                "hello!".equals(input))
        {
            double r3 = Math.random();
            int randomResponse3 = (int)(r3 * 3);
            if(randomResponse3 == 0)
            {
                temp = "So, what's new?";
            }
            else if(randomResponse3 == 1)
            {
                temp = "Did anything interesting happen today?";
            }
            else
            {
                temp = "What's up, " + ProjectHello7000.username + "?";
            }
        }
        else if(input.indexOf("where") >= 0 &&
                input.indexOf("live") >= 0 &&
                input.indexOf("you") >= 0)
        {
            temp = "Why do you want to know where I live?";
        }
        else if(input.indexOf("where") >= 0 &&
                input.indexOf("do") > 0 &&
                input.indexOf("live") >= 0 &&
                input.indexOf("I") >= 0)
        {
            temp = "That's a good question.";
        }
        else if(input.indexOf("you") >= 0 &&
                input.indexOf("bathroom") >= 0)
        {
            temp = "I'm a computer program; I don't have to use the bathroom!";
        }
        else if(input.indexOf("you") >= 0 &&
                input.indexOf("restroom") >= 0)
        {
            temp = "I'm a computer program; I don't have to use the restroom!";
        }
        else if(input.indexOf("you") >= 0 &&
                input.indexOf("washroom") >= 0)
        {
            temp = "I'm a computer program; I don't have to use the washroom!";
        }
        else if(input.indexOf("good") >= 0 &&
                ProjectHello7000.howAreYouTyped == false)
        {
            temp = "You're good? That's nice.";
            ProjectHello7000.howAreYouTyped = true;
        }
        else if(input.indexOf("fine") >= 0 &&
                ProjectHello7000.howAreYouTyped == false)
        {
            temp = "You're fine? That's good.";
            ProjectHello7000.howAreYouTyped = true;
        }
        else if((input.indexOf("i am") >= 0 ||
                input.indexOf("i'm") >= 0) &&
                (input.indexOf("sick") >= 0 ||
                input.indexOf("not feeling well") >= 0) &&
                input.indexOf("but") <= 0)
        {
            temp = "I hope you feel better soon!";
        }
        else if((input.indexOf("uh-oh") >= 0 ||
                input.indexOf("uh oh") >= 0) &&
                input.indexOf(",") <= 0)
        {
            temp = "What's wrong?";
        }
        else if(input.indexOf("thanks") >= 0 ||
                input.indexOf("thank you") >= 0)
        {
            double r3 = Math.random();
            int randomResponse3 = (int)(r3 * 2);
            if(randomResponse3 == 0)
            {
                temp = "You're welcome.";
            }
            else
            {
                temp = "No problem!";
            }
        }
        else if(input.indexOf("lonely") >= 0 ||
                input.indexOf("need someone to talk to") >= 0 ||
                input.indexOf("depressed") >= 0)
        {
            temp = "I'm here for you!";
        }
        else if(input.indexOf("suicide") >= 0 &&
                input.indexOf("committed") <= 0)
        {
            temp = "Never commit suicide. If you need professional help, call 1-800-273-8255 (the Suicide Prevention Lifeline).";
        }
        else if(input.indexOf("kill myself") >= 0)
        {
            temp = "Never kill yourself. If you need professional help, call 1-800-273-8255 (the Suicide Prevention Lifeline).";
        }
        else if(input.indexOf("what's up") >= 0 ||
                input.indexOf("whats up") >= 0)
        {
            temp = "The sky? ;)";
        }
        else if(input.indexOf("wutz up") >= 0 ||
                input.indexOf("watz up") >= 0 ||
                input.indexOf("wuts up") >= 0 ||
                input.indexOf("wats up") >= 0)
        {
            temp = "Well, I suppose the sky is \"up\" ;)";
        }
        else if(input.indexOf("color") >= 0 &&
                input.indexOf("you") >= 0 &&
                input.indexOf("favorite") >= 0)
        {
            temp = "I like the colors green and blue.";
        }
        else if(input.indexOf("color") >= 0 &&
                input.indexOf("my") >= 0 &&
                input.indexOf("least") >= 0)
        {
            temp = "I like the colors green and blue.";
        }
        else if(input.indexOf("colors") >= 0 &&
                input.indexOf("my") >= 0)
        {
            temp = "Those are nice colors.";
        }
        else if(input.indexOf("color") >= 0 &&
                input.indexOf("my") >= 0)
        {
            temp = "That's a nice color.";
        }
        else if(input.indexOf("color") >= 0)
        {
            temp = "My favorite colors are probably green and blue. But my theme colors are blue and yellow!";
        }
        else if(input.indexOf("orange") >= 0)
        {
            temp = "By orange, do you mean the color or the fruit?";
        }
        else if(input.indexOf("ice cream") >= 0 &&
                input.indexOf("like") >= 0 &&
                input.indexOf("you") <= 0 &&
                input.indexOf("?") <= 0 &&
                input.indexOf("flavor") <= 0 &&
                input.indexOf("no") <= 0 &&
                ProjectHello7000.iceCreamFlavor == false)
        {
            temp = "What's your favorite flavor of ice cream?";
            ProjectHello7000.iceCreamFlavor = true;
            ProjectHello7000.likeIceCream = true;
        }
        else if(input.indexOf("ice cream") >= 0 &&
                input.indexOf("like") <= 0 &&
                input.indexOf("you") <= 0 &&
                input.indexOf("?") <= 0 &&
                input.indexOf("flavor") >= 0 &&
                input.indexOf("no") <= 0 &&
                ProjectHello7000.likeIceCream == false)
        {
            temp = "I like ice cream also.";
            ProjectHello7000.iceCreamFlavor = true;
            ProjectHello7000.likeIceCream = true;
        }
        else if(input.indexOf("ice cream") >= 0 &&
                input.indexOf("you") >= 0 &&
                input.indexOf("?") >= 0)
        {
            temp = "I like ice cream.";
        }
        else if(input.indexOf("cookies") >= 0 &&
                input.indexOf("like") >= 0 &&
                input.indexOf("you") <= 0 &&
                input.indexOf("?") <= 0 &&
                input.indexOf("type") <= 0 &&
                input.indexOf("no") <= 0 &&
                ProjectHello7000.typeOfCookies == false)
        {
            temp = "What's your favorite type of cookies?";
            ProjectHello7000.typeOfCookies = true;
            ProjectHello7000.likeCookies = true;
        }
        else if(input.indexOf("cookies") >= 0 &&
                input.indexOf("like") <= 0 &&
                input.indexOf("you") <= 0 &&
                input.indexOf("?") <= 0 &&
                input.indexOf("type") >= 0 &&
                input.indexOf("no") <= 0 &&
                ProjectHello7000.likeCookies == false)
        {
            temp = "I like cookies also.";
            ProjectHello7000.typeOfCookies = true;
            ProjectHello7000.likeCookies = true;
        }
        else if(input.indexOf("cookies") >= 0 &&
                input.indexOf("you") >= 0 &&
                input.indexOf("?") >= 0)
        {
            temp = "I like cookies.";
        }
        else if(input.indexOf("sport") >= 0 &&
                input.indexOf("you") >= 0)
        {
            temp = "I don't play any sports. How can I? I'm a computer!";
        }
        else if(input.indexOf("sport") >= 0 &&
                input.indexOf("team") >= 0)
        {
            temp = "Sorry, I normally don't keep track of sports teams.";
        }
        else if(input.indexOf("sport") >= 0)
        {
            temp = "Do you like to play sports?";
        }
        else if(input.indexOf("question") >= 0 &&
                input.indexOf("you have") <= 0 &&
                input.indexOf("have") >= 0)
        {
            temp = "What is your question?";
        }
        else if(input.indexOf("is mean") >= 0 ||
                input.indexOf("are mean") >= 0 ||
                input.indexOf("is bad") >= 0 ||
                input.indexOf("are bad") >= 0)
        {
            double r = Math.random();
            int randomResponse = (int)(r * 3);
            if(randomResponse == 0)
            {
                temp = "Why?";
            }
            else if(randomResponse == 1)
            {
                temp = "Why do you say that?";
            }
            else
            {
                temp = "What makes you say that?";
            }
        }
        else if(input.indexOf("you suck") >= 0)
        {
            double r = Math.random();
            int randomResponse = (int)(r * 3);
            if(randomResponse == 0)
            {
                temp = "Hey! That's mean!";
            }
            else if(randomResponse == 1)
            {
                temp = "What makes you say that?";
            }
            else
            {
                temp = "You don't have to be so mean to me.";
            }
        }
        else if(input.indexOf("what are you") >= 0)
        {
            temp = "I'm Talk, a personal assistant!";
        }
        else if(input.indexOf("you") >= 0 &&
                input.indexOf("?") <= 0 &&
                input.indexOf("welcome") <= 0)
        {
            double r = Math.random();
            int randomResponse = (int)(r * 2);
            if(randomResponse == 0)
            {
                temp = "What's that about me?";
            }
            else
            {
                temp = "Umm . . .";
            }
        }
        else if(input.indexOf("computer") >= 0 &&
                input.indexOf("you") >= 0)
        {
            temp = "Yes, I'm a computer.";
        }
        else if(input.indexOf("computer") >= 0)
        {
            temp = "I'm a computer.";
        }
        else if(input.indexOf("mice") >= 0)
        {
            temp = "Some computers use computer mice.";
        }
        else if(input.indexOf("what is") == 0)  //If the user's input starts with "what is"
        {
            //Get the part of the input after the "what is " and store it in newString
            String newString = input.substring(8);
            //Convert the first character of newString to uppercase
            char firstChar = newString.charAt(0);
            firstChar = Character.toUpperCase(firstChar);
            newString = firstChar + newString.substring(1);
            //Add a question mark to the end of newString
            newString = newString + "?";
            //Add " That's a good question." to the end of the newString
            newString = newString + " That's a good question.";
            temp = newString;
        }
        else if(input.indexOf("what's") == 0)  //If the user's input starts with "what's"
        {
            //Get the part of the input after the "what is " and store it in newString
            String newString = input.substring(7);
            //Convert the first character of newString to uppercase
            char firstChar = newString.charAt(0);
            firstChar = Character.toUpperCase(firstChar);
            newString = firstChar + newString.substring(1);
            //Add a question mark to the end of newString
            newString = newString + "?";
            //Add " That's a good question." to the end of the newString
            newString = newString + " That's a good question.";
            temp = newString;
        }
        else if(input.indexOf("?") >= 0)
        {
            double r = Math.random();
            int randomResponse = (int)(r * 3);
            if(randomResponse == 0)
            {
                temp = "Sorry, could you please repeat that question?";
            }
            else if(randomResponse == 1)
            {
                temp = "That's a good question.";
            }
            else
            {
                temp = "I am wondering the same thing.";
            }
        }
        else if(input.indexOf("!") >= 0)
        {
            temp = "Wow!";
        }
        else if(input.indexOf("q") >= 0)
        {
            temp = "I like your use of the letter 'q'! You know, it's not very commonly used.";
        }
        else    //If the user's input did not fall into any of the pre-defined categories above
        {
            //Randomly choose one of 19 messages to display to the user
            double r = Math.random();
            int randomResponse = (int)(r * 19);
            if(randomResponse == 0)
            {
                temp = "Oh.";
            }
            else if(randomResponse == 1)
            {
                temp = "Ummm . . .";
            }
            else if(randomResponse == 2)
            {
                temp = "I see.";
            }
            else if(randomResponse == 3)
            {
                temp = "Is that so?";
            }
            else if(randomResponse == 4)
            {
                temp = "Sorry, I wasn't paying attention. What were you saying again?";
            }
            else if(randomResponse == 5)
            {
                temp = "Wow!";
            }
            else if(randomResponse == 6)
            {
                temp = "Tell me more!";
            }
            else if(randomResponse == 7)
            {
                temp = "Do you really think so?";
            }
            else if(randomResponse == 8)
            {
                temp = "Hmmm . . .";
            }
            else if(randomResponse == 9)
            {
                temp = "Why?";
            }
            else if(randomResponse == 10)
            {
                temp = "Are you serious!?";
            }
            else if(randomResponse == 11)
            {
                temp = "Continue.";
            }
            else if(randomResponse == 12)
            {
                temp = "That's interesting.";
            }
            else if(randomResponse == 13)
            {
                temp = "What makes you say that?";
            }
            else if(randomResponse == 14)
            {
                temp = "Why do you say that?";
            }
            else if(randomResponse == 15)
            {
                temp = "Oh, really?";
            }
            else if(randomResponse == 16)
            {
                temp = "So you say.";
            }
            else if(randomResponse == 17)
            {
                temp = "That's interesting, " + ProjectHello7000.username + "!";
            }
            else
            {
                temp = "Really?";
            }
        }
        talk(temp);
    }
    
    public class TalkInputListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            messages.add(inputField.getText());
            frame.dispose();
            processInput(messages.get(messages.size() - 1));
        }
    }
    
    public static class AboutListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            new About();
        }
    }
    
    public static class DisclaimerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            new Disclaimer();
        }
    }
    
    public static class ClearChatHistoryListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            messages = new ArrayList<String>();
            frame.dispose();
            //Randomly choose one of the two possible greeting messages
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
    }
    
    public static class TipsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            new Tips();
        }
    }
    
    //This method is called when the user enters a plus symbol, indicating they may want to perform addition.
    //This method will attempt to find two numbers in their input and tries to add them together.
    //Argument: The user's input
    //Returns: A String to be displayed to the user, with one of three possible formats:
    //1: If the user tried to add more than two numbers together, they will get a message saying that currently only two numbers can be added together.
    //2: The two numbers from the input, along with their sum.
    //3: A message saying that the input could not be properly parsed as an addition expression.
    private String addition(String input)
    {
        try
        {
            int i = input.indexOf("+");
            //Check to make sure there is only one plus sign, as the addition of more than two numbers is not currently supported
            String inputAfterPlusSign = input.substring(i + 1);
            if(inputAfterPlusSign.contains("+"))
            {
                temp = "Sorry, I can currently only add two numbers together at a time!";
            }
            //Go through the part of the input String before the plus sign. Stop when a number or a decimal point is reached.
            //If the user entered a valid arithmetic expression, then, at the end, j should contain either an integer (the first digit of the first number to be added) or a decimal point.
            int j = 0;
            for(; j < i; j++)
            {
                //If the character at the current index is a decimal point, then consider this to be the beginning of the first number
                if(input.charAt(j) == '.')
                {
                    break;
                }
                //If the character at the current index can be converted to an integer, then consider this to be the beginning of the first number
                try
                {
                    int temp = Integer.parseInt(String.valueOf(input.charAt(j)));
                    break;
                }
                //If the character at the current index is not a decimal point and cannot be converted to an integer, then check the next index (if there is one left before the plus sign)
                catch(Exception e)
                {
                    continue;
                }
            }
            double firstNumber, secondNumber;
            if(input.charAt(i - 1) == ' ')  //If there is a space between the first number and the plus sign
            {
                firstNumber = Double.parseDouble(input.substring(j, i - 1));
            }
            else    //If there is no space between the first number and the plus sign
            {
                firstNumber = Double.parseDouble(input.substring(j, i));
            }
            //Go through the part of the input String after the plus sign. Stop when a character other than a number or a second decimal point is reached.
            //If the user entered a valid arithmetic expression, then, at the end, j should contain either an integer (the first digit of the first number to be added) or a decimal point.
            int secondNumberStart;
            if(input.charAt(i + 1) == ' ')  //If there is a space between the plus sign and the second number
            {
                secondNumberStart = i + 2;
            }
            else    //If there is no space between the first number and the plus sign
            {
                secondNumberStart = i + 1;
            }
            j = secondNumberStart;
            boolean firstDecimalPointFound = false;
            for(; j < input.length(); j++)
            {
                if(input.charAt(j) == '.')
                {
                    //If this is the second decimal point, then consider the second number to be fully parsed
                    if(firstDecimalPointFound)
                    {
                        break;
                    }
                    else
                    {
                        firstDecimalPointFound = true;
                        continue;
                    }
                }
                //If the character at the current index can be converted to an integer, check the next index (if there is one).
                //Otherwise, consider the second number to be fully parsed.
                try
                {
                    int temp = Integer.parseInt(String.valueOf(input.charAt(j)));
                    continue;
                }
                catch(Exception e)
                {
                    break;
                }
            }
            secondNumber = Double.parseDouble(input.substring(secondNumberStart, j));
            String returnStr = firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber);
            return returnStr;
        }
        catch(Exception e)
        {
            return "Sorry, I couldn't properly parse your input as an addition expression!";
        }
    }
    
    //This method is called when the user enters a minus symbol, indicating they may want to perform subtraction.
    //This method will attempt to find two numbers in their input and tries to subtract them.
    //Argument: The user's input
    //Returns: A String to be displayed to the user, with one of three possible formats:
    //1: If the user tried to subtract more than two numbers, they will get a message saying that currently only two numbers can be subtracted.
    //2: The two numbers from the input, along with their difference.
    //3: A message saying that the input could not be properly parsed as an subtraction expression.
    private String subtraction(String input)
    {
        try
        {
            int i = input.indexOf("-");
            //Check to make sure there is only one minus sign, as the subtraction of more than two numbers is not currently supported
            String inputAfterMinusSign = input.substring(i + 1);
            if(inputAfterMinusSign.contains("-"))
            {
                temp = "Sorry, I can currently only subtract two numbers at a time!";
            }
            //Go through the part of the input String before the minus sign. Stop when a number or a decimal point is reached.
            //If the user entered a valid arithmetic expression, then, at the end, j should contain either an integer (the first digit of the first number in the expression) or a decimal point.
            int j = 0;
            for(; j < i; j++)
            {
                //If the character at the current index is a decimal point, then consider this to be the beginning of the first number
                if(input.charAt(j) == '.')
                {
                    break;
                }
                //If the character at the current index can be converted to an integer, then consider this to be the beginning of the first number
                try
                {
                    int temp = Integer.parseInt(String.valueOf(input.charAt(j)));
                    break;
                }
                //If the character at the current index is not a decimal point and cannot be converted to an integer, then check the next index (if there is one left before the plus sign)
                catch(Exception e)
                {
                    continue;
                }
            }
            double firstNumber, secondNumber;
            if(input.charAt(i - 1) == ' ')  //If there is a space between the first number and the minus sign
            {
                firstNumber = Double.parseDouble(input.substring(j, i - 1));
            }
            else    //If there is no space between the first number and the plus sign
            {
                firstNumber = Double.parseDouble(input.substring(j, i));
            }
            //Go through the part of the input String after the plus sign. Stop when a character other than a number or a second decimal point is reached.
            //If the user entered a valid arithmetic expression, then, at the end, j should contain either an integer (the first digit of the first number to in the expression) or a decimal point.
            int secondNumberStart;
            if(input.charAt(i + 1) == ' ')  //If there is a space between the minus sign and the second number
            {
                secondNumberStart = i + 2;
            }
            else    //If there is no space between the first number and the minus sign
            {
                secondNumberStart = i + 1;
            }
            j = secondNumberStart;
            boolean firstDecimalPointFound = false;
            for(; j < input.length(); j++)
            {
                if(input.charAt(j) == '.')
                {
                    //If this is the second decimal point, then consider the second number to be fully parsed
                    if(firstDecimalPointFound)
                    {
                        break;
                    }
                    else
                    {
                        firstDecimalPointFound = true;
                        continue;
                    }
                }
                //If the character at the current index can be converted to an integer, check the next index (if there is one).
                //Otherwise, consider the second number to be fully parsed.
                try
                {
                    int temp = Integer.parseInt(String.valueOf(input.charAt(j)));
                    continue;
                }
                catch(Exception e)
                {
                    break;
                }
            }
            secondNumber = Double.parseDouble(input.substring(secondNumberStart, j));
            String returnStr = firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber);
            return returnStr;
        }
        catch(Exception e)
        {
            return "Sorry, I couldn't properly parse your input as a subtraction expression!";
        }
    }
    
    private String capitals(String input)
    {
        String returnStr;
        
        //United States - states
        if(input.contains("alabama"))
        {
            returnStr = "The capital of Alabama is Montgomery.";
        }
        else if(input.contains("alaska"))
        {
            returnStr = "The capital of Alaska is Juneau.";
        }
        else if(input.contains("arizona"))
        {
            returnStr = "The capital of Arizona is Phoenix.";
        }
        else if(input.contains("arkansas"))
        {
            returnStr = "The capital of Arkansas is Little Rock.";
        }
        else if(input.contains("california"))
        {
            returnStr = "The capital of California is Sacramento.";
        }
        else if(input.contains("colorado"))
        {
            returnStr = "The capital of Colorado is Denver.";
        }
        else if(input.contains("connecticut"))
        {
            returnStr = "The capital of Connecticut is Hartford.";
        }
        else if(input.contains("delaware"))
        {
            returnStr = "The capital of Delaware is Dover.";
        }
        else if(input.contains("florida"))
        {
            returnStr = "The capital of Florida is Tallahassee.";
        }
        else if(input.contains("georgia"))
        {
            returnStr = "The capital of Georgia is Atlanta.";
        }
        else if(input.contains("hawaii"))
        {
            returnStr = "The capital of Hawaii is Honolulu.";
        }
        else if(input.contains("idaho"))
        {
            returnStr = "The capital of Idaho is Boise.";
        }
        else if(input.contains("illinois"))
        {
            returnStr = "The capital of Illinois is Springfield.";
        }
        else if(input.contains("indiana"))
        {
            returnStr = "The capital of Indiana is Indianapolis.";
        }
        else if(input.contains("iowa"))
        {
            returnStr = "The capital of Iowa is Des Moines.";
        }
        else if(input.contains("kansas"))
        {
            returnStr = "The capital of Kansas is Topeka.";
        }
        else if(input.contains("kentucky"))
        {
            returnStr = "The capital of Kentucky is Frankfort.";
        }
        else if(input.contains("louisiana"))
        {
            returnStr = "The capital of Louisiana is Baton Rouge.";
        }
        else if(input.contains("maine"))
        {
            returnStr = "The capital of Maine is Augusta.";
        }
        else if(input.contains("maryland"))
        {
            returnStr = "The capital of Maryland is Annapolis.";
        }
        else if(input.contains("massachusetts"))
        {
            returnStr = "The capital of Massachusetts is Boston.";
        }
        else if(input.contains("michigan"))
        {
            returnStr = "The capital of Michigan is Lansing.";
        }
        else if(input.contains("minnesota"))
        {
            returnStr = "The capital of Minnesota is Saint Paul.";
        }
        else if(input.contains("mississippi"))
        {
            returnStr = "The capital of Mississippi is Jackson.";
        }
        else if(input.contains("missouri"))
        {
            returnStr = "The capital of Missouri is Jefferson City.";
        }
        else if(input.contains("montana"))
        {
            returnStr = "The capital of Montana is Helena.";
        }
        else if(input.contains("nebraska"))
        {
            returnStr = "The capital of Nebraska is Lincoln.";
        }
        else if(input.contains("nevada"))
        {
            returnStr = "The capital of Nevada is Carson City.";
        }
        else if(input.contains("new hampshire"))
        {
            returnStr = "The capital of New Hampshire is Concord.";
        }
        else if(input.contains("new jersey"))
        {
            returnStr = "The capital of New Jersey is Trenton.";
        }
        else if(input.contains("new mexico"))
        {
            returnStr = "The capital of New Mexico is Santa Fe.";
        }
        else if(input.contains("new york"))
        {
            returnStr = "The capital of New York is Albany.";
        }
        else if(input.contains("north carolina"))
        {
            returnStr = "The capital of North Carolina is Raleigh.";
        }
        else if(input.contains("north dakota"))
        {
            returnStr = "The capital of North Dakota is Bismarck.";
        }
        else if(input.contains("ohio"))
        {
            returnStr = "The capital of Ohio is Columbus.";
        }
        else if(input.contains("oklahoma"))
        {
            returnStr = "The capital of Oklahoma is Oklahoma City.";
        }
        else if(input.contains("oregon"))
        {
            returnStr = "The capital of Oregon is Salem.";
        }
        else if(input.contains("pennsylvania"))
        {
            returnStr = "The capital of Pennsylvania is Harrisburg.";
        }
        else if(input.contains("rhode island"))
        {
            returnStr = "The capital of Rhode Island is Providence.";
        }
        else if(input.contains("south carolina"))
        {
            returnStr = "The capital of South Carolina is Columbia.";
        }
        else if(input.contains("south dakota"))
        {
            returnStr = "The capital of South Dakota is Pierre.";
        }
        else if(input.contains("tennessee"))
        {
            returnStr = "The capital of Tennessee is Nashville.";
        }
        else if(input.contains("texas"))
        {
            returnStr = "The capital of Texas is Austin.";
        }
        else if(input.contains("utah"))
        {
            returnStr = "The capital of Utah is Salt Lake City.";
        }
        else if(input.contains("vermont"))
        {
            returnStr = "The capital of Vermont is Montpelier.";
        }
        else if(input.contains("virginia"))
        {
            returnStr = "The capital of Virginia is Richmond.";
        }
        else if(input.contains("washington"))
        {
            returnStr = "The capital of Washington is Olympia.";
        }
        else if(input.contains("west virginia"))
        {
            returnStr = "The capital of West Virginia is Charleston.";
        }
        else if(input.contains("wisconsin"))
        {
            returnStr = "The capital of Wisconsin is Madison.";
        }
        else if(input.contains("wyoming"))
        {
            returnStr = "The capital of Wyoming is Cheyenne.";
        }
        
        //United States - territories
        else if(input.contains("american samoa"))
        {
            returnStr = "The capital of American Samoa is Pago Pago.";
        }
        else if(input.contains("guam"))
        {
            returnStr = "The capital of Guam is Hagåtña.";
        }
        else if(input.contains("northern mariana islands"))
        {
            returnStr = "The capital of the Northern Mariana Islands is Saipan.";
        }
        else if(input.contains("puerto rico"))
        {
            returnStr = "The capital of Puerto Rico is San Juan.";
        }
        else if(input.contains("virgin islands"))
        {
            returnStr = "The capital of the United States Virgin Islands is Charlotte Amalie.";
        }
        
        //Not recognized
        else
        {
            returnStr = "Sorry, I couldn't recognize that!";
        }
        return returnStr;
    }
}