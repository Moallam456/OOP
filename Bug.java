/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project;

/**
 *
 * @author LOQ
 */

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


public class Bug implements WorkItem {

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

    private BugSeverity severity;

    private BugState bugState;

    private String environment;

    private String stepsToReproduce;

    private String expectedResult;

    private String actualResult;

    private String rootCause;

    private String fixSummary;

    private String foundInVersion;

    private String fixedInVersion;

    private boolean regression;

    public Bug(String title, String description, User reporter) {
        this(title, description, Priority.HIGH, BugSeverity.MAJOR, reporter);
    }

    public Bug(String title,
               String description,
               Priority priority,
               BugSeverity severity,
               User reporter) {

        this.id = ID_SEQUENCE++;
        this.title = title;
        this.description = description;

        this.priority = (priority != null) ? priority : Priority.HIGH;
        this.severity = (severity != null) ? severity : BugSeverity.MAJOR;

        this.status = WorkStatus.TODO;
        this.bugState = BugState.NEW;

        this.reporter = reporter;
        this.assignee = null;

        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;

        this.parent = null;

        this.environment = null;
        this.stepsToReproduce = null;
        this.expectedResult = null;
        this.actualResult = null;
        this.rootCause = null;
        this.fixSummary = null;
        this.foundInVersion = null;
        this.fixedInVersion = null;

        this.regression = false;
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
        return WorkType.BUG;
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

    private void syncWorkStatusWithBugState() {
        switch (bugState) {
            case NEW:
            case CONFIRMED:
                this.status = WorkStatus.TODO;
                break;
            case IN_PROGRESS:
                this.status = WorkStatus.IN_PROGRESS;
                break;
            case FIXED:
            case IN_QA:
                this.status = WorkStatus.IN_REVIEW;
                break;
            case CLOSED:
                this.status = WorkStatus.DONE;
                break;
            case REOPENED:
                this.status = WorkStatus.TODO;
                break;
            default:
                throw new AssertionError(bugState.name());
        }
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
        return (bugState == BugState.CLOSED) ? updatedAt : createdAt;
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

    public BugSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(BugSeverity severity) {
        if (severity != null) {
            this.severity = severity;
            touch();
        }
    }

    public BugState getBugState() {
        return bugState;
    }

    private void setBugStateInternal(BugState state) {
        this.bugState = state;
        syncWorkStatusWithBugState();
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
        touch();
    }

    public String getStepsToReproduce() {
        return stepsToReproduce;
    }

    public void setStepsToReproduce(String stepsToReproduce) {
        this.stepsToReproduce = stepsToReproduce;
        touch();
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
        touch();
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
        touch();
    }

    public String getRootCause() {
        return rootCause;
    }

    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
        touch();
    }

    public String getFixSummary() {
        return fixSummary;
    }

    public void setFixSummary(String fixSummary) {
        this.fixSummary = fixSummary;
        touch();
    }

    public String getFoundInVersion() {
        return foundInVersion;
    }

    public void setFoundInVersion(String foundInVersion) {
        this.foundInVersion = foundInVersion;
        touch();
    }

    public String getFixedInVersion() {
        return fixedInVersion;
    }

    public void setFixedInVersion(String fixedInVersion) {
        this.fixedInVersion = fixedInVersion;
        touch();
    }

    public boolean isRegression() {
        return regression;
    }

    public void setRegression(boolean regression) {
        this.regression = regression;
        touch();
    }

    public void confirm() {
        setBugStateInternal(BugState.CONFIRMED);
    }

    public void startFix() {
        setBugStateInternal(BugState.IN_PROGRESS);
    }

    public void markFixed(String fixSummary) {
        this.fixSummary = fixSummary;
        setBugStateInternal(BugState.FIXED);
    }

    public void sendToQA() {
        setBugStateInternal(BugState.IN_QA);
    }

    public void close() {
        setBugStateInternal(BugState.CLOSED);
    }

    public void reopen(boolean regression) {
        this.regression = regression;
        setBugStateInternal(BugState.REOPENED);
    }

    public boolean isCritical() {
        return severity == BugSeverity.CRITICAL;
    }

    @Override
    public String toString() {
        return getSummaryLine()
                + " | severity: " + severity
                + " | bugState: " + bugState
                + " | regression: " + regression;
    }
}
