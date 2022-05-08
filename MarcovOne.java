import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class MarcovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarcovOne {
    private String myText;
    private Random myRandom;
    
    public MarcovOne() {
        myRandom = new Random();
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
       for (int i = 0; i < myText.length() - 1; i++) {
           
           //Get the character that follows key.
           if (myText.substring(i ,i + key.length()).equals(key)) {
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
        int index = myRandom.nextInt(myText.length() - 1);
        String key = myText.substring(index, index + 1);
        sb.append(key);
        
        for (int i = 0; i < numChars - 1; i++) {
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }
        
        return sb.toString();
    }
    
}
