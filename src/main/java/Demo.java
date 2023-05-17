
import courses.*;
import enums.*;
import exceptions.*;
import grades.Grade;
import interfaces.IEntityFilter;
import interfaces.IStudentFinder;
import interfaces.IWageComparator;
import people.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Demo {
    private static final Logger LOGGER = LogManager.getLogger(Demo.class.getName());

    public static void main(String[] args) {
        //Creating an object of University class
        University university = new University("National Technical University of Athens", "Athens,Zografu");

        //Declare student variables outside of try block
        GraduateStudent graduate1 = null;
        GraduateStudent graduate2 = null;
        GraduateStudent graduate3 = null;
        UndergraduateStudent undergraduate1 = null;
        UndergraduateStudent undergraduate2 = null;
        UndergraduateStudent undergraduate3 = null;

        try {
            //Creating Graduate Students
            graduate1 = new GraduateStudent("John", "Brown", "johnbrown@gmail.com", Major.BIOLOGY, ThesisTopic.ROBOTICS, 22);
            graduate2 = new GraduateStudent("Maria", "Foss", "mfos@gmail.com", Major.COMPUTER_SCIENCE, ThesisTopic.CYBERSECURITY, 18);
            graduate3 = new GraduateStudent("Ryan", "Creed", "rcreed@gmail.com", Major.ELECTRICAL_ENGINEERING, ThesisTopic.CLOUD_COMPUTING, 45);

            //Creating Undergraduate Students
            undergraduate1 = new UndergraduateStudent("Diego", "Gonazalez", "dgonzalez@gmail.com", Major.BIOLOGY, 1, 23);
            undergraduate2 = new UndergraduateStudent("Ivan", "Gonazalez", "Igonzalez@gmail.com", Major.CHEMISTRY, 2, 20);
            undergraduate3 = new UndergraduateStudent("Chris", "White", "cwhite@gmail.com", Major.BUSINESS_ADMINISTRATION, 4, 21);
        } catch (InvalidAgeException | InvalidNameFormatException | InvalidEmailException ex) {
            LOGGER.info(ex.getMessage());
        }

        //Adding undergraduate students to an ArrayList
        ArrayList<UndergraduateStudent> undergraduateStudents = new ArrayList<>();
        undergraduateStudents.add(undergraduate1);
        undergraduateStudents.add(undergraduate2);
        undergraduateStudents.add(undergraduate3);

        //Adding students to University
        university.addStudent(graduate1);
        university.addStudent(graduate2);
        university.addStudent(graduate3);
        university.addStudent(undergraduate1);
        university.addStudent(undergraduate2);
        university.addStudent(undergraduate3);

        //Adding students to an ArrayList
        ArrayList<Student> students = new ArrayList<>();
        students.add(graduate1);
        students.add(graduate2);
        students.add(graduate3);
        students.add(undergraduate1);
        students.add(undergraduate2);
        students.add(undergraduate3);

        //Declare staff variables outside of try block
        AcademicStaff professor1 = null;
        AcademicStaff professor2 = null;
        AcademicStaff professor3 = null;

        AdministrativeStaff adminStaff1 = null;
        AdministrativeStaff adminStaff2 = null;
        AdministrativeStaff adminStaff3 = null;
        AdministrativeStaff labAs1 = null;
        AdministrativeStaff labAs2 = null;

        try {
            //Creating Academic Staff
            professor1 = new AcademicStaff("Clayton", "Tumblerson", "ctamp@gmail.com", 23);
            professor2 = new AcademicStaff("Tom", "Mullins", "tmullins@gmail.com", 23);
            professor3 = new AcademicStaff("Andrew", "Richards", "arichards@gmail.com", 19);

            //Creating administrative Staff
            adminStaff1 = new AdministrativeStaff("Tara", "Flowers", "tflowers@gmail.com", 54);
            adminStaff2 = new AdministrativeStaff("Jack", "Ford", "jford@gmail.com", 65);
            adminStaff3 = new AdministrativeStaff("John", "Wig", "jwigg@gmail.com", 76);
            labAs1 = new AdministrativeStaff("Carl", "Wig", "carl@gmail.com", 29);
            labAs2 = new AdministrativeStaff("Nick", "Wig", "nickw@gmail.com", 35);

        } catch (InvalidAgeException | InvalidNameFormatException | InvalidEmailException ex) {
            System.out.println(ex.getMessage());
        }

        //Adding responsibilities for admin staff
        adminStaff1.addResponsisbility(AdministrativeResponsibility.ADMISSIONS);
        labAs1.addResponsisbility(AdministrativeResponsibility.LAB_ASSISTANCE);

        //Adding staff to University
        university.addStaff(professor1);
        university.addStaff(professor2);
        university.addStaff(professor3);
        university.addStaff(adminStaff1);
        university.addStaff(adminStaff2);
        university.addStaff(adminStaff3);
        university.addStaff(labAs1);
        university.addStaff(labAs2);

        //Creating lectures
        Lecture math = new Lecture("101", "Math", professor1, LectureRoom.LECTURE_ROOM_A);
        Lecture biology = new Lecture("105", "Biology", professor2, LectureRoom.LECTURE_ROOM_B);
        Lecture physics = new Lecture("106", "Physics", professor3, LectureRoom.LECTURE_ROOM_C);

        //Adding lectures in an arrayList
        ArrayList<Lecture> lectures = new ArrayList<>();
        lectures.add(math);
        lectures.add(biology);
        lectures.add(physics);

        //Creating labs
        Lab physicsLab = new Lab("101", "Physics", labAs1, LabRoom.LAB_ROOM_A);
        Lab biologyLab = new Lab("102", "Biology", labAs2, LabRoom.LAB_ROOM_B);

        //Adding labs in an arrayList
        ArrayList<Lab> labs = new ArrayList<>();
        labs.add(physicsLab);
        labs.add(biologyLab);

        //Enrolling students in classes
        try {
            math.enrollStudent(undergraduate1);
            math.enrollStudent(undergraduate2);
            math.enrollStudent(undergraduate3);
            biology.enrollStudent(undergraduate1);
            biology.enrollStudent(undergraduate2);
            biology.enrollStudent(undergraduate3);
            physics.enrollStudent(undergraduate1);
            physics.enrollStudent(undergraduate2);

            physicsLab.enrollStudent(undergraduate1);
            biologyLab.enrollStudent(undergraduate2);
        } catch (MaxStudentsReachedException ex) {
            LOGGER.info("Enrollment exception occurred : " + ex.getMessage());
        }

        //Adding courses to University
        university.addCourse(math);
        university.addCourse(biology);
        university.addCourse(physics);
        university.addCourse(biologyLab);
        university.addCourse(physicsLab);

        //Graduate 1 introducing himself
        graduate1.introduceMyself();

        //Undergraduate 1 introducing himself
        undergraduate1.introduceMyself();

        //Professor 1 introducing himself
        professor1.introduceMyself();

        //Lab Assistant introducing himself
        labAs1.introduceMyself();

        //Administrative Staff introducing himself
        adminStaff1.introduceMyself();

        //Creating a Grades object
        Grade grade = new Grade();

        //Check the student's grades
        LOGGER.info(undergraduate1.getGrades());

        //Check the graduate student's thesis progress
        LOGGER.info(" ");
        graduate1.printThesisProgress();

        //Make the graduate student study hard
        LOGGER.info(" ");
        graduate1.study();

        //Make the undergraduate student study hard
        //Method Overloading example
        undergraduate1.study();
        undergraduate1.study(math);

        //Calculate GPA
        LOGGER.info(grade.calculateGPA(undergraduate1));
        LOGGER.info(" ");

        //Student gives an exam
        undergraduate1.takeExam(math);
        LOGGER.info(" ");

        //Tuition methods
        undergraduate1.calculateTuition();
        System.out.println();
        undergraduate1.payTuition();

        //calculate revenue
        LOGGER.info(" ");
        math.printCourseRevenue();

        LOGGER.info(" ");
        university.getRevenue();

        //Print the University Details
        LOGGER.info(" ");
        university.printDetails();

        //Average course attendance
        Course.getAverageAttendance();

        //Predicate - Finds the students that are on the first year
        Predicate<UndergraduateStudent> underGraduateInFirstYear = undergraduateStudent -> undergraduateStudent.getYearLevel() == 1;

        for (UndergraduateStudent undergraduateStudent : undergraduateStudents) {
            if (underGraduateInFirstYear.test(undergraduateStudent)) {
                LOGGER.info(undergraduateStudent.getFirstName() + " " + undergraduateStudent.getLastName() +
                        " is on the first year of his studies");
            }
        }

        //Function - Gets the Lectures Professor
        Function<Lecture, Staff> getProfessorForCourse = lecture -> lecture.getLecturer();
        for (Lecture lecture : lectures) {
            String profesorName = getProfessorForCourse.apply(lecture).toString();
            LOGGER.info("For the lecture " + lecture.getCourseName() + " the lecturer is " + profesorName);
        }

        //Consumer - Returns the course code for a course
        Consumer<Lab> printLabCode = lab -> LOGGER.info("Lab code for lab " + lab.getCourseName() + " is: " + lab.getCourseCode());
        for (Lab lab : labs) {
            printLabCode.accept(lab);
        }


        //Supplier - Creates a new Undergraduate Student and prints his name
        Supplier<UndergraduateStudent> studentSupplier = () -> {
            try {
                return new UndergraduateStudent("John", "Green", "johnGreen@gmail.com", Major.BUSINESS_ADMINISTRATION, 3, 34);
            } catch (InvalidAgeException e) {
                throw new RuntimeException(e);
            } catch (InvalidNameFormatException e) {
                throw new RuntimeException(e);
            } catch (InvalidEmailException e) {
                throw new RuntimeException(e);
            }
        };
        UndergraduateStudent newStudent = studentSupplier.get();
        LOGGER.info("The new students name is : " + newStudent.getFirstName() + " " + newStudent.getLastName());

        //BiPredicate - Takes 2 undergrads and checks if they are at the same year level
        BiPredicate<UndergraduateStudent, UndergraduateStudent> checkIfInSameYear = (a, b) -> a.getYearLevel() == b.getYearLevel();
        boolean isSameYear = checkIfInSameYear.test(undergraduate1, undergraduate2);
        LOGGER.info("Is " + undergraduate1.getFirstName() + " and " + undergraduate2.getFirstName() +
                " at the same year level ? " + isSameYear);

        //Lambda Generics
        //IStudentFinder - Find a student by id
        IStudentFinder<Student> studentFinder = studentId ->
                students.stream()
                        .filter(student -> student.getStudentID().equals(studentId))
                        .findFirst()
                        .orElse(null);

        String targetStudentId = "2";
        Student foundStudent = studentFinder.findStudent(targetStudentId);
        if (foundStudent != null) {
            LOGGER.info("Found student: " + foundStudent.getFirstName() + " " + foundStudent.getLastName());
        } else {
            LOGGER.info("Student not found");
        }


        //IEntityFilter - Filters students by attribute
        IEntityFilter<Student> undergraduateFilter = list ->
                list.stream()
                        .filter(student -> student instanceof UndergraduateStudent)
                        .collect(Collectors.toList());


        List<Student> undergrads = undergraduateFilter.filter(students);
        LOGGER.info("List of undergrads : " + undergrads);

        //IWageComparator - Compares the wages between 2 staff members
        IWageComparator<AcademicStaff> wageComparator = (staff1, staff2) -> {
            double wage1 = staff1.calculateWage();
            double wage2 = staff2.calculateWage();

            //Compare the wages
            if (wage1 < wage2) {
                return WageComparisonResult.LESS_THAN;
            } else if (wage1 > wage2) {
                return WageComparisonResult.GREATER_THAN;
            } else {
                return WageComparisonResult.EQUAL;
            }
        };

        WageComparisonResult result = wageComparator.compareWages(professor1, professor2);
        LOGGER.info("Comparing the salaries of : " + professor1.getFirstName() + " " + professor1.getLastName() +
                "\n" + "and " + professor2.getFirstName() + " " + professor2.getLastName() +
                "\n" + "result: " + result);

        //Using streams to filter
        List<Student> graduateStudents = new ArrayList<>();
        graduateStudents = students.stream()
                .filter(x -> x instanceof GraduateStudent).
                collect(Collectors.toList());
        LOGGER.info("Graduate students " + graduateStudents);

        List<Student> highTuition = undergrads.stream()
                .filter(x -> x.calculateTuition() > 300)
                .collect(Collectors.toList());
        LOGGER.info(highTuition);

        lectures.stream()
                .filter(lecture -> lecture.getLecturer() != null)
                .forEach(lecture -> System.out.println(lecture.getLecturer()));

        labs.stream()
                .filter(x->x.getCourseCode()=="101")
                .forEach(x->System.out.println(x.getCourseName()));
    }
}

