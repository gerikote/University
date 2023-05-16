package people;

import enums.AdministrativeResponsibility;
import exceptions.InvalidAgeException;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameFormatException;
import interfaces.IPayable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public final class AdministrativeStaff extends Staff implements IPayable {
    private static final Logger LOGGER = LogManager.getLogger(AcademicStaff.class);
    private ArrayList<AdministrativeResponsibility> responsibilities;

    public AdministrativeStaff(String firstName, String lastName, String email, int age) throws InvalidAgeException, InvalidNameFormatException, InvalidEmailException {
        super(firstName, lastName, email, age);
        this.responsibilities = new ArrayList<>();
    }

    public ArrayList<AdministrativeResponsibility> getResponsibilities() {
        return responsibilities;
    }

    public void addResponsisbility(AdministrativeResponsibility responsibility) {
        this.responsibilities.add(responsibility);
    }

    @Override
    public void introduceMyself() {
        LOGGER.info("Hello. My name is " + firstName + " and i am part of the administrative staff. " + "\n"
                + "My responsibilities are " + responsibilities.toString() + "\n");
    }

    @Override
    public double calculateWage() {
        double bonus = RESPONSIBILITY_BONUS * (responsibilities.size());
        double totalWage = BASE_WAGE + bonus;
        LOGGER.info("The staff member's " + firstName + " " + lastName + " total wage is " + totalWage + "$"
                + "\n" + "Base pay is " + BASE_WAGE + "$" + " and responsibility bonus is " + bonus + "$");
        return totalWage;
    }
}


