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

public class Epic extends WorkItem {

    private ArrayList<Story> stories = new ArrayList<>();

    public Epic(String title, String description) {
        super(title, description, WorkType.EPIC);
    }

    public void addStory(Story story) {
        stories.add(story);
    }
}
