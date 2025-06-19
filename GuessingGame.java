import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private Dictionary dictionary;
    private String wordToGuess;
    private StringBuilder secretWord;
    private int numGuesses;
    private final Scanner scanner;

    public GuessingGame(String filename) {
        dictionary = new Dictionary(filename);
        scanner = new Scanner(System.in);
        numGuesses = 0;
    }

    public void startGame() {
        //Select a random word with at least 5 letters
        selectRandomWord();

        //Initialize secretWord
        secretWord = new StringBuilder(wordToGuess.replaceAll(".", "-"));
        System.out.println("I have picked a secret word. Try to guess its letters!");
        
        // Run the game
        while (secretWord.toString().contains("-")) {
            System.out.println(secretWord);  // Show current word that is to be guessed

            System.out.print("Guess> ");
            char guess = scanner.next().toLowerCase().charAt(0);

            // Process the guess
            updateWord(guess);

            numGuesses++;  // Increment the guess count
        }

        // Dispay results
        System.out.println(wordToGuess);
        System.out.println("You got it in " + numGuesses + " guesses.");
    }

    private void selectRandomWord() {
        Random rand = new Random();
        boolean wordFound = false;
        while (!wordFound) {
            // Pick a random index from the dictionary
            int randomIndex = rand.nextInt(dictionary.getNumWords());
            String word = dictionary.getWordAt(randomIndex);
            
            // Check if the word has at least 5 letters
            if (word.length() >= 5) {
                wordToGuess = word;
				secretWord = new StringBuilder(wordToGuess);
                wordFound = true;
            }
        }
    }

    // The method that updates the secretWord
    private void updateWord(char guess) {
        // Loop through each letter in wordToGuess
        for (int i = 0; i < wordToGuess.length(); i++) {
            // Update the word if the guess matches the letter at position i in the wordToGuess
            if (wordToGuess.charAt(i) == guess) {
                secretWord.setCharAt(i, guess);  
                
            }
        }

    }
    //Main method to start the game
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame("dictionary.txt");
        game.startGame();
    }
}
