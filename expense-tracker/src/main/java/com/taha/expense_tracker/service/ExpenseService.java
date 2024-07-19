package com.taha.expense_tracker.service;

import com.taha.expense_tracker.dto.ExpenseDto;
import com.taha.expense_tracker.entity.Expense;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto getExpenseById(Long id);

    List<ExpenseDto> getAllExpenses();

    ExpenseDto updateExpense(Long id, ExpenseDto expenseDto);

    void deleteExpense(Long expenseId);
}
