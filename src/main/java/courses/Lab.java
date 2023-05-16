package courses;

import enums.LabRoom;
import people.Staff;

public class Lab extends Course {
    private Staff labAssistant;
    public LabRoom labRoom;

    public Lab(String courseCode, String courseName, Staff labAssistant, LabRoom labRoom) {
        super(courseCode, courseName);
        this.labAssistant = labAssistant;
        this.labRoom=labRoom;
    }

    public Staff getLabAssistant() {
        return labAssistant;
    }

    public void setLabAssistant(Staff labAssistant) {
        this.labAssistant = labAssistant;
    }
}
