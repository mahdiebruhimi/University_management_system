import java.util.ArrayList;
import java.util.Scanner;

public class Grade extends Student {
    public Grade (int studentNumber, int courseNumber) {
        super(studentNumber, courseNumber);
    }

    ArrayList <Double> [] gradeList = new ArrayList[studentNumber];

    public void setGradeList () {
        for (int i=0; i<studentNumber; i++) {
            gradeList[i] = new ArrayList<>();
            for (int j=0; j<courseNumber; j++) {
                gradeList[i].add(j, 0.0);
            }
        }
    }

    public void setList (int i, int j) {
        gradeList[i].add(j, doubleException());
    }

    public void display (int stdIndex, int courseIndex) {
        System.out.println(gradeList[stdIndex].get(courseIndex));
    }

    public int display(int courseIndex) {
        double maxGrade = 0;
        int maxGradeStdId = -1;
        for (int i=0; i<studentNumber; i++) {
            if (gradeList[i].get(courseIndex) > maxGrade) {
                maxGrade = gradeList[i].get(courseIndex);
                maxGradeStdId = i;
            }
        }
        return maxGradeStdId;
    }

    public static double doubleException () {
        Scanner input = new Scanner(System.in);

        double value;
        boolean inputConfirm = false;

        while (!inputConfirm) {
            try {
                value = input.nextDouble();
                inputConfirm = true;
                return value;
            }
            catch (Exception e) {
                System.out.println("Please enter a double number:");
                input.nextLine();
            }
        }
        return 0;
    }
}