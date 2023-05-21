package courses;

import enums.LectureRoom;
import people.Staff;

public class Lecture extends Course {
    private Staff lecturer;
    private LectureRoom lectureRoom;

    public Lecture(String courseCode, String courseName, Staff lecturer, LectureRoom lectureRoom) {
        super(courseCode, courseName);
        this.lecturer = lecturer;
        this.lectureRoom = lectureRoom;
    }

    public Staff getLecturer() {
        return lecturer;
    }

    public void setLecturer(Staff lecturer) {
        this.lecturer = lecturer;
    }
}
