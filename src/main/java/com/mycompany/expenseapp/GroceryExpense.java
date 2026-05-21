/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expenseapp;

/**
 *
 * @author DELL
 */

public class GroceryExpense extends Expense {

    public GroceryExpense(double amount) {
        super(amount);
    }

    @Override
    public void showExpense(StringBuilder report) {
        report.append("Grocery Expense        : Rs. ").append(String.format("%.2f", amount)).append("\n");
    }
}
