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
public class ScrumMaster extends TechnicalStaff {
    
    public ScrumMaster(String userId, String name, String username, String password, int capacity) {
        super(userId, name, username, password, "ScrumMaster", capacity);
    }
    
    @Override
    public boolean performWork(Task task) {
        System.out.println(getName() + " (ScrumMaster) is facilitating the process for Task ID: " + task.getTaskId());
        return true; 
    }
    
    
    /**
     * Creates and initializes a new Sprint.
     * @return The newly created SprintPlanning object.
     */
    
    public SprintPlanning createNewSprint(String objective, ArrayList<TechnicalStaff> team, String startDate, String endDate) {
        // Business Logic: This method creates the central Sprint object.
        System.out.println("ScrumMaster " + getName() + " is starting a new Sprint.");
        // Placeholder for actual object creation 
        // return new SprintPlanning(objective, team, startDate, endDate);
        return null; 
    }
    
    /**
     * Assigns a specific Task to a specific TechnicalStaff member.
     * (This is critical logic you must detail in your document.)
     */
    
    public boolean assignTaskToStaff(Task task, TechnicalStaff staff) {
        // 1. Check if the task is valid and not already assigned.
        // 2. Check if the staff member has enough capacity remaining.
        if (staff.getCapacity() >= task.getEstimatedEffort()) { 
            staff.addTask(task);
            System.out.println("Assigned Task " + task.getTitle() + " to " + staff.getName());
            return true;
        } else {
            System.out.println("ERROR: " + staff.getName() + " does not have enough capacity for this task.");
            return false;
        }
    }
    
    
    
}
