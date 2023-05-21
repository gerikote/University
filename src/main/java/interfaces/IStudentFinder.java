package interfaces;

import people.Student;

@FunctionalInterface
public interface IStudentFinder<T extends Student> {
    T findStudent(String studentId);
}
