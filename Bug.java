/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkItems;

/**
 *
 * @author pc
 */
import Enums.BugSeverity;
import Enums.BugState;
import Enums.WorkType;

public class Bug extends WorkItem {

    private BugSeverity severity;
    private BugState state;

    public Bug(String title, String description, BugSeverity severity) {
        super(title, description, WorkType.BUG);
        this.severity = severity;
        this.state = BugState.OPEN;
    }

    public void setState(BugState state) {
        this.state = state;
    }
}
