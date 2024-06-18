/*

Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package uaspbo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*

@author LENOVO
*/
@Entity
@Table(name="score")
public class Score {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="score", nullable=false)
private int score;

@ManyToOne(fetch=FetchType.LAZY)
private Class class01;

@ManyToOne(fetch=FetchType.LAZY)
private Student student;

public Score() {}

public Score(int score, Class class01, Student student) {
this.score = score;
this.class01 = class01;
this.student = student;
}

/**

@return the id
*/
public int getId() {
return id;
}
/**

@param id the id to set
*/
public void setId(int id) {
this.id = id;
}
/**

@return the score
*/
public int getScore() {
return score;
}
/**

@param score the score to set
*/
public void setScore(int score) {
this.score = score;
}
/**

@return the class01
*/
public Class getClass01() {
return class01;
}
/**

@param class01 the class01 to set
*/
public void setClass01(Class class01) {
this.class01 = class01;
}
/**

@return the student
*/
public Student getStudent() {
return student;
}
/**

@param student the student to set
*/
public void setStudent(Student student) {
this.student = student;
}
}