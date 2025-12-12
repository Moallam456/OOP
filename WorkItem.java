/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oop_project;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkItem {

    // Identity
    int getId();

    // Basic descriptive information
    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    // Classification
    WorkType getType();
    
    Priority getPriority();

    void setPriority(Priority priority);

    // Workflow status
    WorkStatus getStatus();

    void changeStatus(WorkStatus newStatus);

    // People (reporter / assignee)
    User getReporter();

    void setReporter(User reporter);

    TechnicalStaff getAssignee();

    void assignTo(TechnicalStaff assignee);

    void unassign();

    // Time meta-data
    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();
    
    LocalDateTime finishedAt();
    
    void touch();

    // Relationships (Epic<->Story<->Task/Bug)
    WorkItem getParent();

    void setParent(WorkItem parent);

    List<WorkItem> getChildren();

    // Convenience default methods (implemented here)
    default boolean isDone() {
        return getStatus() == WorkStatus.DONE;
    }

    default boolean isBlocked() {
        return getStatus() == WorkStatus.BLOCKED;
    }

    default boolean isActive() {
        return getStatus() == WorkStatus.IN_PROGRESS
                || getStatus() == WorkStatus.IN_REVIEW;
    }

    default String getSummaryLine() {
        return String.format(
                "#%d %s (priority: %s, status: %s)",
                getId(),
                getTitle(),
                getPriority(),
                getStatus()
        );
    }
}