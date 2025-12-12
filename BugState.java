/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project;

/**
 *
 * @author LOQ
 */

public enum BugState {
    NEW,         // just reported, not yet confirmed
    CONFIRMED,   // QA / dev reproduced and accepted the bug
    IN_PROGRESS, // developer is working on the fix
    FIXED,       // dev implemented a fix, waiting for verification
    IN_QA,       // under QA verification
    CLOSED,      // verified as fixed
    REOPENED     // came back after being closed
}

