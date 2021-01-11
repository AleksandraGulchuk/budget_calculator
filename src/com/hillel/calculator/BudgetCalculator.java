package com.hillel.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BudgetCalculator {

    public BudgetCalculatorResult receiveResult(List<BudgetItem> budgetItems) {
        budgetItems = getUniqueBudgetItems(budgetItems);
        List<BudgetItem> incomeBudgetItems = getIncomeBudgetItems(budgetItems);
        List<BudgetItem> expenseBudgetItems = getExpenseBudgetItems(budgetItems);
        int incomeTotal = calculateItemTotal(incomeBudgetItems);
        int expenseTotal = calculateItemTotal(expenseBudgetItems);
        int total = calculateItemTotal(budgetItems);
        return new BudgetCalculatorResult(incomeBudgetItems, expenseBudgetItems,
                incomeTotal, expenseTotal, total, getTotalDescription(total));
    }

    private List<BudgetItem> getUniqueBudgetItems(List<BudgetItem> budgetItems) {
        Map<String, Integer> map = new HashMap<>();
        List<BudgetItem> uniqueBudgetItems = new ArrayList<>();
        for (BudgetItem budgetItem : budgetItems) {
            if (map.containsKey(budgetItem.getItem())) {
                map.put(budgetItem.getItem(), map.get(budgetItem.getItem()) + budgetItem.getSum());
            } else {
                map.put(budgetItem.getItem(), budgetItem.getSum());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            uniqueBudgetItems.add(new BudgetItem(entry.getValue(), entry.getKey()));
        }
        return uniqueBudgetItems;
    }

    private List<BudgetItem> getIncomeBudgetItems(List<BudgetItem> budgetItems) {
        return budgetItems.stream()
                .filter(item -> item.getSum() > 0)
                .collect(Collectors.toList());
    }

    private List<BudgetItem> getExpenseBudgetItems(List<BudgetItem> budgetItems) {
        return budgetItems.stream()
                .filter(item -> item.getSum() < 0)
                .collect(Collectors.toList());
    }

    private int calculateItemTotal(List<BudgetItem> budgetItems) {
        return budgetItems.stream()
                .map(BudgetItem::getSum)
                .reduce(0, Integer::sum);
    }

    private String getTotalDescription(int total) {
        if (total < 0) {
            return "Общий убыток: ";
        } else return "Общий доход: ";
    }

}
