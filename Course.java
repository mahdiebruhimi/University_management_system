import java.util.ArrayList;
import java.util.Scanner;

public class Course extends University {
    ArrayList<Integer> courseList = new ArrayList<>();

    public Course(int studentNumber, int courseNumber) {
        super(studentNumber, courseNumber);
    }

    @Override
    public void setList() {
        courseList.add(integerException());
    }

    @Override
    public int getIndex (int value) {
        return courseList.indexOf(value);
    }

    @Override
    public void display () {
        System.out.println("List of all courses:");
        for (int i=0; i<courseNumber; i++) {
            System.out.println((i+1) + ". " + courseList.get(i));
        }
    }

    public static int integerException () {
        Scanner input = new Scanner(System.in);

        int value;
        boolean inputConfirm = false;

        while (!inputConfirm) {
            try {
                value = input.nextInt();
                inputConfirm = true;
                return value;
            }
            catch (Exception e) {
                System.out.println("Please enter an integer number");
                input.nextLine();
            }
        }
        return 0;
    }
}