package enums;

import people.AdministrativeStaff;

public enum AdministrativeResponsibility {
    LAB_ASSISTANCE("Preparing lav equipment"),
    ADMISSIONS("Handling admissions process"),
    STUDENT_RECORDS("Managing student records"),
    FINANCIAL_AID("Administering financial aid programs"),
    ACADEMIC_ADVISORY("Providing academic advisory services"),
    EVENTS_COORDINATION("Coordinating campus events"),
    FACILITIES_MANAGEMENT("Overseeing facilities management"),
    MARKETING_AND_COMMUNICATIONS("Managing marketing and communications"),
    IT_SUPPORT("Providing IT support to staff and students"),
    HR_MANAGEMENT("Handling human resources management"),
    BUDGET_PLANNING("Managing budget planning");

    private String responsibilityDescription;

    AdministrativeResponsibility(String responsibilityDescription) {
        this.responsibilityDescription = responsibilityDescription;
    }

    public String getResponsibilityDescription() {
        return responsibilityDescription;
    }
}
