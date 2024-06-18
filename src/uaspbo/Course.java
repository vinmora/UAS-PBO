/*

Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package uaspbo;
import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*

@author LENOVO
*/
@Entity
@Table(name="course")
public class Course {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="name", nullable=false)
private String name;

@Column(name="course_id", nullable=false)    
private String courseId;

public Course(String name, String courseId)
{
    this.name = name;
    this.courseId = courseId;
}

/**
 * @return the id
 */
public int getId() {
    return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
    this.id = id;
}

/**
 * @return the name
 */
public String getName() {
    return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
    this.name = name;
}

/**
 * @return the courseId
 */
public String getCourseId() {
    return courseId;
}

/**
 * @param courseId the courseId to set
 */
public void setCourseId(String courseId) {
    this.courseId = courseId;
}

}