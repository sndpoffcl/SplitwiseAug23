package com.scaler.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;

    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
}

/*
    User : UserExpense -> 1:M
    Expense : UserExpense -> 1:M

      Expense { for each expense we want to know the userExpense }
       paid : A=100, B=100
       hasToPay : A=50, B=50, C=100
 */