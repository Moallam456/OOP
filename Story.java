package com.mycompany.oop_project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Story implements WorkItem {

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

    private final List<WorkItem> children = new ArrayList<>();

    private String acceptanceCriteria;

    private boolean readyForQA;

    public Story(String title, String description, User reporter) {
        this(title, description, Priority.MEDIUM, reporter);
    }

    public Story(String title, String description, Priority priority, User reporter) {
        this.id = ID_SEQUENCE++;
        this.title = title;
        this.description = description;
        this.priority = (priority != null) ? priority : Priority.MEDIUM;
        this.status = WorkStatus.TODO;

        this.reporter = reporter;
        this.assignee = null;

        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;

        this.parent = null;
        this.acceptanceCriteria = null;
        this.readyForQA = false;
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
        return Collections.unmodifiableList(children);
    }

    public void addChild(WorkItem child) {
        if (child == null || children.contains(child)) {
            return;
        }
        children.add(child);
        child.setParent(this);

        updateReadyForQA();
        touch();
    }

    public void removeChild(WorkItem child) {
        if (child == null) return;

        if (children.remove(child)) {
            if (child.getParent() == this) {
                child.setParent(null);
            }
            updateReadyForQA();
            touch();
        }
    }

    public List<WorkItem> getTaskChildren() {
        List<WorkItem> tasks = new ArrayList<>();
        for (WorkItem wi : children) {
            if (wi.getType() == WorkType.TASK) {
                tasks.add(wi);
            }
        }
        return Collections.unmodifiableList(tasks);
    }

    public List<WorkItem> getBugChildren() {
        List<WorkItem> bugs = new ArrayList<>();
        for (WorkItem wi : children) {
            if (wi.getType() == WorkType.BUG) {
                bugs.add(wi);
            }
        }
        return Collections.unmodifiableList(bugs);
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
        touch();
    }

    public boolean isReadyForQA() {
        return readyForQA;
    }

    private void updateReadyForQA() {
        if (children.isEmpty()) {
            this.readyForQA = false;
            return;
        }

        for (WorkItem wi : children) {
            if (!wi.isDone()) {
                this.readyForQA = false;
                return;
            }
        }

        this.readyForQA = true;
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

    public void recalculateChildrenState() {
        updateReadyForQA();
        touch();
    }

    @Override
    public String toString() {
        return getSummaryLine()
                + " | children: " + children.size()
                + " | readyForQA: " + readyForQA;
    }
}