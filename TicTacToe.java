import java.util.Scanner;              // For creating Scanner object
import java.util.Arrays;

public class TicTacToe
{  
   // Main method
   public static void main(String[] args)       
   {
      // Scanner for reading name and square selection
      Scanner scn = new Scanner(System.in);
   
      int round = 0;        // SHOULD BE IN THE FOR LOOP!! Doesn't work tho
      char answer;          // Stores a character at line 138                
      
      // Introduction to Tic-Tac-Toe - called from method
      introduction();
      
      // Ask for player names
      System.out.print("Player 1 enter your name: ");
      String p1 = scn.nextLine();
      System.out.print("Player 2 enter your name: ");
      String p2 = scn.nextLine();
      
      int score1 = 0;                                            // Stores score of player 1
      int score2 = 0;                                            // Stores score of player 2
      
      // do-while loop to start game from scratch while keeping scores and continue as long as anotherGame == true 
       do{
           int row = 0;                                          // row index for a square
           int column = 0;                                       // Column index for a square
           int line = 0;                                         // Row or column index in checking loop
           int choice = 0;                                       // Square selection number
           int winner = 0;                                       // The winning player
           int player = 0;                                       // Player number - 1 or 2
           
           char[][] board = new char[][] {                       // The board                 
                                    {'1', '2', '3'},             // Initial values are reference numbers used
                                    {'4', '5', '6'},             // to select a vacant square for a turn.
                                    {'7', '8', '9'}               
                                          };     

           // Main game loop. Continues for up to 9 turns or until a winner is found
           for( round = 0; round < 9 && winner == 0 ; round++)
           {
             // Displays the board
             System.out.print("\n\n");
             System.out.printf(" %c | %c | %c\n", board[0][0], board[0][1], board[0][2]); 
             System.out.println("---+---+---");
             System.out.printf(" %c | %c | %c\n", board[1][0], board[1][1], board[1][2]); 
             System.out.println("---+---+---");
             System.out.printf(" %c | %c | %c\n", board[2][0], board[2][1], board[2][2]); 
             
             player = round % 2 + 1;                           // Selects player 1, or 2, depending on turn number
                               
             System.out.printf("\nYour turn %s, please enter the number of the square " + 
                                                                "where you want to place your %c: ", 
                                                               (player == 1) ? p1 : p2, (player == 1) ? 'X' : 'O');
             choice = scn.nextInt();
             row = --choice/3;                            // Get row index of square
             column = choice%3;                           // Get column index of square
                           // Insert player symbol in specified square number
           
             board[row][column] = (player == 1) ? 'X' : 'O';

             // Check for a winning diagonal line
             if((board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
		          (board[0][2] == board[1][1] && board[0][2] == board[2][0]))
             {
		          winner = player;
             }
             else // Check rows and columns for winning line
             {  
                for(line = 0; line <= 2; line++)
                {  
                   if((board[line][0] == board[line][1] && board[line][0] == board[line][2]) ||
				          (board[0][line] == board[1][line] && board[0][line] == board[2][line]))
                   { 
				          winner = player;
                   }
                }                  
             }
           }
           
           // Game over - display final board
           System.out.print("\n\n");
           System.out.printf(" %c | %c | %c\n", board[0][0], board[0][1], board[0][2]); 
           System.out.println("---+---+---");
           System.out.printf(" %c | %c | %c\n", board[1][0], board[1][1], board[1][2]); 
           System.out.println("---+---+---");
           System.out.printf(" %c | %c | %c\n", board[2][0], board[2][1], board[2][2]);
           
           // Display result message
           if(winner == 0)
           {
              System.out.println("\nThe game ended in a draw.\n");
           }
           else 
           {  
              System.out.printf("\nCongratulations, %s, you have won the game!", (player == 1) ? p1 : p2);
              switch(winner)     // Increase score of the winner
              {
                 case 1:         // Player 1
                   score1++;
                   break;
                 
                 case 2:         // Player 2
                   score2++;
                   break;
              }
           } 
           
           // Display scores for both players
           System.out.printf("\n%s has won %d games, while %s has won %d games.", p1, score1, p2, score2);
           
           // Ask for rematch
           System.out.println("\nDo you wish to play again (Y/N)?");
           
           // Get rid of "Enter" in input buffer
           scn.nextLine();          
                             
           // Records if another game is to be played
           String anotherGame = scn.nextLine();
              
           answer = anotherGame.charAt(0);
          
      // Check whether another game is to be played
      }while(answer == 'Y' || answer == 'y');
                  
   }
   
   // Introduction stored in method so as not to clutter main method too much
   public static void introduction()
   {
      System.out.print("Welcome to Tic-Tac-Toe, the game is made for ");
      System.out.println("two players and is very simple.");
      System.out.print("A board consisting of nine squares will be displayed ");
      System.out.println("and the player whose turn it is will be asked which square to fill.");
      System.out.print("The player who fills three squares diagonally, vertically, or horizontally ");
      System.out.println("with their own symbol will be declared the winner and the game will end.");
      System.out.print("However, it is possible to end the game in a draw as ");
      System.out.println("if no player fills three squares correctly.\n");
   
   }
}
