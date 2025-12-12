/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author pc
 */
import SprintPlanning.Sprint;
import WorkItems.Epic;
import WorkItems.Task;

/**
 
ScrumMaster is responsible for sprint planning
and assigning work items (Epics & Tasks) to sprints.*/
public class ScrumMaster extends User {

    public ScrumMaster(String userId, String name, String username, String password) {
        super(userId, name, username, password, "Scrum Master");
    }

    // ================== Sprint Planning ==================

    public void addEpicToSprint(Sprint sprint, Epic epic) {
        sprint.addEpic(epic);
        System.out.println(
                getName() + " added Epic '" + epic.getTitle() +
                "' to Sprint #" + sprint.getSprintId()
        );
    }

    public void addTaskToSprint(Sprint sprint, Task task) {
        sprint.addTask(task);
        System.out.println(
                getName() + " added Task '" + task.getTitle() +
                "' to Sprint #" + sprint.getSprintId()
        );
    }
}