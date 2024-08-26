import java.util.ArrayList;

public class TestGradesAnalyzer {
    public static void main(String[] args) {
        GradesAnalyzer analyzer = new GradesAnalyzer();
        ArrayList<Integer> grades = analyzer.promptForGrades();

        int highest = analyzer.findHighest(grades);
        System.out.printf("The highest grade is: %d.\n", highest);
        String message = highest >= 90 ? "Great job!" : "Keep trying!";
        System.out.println(message);

        int lowest = analyzer.findLowest(grades);
        System.out.printf("The lowest grade is: %d.\n", lowest);

        double average = analyzer.findAverage(grades);
        System.out.printf("The average grade is: %.2f.\n", average);

        int numPassing = analyzer.findNumberPassing(grades);
        System.out.printf("The number of passing students is: %d.\n", numPassing);

        boolean overallPassed = analyzer.overallPassed(average);
        if (overallPassed) {
            System.out.println("The class passed!");
        } else {
            System.out.println("The class did not pass.");
        }

        String performance = analyzer.performance(average);
        System.out.println(performance);
    }
}
