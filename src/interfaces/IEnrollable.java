package interfaces;

import exceptions.*;
import people.*;

public interface IEnrollable {
    int MAX_STUDENTS = 25;

    void enrollStudent(Student student) throws MaxStudentsReachedException;

    void dropoutStudent(Student student);
}

