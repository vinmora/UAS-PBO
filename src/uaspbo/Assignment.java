/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uaspbo;

import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Assignment extends Activity {
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @ManyToMany
    @JoinTable(
        name = "assignment_assignees",
        joinColumns = @JoinColumn(name = "assignment_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> assignees;

    @Override
    public String getDescription() {
        return "Assignment: " + getCourse().getName() + " due on " + dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Set<Student> getAssignees() {
        return assignees;
    }

    public void setAssignees(Set<Student> assignees) {
        this.assignees = assignees;
    }
}

