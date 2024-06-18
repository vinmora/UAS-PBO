/*

Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package uaspbo;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
*

@author LENOVO
*/
@Entity
@Table(name="teacher")
@PrimaryKeyJoinColumn(name="user_id")
public class Teacher extends User{
    @Column(name="teacher_id", nullable=false, unique = true)
private String teacherId;

@OneToMany(mappedBy = "supervisor")
private Set<Student> studentSupervised = new HashSet<>();


public Teacher(String username, String password, String teacherId) {
    super(username, password);
    this.teacherId = teacherId;
}

/**
 * @return the teacherId
 */
public String getTeacherId() {
    return teacherId;
}

/**
 * @param teacherId the teacherId to set
 */
public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
}

/**
 * @return the studentSupervised
 */
public Set<Student> getStudentSupervised() {
    return studentSupervised;
}

/**
 * @param studentSupervised the studentSupervised to set
 */
public void setStudentSupervised(Set<Student> studentSupervised) {
    this.studentSupervised = studentSupervised;
}

}