import java.util.InputMismatchException;
import java.util.Scanner;

class TicTacToe{
	static char[][] board;
	
	public TicTacToe() {
		board=new char[3][3];
		initBoard();
	}
	  // FUNTION TO PROVIDE EMPTY CHARACTER 
	void initBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';	
			}
		}
	}
	// FUNCTION TO DISPLAY BOARD
	static void dispBoard() {
		System.out.println("-------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	// FUNCTION TO PLACE A MARK
	static void placeMark(int row,int column,char mark) {
		if(row>=0 && row<=2 && column>=0 && column<=2) {
			board[row][column]=mark;
		}
		else {
			System.out.println("invalid position");
		}
	}
	// FUNCTION TO CHECK COLUMN
	static boolean checkColumnWin() {
		for(int j=0;j<=2;j++) {
			if(board[0][j] !=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
				return true;
			}
		}
		return false;
	}
	// FUNCTION TO CHECK ROW
	static boolean checkRowWin() {
		for(int i=0;i<=2;i++) {
			if(board[i][0] !=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) {
				return true;
			}
		}
		return false;
	}
		//FUNCTION TO CHECK DIAGONAL
	static boolean checkDiagWin() {
		
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] 
				|| 	board[0][2] !=' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0] ) {
			return true;
		}else {
			return false;
		}
	}

	static boolean checkDraw() {
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				if(board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}

public class LaunchGame {
	
	public static void main(String[] args) {
	  try {
		  TicTacToe tictactoe=new TicTacToe();
		  System.out.println("HEY THERE! HAVE FUN ): ");
		  System.out.println("SELECT OPTION 1 TO PLAY WITH FRIENDS OR SELECT OPTION 2 TO PLAY  WITH COMPUTER AI");

		  Scanner sc=new Scanner(System.in);
		  int select=sc.nextInt();
		  // GIVING OPTIONS TO USER ,WHETHER TO PLAY WITH FRIENDS OR AI.

		  if(select==1) { HumanPlayer humanplayer1= new HumanPlayer("BGR",'X');
		   HumanPlayer humanplayer2= new HumanPlayer("2nd person",'O');
		   
		   Player HvsH;
		   HvsH=humanplayer1;
		   
		   while(true) {
			  System.out.println(HvsH.name + " turn");
			  HvsH.makeMove();
			   TicTacToe.dispBoard();
			   if(TicTacToe.checkColumnWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()) {
				   System.out.println(HvsH.name + " has won");
				   break;
			   }
			   else {
				   if(HvsH == humanplayer1) {
					   HvsH=humanplayer2;
				   }
				   else {
					   HvsH=humanplayer1;
				   }
			   }
		  }
		  }
		
		  else if(select==2) { 
		
			  HumanPlayer humanplayer= new HumanPlayer("BGR",'X');
			  AIPlayer AI=new AIPlayer("AI", '0');
			   
			   Player HvsAI;
			   HvsAI=humanplayer;
			   
			  while(true) {
				  System.out.println(HvsAI.name + " turn");
				  HvsAI.makeMove();
				   TicTacToe.dispBoard();
				   if(TicTacToe.checkColumnWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin() ) {
					   System.out.println(HvsAI.name + " has won");
					   break;
				   }
				   else if(TicTacToe.checkDraw()) {
					   System.out.println("Game is  a Draw! play again.");
				   }
				   else {
					   if(HvsAI == humanplayer) {
						   HvsAI=AI;
					   }
					   else {
						   HvsAI=humanplayer;
					   }
				   }
			  }
		  }
		  else {
			  System.out.println("Wrong Input ! Select 1 or 2");
		  }
	  }
		  catch(InputMismatchException e) {
			  System.out.println("please select only numbers between 0-2,TQ );");
		  }
	  		catch(Exception e) {
	  			System.out.println("UNKNOWN ERROR OCCURED");
	  		}
	}
}
