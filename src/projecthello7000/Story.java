package projecthello7000;
//Generates a story with a length of either 3 or 4 sentences.
public class Story
{
    private final int SENTENCES;    //Stores the number of sentences the story should have
    private String story;
    
    /*
    Constructor
    Parameter: int "sentences," which is 0 for a story with a random length, 3 for a 3-sentence story, or 4 for a 4-sentence story.
    */
    public Story(int sentences)
    {
        //If the story is requested to have a random length, then randomly choose either 3 or 4 and store it in SENTENCES
        if(sentences == 0)
        {
            Double d = Math.random();
            int i = (int)(d * 2);
            i += 3;
            SENTENCES = i;
        }
        else
        {
            SENTENCES = sentences;
        }
        generateStory();
    }
    
    //Returns the story as a String
    public String getStory()
    {
        return story;
    }
    
    private void generateStory()
    {
        String opening, output, setting;
        int openingType;
        double random = Math.random();
        int r = (int)(random * 7);
        if(r == 0)
        {
            opening = "Once upon a time, ";
            setting = "land";
            openingType = 1;
        }
        else if(r == 1)
        {
            opening = "In a land far, far away, ";
            setting = "land";
            openingType = 2;
        }
        else if(r == 2)
        {
            opening = "In an ocean far, far away, ";
            setting = "ocean";
            openingType = 2;
        }
        else if(r == 3)
        {
            opening = "In a castle far, far away, ";
            setting = "castle";
            openingType = 2;
        }
        else if(r == 4)
        {
            opening = "In a palace far, far away, ";
            setting = "palace";
            openingType = 2;
        }
        else if(r == 5)
        {
            opening = "In a desert far, far away, ";
            setting = "desert";
            openingType = 2;
        }
        else
        {
            opening = "In a forest far, far away, ";
            setting = "forest";
            openingType = 2;
        }
        String subject = new String();
        char gender = 'm';
        if("land".equals(setting))
        {
            Double random2 = Math.random();
            int r2 = (int)(random2 * 4);
            if(r2 == 0)
            {
                subject = "person";
                gender = randomGender();
            }
            else if(r2 == 1)
            {
                subject = "cat";
                gender = randomGender();
            }
            else if(r2 == 2)
            {
                subject = "dog";
                gender = randomGender();
            }
            else
            {
                subject = "bear";
                gender = randomGender();
            }
        }
        if("ocean".equals(setting))
        {
            Double random2 = Math.random();
            int r2 = (int)(random2 * 3);
            if(r2 == 0)
            {
                subject = "fish";
                gender = randomGender();
            }
            else if(r2 == 1)
            {
                subject = "dolphin";
                gender = randomGender();
            }
            else
            {
                subject = "shark";
                gender = randomGender();
            }
        }
        if("castle".equals(setting) ||
                "palace".equals(setting))
        {
            Double random2 = Math.random();
            int r2 = (int)(random2 * 4);
            if(r2 == 0)
            {
                subject = "king";
                gender = 'm';
            }
            else if(r2 == 1)
            {
                subject = "queen";
                gender = 'f';
            }
            else if(r2 == 2)
            {
                subject = "prince";
                gender = 'm';
            }
            else
            {
                subject = "princess";
                gender = 'f';
            }
        }
        if("desert".equals(setting))
        {
            Double random2 = Math.random();
            int r2 = (int)(random2 * 2);
            if(r2 == 0)
            {
                subject = "camel";
                gender = 'm';
            }
            else
            {
                subject = "horse";
                gender = 'm';
            }
        }
        if("forest".equals(setting))
        {
            Double random2 = Math.random();
            int r2 = (int)(random2 * 5);
            if(r2 == 0)
            {
                subject = "owl";
                gender = randomGender();
            }
            else if(r2 == 1)
            {
                subject = "squirrel";
                gender = randomGender();
            }
            else if(r2 == 2)
            {
                subject = "bear";
                gender = randomGender();
            }
            else if(r2 == 3)
            {
                subject = "deer";
                gender = randomGender();
            }
            else
            {
                subject = "fox";
                gender = randomGender();
            }
        }
        String secondPhrase = new String();
        if(openingType == 1)
        {
            secondPhrase = "there was a " + subject + ".";
        }
        if(openingType == 2)
        {
            secondPhrase = "there was once a " + subject + ".";
        }
        String firstSentence = opening + secondPhrase;
        if(SENTENCES == 4)
        {
            String time;
            Double random3 = Math.random();
            int r3 = (int)(random3 * 5);
            if(r3 == 0)
            {
                time = "day";
            }
            else if(r3 == 1)
            {
                time = "morning";
            }
            else if(r3 == 2)
            {
                time = "afternoon";
            }
            else if(r3 == 3)
            {
                time = "evening";
            }
            else
            {
                time = "night";
            }
            String infinitiveVerb, typeOfSchool;
            Double random4 = Math.random();
            int r4 = (int)(random4 * 11);
            if(r4 == 0)
            {
                infinitiveVerb = "to swim";
                typeOfSchool = "swimming";
            }
            else if(r4 == 1)
            {
                infinitiveVerb = "to read";
                typeOfSchool = "reading";
            }
            else if(r4 == 2)
            {
                infinitiveVerb = "to draw";
                typeOfSchool = "drawing";
            }
            else if(r4 == 3)
            {
                infinitiveVerb = "to write a story";
                typeOfSchool = "writing";
            }
            else if(r4 == 4)
            {
                infinitiveVerb = "to paint";
                typeOfSchool = "painting";
            }
            else if(r4 == 5)
            {
                infinitiveVerb = "to cook";
                typeOfSchool = "cooking";
            }
            else if(r4 == 6)
            {
                infinitiveVerb = "to use a computer";
                typeOfSchool = "computer";
            }
            else if(r4 == 7)
            {
                infinitiveVerb = "to fish";
                typeOfSchool = "fishing";
            }
            else if(r4 == 8)
            {
                infinitiveVerb = "to drive";
                typeOfSchool = "driving";
            }
            else if(r4 == 9)
            {
                infinitiveVerb = "to bake";
                typeOfSchool = "baking";
            }
            else
            {
                infinitiveVerb = "to fly a plane";
                typeOfSchool = "flying";
            }
            String secondSentence = "One " + time + ", that " + subject + " decided to learn how " + infinitiveVerb + ".";
            String thirdSentence = "So that " + subject + " went to a " + typeOfSchool + " school.";
            String subject2;
            Double random5 = Math.random();
            int r5 = (int)(random5 * 8);
            if(r5 == 0)
            {
                subject2 = "brother";
            }
            else if(r5 == 1)
            {
                subject2 = "sister";
            }
            else if(r5 == 2)
            {
                subject2 = "mother";
            }
            else if(r5 == 3)
            {
                subject2 = "father";
            }
            else if(r5 == 4)
            {
                subject2 = "friend";
            }
            else if(r5 == 5)
            {
                subject2 = "aunt";
            }
            else if(r5 == 6)
            {
                subject2 = "uncle";
            }
            else
            {
                subject2 = "friend";
            }
            String fourthSentence;
            if(gender == 'm')
            {
                fourthSentence = "After he had learnt how " + infinitiveVerb + ",\n"
                        + "he told his " + subject2 + " that he had learnt how to " + infinitiveVerb + ".";
            }
            else
            {
                fourthSentence = "After she had learnt how " + infinitiveVerb + ",\n"
                        + "she told her " + subject2 + " that she had learnt how to " + infinitiveVerb + ".";
            }
            output = firstSentence + "\n" + secondSentence + "\n" + thirdSentence + "\n" + fourthSentence;
        }
        else
        {
            String time;
            Double random3 = Math.random();
            int r3 = (int)(random3 * 5);
            if(r3 == 0)
            {
                time = "day";
            }
            else if(r3 == 1)
            {
                time = "morning";
            }
            else if(r3 == 2)
            {
                time = "afternoon";
            }
            else if(r3 == 3)
            {
                time = "evening";
            }
            else
            {
                time = "night";
            }
            String place;
            boolean land;
            Double random4 = Math.random();
            int r4 = (int)(random4 * 19);
            if(r4 == 0)
            {
                place = "Canada";
                land = true;
            }
            else if(r4 == 1)
            {
                place = "Mexico";
                land = true;
            }
            else if(r4 == 2)
            {
                place = "New York";
                land = true;
            }
            else if(r4 == 3)
            {
                place = "Florida";
                land = true;
            }
            else if(r4 == 4)
            {
                place = "Alaska";
                land = true;
            }
            else if(r4 == 5)
            {
                place = "California";
                land = true;
            }
            else if(r4 == 6)
            {
                place = "England";
                land = false;
            }
            else if(r4 == 7)
            {
                place = "France";
                land = false;
            }
            else if(r4 == 8)
            {
                place = "Spain";
                land = false;
            }
            else if(r4 == 9)
            {
                place = "Russia";
                land = false;
            }
            else if(r4 == 10)
            {
                place = "China";
                land = false;
            }
            else if(r4 == 11)
            {
                place = "Africa";
                land = false;
            }
            else if(r4 == 12)
            {
                place = "Europe";
                land = false;
            }
            else if(r4 == 13)
            {
                place = "Australia";
                land = false;
            }
            else if(r4 == 14)
            {
                place = "Texas";
                land = true;
            }
            else if(r4 == 15)
            {
                place = "Italy";
                land = false;
            }
            else if(r4 == 16)
            {
                place = "India";
                land = false;
            }
            else if(r4 == 17)
            {
                place = "Germany";
                land = false;
            }
            else
            {
                place = "South Africa";
                land = false;
            }
            String secondSentence = "One " + time + ", that " + subject + " decided to go to " + place + ".";
            String meansOfTravel;
            Double random5 = Math.random();
            if(land)
            {
            int r5 = (int)(random5 * 4);
            if(r5 == 0)
            {
                meansOfTravel = "an airplane";
            }
            else if(r5 == 1)
            {
                meansOfTravel = "a train";
            }
            else if(r5 == 2)
            {
                meansOfTravel = "a bus";
            }
            else
            {
                meansOfTravel = "a taxi";
            }
            }
            else
            {
                int r5 = (int)(random5 * 2);
                if(r5 == 0)
                {
                    meansOfTravel = "an airplane";
                }
                else
                {
                    meansOfTravel = "a boat";
                }
            }
            String thirdSentence = "So that " + subject + " took " + meansOfTravel + " to " + place + ".";
            output = firstSentence + "\n" + secondSentence + "\n" + thirdSentence;
        }
        story = output;
    }
    
    //Uses a random number generator to return either a 'm' (for male) or a 'f' (for female)
    private char randomGender()
    {
        Double random = Math.random();
        int r = (int)(random * 2);
        if(r == 0)
        {
            return 'm';
        }
        else
        {
            return 'f';
        }
    }
}