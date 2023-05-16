package people;

import enums.Major;
import enums.ThesisTopic;
import exceptions.*;
import interfaces.IStudyable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GraduateStudent extends Student implements IStudyable {
    private static final Logger LOGGER = LogManager.getLogger(GraduateStudent.class);
    private ThesisTopic thesisTopic;
    private int thesisProgress;

    public int getThesisProgress() {
        return thesisProgress;
    }

    public GraduateStudent(String firstName, String lastName, String email, Major major, ThesisTopic thesisTopic, int age) throws InvalidAgeException, InvalidNameFormatException, InvalidEmailException {
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

    public ThesisTopic getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(ThesisTopic thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

    @Override
    public void introduceMyself() {
        LOGGER.info("Hello. My name is " + getFirstName() + ".\n" +
                "My major is " + getMajor() + " and my thesis topic is " + getThesisTopic() + "\n");
    }
}
