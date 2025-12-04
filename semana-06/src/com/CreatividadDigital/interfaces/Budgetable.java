package com.CreatividadDigital.interfaces;


public interface Budgetable {
    void applyDiscount(double percentage);
    boolean isWithinBudget();
    double getRemainingBudget(double spent);
}