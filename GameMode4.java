// import libraries
import java.util.*;
import java.util.concurrent.*;

// GameMode4 class
public class GameMode4 {

  // colours
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  // Scanner for input
  Scanner in = new Scanner(System.in);

  // multiplayer method
  public void multiplayer(){

    // initialize pleyers to 0
    int players = 0;

    // clear screen
    System.out.print("\033[H\033[2J");  
    System.out.flush();
    
    // make users choose how many players
    System.out.println("How many players are going to play? (2-4): ");
    players = in.nextInt();
    
    do {
      // input valid if invalid
      if (players < 2 || players > 4){

        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        System.out.println("Please input a number between 2 and 4: ");
        players = in.nextInt();
        
      }
      
    } while (players < 2 || players > 4);

    // array to hold player scores (position of score corresponds with the players, so 1st score in array is for player 1)
    long[] playerScores = new long[players];
    
    // loops for how many players there are
    for (int i = 1; i <= players; i++){
      // clear screen
      System.out.print("\033[H\033[2J");  
      System.out.flush();
			
      int j = 3;
    	System.out.println(ANSI_RED + "PLAYER " + i + " READY?"+ ANSI_RESET);

      // countdown of 3 seconds
    	while (j>0){
      System.out.println(ANSI_YELLOW + j + ANSI_RESET);
      	try {
      	  j--;
	        Thread.sleep(1000L);    // 1000L = 1000ms = 1 second
      	}
      	catch (InterruptedException e) {
      	}
    	}
    	System.out.println(ANSI_GREEN +"GO!" + ANSI_RESET);
    	System.out.println();

      try{
	      Thread.sleep(500L);    // 1000L = 1000ms = 1 second
      }
      catch (InterruptedException e) {
      }
      
      // start of time/stopwatch
      long start = System.currentTimeMillis();

      // initiazlize score for player 
			int score = 0;

      // goes on until score is 5
		  while (score < 5) {
        // clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        // randomly choose 2 cards
        int card1 = (int)(Math.random()*13); 
        int card2 = (int)(Math.random()*13);

        // again if 2 cards are the same 
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

        // get users guess/choice
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
  
        // If user guess is correct, let user know and add to score
        if (choice == correctAnswer){
          score += 1;
          System.out.println(ANSI_GREEN + "Correct!\n" +ANSI_RESET);

          try {
            Thread.sleep(1000L);
          }
          catch (InterruptedException e){
          }
        }
  
        // If user guess is wrong, let user know and don't add to score
        else {
          System.out.println(ANSI_RED + "Whoops! Correct answer was " + correctAnswer +"\n" + ANSI_RESET);

          try {
            Thread.sleep(1000L);
          }
          catch (InterruptedException e){
          }
        }
        
      }

      // end stopwatch after user's turn is over
      long end = System.currentTimeMillis();

      // find total time
      long length = end - start;

      // add player time to array (-1 because for loop starts at 1)
			playerScores[i-1] = length;
      
		} // end for loop of games
 
    // initialize min with first element of array.  
    long min = playerScores[0];
    
    // loop through the array  
    for (int i = 0; i < playerScores.length; i++) {  
      
      // compare elements of array to find min 
      if(playerScores[i] < min){  
        min = playerScores[i];
      }
    }  

    // initialize winner string and player number
    String winner = "";
    int playerNum = 0;

    // loop through scores to find the corresponding player matching the lowest time
    for (int i = 0; i < playerScores.length; i++){
      if (playerScores[i] == min){
        playerNum = i + 1;
        winner = "Player " + playerNum + " Wins!!!!!";
      }
    } 

    //prints the winner and the time it took the winner to get 5 correct answers in a row
    System.out.println(winner);
    System.out.println("Player " + playerNum + " completed the game in " + (min/1000) + " seconds");
    
  } //end multiplayer ()
} //end GameMode4 class