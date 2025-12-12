/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SprintPlanning;

/**
 *
 * @author pc
 */
import java.util.ArrayList;
import WorkItems.*;
import Users.TechnicalStaff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sprint {

    private static int counter = 1;

    private int sprintId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String objective;

    private List<TechnicalStaff> teamMembers;
    private List<Epic> epics;
    private List<Task> tasks;

    public Sprint(LocalDate startDate, LocalDate endDate, String objective) {
        this.sprintId = counter++;
        this.startDate = startDate;
        this.endDate = endDate;
        this.objective = objective;

        this.teamMembers = new ArrayList<>();
        this.epics = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    // ================== Team ==================
    public void addTeamMember(TechnicalStaff member) {
        if (!teamMembers.contains(member)) {
            teamMembers.add(member);
        }
    }

    public List<TechnicalStaff> getTeamMembers() {
        return teamMembers;
    }

    // ================== Work ==================
    public void addEpic(Epic epic) {
        epics.add(epic);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Epic> getEpics() {
        return epics;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    // ================== Info ==================
    public int getSprintId() {
        return sprintId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getObjective() {
        return objective;
    }

    @Override
    public String toString() {
        return "Sprint #" + sprintId +
                " [" + startDate + " → " + endDate + "]" +
                "\nObjective: " + objective +
                "\nTeam size: " + teamMembers.size() +
                "\nEpics: " + epics.size() +
                "\nTasks: " + tasks.size();
    }
}

