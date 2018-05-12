package projecthello7000;
public class Disclaimer
{
    public Disclaimer()
    {
        disclaimer();
    }
    
    private void disclaimer()
    {
        InformationWindow disclaimerFrame = new InformationWindow("Disclaimer");
        disclaimerFrame.setSize(900 * ProjectHello7000.multiplier, 500 * ProjectHello7000.multiplier);
        String output = "1. Neither Project Hello7000, nor the programmer(s) of Project Hello7000, nor the distributor(s) of Project Hello7000,\n" +
                "nor anyone or anything else that is involved with Project Hello7000, are responsible for any misinformation, any inaccuracy,\n" +
                "any problems, or any harm, whether physical or otherwise, caused by Project Hello7000 or as a result of using Project Hello7000.\n" +
                "2. No guarantee is provided for any information contained in Project Hello7000.\n" +
                "3. Neither Project Hello7000, nor the programmer(s) of Project Hello7000, nor the distributor(s) of Project Hello7000,\n" +
                "nor anyone or anything else that is involved with Project Hello7000, are responsible for any undesirable or negative responses or\n" +
                "other forms of communication, or any negative consequences that may result from Project Hello7000 or any component(s) of it.";
        disclaimerFrame.addText(ProjectHello7000.bodyText1, output);
        disclaimerFrame.makeVisible();
    }
}