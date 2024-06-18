package uaspbo;

import java.util.Arrays;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 *
 * @author LENOVO
 */
public class Uaspbo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User("ninja", "12345");
        session.save(user);

        Teacher teacher1 = new Teacher("herman", "12345", "1301006");
        Teacher teacher2 = new Teacher("alice", "12345", "1301007");
        Teacher teacher3 = new Teacher("bob", "12345", "1301008");
        Teacher teacher4 = new Teacher("charlie", "12345", "1301009");
        
        session.save(teacher1);
        session.save(teacher2);
        session.save(teacher3);
        session.save(teacher4);

        for (int i = 1; i <= 20; i++) {
            Student student = new Student("student" + i, "password" + i, "studentId" + i);

            Teacher assignedTeacher = (i <= 5) ? teacher1 : (i <= 10) ? teacher2 : (i <= 15) ? teacher3 : teacher4;
            student.setSupervisor(assignedTeacher);

            session.save(student);
            assignedTeacher.getStudentSupervised().add(student);
            session.update(assignedTeacher);
        }
        Course course1 = new Course("Game Development", "ILK1101003");
        Course course2 = new Course("Data Structures", "ILK1101004");
        Course course3 = new Course("Operating Systems", "ILK1101005");
        Course course4 = new Course("Algorithms", "ILK1101006");

        session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(course4);

        Class class1 = new Class("class01");
        class1.setTeacher(teacher1);
        class1.setCourse(course1);
        session.save(class1);

        Class class2 = new Class("class02");
        class2.setTeacher(teacher2);
        class2.setCourse(course2);
        session.save(class2);

        Class class3 = new Class("class03");
        class3.setTeacher(teacher3);
        class3.setCourse(course3);
        session.save(class3);

        Class class4 = new Class("class04");
        class4.setTeacher(teacher4);
        class4.setCourse(course4);
        session.save(class4);
        

        // Add Mahasiswa to Kelas
        Random rand = new Random();
        List<Student> students = session.createQuery("FROM Student", Student.class).list();

        for (Student student : students) {
            int randClass = rand.nextInt(4) + 1;
            switch (randClass) {
                case 1: class1.getStudents().add(student); break;
                case 2: class2.getStudents().add(student); break;
                case 3: class3.getStudents().add(student); break;
                case 4: class4.getStudents().add(student); break;
            }
        }

        session.update(class1);
        session.update(class2);
        session.update(class3);
        session.update(class4);

        // Create Activities for each class
        createActivities(session, class1, teacher1, course1);
        createActivities(session, class2, teacher2, course2);
        createActivities(session, class3, teacher3, course3);
        createActivities(session, class4, teacher4, course4);

        // Create Scores
        createScores(session, students);

        transaction.commit();

        System.out.println("\nPrinting all scores for three students:");
        if (students.size() >= 3) {
            System.out.println("Scores of " + students.get(0).getUsername() + ":");
            students.get(0).printAllScores(session);
            System.out.println("\nScores of " + students.get(1).getUsername() + ":");
            students.get(1).printAllScores(session);
            System.out.println("\nScores of " + students.get(2).getUsername() + ":");
            students.get(2).printAllScores(session);
            System.out.println("\nScores of " + students.get(3).getUsername() + ":");
            students.get(3).printAllScores(session);
            System.out.println("\nScores of " + students.get(4).getUsername() + ":");
            students.get(4).printAllScores(session);
            System.out.println("\nScores of " + students.get(5).getUsername() + ":");
            students.get(5).printAllScores(session);
            System.out.println("\nScores of " + students.get(6).getUsername() + ":");
            students.get(6).printAllScores(session);
            System.out.println("\nScores of " + students.get(7).getUsername() + ":");
            students.get(7).printAllScores(session);
            System.out.println("\nScores of " + students.get(8).getUsername() + ":");
            students.get(8).printAllScores(session);
            System.out.println("\nScores of " + students.get(9).getUsername() + ":");
            students.get(9).printAllScores(session);
            System.out.println("\nScores of " + students.get(10).getUsername() + ":");
            students.get(10).printAllScores(session);
            System.out.println("\nScores of " + students.get(11).getUsername() + ":");
            students.get(11).printAllScores(session);
            System.out.println("\nScores of " + students.get(12).getUsername() + ":");
            students.get(12).printAllScores(session);
            System.out.println("\nScores of " + students.get(13).getUsername() + ":");
            students.get(13).printAllScores(session);
            System.out.println("\nScores of " + students.get(14).getUsername() + ":");
            students.get(14).printAllScores(session);
            System.out.println("\nScores of " + students.get(15).getUsername() + ":");
            students.get(15).printAllScores(session);
            System.out.println("\nScores of " + students.get(16).getUsername() + ":");
            students.get(16).printAllScores(session);
            System.out.println("\nScores of " + students.get(17).getUsername() + ":");
            students.get(17).printAllScores(session);
            System.out.println("\nScores of " + students.get(18).getUsername() + ":");
            students.get(18).printAllScores(session);
            System.out.println("\nScores of " + students.get(19).getUsername() + ":");
            students.get(19).printAllScores(session);
        } else {
            System.out.println("Not enough students to print scores.");
        }

        
        // Calculate and print GPA for three students
        System.out.println("Calculating GPA for three students:");
        if (students.size() >= 3) {
            System.out.println("GPA of " + students.get(0).getUsername() + ": " + students.get(0).calculateGPA(session));
            System.out.println("GPA of " + students.get(1).getUsername() + ": " + students.get(1).calculateGPA(session));
            System.out.println("GPA of " + students.get(2).getUsername() + ": " + students.get(2).calculateGPA(session));
            System.out.println("GPA of " + students.get(3).getUsername() + ": " + students.get(3).calculateGPA(session));
            System.out.println("GPA of " + students.get(4).getUsername() + ": " + students.get(4).calculateGPA(session));
            System.out.println("GPA of " + students.get(5).getUsername() + ": " + students.get(5).calculateGPA(session));
            System.out.println("GPA of " + students.get(6).getUsername() + ": " + students.get(6).calculateGPA(session));
            System.out.println("GPA of " + students.get(7).getUsername() + ": " + students.get(7).calculateGPA(session));
            System.out.println("GPA of " + students.get(8).getUsername() + ": " + students.get(8).calculateGPA(session));
            System.out.println("GPA of " + students.get(9).getUsername() + ": " + students.get(9).calculateGPA(session));
            System.out.println("GPA of " + students.get(10).getUsername() + ": " + students.get(10).calculateGPA(session));
            System.out.println("GPA of " + students.get(11).getUsername() + ": " + students.get(11).calculateGPA(session));
            System.out.println("GPA of " + students.get(12).getUsername() + ": " + students.get(12).calculateGPA(session));
            System.out.println("GPA of " + students.get(13).getUsername() + ": " + students.get(13).calculateGPA(session));
            System.out.println("GPA of " + students.get(14).getUsername() + ": " + students.get(14).calculateGPA(session));
            System.out.println("GPA of " + students.get(15).getUsername() + ": " + students.get(15).calculateGPA(session));
            System.out.println("GPA of " + students.get(16).getUsername() + ": " + students.get(16).calculateGPA(session));
            System.out.println("GPA of " + students.get(17).getUsername() + ": " + students.get(17).calculateGPA(session));
            System.out.println("GPA of " + students.get(18).getUsername() + ": " + students.get(18).calculateGPA(session));
            System.out.println("GPA of " + students.get(19).getUsername() + ": " + students.get(19).calculateGPA(session));
            
        } else {
            System.out.println("Not enough students to display GPA.");
        }

        session.close();
    }

    private static void createActivities(Session session, Class academicClass, Teacher teacher, Course course) {
        for (int i = 1; i <= 3; i++) {
            // Create Meeting
            Meeting meeting = new Meeting();
            meeting.setCourse(course);
            meeting.setAcademicClass(academicClass);
            meeting.setTeacher(teacher);
            meeting.setMeetingStartTime(new Date());
            meeting.setAttendees(new HashSet<>(academicClass.getStudents()));
            session.save(meeting);

            // Create Assignment
            Assignment assignment = new Assignment();
            assignment.setCourse(course);
            assignment.setAcademicClass(academicClass);
            assignment.setTeacher(teacher);
            assignment.setDueDate(new Date());
            assignment.setAssignees(new HashSet<>(academicClass.getStudents()));
            session.save(assignment);

            academicClass.getActivities().add(meeting);
            academicClass.getActivities().add(assignment);
        }
        session.update(academicClass);
    }

    private static void createScores(Session session, List<Student> students) {
        Random rand = new Random();
        List<Class> classes = session.createQuery("FROM Class", Class.class).list();

        for (int i = 1; i <100 ; i++) {
            Student student = students.get(rand.nextInt(students.size()));
            Class academicClass = classes.get(rand.nextInt(classes.size()));
            int scoreValue = rand.nextInt(101);

            Score score = new Score(scoreValue, academicClass, student);
            session.save(score);
        }
    }
}
