import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the number of students:");
        int studentNumber = integerException();

        System.out.println("Please enter the number of courses:");
        int courseNumber = integerException();

        University university = new University(studentNumber, courseNumber);
        Student student = new Student(studentNumber, courseNumber);
        Course course = new Course(studentNumber, courseNumber);
        Grade grade = new Grade(studentNumber, courseNumber);

        grade.setGradeList(); // set all arraylist index's by zero;

        System.out.println("Please select the item you want:\naddStudent | addCourse | addGrade | display | exit");
        String menuItem = input.next();
        boolean nonRepeatStudent = false;
        boolean nonRepeatCourse = false;

        while (!menuItem.equals("exit")) {
            switch (menuItem) {
                case "addStudent":
                    if (!nonRepeatStudent) {
                        for (int i=0; i<studentNumber; i++) {
                            System.out.println("Enter student " + (i+1) + " ID:");
                            student.setList();
                        }
                        System.out.println("Students have been successfully added to the system.");
                    }
                    else {
                        System.out.println("The student ID has already been entered.");
                    }

                    nonRepeatStudent = true;
                    break;

                case "addCourse":
                    if (!nonRepeatCourse) {
                        for (int i=0; i<courseNumber; i++) {
                            System.out.println("Enter course " + (i+1) + " ID:");
                            course.setList();
                        }
                        System.out.println("Courses have been successfully added to the system.");
                    }
                    else {
                        System.out.println("Course ID is already entered.");
                    }

                    nonRepeatCourse = true;
                    break;

                case "addGrade":
                    System.out.println("Enter the student ID to register the grade:");
                    int stdIndex = student.getIndex(integerException());

                    System.out.println("To register the grade, enter the course ID:");
                    int courseIndex = course.getIndex(integerException());

                    System.out.println("Enter the grade:");
                    grade.setList(stdIndex, courseIndex);

                    System.out.println("The grade was successfully registered in the system.");
                    break;

                case "display":
                    System.out.println("Select the desired option to display:\nnumber(for number of students and courses) | highestGrade | allGrades | allStudents | allCourses | exit(from this menu)");
                    String sumMenuItem = input.next();

                    while (!sumMenuItem.equals("exit")) {
                        switch (sumMenuItem) {
                            case "number":
                                university.display();
                                break;

                            case "highestGrade":
                                System.out.println("Please enter the desired course ID to display the highest grade:");
                                int maxCourseId = integerException();
                                int maxStdIndex = grade.display(course.getIndex(maxCourseId));
                                System.out.println("stdID:\tgrade:");
                                System.out.println(student.studentList.get(maxStdIndex) + "\t" + grade.gradeList[maxStdIndex].get(course.getIndex(maxCourseId)));
                                break;

                            case "allGrades":
                                System.out.println("Please enter the desired course ID to display students' grades:");
                                int courseId = integerException();
                                System.out.println("Grades of students in course " + courseId + ":");
                                for (int i=0; i<studentNumber; i++) {
                                    System.out.print(student.studentList.get(i) + ": ");
                                    grade.display(i, course.getIndex(courseId));
                                }
                                break;

                            case "allStudents":
                                if (!nonRepeatStudent) {
                                    System.out.println("No students have been added.");
                                }
                                else {
                                    student.display();
                                }
                                break;

                            case "allCourses":
                                if (!nonRepeatCourse) {
                                    System.out.println("No courses have been added.");
                                }
                                else {
                                    course.display();
                                }
                                break;

                            default:
                                System.out.println("The chosen option is not correct.");
                                break;
                        }

                        System.out.println("Select the desired option to display:\nnumber(for number of students and courses) | highestGrade | allGrades | allStudents | allCourses | exit(from this menu)");
                        sumMenuItem = input.next();
                    }
                    break;

                default:
                    System.out.println("Please choose the appropriate option.");
                    break;
            }

            System.out.println("Please select the item you want:\naddStudent | addCourse | addGrade | display | exit");
            menuItem = input.next();
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
                System.out.println("Please enter an integer number:");
                input.nextLine();
            }
        }
        return 0;
    }
}