import java.util.Scanner;

public class MinefieldApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int row = 9;
		int column = 9;
		int mineTotal = 10;
		
		Minefield gameGrid = new Minefield(row, column, mineTotal);
		String play;
		
		do {
			System.out.print("Please insert a row between 1 - " + row + ": ");
			String rowGuess = scan.nextLine();
			int rowInt = Integer.parseInt(rowGuess) - 1;
			System.out.print("Please insert a column between 1 - " + column + ": ");
			String columnGuess = scan.nextLine();
			int columnInt = Integer.parseInt(columnGuess) - 1;
			System.out.print("Do you want to flag the cell or uncover it? (type \"flag\"): ");
			boolean flag = scan.nextLine().equalsIgnoreCase("flag");
			play = gameGrid.uncoverSquare(rowInt, columnInt, flag);
			gameGrid.printField();
		} while (play.equalsIgnoreCase("cont"));

//		gameGrid.uncoverAllSquare(); //test
//		gameGrid.printField();  //test
		scan.close();
	}

}
