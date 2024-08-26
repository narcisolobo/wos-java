import java.util.ArrayList;

public class TestGradesAnalyzer {
    public static void main(String[] args) {
        GradesAnalyzer analyzer = new GradesAnalyzer();
        ArrayList<Integer> grades = analyzer.promptForGrades();
    }
}
