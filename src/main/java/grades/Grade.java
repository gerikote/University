package grades;

import people.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Grade {
    private static final Logger LOGGER = LogManager.getLogger(Grade.class);
    private GradeCalculator gradeCalulator;

    public Grade() {
        this.gradeCalulator = new GradeCalculator();
    }

    public int calculateGPA(Student student) {
        LOGGER.info("The student's" + student.getFirstName() + " " + student.getLastName() + " gpa is : ");
        return gradeCalulator.calculateGrade(student);
    }

    public void setGradeCalulator(GradeCalculator gradeCalulator) {
        this.gradeCalulator = gradeCalulator;
    }
}

