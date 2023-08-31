package com.scaler.Splitwise.repository;

import com.scaler.Splitwise.model.User;
import com.scaler.Splitwise.model.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {
}
