/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskservice;

/**
 *
 * @author pc
 */




public class TaskService {

    private static final int MAX_TASKS_PER_DEV = 5;

    public static void assignTaskToDeveloper(Task task, Developer developer) {

        if (developer.getAssignedTasks().size() >= MAX_TASKS_PER_DEV) {
            throw new IllegalStateException("Developer has reached max task capacity");
        }

        task.setAssignedTo(developer);
        developer.addTask(task);
    }

    public static void changeTaskStatus(Task task, WorkStatus newStatus, User user) {

        if (!(user instanceof TechnicalStaff)) {
            throw new IllegalStateException("Only Technical Staff can change task status");
        }

        task.setStatus(newStatus);
    }
}
