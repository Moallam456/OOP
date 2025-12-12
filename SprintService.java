/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sprintservice;

/**
 *
 * @author pc
 */


import com.mycompany.database.DataBase;

import java.time.LocalDate;

public class SprintService {

    // Only ScrumMaster can create a sprint
    public static SprintPlanning createSprint(
            User user,
            LocalDate startDate,
            LocalDate endDate,
            String objective) {

        if (!(user instanceof ScrumMaster)) {
            throw new IllegalStateException("Only ScrumMaster can create a Sprint");
        }

        SprintPlanning sprint = new SprintPlanning(startDate, endDate, objective);
        DataBase.sprints.add(sprint);
        return sprint;
    }

    // Assign team member
    public static void addMemberToSprint(SprintPlanning sprint, TechnicalStaff member) {
        sprint.addTeamMember(member);
    }

    // Add Epic
    public static void addEpicToSprint(SprintPlanning sprint, Epic epic) {
        sprint.addEpic(epic);
    }

    // Add Task with capacity check
    public static void addTaskToSprint(SprintPlanning sprint, Task task) {

        if (task.getAssignedTo() == null) {
            throw new IllegalStateException("Task must be assigned before adding to sprint");
        }

        sprint.addTask(task);
    }
}
