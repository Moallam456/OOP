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
public class Developer extends TechnicalStaff {
    
    public Developer(String userId, String name, String username, String password, int capacity) {
        super(userId, name, username, password, "Developer", capacity);
    }
    
    
    @Override
    public boolean performWork(Task task) {
        if (task.getStatus().equals("TO DO")) {
            task.setStatus("IN PROGRESS");
            System.out.println(getName() + " started development on Task: " + task.getTitle());
            return true;
        } else if (task.getStatus().equals("IN PROGRESS")) {
            task.setStatus("DONE");
            System.out.println(getName() + " completed development on Task: " + task.getTitle());
            //At this point, the task might move to the QA Engineer's queue.
            return true;
        } else {
            System.out.println(getName() + " cannot work on Task " + task.getTitle() + " (Current Status: " + task.getStatus() + ")");
            return false;
        }
    }
    
    public Bug createBug(String title, String description) {
        System.out.println(getName() + " created a new Bug: " + title);
        return null;
    }
    
    
}
