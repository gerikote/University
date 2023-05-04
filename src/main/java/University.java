
import courses.Course;
import interfaces.IRevenueCalculatable;
import people.Staff;
import people.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import genericLinkedList.GenericLinkedList;
import java.util.ArrayList;

public class University implements IRevenueCalculatable {
    private static final Logger LOGGER = LogManager.getLogger(University.class);
    private final String name;
    private String address;
    private GenericLinkedList<Student> students;
    private GenericLinkedList<Staff> staff;
    private GenericLinkedList<Course> courses;

    public University(String name, String address) {
        this.name = name;
        this.address = address;
        this.students = new GenericLinkedList<>();
        this.staff = new GenericLinkedList<>();
        this.courses = new GenericLinkedList<>();

    }

    public void addStudent(Student student) {
        this.students.addFirst(student);
    }

    public void dropoutStudent(Student student) {
        boolean removed = students.remove(student);
        if (removed) {
            LOGGER.info("Student " + student.getFirstName() +" " + student.getLastName() + " has been dropped out of the university.");
        } else {
            LOGGER.info("Student " + student.getFirstName() + " " + student.getLastName() + " was not found in the university.");
        }
    }

    public void addStaff(Staff staffMember) {
        this.staff.addFirst(staffMember);
    }

    public void addCourse(Course course) {
        this.courses.addFirst(course);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GenericLinkedList<Student> getStudents() {
        return students;
    }

    public GenericLinkedList<Staff> getStaff() {
        return staff;
    }

    public GenericLinkedList<Course> getCourses() {
        return courses;
    }

    @Override
    public double getRevenue() {
        double totalRev = 0;
        for (int i = 0; i < courses.size(); i++) {
            totalRev += courses.get(i).TUITION;
        }
        LOGGER.info("The total revenue for the University is : " + totalRev + "$");
        return totalRev;
    }

    public void printDetails() {
        LOGGER.info("Welcome to " + getName() + "\n"
                + "Our university is located in " + getAddress() + "\n"
                + "The courses we offer are : " + getCourses() + "\n"
                + "Our wonderful staff includes our teachers : " + getStaff() + "\n");
    }
}


