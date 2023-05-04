package people;

import exceptions.*;
import interfaces.IStudyable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GraduateStudent extends Student implements IStudyable {
    private static final Logger LOGGER = LogManager.getLogger(GraduateStudent.class);
    private String thesisTopic;
    private int thesisProgress;

    public GraduateStudent(String firstName, String lastName, String email, String major, String thesisTopic, int age) throws InvalidAgeException, InvalidNameFormatException, InvalidEmailException {
        super(firstName, lastName, email, major, age);
        this.thesisTopic = thesisTopic;
        this.thesisProgress = 30;
    }

    @Override
    public void study() {
        printThesisProgress();
        if (thesisProgress < MAX_THESIS_PROGRESS) {
            thesisProgress += THESIS_PROGRESSION;
        }
        LOGGER.info("The student spent 1 hour studying!" + "\n"
                + "After the session the progress is at " + thesisProgress + "%" + "\n");

    }

    public void printThesisProgress() {
        LOGGER.info("The student " + super.getFirstName() + " " + super.getLastName() +
                " progress at his thesis is currently at " + thesisProgress + "%");
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

    @Override
    public void introduceMyself() {
        LOGGER.info("Hello. My name is " + getFirstName() + ".\n" +
                "My major is " + getMajor() + " and my thesis topic is " + getThesisTopic() + "\n");
    }
}
