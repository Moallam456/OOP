package com.mycompany.oop_project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Task implements WorkItem {

    private static int ID_SEQUENCE = 1;

    private final int id;
    private String title;
    private String description;
    private Priority priority;
    private WorkStatus status;

    private User reporter;
    private TechnicalStaff assignee;

    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Implementation of finishedAt is necessary, but the field isn't
    // explicitly declared here, using updatedAt as a proxy in the method.

    private WorkItem parent;

    private TaskType taskType;

    private double estimateHours;

    private double loggedHours;

    private double remainingHours;

    private LocalDate dueDate;

    private boolean blocked;

    private String blockedReason;

    public Task(String title, String description, User reporter) {
        this(title, description, Priority.MEDIUM, TaskType.DEVELOPMENT, reporter);
    }

    public Task(String title,
                String description,
                Priority priority,
                TaskType taskType,
                User reporter) {

        this.id = ID_SEQUENCE++;
        this.title = title;
        this.description = description;

        this.priority = (priority != null) ? priority : Priority.MEDIUM;
        this.status = WorkStatus.TODO;

        this.taskType = (taskType != null) ? taskType : TaskType.DEVELOPMENT;

        this.reporter = reporter;
        this.assignee = null;

        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;

        this.parent = null;

        this.estimateHours = 0.0;
        this.loggedHours = 0.0;
        this.remainingHours = 0.0;

        this.dueDate = null;
        this.blocked = false;
        this.blockedReason = null;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
        touch();
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
        touch();
    }

    public WorkType getType() {
        return WorkType.TASK;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public void setPriority(Priority priority) {
        if (priority != null) {
            this.priority = priority;
            touch();
        }
    }

    @Override
    public WorkStatus getStatus() {
        return status;
    }

    @Override
    public void changeStatus(WorkStatus newStatus) {
        if (newStatus == null) return;
        this.status = newStatus;
        touch();
    }

    public void start() {
        changeStatus(WorkStatus.IN_PROGRESS);
    }

    public void sendToReview() {
        changeStatus(WorkStatus.IN_REVIEW);
    }

    public void complete() {
        changeStatus(WorkStatus.DONE);
        this.blocked = false;
        this.blockedReason = null;
    }

    @Override
    public User getReporter() {
        return reporter;
    }

    @Override
    public void setReporter(User reporter) {
        this.reporter = reporter;
        touch();
    }

    @Override
    public TechnicalStaff getAssignee() {
        return assignee;
    }

    @Override
    public void assignTo(TechnicalStaff assignee) {
        this.assignee = assignee;
        touch();
    }

    @Override
    public void unassign() {
        this.assignee = null;
        touch();
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    @Override
    public LocalDateTime finishedAt() {
        return isDone() ? updatedAt : createdAt;
    }

    @Override
    public void touch() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public WorkItem getParent() {
        return parent;
    }

    @Override
    public void setParent(WorkItem parent) {
        this.parent = parent;
        touch();
    }

    @Override
    public List<WorkItem> getChildren() {
        return Collections.emptyList();
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        if (taskType != null) {
            this.taskType = taskType;
            touch();
        }
    }

    public double getEstimateHours() {
        return estimateHours;
    }

    public void setEstimateHours(double estimateHours) {
        if (estimateHours < 0) estimateHours = 0;
        this.estimateHours = estimateHours;
        if (loggedHours <= estimateHours) {
            this.remainingHours = estimateHours - loggedHours;
        }
        touch();
    }

    public double getLoggedHours() {
        return loggedHours;
    }

    public double getRemainingHours() {
        return remainingHours;
    }

    public void logWork(double hours) {
        if (hours <= 0) return;

        this.loggedHours += hours;

        if (estimateHours > 0) {
            this.remainingHours = Math.max(0, estimateHours - loggedHours);
        }

        touch();
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        touch();
    }

    @Override
    public boolean isBlocked() {
        return blocked;
    }

    public String getBlockedReason() {
        return blockedReason;
    }

    public void block(String reason) {
        this.blocked = true;
        this.blockedReason = reason;
        changeStatus(WorkStatus.BLOCKED);
    }

    public void unblock() {
        this.blocked = false;
        this.blockedReason = null;
        if (this.status == WorkStatus.BLOCKED) {
            this.status = WorkStatus.IN_PROGRESS;
        }
        touch();
    }

    public boolean isOverdue() {
        return dueDate != null
                && LocalDate.now().isAfter(dueDate)
                && getStatus() != WorkStatus.DONE;
    }

    @Override
    public String toString() {
        return getSummaryLine()
                + " | type: " + taskType
                + " | estimate: " + estimateHours
                + "h, logged: " + loggedHours
                + "h, remaining: " + remainingHours
                + "h, blocked: " + blocked;
    }
}