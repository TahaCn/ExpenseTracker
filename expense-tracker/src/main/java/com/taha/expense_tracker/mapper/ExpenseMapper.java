package com.taha.expense_tracker.mapper;

import com.taha.expense_tracker.dto.CategoryDto;
import com.taha.expense_tracker.dto.ExpenseDto;
import com.taha.expense_tracker.entity.Category;
import com.taha.expense_tracker.entity.Expense;

public class ExpenseMapper {

    public static ExpenseDto mapToExpenseDto(Expense expense){
           return new ExpenseDto(
             expense.getId(),
             expense.getAmount(),
             expense.getExpenseDate(),
             new CategoryDto(
                     expense.getCategory().getId(),
                     expense.getCategory().getName()
             )
           );
    }

    public static Expense mapToExpense(ExpenseDto expenseDto){
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());

        return  new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );
    }
}
