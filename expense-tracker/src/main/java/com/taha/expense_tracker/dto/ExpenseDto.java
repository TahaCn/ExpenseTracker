package com.taha.expense_tracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense DTO (Data Transfer Object) to"
        + "transfer data between client and system"
)
public record ExpenseDto(Long id,
                         @Schema(description = "Expense Amount") BigDecimal amount,
                         @Schema(description = "Expense Created Date") LocalDate expenseDate,
                         @Schema(description = "Expense Category") CategoryDto categoryDto) {
}
