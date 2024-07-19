package com.taha.expense_tracker.service.impl;

import com.taha.expense_tracker.Exceptions.ResourceNotFoundException;
import com.taha.expense_tracker.dto.ExpenseDto;
import com.taha.expense_tracker.entity.Category;
import com.taha.expense_tracker.entity.Expense;
import com.taha.expense_tracker.mapper.ExpenseMapper;
import com.taha.expense_tracker.repository.CategoryRepository;
import com.taha.expense_tracker.repository.ExpenseRepository;
import com.taha.expense_tracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    private CategoryRepository categoryRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        Expense expense = ExpenseMapper.mapToExpense(expenseDto);
        Expense savedExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found with that id: " + id));

        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {

        List<Expense> expenses = expenseRepository.findAll();

        return expenses.stream()
                .map((expense)-> ExpenseMapper.mapToExpenseDto(expense))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found with that id: " +id));

        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());

        if(expenseDto.categoryDto() != null){
            Category category = categoryRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Category not found with that id: " + expenseDto.categoryDto().id()));
            expense.setCategory(category);
        }

        Expense updatedExpense = expenseRepository.save(expense);

        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(()-> new ResourceNotFoundException("Not found with that id: " + expenseId));
        expenseRepository.delete(expense);
    }
}
