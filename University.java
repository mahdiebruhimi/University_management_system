public class University {
    protected final int studentNumber;
    protected final int courseNumber;

    public University(int studentNumber, int courseNumber) {
        this.studentNumber = studentNumber;
        this.courseNumber = courseNumber;
    }


    public void setList () {}
    public int getIndex (int value) {return 0;}
    public void display () {
        System.out.println("Number of students: " + studentNumber);
        System.out.println("Number of courses: " + courseNumber);
    }
}