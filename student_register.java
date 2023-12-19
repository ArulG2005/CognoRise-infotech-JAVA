import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    String studentID;
    String name;
    List<String> registeredCourses;

    Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

public class student_register {
    private static Map<String, Course> courseDatabase = new HashMap<>();
    private static Map<String, Student> studentDatabase = new HashMap<>();
    static {
       
        studentDatabase.put("000", new Student("000", "Arul"));
        studentDatabase.put("001", new Student("001", "Bala"));
        studentDatabase.put("010", new Student("010", "Deva"));
        studentDatabase.put("011", new Student("011", "Jothi"));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        addSampleCourses();

        while (true) {
            System.out.println("\n===== UNIVERSITY REGISTRATION SYSTEM =====");
            System.out.println("1. Display Course Listing");
            System.out.println("2. Display Student Information");
            System.out.println("3. Student Registration");
            System.out.println("4. Course Removal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    displayCourseListing();
                    break;
                case 2:
                    displayStudentInformation(scanner);
                    break;
                case 3:
                    studentRegistration(scanner);
                    break;
                case 4:
                    courseRemoval(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSampleCourses() {
        courseDatabase.put("CSE101", new Course("CSE101", "Introduction to Computer Science", "Fundamentals of programming", 30, "Mon, Wed 10:00 AM - 11:30 AM"));
        courseDatabase.put("MAT201", new Course("MAT201", "Calculus I", "Limits, derivatives, and integrals", 25, "Tue, Thu 1:00 PM - 2:30 PM"));
        courseDatabase.put("ENG301", new Course("ENG301", "English Literature", "Literary analysis and critical thinking", 20, "Mon, Wed 2:00 PM - 3:30 PM"));
   
    }
    
    private static void displayCourseListing() {
        System.out.println("\n===== COURSE LISTING =====");
        for (Course course : courseDatabase.values()) {
            System.out.println("Course Code: " + course.code);
            System.out.println("Title: " + course.title);
            System.out.println("Description: " + course.description);
            System.out.println("Capacity: " + course.capacity);
            System.out.println("Schedule: " + course.schedule);
            System.out.println("Available Slots: " + (course.capacity - studentCount(course.code)));
            System.out.println("----------------------------");
        }
    }

    private static void displayStudentInformation(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        if (studentDatabase.containsKey(studentID)) {
            Student student = studentDatabase.get(studentID);
            System.out.println("\n===== STUDENT INFORMATION =====");
            System.out.println("Student ID: " + student.studentID);
            System.out.println("Name: " + student.name);
            System.out.println("Registered Courses:");
            for (String courseCode : student.registeredCourses) {
                Course course = courseDatabase.get(courseCode);
                System.out.println("- " + course.title + " (" + courseCode + ")");
            }
            System.out.println("----------------------------");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void studentRegistration(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        if (studentDatabase.containsKey(studentID)) {
            System.out.println("\n===== COURSE REGISTRATION =====");
            displayCourseListing();
            System.out.print("Enter Course Code to Register: ");
            String courseCode = scanner.nextLine();
            if (courseDatabase.containsKey(courseCode)) {
                Course course = courseDatabase.get(courseCode);
                if (studentCount(courseCode) < course.capacity) {
                    Student student = studentDatabase.get(studentID);
                    student.registeredCourses.add(courseCode);
                    System.out.println("Registration successful!");
                } else {
                    System.out.println("Sorry, the course is already full. Cannot register.");
                }
            } else {
                System.out.println("Invalid course code. Please try again.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void courseRemoval(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        if (studentDatabase.containsKey(studentID)) {
            Student student = studentDatabase.get(studentID);
            if (!student.registeredCourses.isEmpty()) {
                System.out.println("\n===== COURSE REMOVAL =====");
                System.out.println("Registered Courses:");
                for (String courseCode : student.registeredCourses) {
                    Course course = courseDatabase.get(courseCode);
                    System.out.println("- " + course.title + " (" + courseCode + ")");
                }
                System.out.print("Enter Course Code to Remove: ");
                String courseCodeToRemove = scanner.nextLine();
                if (student.registeredCourses.contains(courseCodeToRemove)) {
                    student.registeredCourses.remove(courseCodeToRemove);
                    System.out.println("Course removal successful!");
                } else {
                    System.out.println("You are not registered for this course.");
                }
            } else {
                System.out.println("You are not registered for any courses.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private static int studentCount(String courseCode) {
        int count = 0;
        for (Student student : studentDatabase.values()) {
            if (student.registeredCourses.contains(courseCode)) {
                count++;
            }
        }
        return count;
    }
}
