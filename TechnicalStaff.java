/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public abstract class TechnicalStaff extends User {
    private int capacity;
    private ArrayList<Task> assignedTasks; // list of all tasks assigned to this member
    
    public TechnicalStaff(String userId, String name, String username, String password, String role, int capacity) {
        super(userId, name, username, password, role); 
        this.capacity = capacity;
        this.assignedTasks = new ArrayList<>(); // Initialize the list
    }
    
    public TechnicalStaff() {
        super();
        this.assignedTasks = new ArrayList<>();
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public ArrayList<Task> getAssignedTasks() {
        return assignedTasks;
    }
    
    
    //setters
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void setAssignedTasks(ArrayList<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }
    
    public void addTask(Task task) {
        this.assignedTasks.add(task);
        // Business Logic Tip: You might also want to subtract the task's effort from the staff member's capacity here.
    }
    
    public void removeTask(Task task) {
        this.assignedTasks.remove(task);
        // Business Logic Tip: You might also want to re-add the task's effort back to capacity if it's cancelled.
    }
    
    
    //Abstract Method which must be implemented from subclasses
    public abstract boolean performWork(Task task);
}
