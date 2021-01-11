package com.hillel.calculator;

import java.util.List;

public class BudgetCalculatorResult {

    private final List<BudgetItem> incomeBudgetItems;
    private final List<BudgetItem> expenseBudgetItems;
    private final int incomeTotal;
    private final int expenseTotal;
    private final int total;
    private final String totalDescription;

    public BudgetCalculatorResult(List<BudgetItem> incomeBudgetItems, List<BudgetItem> expenseBudgetItems,
                                  int incomeTotal, int expenseTotal, int total, String totalDescription) {
        this.incomeBudgetItems = incomeBudgetItems;
        this.expenseBudgetItems = expenseBudgetItems;
        this.incomeTotal = incomeTotal;
        this.expenseTotal = expenseTotal;
        this.total = total;
        this.totalDescription = totalDescription;
    }

    public List<BudgetItem> getIncomeBudgetItems() {
        return incomeBudgetItems;
    }

    public List<BudgetItem> getExpenseBudgetItems() {
        return expenseBudgetItems;
    }

    public int getIncomeTotal() {
        return incomeTotal;
    }

    public int getExpenseTotal() {
        return expenseTotal;
    }

    public int getTotal() {
        return total;
    }

    public String getTotalDescription() {
        return totalDescription;
    }

}
