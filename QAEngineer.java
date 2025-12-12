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
public class QAEngineer extends TechnicalStaff {
    
    public QAEngineer(String userId, String name, String username, String password, int capacity) {
        super(userId, name, username, password, "QA Engineer", capacity);
    }
    
    
    @Override
    public boolean performWork(Task task) {
        if (task.getStatus().equals("DONE")) {
            System.out.println(getName() + " is starting testing on Task: " + task.getTitle());
            
            //testing logic 
            boolean passedTesting = true; // Assume success 

            if (passedTesting) {
                task.setStatus("VERIFIED"); 
                System.out.println(getName() + " verified and closed Task: " + task.getTitle());
                return true;
            } else {
                task.setStatus("BLOCKED/RE-OPENED");
                System.out.println(getName() + " found an issue. Task " + task.getTitle() + " sent back for rework.");
                //Must assign the task back to the original developer.
                return false;
            }
        } else {
            System.out.println(getName() + " cannot test Task " + task.getTitle() + ". It is not ready for testing.");
            return false;
        }      
    }
   
    
}
