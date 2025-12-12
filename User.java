/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author DELL
 */
public class User {
    private String userId;
    private String name;
    private String username;
    private String password; 
    private String role; 
    
    public User() {    }
    
    public User(String userId, String name, String username, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    // class Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRole() {
        return role;
    }
    
    // class Setters
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public void setRole(String role) {
        this.role = role;
    }

}