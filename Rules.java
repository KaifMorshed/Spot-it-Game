// import libraries
import java.util.concurrent.*;
import java.util.*;

public class Rules { //start class Rules

  //import colours
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public void rules() { // start rules() method

    // scanner for input
    Scanner in = new Scanner(System.in);

    // clear screen
    System.out.print("\033[H\033[2J");  
    System.out.flush();

    // instructions for regular spot-it
    System.out.println(ANSI_BLUE + "How to play Regular Spot-It:"+ ANSI_RESET + ANSI_CYAN + "\n1. Two cards with 4 values will appear and you must decide which one character is common between both\n2. You will have 7 trials\n3. Get as many correct within those 7 trials.\n" + ANSI_RESET); 

    // delay printing
    try {
      TimeUnit.SECONDS.sleep(2);
      }
    catch (InterruptedException e){
      }

    // instructions for timed spot-it
    System.out.println(ANSI_BLUE + "How to play Timed Spot-It:" + ANSI_RESET + ANSI_CYAN +"\n1. Two cards with 4 values will appear and you must choose the common character before the timer runs out.\n2. You will have 30 seconds to get as many correct as possible.\n3. For each correct answer, you will get points.\n" + ANSI_RESET);

    // delay code
    try {
      TimeUnit.SECONDS.sleep(2);
    }
    catch (InterruptedException e){
    }

    // instructions for unlimited spot-it
    System.out.println(ANSI_BLUE + "How To Play Unlimited Spot-It:"+ANSI_RESET + ANSI_CYAN + "\n1. Two cards with 4 values will appear and you must choose the common character before the time runs out.\n2. There is an endless number of turns allowing you to play forever. \n3. Every 5 rounds, you will be prompted to end the game and return you to the main menu. \n4. You will be given a score for how many correct answers you achieve\n" + ANSI_RESET);

    // delay code
    try {
      TimeUnit.SECONDS.sleep(2);
    }
    catch (InterruptedException e){
    }

    // instructions for multiplayer spot-it
    System.out.println(ANSI_BLUE + "How To Play Multiplayer Spot-It:" + ANSI_RESET + ANSI_CYAN + "\n1. You must enter how many players will participate in the game of spot it. \n2. Player 1's cards will appear after a countdown. \n3. After getting 5 correct, the next players cards will be displayed after a 3 second countdown. \n4. Each player will be timed to see how long it takes to get 5 correct answers.\n5. After each player has finished their turns, the winner will be declared based on who finished the quickest, and their time will be displayed." );

    // delay code
    try {
      TimeUnit.SECONDS.sleep(2);
    }
    catch (InterruptedException e){
    }
  } //end rules()
  
} //end Rules class