
import java.util.Random;
import java.util.Scanner;

public class AIPlayer extends Player{
	
	AIPlayer(String name,char mark){
		this.name =  name;
		this.mark = mark;
	}
	
	void makeMove() {
		Scanner sc=new Scanner(System.in);
		int row;
		int column;
		do {
				Random r=new Random();
			row=r.nextInt(3);
			column=r.nextInt(3);
		} while(!isValidMove(row,column));
			
		TicTacToe.placeMark(row, column, mark);	
		
	}
}

