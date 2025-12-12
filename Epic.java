package com.mycompany.oop_project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Epic implements WorkItem {

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

    private WorkItem parent;
    
    private boolean isReadyForReview;

    private final List<WorkItem> children = new ArrayList<>();

    private String businessGoal;

    public Epic(String title, String description, User reporter) {
        this(title, description, Priority.MEDIUM, reporter);
    }

    public Epic(String title, String description, Priority priority, User reporter) {
        this.id = ID_SEQUENCE++;
        this.title = title;
        this.description = description;
        this.priority = priority != null ? priority : Priority.MEDIUM;
        this.status = WorkStatus.TODO;

        this.reporter = reporter;
        this.assignee = null;

        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.parent = null;
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

    @Override
    public WorkType getType() {
        return WorkType.STORY;
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

    @Override
    public User getReporter() {
        return reporter;
    }
//LOOOOOOOOOOK
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
        // An Epic is considered "finished" when its status is DONE. 
        // We use the updatedAt time as a proxy for the completion timestamp.
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
        return Collections.unmodifiableList(children);
    }

    public void addChild(WorkItem child) {
    if (child == null || children.contains(child)) return;

    children.add(child);
    child.setParent(this);

    updateReadyForReview();
    touch();
    }

    public void removeChild(WorkItem child) {
        if (child == null) return;

        if (children.remove(child)) {
            if (child.getParent() == this) {
                child.setParent(null);
            }
            updateReadyForReview();
            touch();
        }
    }


    public List<WorkItem> getStoryChildren() {
        List<WorkItem> stories = new ArrayList<>();
        for (WorkItem wi : children) {
            if (wi.getType() == WorkType.STORY) {
                stories.add(wi);
            }
        }
        return Collections.unmodifiableList(stories);
    }

    public String getBusinessGoal() {
        return businessGoal;
    }

    public void setBusinessGoal(String businessGoal) {
        this.businessGoal = businessGoal;
        touch();
    }

    public double getProgress() {
        if (children.isEmpty()) {
            return (getStatus() == WorkStatus.DONE) ? 1.0 : 0.0;
        }
        int total = children.size();
        int done = 0;
        for (WorkItem wi : children) {
            if (wi.isDone()) {
                done++;
            }
        }
        return (double) done / total;
    }

    @Override
    public String toString() {
        return getSummaryLine() + " | children: " + children.size();
    }
    
   public boolean isReadyForReview() {
    return isReadyForReview;
    }
   
    private void updateReadyForReview() {
        if (children.isEmpty()) {
            this.isReadyForReview = false;
            return;
        }

        for (WorkItem wi : children) {
            if (!wi.isDone()) {
                this.isReadyForReview = false;
                return;
            }
        }

        this.isReadyForReview = true;
    }

}