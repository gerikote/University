package enums;

public enum LectureRoom {
    LECTURE_ROOM_A("Lecture Room A"),
    LECTURE_ROOM_B("Lecture Room B"),
    LECTURE_ROOM_C("Lecture Room C"),
    LECTURE_ROOM_D("Lecture Room D"),
    LECTURE_ROOM_E("Lecture Room E");

    private String roomName;

    LectureRoom(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }
}

