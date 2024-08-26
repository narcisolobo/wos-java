import java.util.Scanner;
import java.util.ArrayList;

public class GradesAnalyzer {

    public ArrayList<Integer> promptForGrades() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.print("How many grades would you like to input? ");
        int numGrades = scanner.nextInt();

        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            int grade = scanner.nextInt();
            grades.add(grade);
        }

        System.out.println("Grades entered: " + grades);
        scanner.close();
        return grades;
    }
}
