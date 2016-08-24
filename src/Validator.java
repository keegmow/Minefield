import java.util.Scanner;

public class Validator {
	public static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            }
            else {
                System.out.println("Error! Please Enter Valid number.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(sc, prompt);
            if (i < min)
                System.out.println(
                    "Error! Number must be greater than " + (min - 1) + ".");
            else if (i > max)
                System.out.println(
                    "Error! Number must be less than " + (max + 1) + ".");
            else
                isValid = true;
        }
        return i;
}

}
