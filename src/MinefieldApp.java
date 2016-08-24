import java.util.Scanner;


public class MinefieldApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int row = 0;
		int column = 0;
		int mineTotal = 0;
		String again = "y";
		while (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("yes"))
		{
		System.out.println("Please select difficulty : Beginner(B)/ Intermediate(I) / Expert (E)");
		String level = scan.nextLine();
		if (level.equalsIgnoreCase("B"))
		{
			row = 9;
			column = 9;
			mineTotal = 10;
			System.out.println("There are 10 mines to flag, Good Luck!");
		}
		if (level.equalsIgnoreCase("I"))
		{
			row = 16;
			column = 16;
			mineTotal = 40;
			System.out.println("There are 40 mine to flag, Good Luck!");
		}
		if (level.equalsIgnoreCase("E"))
		{
			row = 16;
			column = 30;
			mineTotal = 99;
			System.out.println("There are 99 mine to flag, Good Luck!");
		}
		Minefield gameGrid = new Minefield(row, column, mineTotal);
		String play;
			do {
				int columnInt = Validator.getInt(scan, "Please insert a column between 1 - " + column + ": ", 1, column)-1;
				int rowInt = Validator.getInt(scan, "Please insert a row between 1 - " + row + ": ", 1, row)-1;
				System.out.print("Do you want to flag/unflag the cell? (type y/n)");
				boolean flag = scan.nextLine().equalsIgnoreCase("y");
				play = gameGrid.uncoverSquare(rowInt, columnInt, flag);
				gameGrid.printField();
			}while (play.equalsIgnoreCase("cont"));
			
		if (play.equalsIgnoreCase("Win"))
		{
			System.out.println("CONGRATULATIONS you have won!!");
		}
		if (play.equalsIgnoreCase("Loss"))
		{
			System.out.println("Ouch you hit a bomb! you lose");
		}
		System.out.println("Would you like to play again (y/n)");
		again = scan.nextLine();
		}
		System.out.println("Thank You for Playing");

//		gameGrid.uncoverAllSquare(); //test
//		gameGrid.printField();  //test
		scan.close();
	}

}
