/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.database;

/**
 *
 * @author pc
 */



import java.util.ArrayList;

public class DataBase {

    // ================= USERS =================
    public static ArrayList<User> users = new ArrayList<>();

    // ================= SPRINTS =================
    public static ArrayList<SprintPlanning> sprints = new ArrayList<>();

    // ================= WORK ITEMS =================
    public static ArrayList<WorkItem> workItems = new ArrayList<>();

    // ================= SPECIFIC WORK TYPES =================
    public static ArrayList<Epic> epics = new ArrayList<>();
    public static ArrayList<Story> stories = new ArrayList<>();
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static ArrayList<Bug> bugs = new ArrayList<>();

}
