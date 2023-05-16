package enums;

public enum Major {
    COMPUTER_SCIENCE("Computer Science"),
    ELECTRICAL_ENGINEERING("Electrical Engineering"),
    BUSINESS_ADMINISTRATION("Business Administration"),
    PSYCHOLOGY("Psychology"),
    BIOLOGY("Biology"),
    ENGLISH("English"),
    HISTORY("History"),
    MATHEMATICS("Mathematics"),
    PHYSICS("Physics"),
    CHEMISTRY("Chemistry");

    private String majorName;

    Major(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorName() {
        return majorName;
    }
}
