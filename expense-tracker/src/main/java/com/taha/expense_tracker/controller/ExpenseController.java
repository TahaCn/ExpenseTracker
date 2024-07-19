package com.taha.expense_tracker.controller;


import com.taha.expense_tracker.dto.ExpenseDto;
import com.taha.expense_tracker.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Expense Resource",
        description = "Create Expense - Update Expense - Read Expense - Delete Expense"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expences")
public class ExpenseController {

    private ExpenseService expenseService;


    @Operation(
            summary = "Create Expense REST API",
            description = "Create Expense REST API To Save Expense Into Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){

        ExpenseDto saved = expenseService.createExpense(expenseDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET Expense REST API",
            description = "GET Expense REST API To GET Expense From Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> findExpenseById(@PathVariable("id") Long expenseId){
        ExpenseDto expenseDto = expenseService.getExpenseById(expenseId);

        return ResponseEntity.ok(expenseDto);
    }

    @Operation(
            summary = "GET ALL Expenses REST API",
            description = "GET ALL Expenses REST API To GET ALL Expenses From Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenseDto = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenseDto);
    }

    @Operation(
            summary = "Update Expense REST API",
            description = "Update Expense REST API To Update An Existing Expense From Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long id,
                                                    @RequestBody ExpenseDto expenseDto){
        ExpenseDto updatedExpense = expenseService.updateExpense(id,expenseDto);
        return ResponseEntity.ok(updatedExpense);
    }

    @Operation(
            summary = "Delete Expense REST API",
            description = "Delete Expense REST API To Delete Expense From Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long id){
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense Deleted!!");
    }
}
