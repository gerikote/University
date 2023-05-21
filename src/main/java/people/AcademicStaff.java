package people;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import interfaces.*;
import exceptions.*;
import courses.Course;

public final class AcademicStaff extends Staff implements IPayable {
    private static final Logger LOGGER = LogManager.getLogger(AcademicStaff.class);
    private ArrayList<Course> courses;

    public AcademicStaff(String firstName, String lastName, String email, int age) throws InvalidAgeException, InvalidNameFormatException, InvalidEmailException {
        super(firstName, lastName, email, age);
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public void introduceMyself() {
        LOGGER.info("Hello. My name is Professor " + getFirstName() + ".\n" +
                "and i teach the classes " + courses.toString() + "\n");
    }

    @Override
    public double calculateWage() {
        double bonus = courses.size() * COURSE_BONUS;
        double totalWage = BASE_WAGE + bonus;
        LOGGER.info("The professor's " + getFirstName() + " " + getLastName() + " is " + totalWage + "$"
                + "\n" + "Base pay is " + BASE_WAGE + "$" + " and courses bonus is " + bonus + "$");
        return totalWage;
    }
}


