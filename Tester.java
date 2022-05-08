import java.util.ArrayList;
import edu.duke.FileResource;
/**
 * This is a tester class to test the methods created.
 */
public class Tester {
    public void testGetFollows() {
        MarcovOne mo = new MarcovOne();
        mo.setTraining("this is a test yes this is a test.");
        String key = "es";
        ArrayList<String> followCharacters = mo.getFollows(key);
        System.out.println("There are " + followCharacters.size() + 
        " characters that follows \"" + key + "\".");
        System.out.println(followCharacters);
        
    }
    
    public void testGetFollowsWithFile() {
        MarcovOne mo = new MarcovOne();
        FileResource fr = new FileResource();
        String text = fr.asString();
        mo.setTraining(text);
        String key = "t";
        ArrayList<String> followCharacters = mo.getFollows(key);
        System.out.println("There are " + followCharacters.size() + 
        " characters that follows \"" + key + "\".");
    }
}
