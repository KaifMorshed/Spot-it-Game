// Import libraries
import java.util.*;
import java.util.concurrent.*;

// Class for GameMode1
public class GameMode1
{

  //import each colour to format printing
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  
  // Regular spot it method
  public static int regular(){

    // Clear screen
    System.out.print("\033[H\033[2J");  
    System.out.flush();
    
    // Scanner input
    Scanner in = new Scanner(System.in);

    // Initialize counter for turns Spot-It goes on for
    int count = 0; 

    // Initialize player score
    int score = 0;

    // Ready, set, go for user
    int i = 3;
    System.out.println(ANSI_RED + "READY?"+ ANSI_RESET);
    //loop that decreases i by 1 each second
    while (i>0){
      System.out.println(ANSI_YELLOW + i + ANSI_RESET);
      try {
      i--;
      Thread.sleep(1000L);    // 1000L = 1000ms = 1 second
      }
      catch (InterruptedException e) {
      }
    }
    System.out.println(ANSI_GREEN +"GO!" + ANSI_RESET);

    // delay
    try {
      Thread.sleep(500L);
    }
    catch (InterruptedException e){
    }
    
    System.out.println();
    
    while (count < 7){ // User plays for 7 turns

      // clear screen
      System.out.print("\033[H\033[2J");  
      System.out.flush();

      // delay code
      try {
        Thread.sleep(650L);
      }
      catch (InterruptedException e){
      }

      // randomly pick 2 cards
      int card1 = (int)(Math.random()*13); 
      int card2 = (int)(Math.random()*13);

      // randomly pick again if 2 cards are the same
      while (card1 == card2){
        card1 = (int)(Math.random()*13);
        card2 = (int)(Math.random()*13);
      }
      
      // Deck of 13 cards
      int[][] deck = { 
        {1, 2, 3, 4}, 
        {2, 5, 8, 11}, 
        {3, 5, 9, 13}, 
        {4, 5, 10, 12},
        {1, 5, 6, 7}, 
        {2, 6, 9, 12},
        {3, 6, 10, 11}, 
        {4, 6, 8, 13}, 
        {1, 8, 9, 10}, 
        {2, 7, 10, 13},
        {3, 7, 8, 12}, 
        {4, 7, 9, 11}, 
        {1, 11, 12, 13} 
      };      

      // each element of the first card saved into separate variables to be later formatted
      String card1Element1 = "" + deck[card1][0];
      String card1Element2 = "" + deck[card1][1];
      String card1Element3 = "" + deck[card1][2];
      String card1Element4 = "" + deck[card1][3];

      // print formatted first card
      System.out.println("_______");
      System.out.printf("|%-5s|\n|%5s|\n|%-5s|\n|%5s|\n", card1Element1, card1Element2, card1Element3, card1Element4);
      System.out.println("‾‾‾‾‾‾‾");

      System.out.println();

      // each element of the second card saved into separate variables to be later formatted
      String card2Element1 = "" + deck[card2][0];
      String card2Element2 = "" + deck[card2][1];
      String card2Element3 = "" + deck[card2][2];
      String card2Element4 = "" + deck[card2][3];

      // print formatted second card
      System.out.println("_______");
      System.out.printf("|%-5s|\n|%5s|\n|%-5s|\n|%5s|\n", card2Element1, card2Element2, card2Element3, card2Element4);
      System.out.println("‾‾‾‾‾‾‾");
      
      System.out.println();

      // tell user to spot it
      System.out.print(ANSI_YELLOW + "SPOT IT!: " + ANSI_RESET);

      // get user guess
      int choice = in.nextInt();      

      // Initialize correct answer
      int correctAnswer = 0; 

      // Loop through the 2 cards to find the correct answer
      for (int object1 = 0; object1 < deck[card1].length; object1++){
        for (int object2 = 0; object2 < deck[card2].length; object2++){
          if (deck[card1][object1] == deck[card2][object2]){
            correctAnswer = deck[card1][object1];
          }
        }
      }

      // If user guess is correct
      if (choice == correctAnswer){
        // add 1 to code
        score += 1;

        // tell user they are correct
        System.out.print(ANSI_GREEN + "Correct!\n" + ANSI_RESET);

        // delay code
        try {
          Thread.sleep(1000L);
        }
        catch (InterruptedException e){
        }
      }

      // If user guess is wrong
      else {
        // tell user they are wrong
        System.out.print(ANSI_RED + "Whoops! Correct answer was " + correctAnswer + "\n" + ANSI_RESET);

        // delay code
        try {
          Thread.sleep(1650L);
        }
        catch (InterruptedException e){
        }
      }

      // increment count/turn for spot it
      count++;
      
    }

    // delay code
    try {
      Thread.sleep(500L);
    }
    catch (InterruptedException e){
    }
    
    return score;
    
  } // End regular spot it
} // End GameMode1 class