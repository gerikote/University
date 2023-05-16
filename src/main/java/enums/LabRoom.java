package enums;

public enum LabRoom {
    LAB_ROOM_A("Lab Room A"),
    LAB_ROOM_B("Lab Room B"),
    LAB_ROOM_C("Lab Room C"),
    LAB_ROOM_D("Lab Room D"),
    LAB_ROOM_E("Lab Room E");

    private String roomName;

    LabRoom(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }
}
