import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovModel {
    private String myText;
    private Random myRandom;
    private int numOfCharacters;
    
    public MarkovModel(int num) {
        myRandom = new Random();
        numOfCharacters = num;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    /*
     *Gets the characters that follow each key text in myText.
     *
     */
    public ArrayList<String> getFollows(String key) {
       ArrayList<String> followCharacters = new ArrayList<String>();
       //While there is key to find in myText:
       for (int i = 0; i < myText.length(); i++) {
           int finalIndexToCompareWithKey = i + key.length();
           
           
           //Checks if the final index to compare with key does not exist in
           //the length of myText, and breaks the loop.
           if (finalIndexToCompareWithKey > myText.length()) break;
           //Get the character that follows key.
           if (myText.substring(i ,i + key.length()).equals(key)) {
               int finalIndexOfNextCharacter = i + key.length() + 1;
               //If the next character to find is out of the range of
               //myText, break the loop.
               if (finalIndexOfNextCharacter > myText.length()) break;
               followCharacters.add(myText.substring(i + key.length(), i + key.length() + 1));
               i += key.length() - 1;
            }
           //Append that character to followCharacters array.
           //Start the loop again at index(es) from key + 1-
       }
       return followCharacters;
    }
    
    public String getRandomText(int numChars){
        StringBuffer sb = new StringBuffer();
        int index = myRandom.nextInt(myText.length() - numOfCharacters);
        String key = myText.substring(index, index + numOfCharacters);
        sb.append(key);
        
        for (int i = 0; i < numChars - numOfCharacters; i++) {
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        
        return sb.toString();
    }
}
