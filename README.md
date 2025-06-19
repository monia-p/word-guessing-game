# Word Guessing Game

A console-based word guessing game implemented in Java that challenges players to guess letters in a randomly selected word.

## Features
- Random word selection from dictionary file (minimum 5 letters)
- Interactive letter-by-letter guessing
- Visual progress tracking with dashes for unguessed letters
- Guess counter to track player performance
- Input validation and case-insensitive guessing

## How to Play
1. The game selects a random word from the dictionary
2. You see dashes representing each letter: `-----`
3. Guess letters one at a time
4. Correct guesses reveal the letter's position(s)
5. Continue until you've guessed the complete word

## Attribution
- `Dictionary.java` - (Provided by Programming I - University of Galway /Sam Redfern) Foundation class for file I/O operations
- `GuessingGame.java` - Original implementation including game logic, random word selection, and user interaction

## Technologies Used
- Java
- File I/O
- Random number generation
- String manipulation
- Scanner for user input

## How to Run
```bash
javac *.java
java GuessingGame
