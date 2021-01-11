package com.hillel.userInteraction;

import com.hillel.calculator.BudgetCalculatorResult;
import com.hillel.calculator.BudgetItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;


public class UserInteraction {

    private final BufferedReader reader;

    public UserInteraction(BufferedReader reader) {
        this.reader = reader;
    }

    public List<BudgetItem> getBudgetItems() throws IOException {
        System.out.println("Введите информацию о расходах и доходах:");
        List<BudgetItem> budgetItems = new ArrayList<>();
        String s = reader.readLine();
        while (!s.equals("END")) {
            String[] expensesString = s.split(" ", 2);
            budgetItems.add(new BudgetItem(Integer.parseInt(expensesString[0]), expensesString[1]));
            s = reader.readLine();
        }
        return budgetItems;
    }

    public void printResult(BudgetCalculatorResult result) {
        System.out.println(result.getTotalDescription() + result.getTotal());

        System.out.println("Расходы составляют: " + (-result.getExpenseTotal()) + ", из которых:");
        result.getExpenseBudgetItems()
                .forEach(item -> System.out.println("  " + item.getItem() + ": " + (-item.getSum())));

        System.out.println("Доходы составляют: " + result.getIncomeTotal() + ", из которых:");
        result.getIncomeBudgetItems()
                .forEach(item -> System.out.println("  " + item.getItem() + ": " + item.getSum()));
    }

}




