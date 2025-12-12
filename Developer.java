/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author pc
 */
import WorkItems.Task;
import Enums.WorkStatus;

public class Developer extends TechnicalStaff {

    public Developer(String userId, String name, String username, String password) {
        super(userId, name, username, password, "Developer");
    }

    public void workOnTask(Task task) {
        task.setStatus(WorkStatus.IN_PROGRESS);
        System.out.println(name + " started working on task: " + task.getTitle());
    }
}