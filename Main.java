/* 
Authors: Eshan Khan, Shane Edelstein, and Kaif Morshed
Program Name: Spot-It Game 
Program Description: Making the game called spot-it
Date Created: March 3, 2022
Last edited: March 20, 2022
*/

// Import libraries
import java.util.*; 
import java.util.concurrent.*;

public class Main { // Start class

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

  // global scanner for input
  public static Scanner in = new Scanner(System.in);
  
  public static void main(String[] args) { // start main

    // initialize high scores
    int regularHighScore = 0;
    int timedHighScore = 0; 
    int unlimitedHighScore = 0; 
    
    // initizalize menu choice 
    int choice = 0;

    // loop for menu
    do {

      clear();
      
      // title
    System.out.println(ANSI_RED + "░██████╗██████╗░░█████╗░████████╗  ██╗████████╗██╗\n██╔════╝██╔══██╗██╔══██╗╚══██╔══╝  ██║╚══██╔══╝██║\n╚█████╗░██████╔╝██║░░██║░░░██║░░░  ██║░░░██║░░░██║\n░╚═══██╗██╔═══╝░██║░░██║░░░██║░░░  ██║░░░██║░░░╚═╝\n██████╔╝██║░░░░░╚█████╔╝░░░██║░░░  ██║░░░██║░░░██╗\n╚═════╝░╚═╝░░░░░░╚════╝░░░░╚═╝░░░  ╚═╝░░░╚═╝░░░╚═╝\n" + ANSI_RESET);
      
      // print menu
      System.out.println(ANSI_CYAN + "--------------------------------" + ANSI_RESET);
      System.out.println(ANSI_CYAN + "MAIN MENU"+ ANSI_RESET);
      System.out.println(ANSI_BLUE + "1 - Play Regular Spot it!"+ ANSI_RESET);
      System.out.println(ANSI_BLUE + "2 - Play Timed Spot It!"+ ANSI_RESET);
      System.out.println(ANSI_BLUE + "3 - Play Unlimited Spot It!"+ ANSI_RESET);
			System.out.println(ANSI_BLUE + "4 - Play Multiplayer Spot it!"+ ANSI_RESET);
      System.out.println(ANSI_BLUE + "5 - Rules/Instructions"+ ANSI_RESET);
      System.out.println(ANSI_BLUE + "6 - View Highscores"+ ANSI_RESET);
      System.out.println(ANSI_BLUE + "7 - Exit"+ ANSI_RESET);
      System.out.println(ANSI_CYAN + "--------------------------------" + ANSI_RESET);
      
      System.out.println();

      // ask user for their choice
      System.out.print(ANSI_CYAN + "Enter 1, 2, 3, 4, 5, 6 or 7: "+ ANSI_RESET);
      choice = in.nextInt();

      // ask user again for choice if choice is invalid
      if (choice < 1 || choice > 7){ 
        System.out.println(ANSI_RED + "\n~Please input a valid number~"+ ANSI_RESET);
        choice = in.nextInt();
      }

      // if choice is 1, make user play regular spot it
      else if (choice == 1){

        // run regular spot it from GameMode1 file and save the score
        // GameMode1 regular = new GameMode1();
        int regScore = GameMode1.regular(); 

        // If new highscore, tell user and save the highscore
        if (regScore > regularHighScore){
          clear();
          
          System.out.println(ANSI_RED + "\nGAME OVER" + ANSI_RESET);
          System.out.println(ANSI_GREEN + "NEW HIGHSCORE!!"+ ANSI_RESET);
          System.out.println(ANSI_YELLOW + "You got a score of: " + regScore + ANSI_RESET);
          regularHighScore = regScore;

          delay();
          enter();
        }

        // else just show score
        else{
          clear();
          
          System.out.println(ANSI_RED + "\nGAME OVER" + ANSI_RESET);
          System.out.println(ANSI_YELLOW +"You got a score of: " + regScore + ANSI_RESET);

          delay();
          enter();
        }
        
      }
        
      // if choice is 2, make user play timed spot it
      else if (choice == 2) {

        // run timed spot-it from GameMode2 file and save the score
        GameMode2 timeControl = new GameMode2();
        int timedScore = timeControl.timeControl();

        // if new highscore, tell user and save the highscore
        if (timedScore > timedHighScore){
          clear();
          
          System.out.println(ANSI_RED + "GAME OVER" + ANSI_RESET);
          System.out.println(ANSI_GREEN + "NEW HIGHSCORE!!"+ ANSI_RESET);
          System.out.println(ANSI_YELLOW + "You got a score of: " + timedScore + ANSI_RESET);
          timedHighScore = timedScore;

          delay();
          enter();
        }

        // else just show score
        else{
          clear();
          
          System.out.println(ANSI_RED + "GAME OVER" + ANSI_RESET);
          System.out.println(ANSI_YELLOW + "You got a score of: " + timedScore + ANSI_RESET);

          delay();
          enter();
        }
      }

      // if choice is 3, make user play unlimited spot-it
      else if (choice == 3) { 

        // run unlimited spot-it from GameMode3 file and save the score
        GameMode3 unlimited = new GameMode3();
        int unlimitedScore = unlimited.unlimited();

        // if new highscore, tell user and save the highscore
        if (unlimitedScore > unlimitedHighScore){
          clear();
          
          System.out.println(ANSI_RED + "GAME OVER" + ANSI_RESET);
          System.out.println(ANSI_GREEN + "NEW HIGHSCORE!!"+ ANSI_RESET);
          System.out.println(ANSI_YELLOW + "You got a score of: " + unlimitedScore + ANSI_RESET);
          unlimitedHighScore = unlimitedScore;

          delay();
          enter();
        }

        // else just show score
        else{
          clear();
          
          System.out.println(ANSI_RED + "GAME OVER" + ANSI_RESET);
          System.out.println(ANSI_YELLOW + "You got a score of: " + unlimitedScore + ANSI_RESET);

          delay();
          enter();
        }
      }

      // if choice is 4, make users play multiplayer mode
      else if (choice == 4){
        
        // run multiplayer spot it from GameMode4 file 
        GameMode4 multiplayer = new GameMode4();
        multiplayer.multiplayer();

        delay();
        enter();
      }

      // if choice is 5, show the rules/instructions
      else if (choice == 5){

        // run rules method from the rules file
        Rules rules = new Rules();
        rules.rules(); 
        
        enter();
      }

      // if choice is 5, show highscores
      else if (choice == 6){
        
        clear();
        
        System.out.println(ANSI_GREEN + "\nRegular Mode High Score: " + regularHighScore + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Timed Mode High Score: " + timedHighScore + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Unlimited Mode High Score: " + unlimitedHighScore + ANSI_RESET);

        delay();
        enter();
      }

      // if choice is 7, exit
      else if (choice == 7){
        System.out.println(ANSI_RED + "Exited" + ANSI_RESET);
      }
      
    } while (choice != 7);
  
  } // End main


  
  // Enter to return method
  public static void enter(){
    String enter;
    do {
      System.out.println(ANSI_BLUE +"\nPress enter to return: " + ANSI_RESET);
      in.nextLine();
      enter = in.nextLine();
    } while (!(enter.equals("")));

    System.out.print("\033[H\033[2J");  
    System.out.flush(); 
  } // End enter to return method

  
  // method to delay code
  public static void delay(){
    try {
      TimeUnit.SECONDS.sleep(2);
    }
    catch (InterruptedException e){
    }
  } // end delay method

  
  // method to clear screen
  public static void clear(){
    System.out.print("\033[H\033[2J");  
    System.out.flush();
  } // end clear method
  
} // End class