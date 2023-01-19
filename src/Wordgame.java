import java.lang.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Wordgame {

    static Scanner input;

    // array of strings containing words
    public static ArrayList colours = new ArrayList( Arrays.asList("red", "blue", "green", "grey", "yellow",
            "black", "white", "pink", "orange", "purple"));

    public static void game()
    {
        input = new Scanner(System.in);

        //display the colours
        System.out.println("---------");
        System.out.println("COLOURS");
        System.out.println("---------");
        for (int i=0; i<colours.size(); i++) {
            System.out.println(colours.get(i));
        }

        //select the random word
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(colours.size());
        String word = (String) colours.get(index);

        // To show the word in underscores
        word.replaceAll("[a-z]", "_");
        System.out.println("let's play the game");
        System.out.println("A colour has been picked from the list, guess it.");

        startGame(word);
    }
    public static void startGame(String word)
    {
        // total guesses
        int guess_ = 0;

        // number of wrong guesses
        int wrong = 0;

        // for each guess
        String guess;

        // while loop starts
        while (wrong < 3) {

            System.out.println(word + "\n");
            int temp = 3 - wrong;
            if (wrong != 0 ) {

                // for picture 1
                System.out.println("You have " + temp
                        + " guesses left.");
            }

            //player enters guess
            System.out.print("Your guess:");
            // takes guess input
            guess = input.nextLine();

//            //add guess to array
//            List<String> g = new ArrayList<String>();
//            g.add(guess);
////                String[] guessed_colours = new String[g.size()];
////                g.toArray(guessed_colours);
//
//
//            // if word already guessed
//            if (g.contains(guess))
//            { System.out.println("You've already guessed " + guess);}

            //if correct
            if(Objects.equals(word, guess))
            {
                System.out.println("Great," + guess + " is the right word");
                colours.remove(word);
                System.out.println("The number of words left is: " + colours.size());
                break;
            }

            //if wrong
            else {
                //after every wrong answer
                System.out.println(guess + " is not the right word.");
                wrong++;

            }
            // guess_ = guess_ + 1, after every attempt
            guess_++;

            //after first attempt
            if (wrong == 1 )
            {
                char firstCharacter = word.charAt(0);
                System.out.println("Here is a clue: The first letter of the word is " +  firstCharacter);
            }
            else if (wrong == 2 ) {
//                int count = 0;
//                for (int i = 0; i < word.length(); i++) {
//                    count = 0;
//                    if (word.charAt(i) != ' ')
//                        count++;
//                }
                System.out.println("Here is a clue: The word has " + word.length() + " letters.");
            }

        }
        // if the chances finish
        if (wrong == 3) {
            System.out.println("YOU LOST!, maximum limit of incorrect guesses reached.");
            System.out.print("Press y to play again and n to exit");
            String choice = input.nextLine();
            String y = null;

        }

    }

    public static void main(String[] args)
    {
        // play game
        game();
    }
}