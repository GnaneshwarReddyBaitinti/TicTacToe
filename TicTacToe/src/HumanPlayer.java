
import java.util.Scanner;

abstract class Player{
	String name;
	char mark;
	
	abstract void makeMove();
	//FUNCTION TO TEST THE GIVEN INPUT
	boolean isValidMove(int row,int column) {
		if(row >=0 && row<=2 &&
				column >=0 && column <=2) {
			if(TicTacToe.board[row][column] == ' ') {
				return true;
			}
		}
		return false;
	}
}

public class HumanPlayer extends Player {
	
	HumanPlayer(String name,char mark){
		this.name =  name;
		this.mark = mark;
	}
	//FUNCTION TO  MOVE THE CHAR INTO BOARD
	void makeMove() {
		Scanner sc=new Scanner(System.in);
		int row;
		int column;
		do {
			System.out.println("Enter the Row and Column");
			 row=sc.nextInt();
			 column=sc.nextInt();
		} while(!isValidMove(row,column));
			
		TicTacToe.placeMark(row, column, mark);		
	}	
}

