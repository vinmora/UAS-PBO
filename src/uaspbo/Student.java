package uaspbo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author LENOVO
 */
@Entity
public class Student extends User {

    private String studentId;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher supervisor;

    @OneToMany(mappedBy = "student")
    private Set<Score> scores;

    @ManyToMany(mappedBy = "students")
    private Set<Class> classes;

    public Student(String username, String password, String studentId) {
        super(username, password);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Teacher getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Teacher supervisor) {
        this.supervisor = supervisor;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }
    // Method to calculate GPA
    public double calculateGPA(Session session) {
        String hql = "FROM Score WHERE student = :student";
        Query<Score> query = session.createQuery(hql, Score.class);
        query.setParameter("student", this);
        java.util.List<Score> scores = query.list();

        double totalPoints = 0.0;
        int totalCourses = scores.size();

        for (Score score : scores) {
            totalPoints += convertScoreToGPA(score.getScore());
        }

        return totalCourses == 0 ? 0 : totalPoints / totalCourses;
    }

    private double convertScoreToGPA(int score) {
        if (score >= 85) {
            return 4.0;
        } else if (score >= 70) {
            return 3.0;
        } else if (score >= 55) {
            return 2.0;
        } else if (score >= 40) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    // Method to print all scores
    public void printAllScores(Session session) {
        String hql = "FROM Score WHERE student = :student";
        Query<Score> query = session.createQuery(hql, Score.class);
        query.setParameter("student", this);
        java.util.List<Score> scores = query.list();

        for (Score score : scores) {
            Class class01 = score.getClass01();
            Course course = class01.getCourse();
            System.out.println(course.getCourseId() + " " + course.getName() + " " + score.getScore());
        }
    }

    
}
