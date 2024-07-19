package com.taha.expense_tracker.repository;

import com.taha.expense_tracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //spring data jpa provides implementation for this interface
    //transaction for all the CRUD methods
    
}
