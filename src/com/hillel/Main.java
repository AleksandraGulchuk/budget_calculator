package com.hillel;

import com.hillel.calculator.BudgetCalculator;
import com.hillel.userInteraction.UserInteraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        UserInteraction userInteraction = new UserInteraction(new BufferedReader(new InputStreamReader(System.in)));
        BudgetCalculator budgetCalculator = new BudgetCalculator();
        userInteraction.printResult(budgetCalculator.receiveResult(userInteraction.getBudgetItems()));

    }

}
