import java.util.*;

public class GradesAnalyzer {

    public ArrayList<Integer> promptForGrades() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.print("How many grades would you like to input? ");
        int numGrades = scanner.nextInt();

        for (int i = 1; i <= numGrades; i++) {
            System.out.print("Enter grade " + i + ": ");
            int grade = scanner.nextInt();
            grades.add(grade);
        }

        System.out.println("Grades entered: " + grades);
        scanner.close();
        return grades;
    }

    public int findHighest(ArrayList<Integer> grades) {
        int highest = Collections.max(grades);
        return highest;
    }

    public int findLowest(ArrayList<Integer> grades) {
        int lowest = Collections.min(grades);
        return lowest;
    }

    public double findAverage(ArrayList<Integer> grades) {
        int sum = 0;
        int size = grades.size();

        // for (int i = 0; i < size; i++) {
        //     sum += grades.get(i);
        // }

        // enhanced for loop
        for (int grade : grades) {
            sum += grade;
        }

        return sum / size;
    }

    public int findNumberPassing(ArrayList<Integer> grades) {
        int count = 0;
        for (int grade : grades) {
            if (grade >= 60) {
                count++;
            }
        }

        return count;
    }

    public boolean overallPassed(double average) {
        return average >= 60;
    }

    public String performance(double average) {
        if (average >= 90) {
            return "Excellent";
        } else if (average >= 80) {
            return "Good";
        } else if (average >= 70) {
            return "Average";
        } else if (average >= 60) {
            return "Passable";
        } else {
            return "Failing";
        }
    }
}
