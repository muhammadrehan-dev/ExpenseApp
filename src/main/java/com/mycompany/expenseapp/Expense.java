/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expenseapp;

/**
 *
 * @author DELL
 */
public abstract class Expense {

    protected double amount;

    public Expense(double amount) {
        this.amount = amount;
    }

    public abstract void showExpense(StringBuilder report);

    public double getAmount() {
        return amount;
    }
}