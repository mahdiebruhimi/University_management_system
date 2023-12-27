import java.util.ArrayList;
import java.util.Scanner;

public class Student extends University {
    public Student (int studentNumber, int courseNumber) {
        super(studentNumber, courseNumber);
    }
    ArrayList<Integer> studentList = new ArrayList<>();

    @Override
    public void setList() {
        studentList.add(integerException());
    }

    @Override
    public int getIndex (int value) {
        return studentList. indexOf(value);
    }

    @Override
    public void display () {
        System.out.println("List of all students:");
        for (int i=0; i<studentNumber; i++) {
            System.out.println((i+1) + ". " + studentList.get(i));
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