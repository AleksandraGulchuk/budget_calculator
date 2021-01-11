package com.hillel.calculator;

import java.util.Objects;

public class BudgetItem {
    private final int sum;
    private final String item;

    public BudgetItem(int sum, String item) {
        this.sum = sum;
        this.item = item;
    }

    public int getSum() {
        return sum;
    }

    public String getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BudgetItem that = (BudgetItem) o;
        return item.equals(that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

}
