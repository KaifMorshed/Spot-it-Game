// Import libraries
import java.util.*;
import java.util.concurrent.*;

// Class for GameMode2
public class GameMode2{

  //import all different colours for printing
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  // Time-control spot it
  public int timeControl(){

    // Clear screen
    System.out.print("\033[H\033[2J");  
    System.out.flush();
    
    // Scanner
    Scanner in = new Scanner(System.in);

    // Intialize player score
    int score = 0;

    // countdown
    int i = 3; //declare how long the timer will be for
    System.out.println(ANSI_RED + "READY?"+ ANSI_RESET);
    //while loop that decreases i by 1 each second until it reaches 0
    while (i>0){
      System.out.println(ANSI_YELLOW + i + ANSI_RESET);
      try {
      i--;
      Thread.sleep(1000L);    // 1000L = 1000ms = 1 second
      }
      catch (InterruptedException e) {
      }
    }
    System.out.println(ANSI_GREEN +"GO!" + ANSI_RESET); //prints go

    // delay code 
    try {
      Thread.sleep(585L);
    }
    catch (InterruptedException e){
    }
    
    System.out.println();

    long end = System.currentTimeMillis()+30000; //sets time as 30000 milliseconds / 30 seconds
    
    while (System.currentTimeMillis() < end){ // User plays for 30 seconds

      System.out.print("\033[H\033[2J");  
      System.out.flush(); //clears the console

      //delay code
      try {
        Thread.sleep(500L);
      }
      catch (InterruptedException e){
      }

      //generates random number for each card
      int card1 = (int)(Math.random()*13);
      int card2 = (int)(Math.random()*13); 

      // If 2 cards are the same, pick 2 cards until they are not the same
      while (card1 == card2){
        card1 = (int)(Math.random()*13);
        card2 = (int)(Math.random()*13);
      }
      
      // Deck of 13 cards
      int[][] deck = { 
        {1, 2, 3, 4}, // 1st card
        {2, 5, 8, 11}, // 2nd card
        {3, 5, 9, 13}, // 3rd card
        {4, 5, 10, 12}, // 4th card
        {1, 5, 6, 7}, // 5th card
        {2, 6, 9, 12}, // 6th card
        {3, 6, 10, 11}, // 7th card
        {4, 6, 8, 13}, // 8th card
        {1, 8, 9, 10}, // 9th card
        {2, 7, 10, 13}, // 10th card
        {3, 7, 8, 12}, // 11th card
        {4, 7, 9, 11}, // 12th card
        {1, 11, 12, 13} // 13th card
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
      
      System.out.print(ANSI_YELLOW + "SPOT IT!: " + ANSI_RESET); //promts user to make guess

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
      
      // Get user guess
      int guess = in.nextInt();       

      //finds how long the user has left
      long currentTimeLeft = (end - System.currentTimeMillis()) / 1000;
      
      // If user guess is correct
      if (guess == correctAnswer){

        // add to score
        score += 1;

        // tell user they are correct
        System.out.println(ANSI_GREEN + "Correct!" + ANSI_RESET);

        // tell remaining time if there is remaining time
        if (currentTimeLeft > 0){
          System.out.println(ANSI_CYAN + currentTimeLeft + " seconds left\n" + ANSI_RESET);
        }

        // else tell user time's up
        else {
          System.out.println(ANSI_RED + "\nTIME'S UP!" + ANSI_RESET);
        }
        
        // delay code 
        try {
          Thread.sleep(1500L);
        }
        catch (InterruptedException e){
        }
      }

      // If user guess is wrong
      else {

        // tell user they're wrong
        System.out.println(ANSI_RED + "Whoops! Correct answer was " + correctAnswer + ANSI_RESET);

        // show remaining time if there is remaining time
        if (currentTimeLeft > 0){
          System.out.println(ANSI_CYAN + currentTimeLeft + " seconds left\n" + ANSI_RESET);
        }

        // else tell user time is up
        else {
          System.out.println(ANSI_RED + "\nTIME'S UP!" + ANSI_RESET);
        }

        // delay code 
        try {
          Thread.sleep(1850L);
        }
        catch (InterruptedException e){
        }
      }
    }
    
    return score;
    
  } // End time-control spot it
} // End GameMode2 class