package projecthello7000;
public class Tips
{
    public Tips()
    {
        tips();
    }
    
    private void tips()
    {
        InformationWindow disclaimerFrame = new InformationWindow("Tips");
        disclaimerFrame.setSize(775 * ProjectHello7000.multiplier, 450 * ProjectHello7000.multiplier);
        String output = "1. \"What date is it?\" or \"What time is it?\" - Displays the date and time.\n\n"
                + "2. You can ask Project Hello7000 to tell you a story, and it will display a randomly generated story on the screen!\n\n"
                + "3. You can add two numbers together by entering, for example, \"3.5 + 5.5.\"\n"
                + "You may also enter it in a more natural way, such as, \"What is 10.1 + 12.3?\"\n"
                + "Note: Project Hello7000 currently does not support having commas in addition expressions."
                + "Please enter your addition expressions without commas in Project Hello7000.\n"
                + "Also, ProjectHello7000 currently does not support adding more than two numbers together at once,\n"
                + "nor does it support negative numbers in addition.\n\n"
                + "4. You can subtract two numbers. The format is the same as for addition (with the same disclaimers);\n"
                + "however, instead of entering a + symbol, use a - symbol to designate subtraction (ex. \"5 - 3\").\n\n"
                + "5. You can ask Project Hello7000 for state capitals!\n"
                + "For example, you can ask, \"What is the capital of Alaska?\"\n"
                + "Note: Currently, only the capitals of the 50 U.S. states and five U.S. territories are supported. Also, accuracy is not guaranteed.";
        disclaimerFrame.addText(ProjectHello7000.bodyText1, output);
        disclaimerFrame.makeVisible();
    }
}