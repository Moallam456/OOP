/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

/**
 *
 * @author pc
 */
import java.util.ArrayList;
import Users.*;
import WorkItems.*;
import SprintPlanning.Sprint;

public class InMemoryDatabase {

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Epic> epics = new ArrayList<>();
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static ArrayList<Bug> bugs = new ArrayList<>();
    public static ArrayList<Sprint> sprints = new ArrayList<>();
}
