/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expenseapp;

/**
 *
 * @author DELL
 */


public class PetrolExpense extends Expense {

    public PetrolExpense(double amount) {
        super(amount);
    }

    @Override
    public void showExpense(StringBuilder report) {
        report.append(" Petrol Expense         : Rs. ").append(String.format("%.2f", amount)).append("\n");
    }
}