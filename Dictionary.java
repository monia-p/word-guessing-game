import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
    private String[] words;
    private int numWords = 0;

    public Dictionary(String filename) {
        File f = new File(filename);
        if (f.exists()) {
            Scanner fileInput;
            
            try {
                fileInput = new Scanner(f);
                
                // 1: count the number of words
                while (fileInput.hasNext()) {
                    String s = fileInput.nextLine();
                    numWords++;
                }
                fileInput.close();
                
                // 2: size the array appropriately and read the words into it
                words = new String[numWords];
                
                // re-instantiating the Scanner resets us to the start of the file
                fileInput = new Scanner(f); 
                for (int i = 0; i < numWords; i++) {
                    words[i] = fileInput.nextLine();
                }
                fileInput.close();

            } 
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Method names updated to follow conventions
    public int getNumWords() {
        return numWords;
    }
    
    public String getWordAt(int index) {
        return words[index];
    }
}
