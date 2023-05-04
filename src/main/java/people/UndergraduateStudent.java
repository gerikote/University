package people;

import courses.Course;
import exceptions.InvalidAgeException;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameFormatException;
import exceptions.NotEnrolledException;
import interfaces.IStudyable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class UndergraduateStudent extends Student implements IStudyable {
    private static final Logger LOGGER = LogManager.getLogger(UndergraduateStudent.class);
    private int yearLevel;

    public UndergraduateStudent(String firstName, String lastName, String email, String major, int yearLevel, int age) throws InvalidAgeException, InvalidNameFormatException, InvalidEmailException {
        super(firstName, lastName, email, major, age);
        this.yearLevel = yearLevel;
    }

    @Override
    public void study() {
        try {
            if (this.enrolledCourses == null) {
                throw new NotEnrolledException("Student " + getFirstName() + " " + getLastName() + " is not enrolled in any courses");
            }
            LOGGER.info("The grades for student " + getFirstName() + " " + getLastName() + " are :" + getGrades());
            LOGGER.info("The student just spent an entire day studying all his classes");
            for (Course course : super.getGrades().keySet()) {
                int currentGrade = super.getGrades().get(course);
                super.getGrades().put(course, currentGrade + 1);
            }
            LOGGER.info("The new grades for student " + getFirstName() + " " + getLastName() + " are :" + getGrades() + "\n");
        } catch (NotEnrolledException ex) {
            LOGGER.info(ex.getMessage());
        }

    }

    public int getYearLevel() {
        return yearLevel;
    }

    @Override
    public void introduceMyself() {
        LOGGER.info("Hello. My name is " + getFirstName() + ".\n" +
                "I am on the " + getYearLevel() + " year and my major is " + getMajor() + "\n");
    }
}
