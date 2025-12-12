/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkItems;

/**
 *
 * @author pc
 */
import Enums.TaskType;
import Enums.WorkType;
import Users.Developer;

public class Task extends WorkItem {

    private TaskType taskType;
    private Developer assignedDeveloper;

    public Task(String title, String description, TaskType taskType) {
        super(title, description, WorkType.TASK);
        this.taskType = taskType;
    }

    public void assignDeveloper(Developer dev) {
        this.assignedDeveloper = dev;
    }
}
