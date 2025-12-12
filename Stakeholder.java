/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author pc
 */
import WorkItems.Epic;

public class Stakeholder extends User {

    public Stakeholder(String userId, String name, String username, String password) {
        super(userId, name, username, password, "Stakeholder");
    }

    public Epic createHighLevelRequest(String title, String description) {
        System.out.println(name + " created Epic: " + title);
        return new Epic(title, description);
    }
}