/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author pc
 */
import WorkItems.Bug;
import Enums.BugState;

public class QAEngineer extends TechnicalStaff {

    public QAEngineer(String userId, String name, String username, String password) {
        super(userId, name, username, password, "QA Engineer");
    }

    public void verifyBug(Bug bug) {
        bug.setState(BugState.CLOSED);
        System.out.println(name + " verified and closed bug: " + bug.getTitle());
    }
}
