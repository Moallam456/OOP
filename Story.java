/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkItems;

/**
 *
 * @author pc
 */
import Enums.WorkType;
import java.util.ArrayList;

public class Story extends WorkItem {

    private ArrayList<Task> tasks = new ArrayList<>();

    public Story(String title, String description) {
        super(title, description, WorkType.STORY);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}