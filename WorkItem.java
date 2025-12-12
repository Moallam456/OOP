/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkItems;

/**
 *
 * @author pc
 */
import Enums.Priority;
import Enums.WorkStatus;
import Enums.WorkType;

public abstract class WorkItem {

    protected String title;
    protected String description;
    protected Priority priority;
    protected WorkStatus status;
    protected WorkType type;

    public WorkItem(String title, String description, WorkType type) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = WorkStatus.TODO;
        this.priority = Priority.MEDIUM;
    }

    public String getTitle() {
        return title;
    }

    public void setStatus(WorkStatus status) {
        this.status = status;
    }
}
